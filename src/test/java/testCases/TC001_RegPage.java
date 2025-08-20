package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.Homepage;
import testBase.Baseclass;

public class TC001_RegPage extends Baseclass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_account_registration() {
        try {
            logger.info("Testcase Started!");

            Homepage hp = new Homepage(driver);
            hp.clickmyaccount();
            logger.info("Clicked on My Account");

            hp.clickregister();
            logger.info("Clicked on Register");

            AccountRegistration ar = new AccountRegistration(driver);
            logger.info("Entering customer details");

            ar.setfirstname(randomeString().toUpperCase());
            ar.setlastname(randomeString().toUpperCase());
            ar.setemail(randomeString() + "@gmail.com");
            ar.setphn(randomnumber());

            String password = randomalphanumeric();
            ar.setpass(password);
            ar.setcpass(password);
            ar.setckbx();
            ar.setbtn();
            logger.info("Form submitted, waiting for confirmation");

            // Option 1: check visibility
            // boolean status = ar.getconfmsgVisible();
            // Assert.assertTrue(status, "Confirmation message not visible");

            // Option 2: check actual message text
            String msg = ar.getconfmsgText();
            Assert.assertEquals(msg, "Your Account Has Been Created!", "Registration confirmation text mismatch");

            logger.info("Testcase passed. Registration successful.");

        } catch (Exception e) {
            logger.error("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}




/*package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.Homepage;
import testBase.Baseclass;

public class TC001_RegPage extends Baseclass{
	
	
	@Test(groups = {"Sanity","Master"})
	public void verify_account_registration() throws InterruptedException {
		try {
		
		logger.info("Testcase Started!");  
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
		logger.info("clicked on myaccount");
		hp.clickregister();
		logger.info("clicked on Register");

		AccountRegistration ar = new AccountRegistration(driver);
		logger.info("entering all the details of the customer");

		ar.setfirstname(randomeString().toUpperCase());
		ar.setlastname(randomeString().toUpperCase());
		ar.setemail(randomeString()+"@gmail.com");
		ar.setphn(randomnumber());
		String password = randomalphanumeric();
		ar.setpass(password);
		ar.setcpass(password);
		ar.setckbx();
		Thread.sleep(3000);
		ar.setbtn();
		logger.info("Validating the messsage.....");

		    
		boolean msgconf = ar.getconfmsg();
		
		
		Assert.assertEquals(msgconf, "Your Account Has Been Created!", "Account registration confirmation failed");


		
		
		if(msgconf.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("Testcase failed......");
			logger.debug("debug logs");

			Assert.assertFalse(false);
		}
		
		
		
	}
		catch(Exception e) {
            Assert.fail();
		}

	}
	}
	*/
