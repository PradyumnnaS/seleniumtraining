package com.qa.selenium.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitelyWait {

public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dj.pradyumnna@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("python010");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		clickOn(driver, driver.findElement(By.xpath("//div[@class='_1d6g']/a[contains(text(), 'Creativity never ends') and @id='u_fetchstream_1_5']")), 30);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		driver.navigate().back();
		
		
 }
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
	
	new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	
	locator.click();
	}
	

}

