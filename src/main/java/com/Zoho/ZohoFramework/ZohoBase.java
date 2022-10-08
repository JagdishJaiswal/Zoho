package com.Zoho.ZohoFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class ZohoBase {

		public static WebDriver driver;
		
	public static void userInput(WebElement element, String value) {
			element.sendKeys(value);
		}
		public static void clickOnElement(WebElement element) {
			element.click();

		}
		public static void elementIsSelected(WebElement element) {
			
			boolean isSelected= element.isSelected();
			System.out.println("Check whether the element is selected or not :" +isSelected);

		}
		public static void elementIsEnabled(WebElement element) {
			boolean isEnabled = element.isEnabled();
			System.out.println("Check whether the selected element is enabled or not :" +isEnabled);
		}
	  public static void elementIsDisplayed(WebElement element) {
		boolean isDisplayed= element.isDisplayed();
		System.out.println("Check whether the selected element is displayed or not: " +isDisplayed);

	}
	  public static void clearElement(WebElement element) {
	  element.clear();
	  }



		public static WebDriver browserLaunch(String value) {
			
			if(value.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", 
			 
						"D:\\program backup\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\Maven_Project\\Chrome_Driver\\chromedriver.exe");
			
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Chrome_Driver\\chromedriver.exe");
			
			//C:\Users\hp\Downloads\eclipse-java-2019-06-R-win32-x86_64\Maven_Project\Chrome_Driver\chromedriver.exe
			//To use Chrome as default browser we use these 2 lines:
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("incognito");
//			
			driver = new ChromeDriver();
			}
			
			else if(value.equalsIgnoreCase("gecko")) {
			
				
//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
//"D:\\program backup\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\Maven_Project\\Chrome_Driver\\chromedriver.exe");
			
				
System.setProperty("webdriver.gecko.driver",
	"D:\\program backup\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\Maven_Project\\Chrome_Driver\\chromedriver.exe");
				
			}else if(value.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Chrome_Driver\\chromedriver.exe");
				
			}else if(value.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Chrome_Driver\\chromedriver.exe");
			}else {
				System.out.println("Invalid Browser name");
			}
			
			driver.manage().window().maximize();
			 
			return driver;
			}
		
		
		
		public static void launchUrl(String Value) {
			driver.get(Value);
			
		}
		
		public static void close() {
			driver.close();
		}
		public static void quit() {
			driver.quit();
		}
			
			public static void navigateTo(String value) {
				
				driver.navigate().to(value);
				
				}
	  public static void navigateBack() {
		driver.navigate().back();
	  }
	  public static void navigateRefresh() {
		driver.navigate().refresh();
	  }
	  public static void navigateForward() {
		driver.navigate().forward();
	  }
	  
	  public static void getTitle() {
		String title = driver.getTitle();
	  System.out.println("Page Title is: " +title);
	  }
	  
	  
	  public static void getCurrentUrl() {
		 String currentUrl=  driver.getCurrentUrl();
		 System.out.println("URL of current window is:" +currentUrl);
		 
		}
	  
	  
	  
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);

	}
	public static void selectfromdropdown(WebElement element, String value, String text) {
		
		Select sel = new Select(element);
		 if(value.equalsIgnoreCase("index")) {
			 int a =Integer.parseInt(text);
			 sel.selectByIndex(a);
		 
		 }else if(value.equalsIgnoreCase("value")) {
			 sel.selectByValue(text);
		 
		 }else if(value.equalsIgnoreCase("text")) {
			 sel.selectByVisibleText(text);
		 }else{
			 System.out.println("Invalid Selection");
		 }
	}
		 public static void deselectfromDropdown(WebElement element, String value, String text) {
				
				Select deselect=new Select(element);
				if(value.equalsIgnoreCase("Index")) {
					int b=Integer.parseInt(text);
					deselect.deselectByIndex(b);
				}else if(value.equalsIgnoreCase("Value")) {
					deselect.deselectByValue(text);
				}else if(value.equalsIgnoreCase(text)) {
					deselect.deselectByVisibleText(text);
				}
				else{
					System.out.println("Invalid Deselect OPtion");
	}
		 }
		 
		 public static void isMultiple(WebElement element) {
			 Select s= new Select(element);
			 Boolean multiple=s.isMultiple();
			 System.out.println("Multiple option is:" +multiple);
			
		 }
		 
	public static void getOptionsfromDropdown(WebElement element) {
		
		Select sel= new Select(element);
		List<WebElement> list = sel.getOptions();
		
		for(int i =0; i<list.size();i++) {
			WebElement e = list.get(i);
			String str = e.getText();
			System.out.println(str);
			
		}
	}
		public static void getAttribute(WebElement element, String value) {
			String words= element.getAttribute(value);
					System.out.println("Get Attribute is :" +words);
					
					
		}

	public static void getFirstOption(WebElement element, String value) {
		
		Select sel = new Select(element);
		WebElement first= sel.getFirstSelectedOption();
		System.out.println("Get First Selected Option:" +first);
	}

	public static void getAllSelectedOptions(WebElement element) {
		 Select s = new Select(element);
		 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		 for (int i = 0; i<allSelectedOptions.size(); i++) {
			 WebElement e = allSelectedOptions.get(i);
			 
			 String text = e.getText();
			 System.out.println("All Selected options are:" +text);
				}
		 
		 //for(WebElement each:allSelectedOptions){
		 
		 //String text= each.getText();
		 //system.out.println("all selected options are:" +text);}
	}
	  public static void alertAccept(WebDriver driver) {
		
		  Alert a =driver.switchTo().alert();
		  a.accept();
		  
	  }
	public static void alertDismiss(WebDriver driver) {
		Alert al =driver.switchTo().alert();
		al.dismiss();
		
	}
	public static void notify(WebDriver driver) {
		
		Alert a =driver.switchTo().alert();
		a.getText();
		
	}
	public static void sendKeys(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
		
	}
	 public static  void moveToElement(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	 

	 public static void actionClick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.click(element).build().perform();
	}
	 
	 public static void contextClick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.contextClick().build().perform();

	}
	  
	 public static void doubleClick(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.doubleClick().build().perform();

	}
	 
	 public static void dragAndDrop(WebDriver driver,WebElement drag, WebElement drop) {
			Actions a = new Actions(driver);
			a.dragAndDrop(drag,drop).perform();
		   }
	 
	 //Robots Class: 
	 public static void KeyBoardEnter() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	 
	 public static void keyDown() throws AWTException {
		Robot r= new Robot();
		
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}
	 
	 public static void keyUp() throws AWTException {
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
	}
	 //JSE
	  public static void scrollByUp() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);");
		}
	  
	  public static void scrollByDown() {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500);");
			} 
	  
	 public static void scrollIntoView(WebElement element) {

		 JavascriptExecutor js=(JavascriptExecutor) driver;

		 js.executeScript("arguments[0].scrollIntoView();",element);


		 }
	 //Frames:
	 
	 public static void framesIn(int index) {
		 driver.switchTo().frame(index);
	 }
	 
	 public static void framesOut() {
		 driver.switchTo().defaultContent();
	 }
		


	 
	public static  void singleWindow() {
		String windowHandle= driver.getWindowHandle();
		System.out.println(windowHandle);

	}
	public static  void multipleWindow() {
		Set<String> multipleWindow =driver.getWindowHandles();
		
		for (String s : multipleWindow) {
			String title= driver.switchTo().window(s).getTitle();
			System.out.println(title);
			
		}
	}

	public static void radioButton(WebElement element) {
		element.click();
		
	}

	public static void checkButton(WebElement element) {
		element.click();


	}
	public static void Screenshot(WebDriver driver) throws IOException {
		
		Date date=new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String file = sd.format(date);
		
		String location= file.replaceAll("/", "_");
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File s= ts.getScreenshotAs(OutputType.FILE);
		File d= new File("C:\\Users\\hp\\Downloads\\eclipse-java-2019-06-R-win32-x86_64\\qc\\Screenshot\\" + location + "a.png");
		
		//File.Utils.copyFile(s,d);
		
		FileHandler.copy(s, d);
		

	} 
		
	}


		


