package Source;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import configuration.Constants;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
//import utility.Log;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class BaseClass {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	 
	
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException {

		SetExtent.setExtent();
		
						
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Source\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String DeviceName = (String) prop.get("DeviceName");
		String PlatformName = (String) prop.get("PlatformName");
		String AUTOMATION_NAME = (String) prop.get("AUTOMATION_NAME");
		String udid = (String) prop.get("UDID");
		//String id = (String) prop.get("UserID");
		//String password = (String) prop.get("PassWord");
		
		//killAllNodes();
		//startServer();

		DesiredCapabilities cap = new DesiredCapabilities();
		// Log.info("ObjectProperty : " + object + " " + Value);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		System.out.println("--------- Connecting to the Android device ----------");
		cap.setCapability(MobileCapabilityType.UDID, udid);// Samsung 9
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		// Disabling screen keyboard
		cap.setCapability("unicodeKeyboard", true);

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.aaa.android.discounts");

		// new national APP_ACTIVITY-
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.aaa.android.discounts.activities.LaunchScreenActivity");

		System.out.println("------ Initializing Appium Settings -------");

		cap.setCapability("newCommandTimeout", 200);

		try {

			System.out.println("************* Opening Application ************");

			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

		} catch (Exception e) {
			// Log.error("############## Failed to Open App ##############");
			// Constants.TestCaseStatus = false;
			 //e.printStackTrace();
		}

		return;

	}
	
	@AfterMethod
	public void resultEvaloator(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
			String screenshotPath = getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			String screenshotPath = getScreenshot(driver, result.getName());
		}

	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	@AfterTest
	public void teardown() {

		// Log.info("********* Closing Application *************");
		try {
			SetExtent.endReport();
			driver.closeApp();
			
			//service.stop();
			
		} catch (Exception e) {
			// Log.error("########### Failed to close Application ##############");
			// Constants.TestCaseStatus = false;
			System.out.println("Message is:" + e.getCause());
			System.out.println("Message is:" + e.getMessage());
			//e.printStackTrace();
		}

	}
	
	//Kill all node before appium server start
		public void killAllNodes() throws IOException, InterruptedException
		{
		
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(3000);
			
		}
		

		//method- Start server automatically
		public AppiumDriverLocalService startServer() {

			boolean flag = checkIfServerIsRunnning(4723);
			if (!flag) {

				service = AppiumDriverLocalService.buildDefaultService();
				service.start();
			}
			return service;

		}

		//method- check if start is open or not
		public static boolean checkIfServerIsRunnning(int port) {

			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);

				serverSocket.close();
			} catch (IOException e) {
				// If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}
		
		

	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
}
