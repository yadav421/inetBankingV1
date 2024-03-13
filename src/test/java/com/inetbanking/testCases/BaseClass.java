package com.inetbanking.testCases;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username =  readconfig.getUserName();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	

	
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", readconfig.getChormePath());
		driver = new ChromeDriver();
		
        System.setProperty("log4j.configurationFile", "log4j2.properties");
		logger = LogManager.getLogger("ebanking");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
	}
	 
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	 	System.out.println("Screenshot taken");
		
	}
	

}
