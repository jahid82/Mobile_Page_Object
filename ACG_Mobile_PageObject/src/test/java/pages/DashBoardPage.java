package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Source.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Util;


public class DashBoardPage extends BaseClass {

	
	
	public DashBoardPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(xpath="")
	private WebElement userID;
	


}
