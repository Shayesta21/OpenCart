package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		
		super(driver);
	}
	
		
	@FindBy(linkText="Register")
	WebElement LinkRegister;
	
	@FindBy(id="input-firstname")
	WebElement txtFirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtLastname;
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-telephone")
	WebElement txttelephone;
	
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmpwd;
	
	@FindBy(name="agree")
    WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement msgConfirmAccountRegister;
	
	
	
	public void clickRegister() {
		LinkRegister.click();
	}
	
	public void enterFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	
	public void enterLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void enteremail(String email) {
		 txtemail.sendKeys(email);
	}
	
	public void enterTelephone(String tel) {
		txttelephone.sendKeys(tel);
	}
	
		
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void enterConfrimpassword(String pwd) {
		txtConfirmpwd.sendKeys(pwd);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	
	public void clickprivacypolicy() {
		chkPrivacyPolicy.click();
	}
	
	public String getmsgConfirmation (){
		try {
			return msgConfirmAccountRegister.getText();
		}catch(Exception e){
			return(e.getMessage());
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
