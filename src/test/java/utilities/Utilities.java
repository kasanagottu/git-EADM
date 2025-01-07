package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static String captureScreenshot(WebDriver driver,String testname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File srcscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\Screenshots\\" + testname +"_"+timeStamp+".png";
		try {
			FileHandler.copy(srcscreenshot, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}
		
}
