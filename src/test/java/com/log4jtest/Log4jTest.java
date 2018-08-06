package com.log4jtest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jTest {
	//what is log4j:capturing info/activities at the time of program execution
	//types of logs
	//1.info
	//2.warn
	//3.error
	//4.fatal
	//how to generate the logs: using apache log 4j API(log4j jar)
	//how it works?: It reads log4j configuration from log4j.properties.file
	//where to create: create inside the resources folder
	
public WebDriver driver;
Logger  log=Logger.getLogger(Log4jTest.class);

	@BeforeMethod
	public void setUp()
	{
		log.info("***********************Starting test case execution****************************");
			
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		log.info("launching chrome browser");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			driver.get("https://www.freecrm.com/index.html");
			log.info("enter application url");
			log.warn("enter a warning message");
			log.fatal("this is fatal error messag");
			log.debug("this is debug message");
			
		}
		
	
	@Test(priority=1)
	public void freeCrmTitleTest(){
		log.info("***********************Starting test case****************************");
		log.info("***********************Free Title Test***************************");
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
		log.info("***********************ending test case****************************");
		log.info("***********************Free CRM Title Test***************************");
	}
	@Test(priority=2)
	public void freemCRMLogoTest(){
		
		log.info("***********************Starting test case****************************");
		log.info("***********************Free CRM Logo Test***************************");

		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		log.info("***********************ending test case****************************");
		log.info("***********************Free CRM Logo Test***************************");
		}
	
	
	@AfterMethod
	public void tearDown()
	{
		log.info("***********************browser is closed****************************");
		driver.quit();
		
	}
	
} 
