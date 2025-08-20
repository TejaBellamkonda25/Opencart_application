package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistration extends Baseclass {

    public AccountRegistration(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement fname;

    @FindBy(id = "input-lastname")
    WebElement lname;

    @FindBy(id = "input-email")
    WebElement mail;

    @FindBy(id = "input-telephone")
    WebElement phn;

    @FindBy(id = "input-password")
    WebElement pass;

    @FindBy(id = "input-confirm")
    WebElement cpass;

    @FindBy(name = "agree")
    WebElement ckbx;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement Btn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgconfirmation;

    public void setfirstname(String name) {
        fname.sendKeys(name);
    }

    public void setlastname(String lastname) {
        lname.sendKeys(lastname);
    }

    public void setemail(String email) {
        mail.sendKeys(email);
    }

    public void setphn(String mobile) {
        phn.sendKeys(mobile);
    }

    public void setpass(String password) {
        pass.sendKeys(password);
    }

    public void setcpass(String confirmpassword) {
        cpass.sendKeys(confirmpassword);
    }

    public void setckbx() {
        ckbx.click();
    }

    public void setbtn() {
        Btn.click();
    }

    /*public boolean getconfmsgVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(msgconfirmation));
            return msgconfirmation.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
*/
    public String getconfmsgText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(msgconfirmation));
            return msgconfirmation.getText();
        } catch (Exception e) {
            return null;
        }
    }
}




/*package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends Baseclass {
	
	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement fname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement lname;
@FindBy(xpath="//input[@id='input-email']")
WebElement mail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement phn;
@FindBy(xpath="//input[@id='input-password']")
WebElement pass;    
@FindBy(xpath="//input[@id='input-confirm']")
WebElement cpass;
@FindBy(xpath="//input[@name='agree']")
WebElement ckbx;
@FindBy(xpath="//input[@value='Continue']")
WebElement Btn;


@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")

WebElement msgconfirmation;


public void setfirstname(String name) {
	fname.sendKeys(name);
}
public void setlastname(String lastname) {
	lname.sendKeys(lastname);
	
}
public void setemail(String email) {
	mail.sendKeys(email);
}
public void setphn(String mobile) {
	phn.sendKeys(mobile);
}
public void setpass(String password) {
	pass.sendKeys(password);
}
public void setcpass(String confirmpassword) {
	cpass.sendKeys(confirmpassword);
}
public void setckbx() {
	ckbx.click();
}
public void setbtn() {
	Btn.click();;
}
public boolean  getconfmsg() {
try {
	return(msgconfirmation.isDisplayed());
}
catch(Exception e) {
	return(false);
}

}



*/


