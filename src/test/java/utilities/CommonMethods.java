package utilities;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.ClassificationsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class CommonMethods extends BaseClass {
	
	public static ClassificationsPage cp;
	
	public static void verify_Login() throws InterruptedException 
	{	
		try {
		    // Enter Username & password Login Page
			LoginPage lp = new LoginPage(driver);
			try {
				lp.setUserName(p.getProperty("username"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			logger.info("***********Validating the login page *********");
			
			//validating Home page is displayed or not
			HomePage hp = new HomePage(driver);
			Thread.sleep(2000);
			boolean taget = hp.isHomePageExists();
			Assert.assertEquals(taget, true, "Login Passed");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		logger.info("***********Login Test Finished***********");
	
			//Home page
			cp = new ClassificationsPage(driver);
			
			cp.clickOpenMenu();
			
			//Switch by Index 
			driver.switchTo().frame(0);
			Thread.sleep(1000);
					
			cp.setSearchKey("Classifications");
			
			cp.clickClassifications();
		
	}	
	
	public static void verify_LogOut() throws InterruptedException 
	{
		logger.info("*********** Logout Test started***********");
		
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		
		
		driver.findElement(By.xpath("//button[@id='profile']")).click();
		driver.findElement(By.xpath("//span[@id='suite-header-profile-menu-logout']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Log out']")).click();//Click logout button in displayed window
		
		driver.quit();
		logger.info("*********** Logout Test Finished***********");
	}

}
