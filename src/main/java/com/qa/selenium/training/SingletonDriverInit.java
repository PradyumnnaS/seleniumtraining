package com.qa.selenium.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriverInit {

	private static SingletonDriverInit instance_var = null;
	private WebDriver driver;
	
	private SingletonDriverInit() {
		
		
	}
	
	public WebDriver initDriver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static SingletonDriverInit getInstance() {
		//Lazy initialization 
		if (instance_var == null)
			instance_var =  new SingletonDriverInit();
		return instance_var;
	}
}
