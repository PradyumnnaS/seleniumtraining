package com.qa.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {
	
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pradyumnna");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("python@010");
		
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.switchTo().frame("mainpanel");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			driver.quit();
		}
	}
	
	

}
