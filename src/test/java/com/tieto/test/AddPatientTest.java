package com.tieto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;

public class AddPatientTest extends WebDriverWrapper {

	@Test
	public void createPtientTest() throws InterruptedException {
		
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		// driver.findElement(By.className("languageChoice")).

		// select class
		Select selectLanguage = new Select(driver.findElement(By.xpath("//*[@name='languageChoice']")));
		selectLanguage.selectByVisibleText("English (Indian)");

		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		JavascriptExecutor script=(JavascriptExecutor) driver;
        script.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(text(),'Patient/Client')]")));
        script.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text()='Patients']")));
        
        WebDriverWait wait=new WebDriverWait(driver,10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Patient Finder']")));
        Thread.sleep(3000);
        driver.switchTo().frame("fin");
  driver.findElement(By.xpath("//button[@id='create_patient_btn1']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("pat");
        driver.findElement(By.id("form_fname")).sendKeys("abcd");
        driver.findElement(By.id("form_lname")).sendKeys("efgh");
        driver.findElement(By.id("form_DOB")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']")));
        driver.findElement(By.xpath("//td[@class='xdsoft_date xdsoft_day_of_week5 xdsoft_date xdsoft_current xdsoft_today']/div")).click();
        Select gender=new Select(driver.findElement(By.id("form_sex")));
        gender.selectByVisibleText("Female");
        driver.findElement(By.id("create")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("modalframe");
        driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        
        
        Thread.sleep(5000);



	}

}
