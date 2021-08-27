package com.pixelmaticentry.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		//driver.get("http://www.google.com/");
		driver.get("http://127.0.0.1:8081/");
	}
	
	@Test
	
	public void testGooglePage() throws InterruptedException {
		assertEquals("UI Testing Site", driver.getTitle());
		
		//WebElement searchbox = driver.findElement(By.name("q"));
		
		Thread.sleep(3000);
		//searchbox.clear();
		
		//searchbox.sendKeys("Enter the guneon wiki");
		
		//searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@After
	
	public void tearDown() {
		driver.quit();
	}
}
