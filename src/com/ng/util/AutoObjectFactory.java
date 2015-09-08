package com.ng.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoObjectFactory {

	public WebDriver driver;

	private By getBy(Leaf leaf) {

		By by = null;

		String propertyNameValue = leaf.getPropertyNameValue();

		String value = leaf.getValue();

		if (propertyNameValue.equals("id")) {

			by = By.id(value);

		}

		if (propertyNameValue.equals("name")) {

			by = By.name(value);

		}

		if (propertyNameValue.equals("xpath")) {

			by = By.xpath(value);

		}

		if (propertyNameValue.equals("className")) {

			by = By.className(value);

		}

		if (propertyNameValue.equals("linkText")) {

			by = By.linkText(value);

		}
		
		if (propertyNameValue.equals("cssSelector")) {

			by = By.cssSelector(value);

		}		

		return by;

	}

	public WebElement getElement(String node, WebDriver driver, String map_url) {

		WebElement element = null;

		this.driver = driver;

		Leaf leaf;
		
		try {
			leaf = new ObjectItem().viewXML(node, map_url);

			By by = this.getBy(leaf);

			element = driver.findElement(by);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return element;

	}
	
	public By getElementBy(String node, String map_url) {

		Leaf leaf;
		
		By by = null;
		
		try {
			leaf = new ObjectItem().viewXML(node, map_url);

			by = this.getBy(leaf);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return by;

	}

}
