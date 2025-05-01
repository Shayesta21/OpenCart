package testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegisterPage;
import testbase.BaseClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC001_AccountRegisterTest extends BaseClass{


@Test
public void verify_AccountRegistration() throws InterruptedException {
	
	HomePage hp= new HomePage(driver);
	
	hp.clickMyAccount();
	hp.clickRegister();
	
	
	RegisterPage regp= new RegisterPage(driver);
	regp.enterFirstname(randomString().toUpperCase());
	regp.enterLastname(randomString().toUpperCase());
	regp.enteremail(randomString()+"@gmail.com");
	regp.enterTelephone(randomNumber());
	String pwd=randomAN();
	regp.enterPassword(pwd);
	regp.enterConfrimpassword(pwd);
	regp.clickprivacypolicy();
	Thread.sleep(4000);
	regp.clickContinue();
	
	String cmsg= regp.getmsgConfirmation();
	Assert.assertEquals(cmsg, "Congratulations! Your new account has been successfully created!");
}




}
