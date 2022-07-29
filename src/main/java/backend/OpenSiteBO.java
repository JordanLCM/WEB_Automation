package backend;

import javax.security.auth.login.FailedLoginException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import methodFunctions.Functions;
import utilities.BaseDrivers;
import utilities.CreateReports;
import utilities.GenerateRandomNumbers;
import utilities.ResultListener;

public class OpenSiteBO {

	static String siteUrl = "https://wl003-bo.the777888.com/";
	static String driverType = "webdriver.chrome.driver";
	static String driverPath = "chromedriver.exe";
	static String reportName = "Open Site BO";

	BaseDrivers bd = BaseDrivers.getInstance();
	CreateReports createR = CreateReports.getInstance();
	ResultListener resultL = ResultListener.getInstance();
	Functions func = Functions.getInstance();

	@BeforeClass
	public void setProperty() throws InterruptedException {
		createR.doGenerateReport(reportName);
		bd.setDriverProperty(driverType, driverPath);
		bd.startDriver(siteUrl);
	}

	@Test(priority = 0)
	public void openWebsiteBO() throws InterruptedException, FailedLoginException {
		createR.doCreateTest("Open website BO");
		func.openToURL(siteUrl);
	}
	
//	@Test(priority = 1)
//	public void fail() throws InterruptedException, FailedLoginException {
//		createR.doCreateTest("fail");
//		func.openToURL(siteUrl+"123");
//	}

	@AfterMethod
	public void logCaseStatus(ITestResult result) {
		resultL.logCase(result);
	}
	
	@AfterClass
	public void endTest() throws InterruptedException {
		bd.stopDriver();
		createR.doFlushTest();
	}
}
