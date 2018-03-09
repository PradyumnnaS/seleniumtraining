package com.qa.selenium.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandingActionsDragndDrop {

public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Wait for max 40 sec to fully loaded the page .. if the page is not loaded in 40 sec then throw exceprion
		//The below pageLoadTimeout and implecityelyWait methods are dynamic wait in nature
		//Static wait is Thread.sleep method
		//implecitylyWait wait for a element for the maxtime that given in the threshold.
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		//Use Actions class for Drag and Drop
		
		Actions action =  new Actions(driver);
		
		action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]/p")))
		.moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]")))
		.release()
		.build()
		.perform();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		driver.quit();
		
}
}
