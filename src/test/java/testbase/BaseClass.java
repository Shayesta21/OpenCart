package testbase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com.gr/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}


	public String randomString() {
	 @SuppressWarnings("deprecation")
	String 	generatedstring=RandomStringUtils.randomAlphabetic(5);
	 return generatedstring;
	}

	public String randomNumber() {
		String randomnumber=RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}


	public String randomAN() {
		String randomAM=RandomStringUtils.randomAlphanumeric(5, 10);
		return randomAM;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
