package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UiPage_Test {
	
	By FormIdLocator = By.id("form");
	By HomeIdLocator = By.id("home");
	By UiIdLocator = By.id("site");
	By ErrorIdLocator = By.id("error");
	By HelloPageLocator = By.id("hello-text");
	
	By HomeActive = By.xpath("//*[@id=\"navbar\"]/ul/li[1]");
	By FormActive = By.xpath("//*[@id=\"navbar\"]/ul/li[2]");
	
	By ErrorCode = By.xpath("/html/body/h1");
	By FormLocator = By.xpath("/html/body/div/div[1]/h1");
	By HomeHeaderLocator = By.xpath("/html/body/div/div[1]/h1");
	By HomeBodyLocator = By.xpath("/html/body/div/div[1]/p");
	
	By LogoLocator = By.xpath("//img[@src='assets/img/infinitefleet.jpeg']");
	
	By HomePageActive = By.xpath("//*[@id=\"navbar\"]/ul/li[1]");
	By FormPageActive = By.xpath("//*[@id=\"navbar\"]/ul/li[2]");
	
	By FormInputBox = By.id("hello-input");
	By FormSubmitButton = By.id("hello-submit");
	
	By FormNameResponse = By.xpath("//*[@id=\"hello-text\"]");
	
	private String desiredText = "UI Testing Site";
	
	private String homeHeaderText = "Welcome to Pixelmatic QA department";
	private String homeBodyText = "This site is dedicated to perform some exercises and demonstrate automated web testing.";
	private String ErrorSampleTextitle = "404 Error: File not found :-(";
	
	private WebDriver driver;
	UiTestingPage testingPage;

	@Before
	public void setUp() throws Exception {
		testingPage = new UiTestingPage(driver);
		driver = testingPage.chromeDriverConnection();
		testingPage.visit("http://127.0.0.1:8081/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void overallChecksTest() throws InterruptedException {
		testingPage.logoLocator(HomeIdLocator);
		testingPage.logoLocator(FormIdLocator);
		testingPage.logoLocator(UiIdLocator);

		testingPage.titleAsserter(HomeIdLocator,desiredText);
		testingPage.titleAsserter(FormIdLocator,desiredText);
		testingPage.titleAsserter(UiIdLocator,desiredText);
		
	}
	
	@Test
	public void navigationTest() throws InterruptedException {
		testingPage.navigateTabs(HomeIdLocator, HomeHeaderLocator, HomePageActive);
		testingPage.navigateTabs(FormIdLocator, FormLocator, FormPageActive);
		testingPage.navigateTabs(UiIdLocator, HomeHeaderLocator, HomePageActive);	
		
		
	}

	@Test
	public void displayedTextTest() throws InterruptedException {
		testingPage.click(HomeIdLocator);
		Thread.sleep(1000);
		testingPage.textFinder(HomeHeaderLocator,homeHeaderText);
		testingPage.textFinder(HomeBodyLocator,homeBodyText);
		
		Thread.sleep(1000);
		testingPage.click(ErrorIdLocator);
		testingPage.textFinder(ErrorCode,ErrorSampleTextitle);
	}
	
	@Test
	public void findInteractiveElementsTest() {
		testingPage.click(FormIdLocator);

		if (testingPage.interactiveFields(FormInputBox) && testingPage.interactiveFields(FormInputBox)) {
			System.out.print("Both interactive elements found ");
		} else { System.out.print("Some interactive elements not found ");
				}
	}
	
	@Test
	public void inputNameTest() {
		testingPage.inputName(FormIdLocator, FormInputBox, FormSubmitButton, "John");
		testingPage.textFinder(FormNameResponse, "Hello John!");
			
		}
	


}
