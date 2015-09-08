package com.ng.cases.common;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.StringUtil;

public class GameTimer {

	private Integer time = 1;

	private String hour = "";

	private String min = "";

	private String sec = "1";

	public void GetGameTimer(BrowserEmulator be, String id)
			throws InterruptedException {

		// hour = be.getText("//div[@class='hour']");
		//
		// min = be.getText("//div[@class='min']");

		if (be.isElementPresent("//*[@id='lli_" + id + "']/span", 500)) {
			sec = be.getText("//*[@id='lli_" + id + "']/span").substring(5, 7);
			System.out.println(sec + "!!!!!!!!!!!!!!!!");
			time = StringUtil.parseInt(sec);

			if (time < 20) {
				Thread.sleep(time * 1000 + 5000);
				if (be.isElementPresent("//input[@id='alert_close_button']",
						500)) {
					be.click("//input[@id='alert_close_button']");
				}
			}
		} else if (be.isElementPresent("//div[@class='sec']", 5000)) {

			sec = be.getText("//div[@class='sec']");

			time = StringUtil.parseInt(sec);

			if (time < 20) {
				Thread.sleep(time * 1000 + 5000);
				if (be.isElementPresent("//input[@id='alert_close_button']",
						500)) {
					be.click("//input[@id='alert_close_button']");
				}
			}
		}
	}

	public void GetGameTimer(BrowserEmulator be) throws InterruptedException {

		// hour = be.getText("//div[@class='hour']");
		//
		// min = be.getText("//div[@class='min']");

		if (be.isElementPresent("//div[@class='sec']", 5000)) {

			sec = be.getText("//div[@class='sec']");

			time = StringUtil.parseInt(sec);

			if (time < 20) {
				Thread.sleep(time * 1000 + 5000);
				if (be.isElementPresent("//input[@id='alert_close_button']",
						500)) {
					be.click("//input[@id='alert_close_button']");
				}
			}
		}
	}
}
