/* Sprint : 1
 
   User Story:EADMF26-24 (Configure Business and Business Product Level Classification)
 
   TC Name: BUSINESS PRODUCT level data validation (https://jira.watercorporation.com.au/browse/EADMF26-268)
   
   TC Description: Verify 14 classification records created in Maximo for 'BUSINESS PRODUCT' level classification .
   
 */

package testCases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClassificationsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class BP_level_DataValidation extends BaseClass {
	
	public ClassificationsPage cp;
	
	
	@Test(priority=1)
	public void verify_Login() throws InterruptedException  
	{	
		logger.info("***********Login Test Started***********");
		
		try {
		    // Enter User name & password Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(p.getProperty("username"));
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
	
	@Test(priority=2,dataProvider="ClassificationData",dataProviderClass=DataProviders.class,dependsOnMethods= {"verify_Login"}) //getting data provider from different class
	public void verify_Classification_BusinessProduct(String ClassificationPath,String Classification,String Desc,String ProdDesc,String ProdLongDesc,String Order) throws InterruptedException {
		
		logger.info("***********Classification Test BUSINESS PRODUCT level Started***********");
		
		Thread.sleep(1000);
		cp.clickQuickSearchMenu();
		cp.clickMoreSearchFields();
		cp.setClassificationPath("="+ClassificationPath);
		Thread.sleep(1000);
		cp.clickFind();
		Thread.sleep(1000);
		
		//Validating the Classification
		String txtClass = cp.getClassification();
		if(txtClass.equalsIgnoreCase(Classification.trim())) 
			if(txtClass.equalsIgnoreCase(Classification.trim())) 
			  { 
			 	Assert.assertTrue(true);
			 	
			  }
		else 
			{
			 System.out.println("The Classification is displayed as :"+txtClass);
			  Assert.assertTrue(false);
		    } 
		
		//Validating the Classification Description
		String txtClassDescription = cp.getClassDesc();
		if(txtClassDescription.equalsIgnoreCase(Desc.trim())) 
		  { 
		 	Assert.assertTrue(true);
		 	
		  }
		else 
		{
		 System.out.println("The Classification Description is displayed as :"+txtClassDescription);
		  Assert.assertTrue(false);
	    } 
			
		//Validating the Classification Path
		 String txtClassPath = cp.getClassificationPath();
		if(txtClassPath.equalsIgnoreCase(ClassificationPath.trim())) 
			{ 
			 Assert.assertTrue(true);
			}
	
		else 
		{
			 System.out.println("The Classification Path is displayed as :"+txtClassPath); 
			  Assert.assertTrue(false);
			  
		  } 
		
			
		 //Validating the Classification Path Description
		 	String txtClassPathDesc = cp.getClassificationDesc();
		 	if(txtClassPathDesc.equalsIgnoreCase(ProdDesc.trim())) 
		 		{ 
		 			Assert.assertTrue(true);
		 		}
	 
		 	else 
			{
		 		System.out.println("The Classification Path Description is displayed as :"+txtClassPathDesc);
			    Assert.assertTrue(false);
			   
		    }
		 
		 cp.clickImgClassificationDesc();
		 Thread.sleep(100);
		 driver.switchTo().frame("ma6499a9c-rte_iframe");
		 Thread.sleep(200);
		 
		//Validating the Classification Long Description
			String txtClassLongDesc = cp.getClassificationLongDesc();
		 	if(txtClassLongDesc.equalsIgnoreCase(ProdLongDesc.trim())) 
		 		{ 
		 			Assert.assertTrue(true);
		 		}
	 
		 	else 
			{
		 		System.out.println("The Classification Long description is displayed as :"+txtClassLongDesc);
			  Assert.assertTrue(false);
			   
		    }
		 	
		 	  driver.switchTo().defaultContent();
			   Thread.sleep(200);
			   driver.switchTo().frame(0);
			   Thread.sleep(200);
		 
		 cp.clickOKButton();
		 
		//Validating the Order Value
		 String valOrder = cp.getOrder();
		 if(Order!="NA") {
			 	
		 }else if(valOrder.equals(Order)) 
			  { 
				 Assert.assertTrue(true);
			  }
			 else 
			{
			System.out.println("The Order Value displayed as :"+valOrder); 
		    Assert.assertTrue(false);
		    } 
		 
		 
		//Validating the Location
		 boolean valLoc = cp.isLocationExists();
		 
		 Assert.assertTrue(valLoc);
		 logger.info("*********** Classification Test BUSINESS PRODUCT level Finished***********");
		 	}
	
	@Test(priority=3,dependsOnMethods= {"verify_Login"})
	public void verify_LogOut() throws InterruptedException 
	{
		 logger.info("*********** Logout Test started***********");
		
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='profile']")).click();
		driver.findElement(By.xpath("//span[@id='suite-header-profile-menu-logout']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Log out']")).click();  //Click logout button in displayed window
		driver.quit();
		
		logger.info("*********** Logout Test Finished***********");
	}
	
}

	
