package tests;


import org.testng.annotations.Test;
import Source.BaseClass;
import pages.DashBoardPage;
import pages.LoginPage;
import utility.Util;
import utility.Util;



public class EndToEnd extends BaseClass {
	
	@Test
	public void E2E_Smoke() throws InterruptedException {
		
		
		LoginPage lp=new LoginPage(driver);
		lp.Handle_ZipGate();
	
		
		
		Util util=new Util(driver);
		util.scrollToText("Do More With Your Membership");
		
		Thread.sleep(5000);
		
		
		
		
	     
	}
	

}
