package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List findElements(By locator){
		return (List) driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public Boolean isEnabled(By locator) {
		try {
			return driver.findElement(locator).isEnabled();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean textMatch(String desiredText, String sampleText) {
		return sampleText.equals(desiredText);
		
	}	
	
	public void visit(String url) {
		driver.get(url);
	}
	
	
}
