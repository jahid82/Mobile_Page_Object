package Source;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SetExtent {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static AndroidDriver<AndroidElement> driver;

	public static void setExtent() {

		// specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extent_Report/myReport.html");

		htmlReporter.config().setDocumentTitle("Mobile Test Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Jahid");
	}

	
	
	public static void endReport() {
		extent.flush();
	}

}
