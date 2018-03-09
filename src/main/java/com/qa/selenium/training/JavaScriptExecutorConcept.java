package com.qa.selenium.training;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/home/PradyumnnaS/EclipseHome/Java/chromedriver");
		
		WebDriver driver =  new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("pradyumnna");
		driver.findElement(By.name("password")).sendKeys("python@010");
		
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]"
				+ "/div/div/input"));
		
		//Now highlight a spcific element
		flash(driver, loginbtn);
		drawBorder(loginbtn, driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generateAlert("Issue in Login button", driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// Once the broder drawn then take screen shot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("/home/PradyumnnaS/EclipseHome/workspace/"
					+ "seleniumtraining/element.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		
		driver.quit();
	}

	//Creating a method for heighlighting 
	public static void flash(WebDriver driver, WebElement element) {
		
		String bgcolor = element.getCssValue("backgroundColor");
		
		for (int i=0; i<10;i++) {
			changeColor("rgb(100,200,300)", element ,driver);
			changeColor(bgcolor, element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//method defination for drawBorder
	public static void drawBorder(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='10px solid red'", element);
	}
	
	//method defination for generating runtime js alert
	public static void generateAlert(String message, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	//Clicking a element using javascript executor
	public static void clickElementByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();");
	}
	
	//Refhreshing page using javascript executor
	public static void refreshPage(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	//getTitle using javascript executor
	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title=js.executeScript("return document.title").toString();
		return title;
	}
	
	//If user wants to get the total page inner text then selenium does not have thta.
	//it can be achive through java script ex
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pagetext=js.executeScript("return document.documentElement.InnterText").toString();
		return pagetext;
	}
	
	//One Imp is Page scrolling
	// scroll down
	public static void pagescrawlDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//scroll into view
	//scrolling to that extends when the element is visible
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
}
