package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends Baseclass{
	public Searchpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder='Search']")WebElement searchbox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement Button;
	@FindBy(xpath="//h1[normalize-space()='Search - phone']")WebElement confirmsearch;
	
	
	
	public void clickinputbox(String product) {
		searchbox.sendKeys(product);
	}
	public void clickbtn() {
		Button.click();
	}
	public boolean isPhoneExicts() {
		try {
		return(confirmsearch.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	
	

}
}
 