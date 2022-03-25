package com.ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentrepot1 {
	
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	
	public void setup() {
		htmlreporter = new ExtentHtmlReporter("karna2.html");
		
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		
	}
	
	@BeforeTest
	 
	public void setUpTest() {
		
		String projectpath = System.getProperty("user dir");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	
	public void test1() {
		
		ExtentTest test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName(),"Sample Description");
		driver.get("https://www.facebook.com/");
		
		test.pass("Navigate to facebook");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	}
	
	@AfterTest
	 public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	 public void tearDownstep() {
		
		driver.quit();
		extent.flush();
	}

}
