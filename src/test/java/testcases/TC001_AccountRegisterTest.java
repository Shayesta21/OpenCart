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


@Test(groups={"Sanity","Master"})
public void verify_AccountRegistration() throws InterruptedException {
	
	try {
	logger.info("****************Starting TC001_AccountRegisterTest*************************");
	
	HomePage hp= new HomePage(driver);
	
	hp.clickMyAccount();
	hp.clickRegister();
	logger.info("Clicked on Register Link");
	
	RegisterPage regp= new RegisterPage(driver);
	
	logger.info("Providing customer details...");
	
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
	
	logger.info("Validating excepcted message");
	
    String cmsg= regp.getmsgConfirmation();
	Assert.assertEquals(cmsg, "Congratulations! Your new account has been successfully created!");
	
	/*if you want to test with test fail 
	String cmsg1= regp.getmsgConfirmation();
	if(cmsg1.equals("Congratulations! Your new account successfully created!")) {
	Assert.assertTrue(true);
	}else{
		logger.error("Test Failed");
		logger.debug("Debug logs");
		Assert.assertTrue(false);
	}*/
	
	}
	catch(Exception e){
		logger.error("Test Failed");
		logger.debug("Debug logs");
		Assert.fail();
	}
	logger.info("****************End TC001_AccountRegisterTest*************************");	
	}
}




