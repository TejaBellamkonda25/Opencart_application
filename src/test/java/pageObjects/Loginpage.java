package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Baseclass{
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	
	WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	
	
	public void emailinput(String mail) {
		email.sendKeys(mail);
	}
	public void passwordinput(String pwd) {
		password.sendKeys(pwd);
	}
	public void clicklogin() {
		loginbutton.click();
	}
	

	

}
