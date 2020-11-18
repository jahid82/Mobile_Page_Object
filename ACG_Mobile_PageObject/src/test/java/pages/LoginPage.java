package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Source.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPage extends BaseClass {

	public LoginPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	
	@AndroidFindBy(xpath="//*[@resource-id='login-user']/*[@class='android.widget.EditText']")
	private WebElement userID;

	@AndroidFindBy(xpath="//*[@resource-id='login-pass']/*[@class='android.widget.EditText']")
	private WebElement passWord;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.Button' and @index='0']")
	private WebElement submit;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.Button'and @index='3']")
	private WebElement skip_it;
	
		
		public void Handle_ZipGate() 
		{ 
			
				try {
					//WebDriverWait wait = new WebDriverWait(driver, 300);
					TouchAction touchAction = new TouchAction(driver);
					// Click on Continue Button
					Thread.sleep(8000);
					touchAction.tap(PointOption.point(720, 1580)).perform();

					// Click on Allow all the links
					touchAction.tap(PointOption.point(710, 2125)).perform();
					
					Thread.sleep(5000);
					// click on I Agree check box
					touchAction.tap(PointOption.point(184, 2319)).perform();

					
					// click continue Button
					touchAction.tap(PointOption.point(720, 2561)).perform();
					
					// Send user id+PassWord+Submit
					  WebDriverWait wait = new WebDriverWait(driver, 300);
					  wait.until(ExpectedConditions.visibilityOf(userID)).sendKeys("jFrank");
					  
					  wait.until(ExpectedConditions.visibilityOf(passWord)).sendKeys("seed135");
					  
					  wait.until(ExpectedConditions .visibilityOf(submit)) .click();
					  
					  wait.until(ExpectedConditions .visibilityOf(skip_it)) .click();
					  
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return;
		
		}

		
		 

	
	
}
