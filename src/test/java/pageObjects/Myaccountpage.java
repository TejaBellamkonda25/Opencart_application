package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myaccountpage extends Baseclass {
	
	public Myaccountpage(WebDriver driver) {
		super(driver);
	}
      
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	//@FindBy(className="list-group-item")
	WebElement myaccountpage;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutbtn;
	
	
	public boolean ismyaccountpageExicts() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return(myaccountpage.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
}
	/*public boolean ismyaccountpageExicts() {
	    try {
	        
	        wait.until(ExpectedConditions.visibilityOf(myaccountpage));
	        return myaccountpage.isDisplayed();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
*/
	
	public void clicklogout() {
		logoutbtn.click();
	}
	}
