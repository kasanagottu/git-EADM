package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	
	@Test
	public void verify_Login() throws InterruptedException {
		
		logger.info("***********Login Test Case Started***********");
		
		try {
			
						
		// Enter username & password Login Page
			LoginPage lp = new LoginPage(driver);
			
			//lp.setUserName("maxadmin");
			lp.setUserName(p.getProperty("username"));
			lp.setPassword(p.getProperty("password"));
			//lp.setPassword("maxadmin");
			lp.clickLogin();
			
			logger.info("***********Validating the login page *********");
			//Home page
			HomePage hp = new HomePage(driver);
			Thread.sleep(2000);
			boolean taget = hp.isHomePageExists();
			Assert.assertEquals(taget, true, "Login Passed");
			// Assert.assertTrue(taget);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***********Login Test Case Finished***********");
	}
}

