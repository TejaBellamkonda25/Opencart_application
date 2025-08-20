package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Searchpage;
import testBase.Baseclass;

public class TC004_SearchTest extends Baseclass{
	@Test(groups = {"Sanity","Master"})
	public void verify_search() {
		
		try
		{
		logger.info("..Started verify_search..");
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		Loginpage lp = new Loginpage(driver);
		lp.emailinput(p.getProperty("email"));
		lp.passwordinput(p.getProperty("password"));
		lp.clicklogin();
		
		Searchpage sp = new Searchpage(driver);
		sp.clickinputbox("phone");
		sp.clickbtn();
		boolean page = sp.isPhoneExicts();
		Assert.assertTrue(page);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("..verify_search is finished..");
	}
	

}
