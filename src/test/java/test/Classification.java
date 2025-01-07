package test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Classification {
	
	WebDriver driver;
	public Properties p;
	@Test
	public void classification() throws InterruptedException, IOException {
		
		// loading config.properites file
				FileReader file = new FileReader("./src//test//resources//config.properties");
				
				p = new Properties();
				p.load(file);

			
			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.manage().window().maximize();

			driver.get("http://localhost:9080/maximo/webclient/login/login.jsp?welcome=true");
			
			driver.findElement(By.id("username")).sendKeys("maxadmin");
			driver.findElement(By.id("password")).sendKeys("maxadmin");
			driver.findElement(By.id("loginbutton")).click();
			Thread.sleep(3000);
			
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println("Total number of iframes are " + iframeElements.size());
			
			driver.findElement(By.xpath("//button[@title='Open menu']//*[name()='svg']")).click();
			
			//Switch by Index 
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='AppNavSearchInput']")).sendKeys("Classifications");
							
			driver.findElement(By.xpath("//div[@data-search-input-id='AppNavSearchInput']//li[2]//a[1]")).click();
			                             
			
			driver.findElement(By.xpath("//input[@title='Quick Search menu']")).click();
			  Thread.sleep(500);
			
			driver.findElement(By.xpath("//a[@id='menu0_SEARCHMORE_OPTION_a']")).click();
			  Thread.sleep(100);
			
			driver.findElement(By.xpath("//input[@id='ma69628ae-tb']")).sendKeys("=Business_Product");
			
		
										 
			//  driver.findElement(By.xpath("//input[@id='ma69628ae-tb']")).sendKeys("=Scheme \\ Collection");
			
			  Thread.sleep(100);
			driver.findElement(By.xpath("//button[@title='Find']")).click();
			
			//WebElement TogetRows = driver.findElement(By.xpath("//table[@id='users_table']/tbody"));
		/*	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='m6a7dfd2f-to']//tr"));
			
			WebElement cellvalue = driver.findElement(By.xpath("//table[@id='m6a7dfd2f-to']/tbody/tr[5]/td[1]"));
			
			System.out.println("The total rows are :"+cellvalue.getText()); */
					
					
			String Class = driver.findElement(By.xpath("//input[@id='maa8ad01-tb']")).getAttribute("value");
			
			System.out.println("The Clasicification is: "+Class);
								
			String ClasPath = driver.findElement(By.xpath("//input[@id='md209854a-tb']")).getAttribute("value");
			
			System.out.println("The Clasicification Path is: "+ClasPath);
			
			Thread.sleep(100);
						
			String ClasPathDesc = driver.findElement(By.xpath("//input[@id='md209854a-tb2']")).getAttribute("value");
			
			System.out.println("The Clasicification Path Desc is: "+ClasPathDesc);
			
		   driver.findElement(By.xpath("//img[@id='md209854a-img2']")).click();
		   
		   Thread.sleep(100);
		   
		   
		   driver.switchTo().frame("ma6499a9c-rte_iframe");
		   Thread.sleep(200);
		   
		   String longDesc=driver.findElement(By.xpath("//div[@id='dijitEditorBody']")).getText();
		   

		   System.out.println("The Product long description is: "+longDesc);
		   
		   driver.switchTo().defaultContent();
		   Thread.sleep(200);
		   driver.switchTo().frame(0);
		   Thread.sleep(200);
		   
		   driver.findElement(By.xpath("//button[@title='OK']")).click();
		   
		   
		   String LocVal = driver.findElement(By.xpath("//div[@id='me3cb0834-tb']")).getAttribute("aria-checked");
		   System.out.println("The Location value is: "+LocVal);
		   
		   String OrderVal = driver.findElement(By.xpath("//input[@id='m7a6976ad-tb']")).getAttribute("value");
			
		   System.out.println("The Order Value is: "+OrderVal);
			
		  String Loc = driver.findElement(By.xpath("//input[@id='md199a579_tdrow_[C:1]_txt-tb[R:0]']")).getAttribute("value");
				
			System.out.println("The Location: "+Loc); 
			
		   
		   
		   
	}	
	
	}
