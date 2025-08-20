package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_LoginDDT extends Baseclass{
	@Test(dataProvider = "username_passwords",dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email,String pwd,String exp) {
		logger.info("....Starting the TC003_LoginDDT....");
		try {
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount(); 
		hp.clicklogin();
		
		Loginpage lp = new Loginpage(driver);
		lp.emailinput(email);
		lp.passwordinput(pwd);
		Thread.sleep(2000);
		lp.clicklogin();
		
		Myaccountpage ma = new Myaccountpage(driver);
		boolean maccpage = ma.ismyaccountpageExicts();
		
		//valid data - login success - test pass -logout
		//             login fail - test fail
		
		
		//Invalid data - login success - test fail - logout
		                 // login fail - test pass
		
		if(exp.equalsIgnoreCase("valid")) {
			
			if(maccpage ==true) {
				ma.clicklogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
	}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(maccpage==true) {
				ma.clicklogout();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("....Completed the TC003_LoginDDT....");

	}

}
