package com.ng.cases.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.netease.dagger.BrowserEmulator;

public class CaptureScreen {

	public static void captureScreen(BrowserEmulator be, String screenName)
			throws IOException {

		String screenpath = "captureScreen/";

		// ÅÐ¶ÏÊÇ·ñ´æÔÚscreenpathÄ¿Â¼
		if (!(new File(screenpath).isDirectory())) {
			new File(screenpath).mkdir();
		}
		File screenShotFile = ((TakesScreenshot) be.getBrowserCore())
				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenShotFile, new File(screenpath + screenName
				+ ".jpg"));
	}

}
