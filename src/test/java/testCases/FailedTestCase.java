package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClassificationsPage;
import testBase.BaseClass;
import utilities.CommonMethods;
import utilities.DataProviders;

public class FailedTestCase extends BaseClass {
	
	 	public ClassificationsPage cp;
				
		@Test(priority=1)
		public void Login() throws InterruptedException 
		{	
			CommonMethods.verify_Login();
		}
			
		@Test(priority=2,dataProvider="InCorrectData",dataProviderClass=DataProviders.class,dependsOnMethods= {"Login"}) //getting data provider from different class
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
				
			 
		} 
			 @Test(priority=3)
				public void LogOut() throws InterruptedException 
				{	
					CommonMethods.verify_LogOut();
				} 
				

}
