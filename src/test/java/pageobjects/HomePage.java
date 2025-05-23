package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (linkText="My Account")
	WebElement lnkmyaccount;

	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	
	public void clickMyAccount() {
	lnkmyaccount.click();	
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	
	
	
	

}
