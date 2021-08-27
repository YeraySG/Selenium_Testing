package com.project.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UiTestingPage extends Base {

	By FormIdLocator = By.id("form");
	By HomeIdLocator = By.id("home");
	By ErrorIdLocator = By.id("error");
	By HelloPageLocator = By.id("hello-text");
	
	By HomeActive = By.xpath("//*[@id=\"navbar\"]/ul/li[1]");
	By FormActive = By.xpath("//*[@id=\"navbar\"]/ul/li[2]");
	
	By ErrorTitle = By.partialLinkText("404 Error: File not found :-(");
	By FormLocator = By.name("simple Form Submission");
	
	By LogoLocator = By.xpath("//img[@src='assets/img/infinitefleet.jpeg']");
	
	By HomePageActive = By.xpath("//*[@id=\"navbar\"]/ul/li[1]");
	By FormPageActive = By.xpath("//*[@id=\"navbar\"]/ul/li[2]");
	
	By FormInputBox = By.id("hello-input");
	By FormSubmitButton = By.id("hello-submit");
		
	public UiTestingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void logoLocator(By pageLocator) throws InterruptedException {
		click(pageLocator);
		if (isDisplayed(LogoLocator)) {
			System.out.print("Logo visible ");                      
		} 
		else {
			System.out.print("Logo not visible ");
			} 
			
	}
	
	public void titleAsserter(By pageLocator, String text) {
		click(pageLocator);
		if (text.equals(pageTitle())) {
			System.out.print("Page Title Matches ");
		} 
		else {
			System.out.print("Page Title Does Not Match ");
			} 
	}
	
	public void navigateTabs (By pageLocator, By pageIdentifier, By active) {
		click(pageLocator);
		if (isDisplayed(pageIdentifier) && (isEnabled(active))) {
			System.out.print("Desired Page Reached Successfully ");
		} 
		else {
			System.out.print("Desired Page Not Reached ");
			}
	}
	
	public void headerTextFinder(By desiredText, String sampleText) {
		String desiredExtractedText = getText(desiredText);
		
		if(textMatch(desiredExtractedText,sampleText)) {
			System.out.print("Desired Text Found ");
		} 
		else {
			System.out.print("Desired Text Not Found ");
			} 
	}
		
	public Boolean interactiveFields(By buttonIdentifier) {
		return isDisplayed(buttonIdentifier);
		
	}

}
