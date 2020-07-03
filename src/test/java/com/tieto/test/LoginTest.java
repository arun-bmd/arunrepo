package com.tieto.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.LoginPage;
import com.tieto.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper { // inheritance

	@Test
	public void checkLinkCount() {
		int actualValue = driver.findElements(By.tagName("a")).size();
		Assert.assertEquals(actualValue, 1);

	}

	@DataProvider
	public Object[][] validCredentialData() throws IOException
	{
		Object[][] main = ExcelUtils.getSheetIntoObject("testdata/OpenEMRData.xlsx","validCredentialData" );
		return main;
	}
	
	@Test(priority = 1, dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedValue) {

		// https://demo.openemr.io/b/openemr/interface/login/login.php?site=default
		// https://www.open-emr.org/

		//driver.findElement(By.id("authUser")).sendKeys("admin");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		
LoginPage login =new LoginPage(driver);
		
		login.enterUsername("admin");
		login.enterPassword("pass");
		//LoginPage.enterUsername(driver, "admin");  // using methods from Login Pages
		//LoginPage.enterPassword(driver, "pass");
		
		// driver.findElement(By.className("languageChoice")).

		// select class
		
		login.selectLanguage("English (Indian)");
		//Select selectLanguage = new Select(driver.findElement(By.xpath("//*[@name='languageChoice']")));
		//selectLanguage.selectByVisibleText("English (Indian)");

		login.clickOnLogin();
		//driver.findElement(By.xpath("//*[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='tabTitle']")));

		String actualTitle = driver.getTitle();
		Reporter.log(actualTitle);

		// in test NG - min one assert is required
		Assert.assertEquals(actualTitle, "OpenEMR");

	}

	
	
	
	@DataProvider
	public Object[][] invalidData()
	{
		Object[][] main = new Object[2][4];
		
		// i- no of testcases
		//j- number of parameter
		
		
		main [0][0] = "john";
		main [0][1] = "john123";
		main [0][2] = "French (Standard)";
		main [0][3] = "Invalid username or password";

		main [1][0] = "peter";
		main [1][1] = "peter123";
		main [1][2] = "French (Standard)";
		main [1][3] = "Invalid username or password";
		
		return main;

	}
	
	
	@Test(priority = 2, invocationCount = 1, dataProvider = "invalidData")
	public void invalidCredentialTest(String username, String password, String language, String expectedValue) {

		// https://demo.openemr.io/b/openemr/interface/login/login.php?site=default
		// https://www.open-emr.org/

		driver.findElement(By.id("authUser")).sendKeys(username);//from data provider
		driver.findElement(By.id("clearPass")).sendKeys(password); // from data provider
		// driver.findElement(By.className("languageChoice")).

		// select class
		Select selectLanguage = new Select(driver.findElement(By.xpath("//*[@name='languageChoice']")));
		selectLanguage.selectByVisibleText("English (Indian)");

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		String error = driver.findElement(By.xpath("//div[contains(text(),'Invalid username')]")).getText();

		Assert.assertEquals(error.trim(), expectedValue); // from data provider
		Reporter.log(error);

		Assert.assertTrue(error.contains("Invalid username or password"));
	}
}
