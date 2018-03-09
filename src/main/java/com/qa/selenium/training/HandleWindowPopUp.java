package com.qa.selenium.training;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com/");
		
		// Storing all window handle ids in a Set collection
		Set<String> handles= driver.getWindowHandles();
		
		// Need to iterator  for iterating in Set collection as
		// for loop is not using for iteration in Set.
		
		Iterator<String> it = handles.iterator();
		
		String parentwindowid=it.next();
		System.out.println("Parent WindowiD:" + parentwindowid);
		
		String child1windowid = it.next();
		System.out.println("Child Window ID:" + child1windowid);
		
		String child2windowid = it.next();
		System.out.println("Child Window ID:" + child2windowid);
		
		//Switching to child 1 window
		driver.switchTo().window(child1windowid);
		System.out.println("Title of Child 1 Window is:" + driver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Closing first child window.
		driver.close();
		//coming back to parent window
		driver.switchTo().window(parentwindowid);
		System.out.println("Title of Parent Window after first switch:" + driver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Now again travers to next child window
		driver.switchTo().window(child2windowid);
		System.out.println("Title of Child 2 Window is:" + driver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Closing first child window.
		driver.close();
		//coming back to parent window
		driver.switchTo().window(parentwindowid);
		System.out.println("Title of Parent Window after second switch:" + driver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();		
	}

}
