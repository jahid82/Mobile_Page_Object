package Source;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TestSupport {
	public static AndroidDriver<AndroidElement> driver;
	public static void test_timeout(int t)
	{
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
		
	}
	
	
public static String getCurrentDateTime(boolean bdate, boolean btime)
	{
		String datetimeStamp;
		if(bdate && btime) {
			datetimeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(Calendar.getInstance().getTime());
			return datetimeStamp;
		}else if(bdate) {
			datetimeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			return datetimeStamp;
			
		}else if(btime) {
			datetimeStamp = new SimpleDateFormat("HH-mm-ss").format(Calendar.getInstance().getTime());
			return datetimeStamp;
		}
		else {
			return null;
		}
	}






}
