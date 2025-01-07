package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public static Logger logger; // import org.apache.logging.log4j.Logger;

	@BeforeClass
	public void setup() throws IOException {

		// Create logger object to access the class
		 logger=LogManager.getLogger(this.getClass()); //import org.apache.logging.log4j.LogManager;

		// loading config.properites file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		
		p = new Properties();
		p.load(file);

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(p.getProperty("appURL")); // reading URL from properties file

	}

/*	@AfterClass
	public void tearDown() {

		driver.quit();
	}*/

}
