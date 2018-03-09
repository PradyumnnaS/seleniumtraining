package com.qa.selenium.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingActionsMousHover {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("http://www.spicejet.com/Default.aspx");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		//Click on ADD-ONS
		
		WebElement addonlink = driver.findElement(By.xpath("//a[@id='highlight-addons']"));
		WebElement you1st = driver.findElement(By.xpath("//a[contains(text(),'You 1st')]"));
		
		//Using Action class
		
		Actions action = new Actions(driver);
		
		action.moveToElement(addonlink).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		you1st.click();
	    
	    
		driver.quit();
	}
}
