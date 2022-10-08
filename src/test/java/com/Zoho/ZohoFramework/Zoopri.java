package com.Zoho.ZohoFramework;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
//import com.homepage.datadriven.zoho.XLSXReader;

 public class Zoopri {
	
	public static WebDriver driver;
	
	public static void home_Page() throws InterruptedException, WebDriverException, IOException {
		
		System.setProperty("webdriver.chrome.driver", 
				
		"C:\\Users\\hp\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\Maven_Project\\Chrome_Driver\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.zoho.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//String userName= XLSXReader.particularData("Project", 1, 1);
		//String passWord = XLSXReader.particularData("Project", 1, 2);
		
		driver.findElement(By.xpath("//div[@class='main-container-wrapper']//descendant::a[text()='Free Sign Up']")).click();
		
		driver.findElement(By.xpath("//div[@class='signup-box']//descendant::input[@type='email']")).sendKeys("nikita.jais23@gmail.com");
		
		driver.findElement(By.xpath("//div[@class='signup-box']//descendant::input[@type='password']")).sendKeys("Nikita@23");
		Thread.sleep(5000);
		
		WebElement agreeCheckBox= driver.findElement(By.xpath("//div[@class='signup-box']//descendant::span[@class='unchecked']"));
		agreeCheckBox.click();
		
		WebElement radio_button= driver.findElement(By.id("signupbtn"));
		radio_button.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		Date dt = new Date();
		String date = dt.toString().replaceAll(":", "-")+ ".png";
		Files.copy(ts.getScreenshotAs(OutputType.FILE), 
		
	new File("C:\\Users\\hp\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\.metadata\\ZohoFramework\\picture"+ "zoho" +date));
		
		
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, WebDriverException, IOException {
		home_Page();
	}

}



