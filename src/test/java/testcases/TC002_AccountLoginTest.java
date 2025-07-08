package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testbase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	@Test (groups={"Regression","Master"})
	public void verify_login() {
	 
		logger.info("************Starting TC001_AccountLoginTest************ ");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("enter email, password and click login button");
		LoginPage lp= new LoginPage(driver); 
		lp.enterEmail(p.getProperty("email"));	
		Thread.sleep(3000);
		lp.enterpasword(p.getProperty("password"));
		lp.clickLoginLP();
		
		AccountPage ap= new AccountPage(driver);
	    boolean target=	ap.isAccountpageExist();
		
		Assert.assertEquals(target, true,"Login failed");
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****************Test Case completed**********************");
		
		
		
		
	
	}
	
	
	
	

}
