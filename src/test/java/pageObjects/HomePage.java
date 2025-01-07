package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@title='Open menu']//*[name()='svg']") WebElement lnkOpenMenu;
	
	@FindBy(xpath="//button[@id='profile']") WebElement lnkprofile;
	
	@FindBy(xpath="//span[@id='suite-header-profile-menu-logout']") WebElement lnkprofileMenu;
	
	@FindBy(xpath="//button[normalize-space()='Log out']") WebElement btnlogout;
	
	public void clickProfile()
	{
		lnkprofile.click();
	}
	
	public void clickLogOut()
	{
		lnkprofileMenu.click();
	}
	
	public void clickPopLogOut()
	{
		btnlogout.click();
	}
	
	public boolean isHomePageExists()
	{
		try 
		{
			return (lnkOpenMenu.isDisplayed());	//if it is displayed return true
		}
		catch (Exception e)
		{
			return false;
		}
	}

}
