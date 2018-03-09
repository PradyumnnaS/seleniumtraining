package com.qa.selenium.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicWebTable {

public static void main (String args []) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
		driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).submit();
		
		driver.switchTo().frame("mainpanel");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(@title, 'Contacts')]")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Method 1
		// Use loop for selecting values from a web table
		
		//Method 2
		//Using Dyanamic xpath for selecting webtable values...
		
		//for clicking in "Any Patel" row
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Any Patel')]/parent::td//preceding-sibling::td//input[@type='checkbox']")); 
		scrollIntoView(driver, element);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		element.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
 	}

	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	
	}
}
