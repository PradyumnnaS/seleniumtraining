package com.qa.selenium.training;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingPopUp {

	public static void main (String args []) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		// Now a pop up will come and we need to handle it by accepting it.
        
		try {
		Thread.sleep(4000);
		System.out.println("Accepting alerts popup");
		//driver.switchTo().alert().accept();
		//or
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); // for clicking on ok button on alert
		//alert.dismiss(); // for clicking on cancle button on alert
		}
		catch(NoAlertPresentException ne) {
			
			System.out.println("Alert not coming:--" + ne);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// uploading Files from os popup
		
		driver.get("https://html.com/input-type-file/");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/home/PradyumnnaS/file");
		
		driver.quit();
	}
	
}
