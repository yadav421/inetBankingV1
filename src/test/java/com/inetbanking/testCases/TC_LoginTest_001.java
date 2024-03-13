package com.inetbanking.testCases;

//import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import com.inetbanking.pageObjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws IOException 
	{
		driver.get(baseURL);
		logger.info("BaseURL succesfully open in browser");
		LoginPage lp = new LoginPage(driver);	
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		try {
            // Wait for 10 seconds
            Thread.sleep(20000);
        } 
		catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	

}
