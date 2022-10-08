package com.Zoho.ZohoFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zooho {
	
	

	
	
	
	public static WebDriver driver;
	
	public static void browserLaunch(){
		
	
	System.setProperty("webdriver.chrome.driver", 
			
			"C:\\Users\\hp\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\Maven_Project\\Chrome_Driver\\chromedriver.exe");
	
	
	
	driver= new ChromeDriver();
	
	driver.get("https://www.zoho.com/sign/signup.html");
	
	driver.manage().window().maximize();
	
	}
	
	
	public static void signupPage() {
	WebElement create =	driver.findElement(By.name("email"));
	
	create.sendKeys("nikita.jais24@gmail.com");
	
	WebElement pass= driver.findElement(By.name("password"));
	
	pass.sendKeys("chocolate");
	
	WebElement check= driver.findElement(By.xpath("//div[@class='signup-form']//descendant::span[@class='unchecked']"));
	check.click();
	
	WebElement signup = driver.findElement(By.xpath("//div[@class='signup-form']//descendant::input[@name='signup']"));
	signup.click();
	
	
	
	}
	
	public static void main(String[] args) {
		
		browserLaunch();
		signupPage();
	}
}