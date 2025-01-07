package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static String repName;
	
	public static ExtentReports generateExtentReport() throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
		
		repName="Test Report- "+timestamp+".html";
		ExtentReports extentReport=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\"+repName);
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(extentReportFile);
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("System Testing Results");
		sparkreporter.config().setDocumentTitle("EADAM Project Automation Testing Results");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkreporter);
		
		Properties  configPro=new Properties();
		File configPropFile=new File("./src//test//resources//config.properties");
		try {
			FileInputStream fis=new FileInputStream(configPropFile);
			configPro.load(fis);
		}catch (Throwable e)
		{
			e.printStackTrace();
		}
				
		extentReport.setSystemInfo("Application URL", configPro.getProperty("appURL"));
		extentReport.setSystemInfo("Environment Name", configPro.getProperty("env"));
		extentReport.setSystemInfo("User Name", configPro.getProperty("username"));
		extentReport.setSystemInfo("Browser Name", configPro.getProperty("browser"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Executed By", System.getProperty("user.name"));
		
		return extentReport;
		
	}

}
