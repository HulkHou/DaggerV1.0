package com.ng.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ThreadRefresh extends Thread {
	private WebDriver driver;
	public boolean isGetSucceed = false;
	
	public ThreadRefresh(WebDriver driver){
		this.driver = driver;
	}
	
	@Override
	public void run(){
		try {
			driver.navigate().refresh();
			isGetSucceed = true;
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
