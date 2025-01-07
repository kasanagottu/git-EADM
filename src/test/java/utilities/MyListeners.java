package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extendTest;
	String testname;

	@Override
	public void onStart(ITestContext context) { // This mean started the execution, not actual test method

		// Call generateExtentReport method from ExtentReporter class to generate report
		try {
			extentReport = ExtentReporter.generateExtentReport();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

		testname = result.getName();
		extendTest = extentReport.createTest(testname);
		extendTest.log(Status.INFO, testname + " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extendTest.log(Status.PASS, testname + " got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testname = result.getName();
		WebDriver driver = null;
		try {
		//	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationPath;
		try {
			destinationPath = Utilities.captureScreenshot(driver, testname);
		
		extendTest.addScreenCaptureFromPath(destinationPath);
		extendTest.log(Status.INFO, result.getThrowable());
		extendTest.log(Status.FAIL, testname + " got failed");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extendTest.log(Status.INFO, result.getThrowable());
		extendTest.log(Status.SKIP, testname + " got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();   //Consolidate all information and generate
		String pathOfExtentReport =System.getProperty("user.dir")+"\\ExtentReports\\"+ExtentReporter.repName;
		File extentReport=new File(pathOfExtentReport);
		try {
			 Desktop.getDesktop().browse(extentReport.toURI()); //This statement open the report automatically once the execution completed
		} catch(IOException e) {
			e.printStackTrace();
				
	}						


	}

}
