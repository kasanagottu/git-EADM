/* Sprint : 1
 
   User Story: EADMF26-26 (Configure Scheme Level Classification)
 
   TC Name: Scheme level classification_data validation (https://jira.watercorporation.com.au/browse/EADMF26-270)
  
   TC Description: Verify 14 classification records created in Maximo for 'Scheme' level classification .
  */

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClassificationsPage;
import testBase.BaseClass;
import utilities.CommonMethods;
import utilities.DataProviders;

public class Scheme_level_DataValidation extends BaseClass {
	
		public ClassificationsPage cp;
				
		@Test(priority=1)
		public void Login() throws InterruptedException 
		{	
			CommonMethods.verify_Login();
		}
			
		@Test(priority=2,dataProvider="ClassificationSchemeData",dataProviderClass=DataProviders.class,dependsOnMethods= {"Login"}) //getting data provider from different class
		public void verify_ClassificationScheme(String ClassificationPath,String Classification,String Desc,String ProdDesc,String ProdLongDesc,String Order) throws InterruptedException {
			
			logger.info("***********Classification Scheme Level Test Started***********");
			
			cp = new ClassificationsPage(driver);
			Thread.sleep(1000);
			cp.clickQuickSearchMenu();
			cp.clickMoreSearchFields();
			cp.setClassificationPath("="+ClassificationPath);
			Thread.sleep(1000);
			cp.clickFind();
			Thread.sleep(1000);
			
			//Validating the Classification
			 String txtClass = cp.getClassification();
			 Assert.assertEquals(txtClass.toUpperCase(), Classification.toUpperCase());
			 
			//Validating the Classification Description
			 String txtClassDesc = cp.getClassification();
			 Assert.assertEquals(txtClassDesc.toUpperCase(), Classification.toUpperCase());
			
			//Validating the Classification Path
			 String txtClassPath = cp.getClassificationPath();
			 Assert.assertEquals(txtClassPath.toUpperCase(), ClassificationPath.toUpperCase());
			 				
			 //Validating the Classification Description
			 String txtClassPathDesc = cp.getClassificationDesc();
			 Assert.assertEquals(txtClassPathDesc.toUpperCase(), ProdDesc.toUpperCase());
			 				 
			 cp.clickImgClassificationDesc();
			 Thread.sleep(100);
			 driver.switchTo().frame("ma6499a9c-rte_iframe");
			 Thread.sleep(200);
			 
			//Validating the Classification Long Description
			 String txtClassLongDesc = cp.getClassificationLongDesc();
			 Assert.assertEquals(txtClassLongDesc.trim(), ProdLongDesc.trim());
			 		 	
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
			 logger.info("*********** Classification Scheme Level Test Finished***********");
			 	}

		@Test(priority=3)
		public void LogOut() throws InterruptedException 
		{	
			CommonMethods.verify_LogOut();
		}
		
	}

		



