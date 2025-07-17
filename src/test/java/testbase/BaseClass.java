package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger; //add log4j
	
	public Properties p;//to load config.propertiesfile
	
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters ({"os","browser"})
	public void setup(String os, String br) throws IOException {
	//	FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
	
		FileReader file1 = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file1);
		
		logger= LogManager.getLogger(this.getClass());//log4j entry do it only once in here
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver(); break;
		case "edge": driver= new EdgeDriver(); break;
		case "firefox" : driver =new FirefoxDriver(); break;
		default:System.out.println("This is an invalid browser"); return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	 // driver.get("https://tutorialsninja.com/demo/");
	// driver.get(p.getProperty("appurl")); //reading app url from config.poperty file
	   driver.get(p.getProperty("appurl").trim());
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
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

	
	public String captureScreen(String testname) throws IOException {
		
		String timeStamp= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot  screenshot= (TakesScreenshot) driver;    
		File sourcefile =screenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath = System.getProperty("user.dir")+"\\screenshots\\"+ testname+ "_"+timeStamp;
		File targetfile = new File (targetfilepath);
		
		sourcefile.renameTo(targetfile);
	                    
		return targetfilepath;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
