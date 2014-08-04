package com.willydupreez.aphorism.app;

import com.willydupreez.aphorism.daemon.ApplicationEnvironment;

public interface Application {

	void onStart(ApplicationEnvironment context);
	void onStop();

}
