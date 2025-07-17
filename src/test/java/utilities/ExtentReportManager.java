package utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	
	public void onStart(ITestContext testcontext) {
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt= new Date();
		String curdatetimestamp=df.format(dt); //this will return the date in a string format
		
	//	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //the above three lines in one to avoid multiple variables
		
		repname= "Test-Report- " +curdatetimestamp+".html";
		
		sparkreporter = new ExtentSparkReporter(".\\reports\\"+repname); //specify the location of the report
		
		sparkreporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkreporter.config().setReportName("Openart Functional testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("SubModule","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		
		String os= testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System",os);	
		
		String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Broswer", browser);
		
		List<String> includedGroups= testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
	}
		
	public void onTestSuccess(ITestResult result) {
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"successfully executed");
		}
		
	
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+" test failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imppath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imppath);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
		
	}
	
	
	
	public void onTestSkipped(ITestResult result) {
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		}
		
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
		
		
		//optional code to open the file directly on the browser after execution
		
		  String pathofextentreport =System.getProperty("user.dir")+"\\reports\\repname";
		  File extentReport= new File( pathofextentreport);
		 
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e){
			e.printStackTrace();
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
