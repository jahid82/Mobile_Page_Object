package utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Source.TestSupport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class Util {
	static AndroidDriver<AndroidElement>  driver;

	public Util(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	//Scroll down to a particular word
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	
	
	//	//method- take screen shot
	public static String takeScreenShot(String reportDirectory) throws IOException {

		String filePath = "";

		try {

			String dateTimeStamp = TestSupport.getCurrentDateTime(true, true);
			dateTimeStamp = dateTimeStamp.replace("/", "-");
			dateTimeStamp = dateTimeStamp.replace(":", "-");
			filePath = reportDirectory + "\\" + "Screenshots" + "\\" + dateTimeStamp + ".png";

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filePath));

		} catch (Exception e) {
			System.out.println("---> Could not take screenshot.");
		}

		return filePath;
	}


}
