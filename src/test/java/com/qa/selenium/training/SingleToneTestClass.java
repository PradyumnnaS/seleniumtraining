package com.qa.selenium.training;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleToneTestClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		SingletonDriverInit instancediver = SingletonDriverInit.getInstance();
		driver = instancediver.initDriver();
	}
	
	@Test
	public void testPage() {
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
