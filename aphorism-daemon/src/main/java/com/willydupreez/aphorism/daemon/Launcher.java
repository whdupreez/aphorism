/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.daemon;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * The application entry point.
 *
 * @author Willy du Preez
 *
 */
// TODO Create children of data directory if not exist
// TODO Clean command
public class Launcher {

	private static final String ON_START_METHOD = "onStart";
	private static final String ON_STOP_METHOD = "onStop";

	private static final String CMD_RUN = "run";
	private static final String CMD_START = "start";
	private static final String CMD_STOP = "stop";

	private static Launcher launcher;

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			throw new IllegalArgumentException("No arguments provided.");
		} else {
			System.out.println(Arrays.asList(args));
		}

		switch (args[0]) {
		case CMD_START:
			if (launcher != null) {
				throw new IllegalStateException("Failed to start. Launcher is not null.");
			}
			launcher = new Launcher();
			launcher.init(args);
			launcher.start();
			break;

		case CMD_STOP:
			if (launcher == null) {
				throw new IllegalStateException("Failed to stop. Launcher is null.");
			}
			try {
				launcher.stop();
			} catch (Exception e) {
				launcher.destroy();
				System.out.println("ERROR: Failed to stop launcher. Destroying.");
				e.printStackTrace();
			}
			break;

		case CMD_RUN:
			launcher = new Launcher();
			launcher.init(args);
			launcher.consolePostInit();
			launcher.start();
			break;

		default:
			throw new UnsupportedOperationException("Unsupported operation: " + args[0]);
		}

	}

	private DefaultApplicationEnvironment context;
	private LauncherProperties properties;
	private LauncherThread thread;
	private Object lock;
	private boolean run;

	private Class<?> appClass;
	private Object appInstance;

	private Launcher() {
	}

	public void init(String[] args) throws Exception {
		System.out.println("init");

		// Here open configuration files, create a trace file, create ServerSockets, Threads

		if (args.length < 2) {
			throw new IllegalArgumentException("APP_HOME argument must be provided.");
		}

		// 1. Handle command-line arguments.
		String appHome = args[1];

		// 2. Create the launcher context.
		this.context = DefaultApplicationEnvironment.builder()
				.applicationHome(appHome)
				.build();

		// 3. Load system properties.
		properties = context.getConfigurationFactory().create(LauncherProperties.class);

		// 4. Create the Launcher control thread.
		lock = new Object();
		thread = new LauncherThread("Thread-Launcher-" + appHome);
		run = true;

	}

	private void consolePostInit() {
		System.out.println("consolePostInit");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					Launcher.this.stop();
				} catch (Exception e) {
					Launcher.this.destroy();
					System.out.println("ERROR: Failed to stop from shutdown hook.");
					e.printStackTrace();
				}
			}
		});
	}

	public void start() throws Exception {
		// Start the Thread, accept incoming connections
		System.out.println("start");

		appClass = Class.forName(properties.getApplicationClass());
		appInstance = appClass.newInstance();
		Method onStartMethod = appClass.getMethod(ON_START_METHOD);

		// TODO Test
		if (onStartMethod.getParameterCount() == 0) {
			onStartMethod.invoke(appInstance);
		} else if (onStartMethod.getParameterCount() == 1
				&& onStartMethod.getParameterTypes()[0].equals(ApplicationEnvironment.class)) {
			onStartMethod.invoke(appInstance, context);
		} else {
			throw new LauncherException("Invalid parameter types in Application class onStart method.");
		}

		synchronized (lock) {
			thread.start();
		}

	}

	public void stop() throws Exception {
		// Inform the Thread to terminate the run(), close the ServerSockets
		System.out.println(ON_STOP_METHOD);

		if (appClass == null || appInstance == null) {
			throw new IllegalStateException(
					"appClass [" + appClass + "] or appInstance [" + appInstance + "] cannot be null.");
		}
		if (!run) {
			throw new IllegalStateException("Thread not running");
		}

		stopThread();
		System.out.println("Thread stopped");

		appClass.getMethod("onStop").invoke(appInstance);
	}

	private void stopThread() {

		run = false;
		synchronized (lock) {
			lock.notify();
		}

		while (thread.isAlive()) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println("WARNING: Thread interrupt while waiting for join.");
				// Ignore.
			}
		}
	}

	public void destroy() {
		// Destroy any object created in init()
		System.out.println("destroy");

		appClass = null;
		appInstance = null;
		thread = null;
		lock = null;
		run = false;
		launcher = null;
	}

	private class LauncherThread extends Thread {

		public LauncherThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println("INFO: Starting application control thread: " + this.getName());
			while (run) {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// Ignore.
						System.out.println("WARNING: Thread interrupted, continuing wait state.");
					}
				}
			}
		}

	}

}
