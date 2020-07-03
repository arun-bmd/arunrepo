package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	
	
	private By userLocator=  By.id("authUser");
	private By passLocator=By.id("clearPass");
	private By languageLocator = By.name("languageChoice");
	private By loginLocator = By.xpath("//*[@type='submit']");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(userLocator).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passLocator).sendKeys(password);
	}
	
	public void selectLanguage(String text) 
	{
		Select selectLanguage = new Select(driver.findElement(languageLocator));
		selectLanguage.selectByVisibleText(text);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginLocator).click();

	}
	
	//select language and click on login
	//2 dimentional array - check online  // this key word // concept of complile // xpath concept
}
