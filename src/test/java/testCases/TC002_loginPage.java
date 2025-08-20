package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;

public class TC002_loginPage extends Baseclass{
	@Test(groups = {"Regration","Master"})
	public void verify_login() {
		try {
		logger.info("...Starting the TestCase...");
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		Loginpage lp = new Loginpage(driver);
		Thread.sleep(2000);
		lp.emailinput(p.getProperty("email"));
		lp.passwordinput(p.getProperty("password"));
		lp.clicklogin();
		
		Myaccountpage ma = new Myaccountpage(driver);
		boolean maapage = ma.ismyaccountpageExicts();
		Assert.assertTrue(maapage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("....Testcase has been Finished");
	}

}
