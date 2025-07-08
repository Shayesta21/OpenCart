package pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
		
		
		@FindBy(xpath="//h2[text()='My Account']" ) 
		WebElement msgHeading;
		
		@FindBy(linkText="Logout")
		WebElement lnklogout;
		
		public boolean isAccountpageExist() {
			try {
				return (msgHeading.isDisplayed());
			}catch(Exception e){
				return false;
			}
		}
		
		
		

		public void clickLogout() {
			
			lnklogout.click();
		}


		
			
		}
		
		
		
	


