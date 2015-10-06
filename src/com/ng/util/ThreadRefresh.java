package com.ng.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.netease.dagger.BrowserEmulator;

public class ThreadRefresh extends Thread {
	private BrowserEmulator be;
	public boolean isGetSucceed = false;

	public ThreadRefresh(BrowserEmulator be) {
		this.be = be;
	}

	@Override
	public void run() {
		try {
			be.getBrowser().refresh();
			isGetSucceed = true;
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
