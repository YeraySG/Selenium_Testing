package com.pixelmaticentry.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pixelmatic_TestCase {

	private WebDriver driver;
	By FormIdLocator = By.id("form");
	By HomeIdLocator = By.id("home");
	By ErrorIdLocator = By.id("error");
	By UiIdLocator = By.id("site");
	
	By HomeActive = By.xpath("//*[@id=\"navbar\"]/ul/li[1]");
	By FormActive = By.xpath("//*[@id=\"navbar\"]/ul/li[2]");
	
	By ErrorTitle = By.partialLinkText("404 Error: File not found :-(");
	By FormLocator = By.name("simple Form Submission");
	
	By LogoLocator = By.xpath("//img[@src='assets/img/infinitefleet.jpeg']");
	

	
	By FormInputBox = By.id("hello-input");
	By FormSubmitButton = By.id("hello-submit");

	By HomeHeaderLocator = By.xpath("/html/body/div/div[1]/h1");
	By HomeBodyLocator = By.xpath("/html/body/div/div[1]/p");

	private String homeHeaderText = "Welcome to Pixelmatic QA department";

	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8081/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();	

	}

	//@Test
	public void logoTest() throws InterruptedException {     		
		assertEquals("UI Testing Site", driver.getTitle());  
		//Thread.sleep(1000);
		driver.findElement(HomeIdLocator).click();
		if (driver.findElement(LogoLocator).isDisplayed()) {
				System.out.print("Logo visible ");                      	
		}
		else {
			System.out.print("Logo not visible ");
			}

		driver.findElement(FormIdLocator).click();
		//Thread.sleep(1000);

		if (driver.findElement(LogoLocator).isDisplayed()) {
			System.out.print("Logo visible ");                      	
		}
		else {
			System.out.print("Logo not visible ");
			}
	}
	//@Test
	public void uiTest() throws InterruptedException {     		
		assertEquals("UI Testing Site", driver.getTitle());  
		//Thread.sleep(1000);
		driver.findElement(HomeIdLocator).click();
		assertEquals("UI Testing Site", driver.getTitle());
		driver.findElement(FormIdLocator).click();
		assertEquals("UI Testing Site", driver.getTitle());
	}
	//@Test
	public void homeTest() throws InterruptedException {     		
		
		driver.findElement(HomeIdLocator).click();
		
		driver.findElement(FormIdLocator).click();
		assertEquals("UI Testing Site", driver.getTitle());
	}
	
	//@Test
	public void activeTest() throws InterruptedException {     		
		assertEquals("UI Testing Site", driver.getTitle());  
		Thread.sleep(1000);
		driver.findElement(HomeIdLocator).click();
		assertTrue(driver.findElement(HomeActive).isEnabled());
	}
	@Test
		public void compararHeadersTest() throws InterruptedException { 
			String  alo = driver.findElement(HomeBodyLocator).getText();
			System.out.print(alo);

	
}

	
}