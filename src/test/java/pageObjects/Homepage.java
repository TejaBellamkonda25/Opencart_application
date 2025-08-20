package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Baseclass {
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	


	@FindBy(xpath="//i[@class='fa fa-user']")
WebElement myaccount;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement register;
@FindBy(xpath= "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
WebElement login;

public void clickmyaccount() {
	myaccount.click();
}
public void clickregister() {
	register.click();
}
public void clicklogin() {
	login.click();
}

}
