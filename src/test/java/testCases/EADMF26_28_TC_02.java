/* TC Name: EADMF26_28_TC_02 (Sprint 1)


   TC Description: Verify 166 classification records  created in Maximo for 'Facility' level classification 
   ENV: Dev
 
 */

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ClassificationsPage;
import testBase.BaseClass;
import utilities.CommonMethods;
import utilities.DataProviders;

public class EADMF26_28_TC_02 extends BaseClass{
	
			public ClassificationsPage cp;
					
			@Test(priority=1)
			public void Login() throws InterruptedException 
			{	
				CommonMethods.verify_Login();
			}
				 
			@Test(priority=2,dataProvider="ClassificationFacilityData",dataProviderClass=DataProviders.class,dependsOnMethods= {"Login"}) //getting data provider from different class
			public void verify_ClassificationFacility(String ClassificationPath,String Classification,String Desc,String ProdDesc,String ProdLongDesc,String Order,String FacilityOne, String FacilityTwo,String ClassCode) throws InterruptedException {
				
				
			    logger.info("***********Classification Facility Level Test Started***********");
				
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
				SoftAssert softAssert=new SoftAssert();
				 String txtClassLongDesc = cp.getClassificationLongDesc();
				 softAssert.assertEquals(txtClassLongDesc.trim(), ProdLongDesc.trim());
				
				 		 	
			 	  driver.switchTo().defaultContent();
				  Thread.sleep(200);
				  driver.switchTo().frame(0);
				  Thread.sleep(200);
			 	 cp.clickOKButton();
				
				//Validating the Order Value
				 String valOrder = cp.getOrder();
				 if(Order!="N/A") {
					 	
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
				 
				//Validating the Classification Code
				 String valClassCode = cp.getClassificationCode();
				 if(ClassCode!=" ") {
					 	
				 }else if(valClassCode.equals(ClassCode)) 
					  { 
						 Assert.assertTrue(true);
					  }
					 else 
					{
					System.out.println("The Classification Code Value displayed as :"+valClassCode); 
				    Assert.assertTrue(false);
				    }
				
				//Validating the Sequence of Length:
				 String  sequenceLen= cp.getSequenceLenth();
				 if(ClassCode!=" ") {
					 	
				 }else if(sequenceLen.equals("3")) 
					  { 
						 Assert.assertTrue(true);
					  }
					 else 
					{
					System.out.println("The Classification Code Value displayed as :"+valClassCode); 
				    Assert.assertTrue(false);
				    }
				 
					 
				 logger.info("*********** Classification Facility Level Test Finished***********");
				 
				 softAssert.assertAll();
				 	}

			@Test(priority=3)
			public void LogOut() throws InterruptedException 
			{	
				CommonMethods.verify_LogOut();
			}
			
	
}
