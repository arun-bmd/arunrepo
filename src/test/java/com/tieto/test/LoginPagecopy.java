package com.tieto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagecopy {

	private static By userLocator = By.id("authUser");

	private static By passwordLocator = By.id("clearPass");

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(userLocator).sendKeys(username);

	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(passwordLocator).sendKeys(password);

	}
}
