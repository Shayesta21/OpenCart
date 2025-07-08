package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003LoginDataDrivenTC extends BaseClass{
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")//getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException {
		
		logger.info("************Starting TC003LoginDataDrivenTC************ ");
		try {
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("enter email, password and click login button");
		LoginPage lp= new LoginPage(driver); 
		lp.enterEmail(p.getProperty("email"));	
		Thread.sleep(3000);
		lp.enterpasword(p.getProperty("password"));
		lp.clickLoginLP();
		
		AccountPage map= new AccountPage(driver);
	    boolean targetpage=	map.isAccountpageExist();
	    
	    /*
	     * Data is valid: login success -test pass-logout
	     *                login failed - test failed
	     *                
	     *Data is invalid: login success- test failed- logout
	     *                 login failed- test pass                 
	     *                
	     */
	    if(exp.equalsIgnoreCase("Valid")) {
	    	if(targetpage==true) {
	    		
	    		Assert.assertTrue(true);
	    		map.clickLogout();
	    		
	    	}else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(exp.equalsIgnoreCase("Invalid")) {
	    	if(targetpage==true) {
	    		
	    		Assert.assertTrue(true);
	    		map.clickLogout();
	    		
	    	}else
	   
	    	{
	    		Assert.assertTrue(false);
	    	}
	    	}
	    }catch (Exception e)
	    {
	    	Assert.fail();
	    }
	
    	logger.info("****************Test Case completed**********************");

	}
	
	
	
	
	

}
