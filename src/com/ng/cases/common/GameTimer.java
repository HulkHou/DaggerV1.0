package com.ng.cases.common;

import com.netease.dagger.BrowserEmulator;
import com.ng.util.StringUtil;

public class GameTimer {

	private Integer time = 1;

	private String hour = "";

	private String min = "";

	private String sec = "1";

	public void GetGameTimer(BrowserEmulator be, String lotteryId)
			throws InterruptedException {

		// hour = be.getText("//div[@class='hour']");
		//
		// min = be.getText("//div[@class='min']");

		if (be.isElementPresent("//*[@id='lli_" + lotteryId + "']/span", 500)) {
			min = be.getText("//*[@id='lli_" + lotteryId + "']/span")
					.substring(2, 4);
			sec = be.getText("//*[@id='lli_" + lotteryId + "']/span")
					.substring(5, 7);
			time = StringUtil.parseInt(min) * 60 + StringUtil.parseInt(sec);

			System.out.println(time);

			if (time < 20) {
				Thread.sleep(time * 1000 + 5000);
				if (be.isElementPresent("//input[@id='alert_close_button']",
						500)) {
					be.click("//input[@id='alert_close_button']");
				}
			}
		} else if (be.isElementPresent("//div[@class='sec']", 5000)) {

			min = be.getText("//div[@class='min']");

			sec = be.getText("//div[@class='sec']");

			time = StringUtil.parseInt(min) * 60 + StringUtil.parseInt(sec);

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

			min = be.getText("//div[@class='min']");

			sec = be.getText("//div[@class='sec']");

			time = StringUtil.parseInt(min) * 60 + StringUtil.parseInt(sec);

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
