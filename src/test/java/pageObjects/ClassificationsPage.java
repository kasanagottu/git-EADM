package pageObjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassificationsPage extends BasePage {
	
	public ClassificationsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@title='Open menu']//*[name()='svg']") WebElement lnkOpenMenu;
	
	@FindBy(xpath="//input[@id='AppNavSearchInput']") WebElement txtSearch;
	
	@FindBy(xpath="//div[@data-search-input-id='AppNavSearchInput']//li[2]//a[1]") WebElement lnkClassifications;
	
	@FindBy(xpath="//input[@title='Quick Search menu']") WebElement lnkQuickSearchMenu;
	
	@FindBy(xpath="//a[@id='menu0_SEARCHMORE_OPTION_a']") WebElement lnkSearchMore;
	
	@FindBy(xpath="//input[@id='ma69628ae-tb']") WebElement txtClassificationPath;
		
	@FindBy(xpath="//button[@title='Find']")  WebElement btnFind;
	
	@FindBy(xpath="//input[@id='maa8ad01-tb']") WebElement txtClassification;
	
	@FindBy(xpath="//input[@id='maa8ad01-tb2']") WebElement txtClassDesc;
		
	@FindBy(xpath="//input[@id='md209854a-tb']") WebElement FieldClassificationPath;
	
	@FindBy(xpath="//input[@id='md209854a-tb2']") WebElement txtClassificationDesc;
	
	@FindBy(xpath="//img[@id='md209854a-img2']") WebElement imgClassificationLongDesc;
	
	@FindBy(xpath="//div[@id='dijitEditorBody']") WebElement txtClassificationLongDesc;
	
	@FindBy(xpath="//button[@title='OK']")  WebElement btnOK;
	
	//@FindBy(xpath="//input[@id='me3cb0834-tb']") WebElement txtOrder;
	
	@FindBy(xpath="//input[@id='m7a6976ad-tb']") WebElement txtOrder;
	
	@FindBy(xpath="//input[@id='md199a579_tdrow_[C:1]_txt-tb[R:0]']") WebElement txtLoc;
	
	@FindBy(xpath="//input[@id='me3cb0834-tb']") WebElement toggleClassClass;
	
	@FindBy(xpath="//input[@id='me0ad6ac7-tb']") WebElement txtClassificationCode;
	
	public void clickOpenMenu()
	{
		try {
			lnkOpenMenu.click();
		} catch(StaleElementReferenceException e)
			{
			lnkOpenMenu.click();
			e.getMessage();
			}
		
	}
	
	public void setSearchKey(String SearchItem)
	{
		txtSearch.sendKeys(SearchItem);
	}
		
	public void clickClassifications()
	{
		lnkClassifications.click();
	}
	
	public void clickQuickSearchMenu()
	{
		lnkQuickSearchMenu.click();
	}
	
	public void clickMoreSearchFields()
	{
		lnkSearchMore.click();
	}

	public void setClassificationPath(String ClassificationClass)
	{
		txtClassificationPath.clear();
		txtClassificationPath.sendKeys(ClassificationClass);
	}
	
	public void clickFind()
	{
		btnFind.click();
	}
	
	public String getClassification()
	{
		return(txtClassification.getAttribute("value"));
		
	}
	
	public String getClassDesc()
	{
		return(txtClassDesc.getAttribute("value"));
		
	}
	
	public String getClassificationPath()
	{
		return(FieldClassificationPath.getAttribute("value"));
		
	}
	
	public String getClassificationDesc()
	{
		return(txtClassificationDesc.getAttribute("value"));
		
	}
	
	public void clickImgClassificationDesc()
	{
		imgClassificationLongDesc.click();
	}
	
	public String getClassificationLongDesc()
	{
		return(txtClassificationLongDesc.getText());
		
	}
	
	public void clickOKButton()
	{
		btnOK.click();
	}
	
	public String getOrder()
	{
		return(txtOrder.getAttribute("value"));
		
	}
	
	public boolean isLocationExists()
	{
		try 
		{
			return (txtLoc.isDisplayed());	//if it is displayed return true
		}
		catch (Exception e)
		{
			return false;
		}
		//return(txtLoc.getAttribute("value"));
		
	}
	
	public String getToggleClassLevel()
	{
		return(toggleClassClass.getAttribute("aria-checked"));
		
	}
	
	public String getClassificationCode()
	{
		return(txtClassificationCode.getAttribute("value"));
		
	}
	
	}
