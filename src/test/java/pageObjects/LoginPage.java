package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
		public LoginPage(WebDriver driver) {
			super(driver);
		}

		@FindBy(id = "username")
		WebElement txtUserName;

		@FindBy(id = "password")
		WebElement txtUserPassword;
		
		@FindBy(id = "loginbutton")
		WebElement btnLogin;
		
		@FindBy(xpath="//input[@id='AppNavSearchInput']")
		WebElement txtSearch;
		
		
		public void setUserName(String username)
		{
			txtUserName.sendKeys(username);
		}
		
		public void setPassword(String pwd)
		{
			txtUserPassword.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}
	
		
		public void setSearch(String val)
		{
			txtSearch.sendKeys(val);;
		}
}



