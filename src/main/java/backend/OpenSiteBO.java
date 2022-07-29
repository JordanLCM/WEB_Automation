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

	BaseDrivers bd = BaseDrivers.get_Instance();
	CreateReports createR = CreateReports.get_Instance();
	ResultListener resultL = ResultListener.get_Instance();
	Functions func = Functions.get_Instance();

	@BeforeClass
	public void set_Property() throws InterruptedException {
		createR.do_Generate_Report(reportName);
		bd.setDriverProperty(driverType, driverPath);
		bd.startDriver(siteUrl);
	}

	@Test(priority = 0)
	public void open_Website_BO() throws InterruptedException, FailedLoginException {
		createR.do_Create_Test("open_Website_BO".toUpperCase());
		func.open_To_URL(siteUrl);
	}
	
//	@Test(priority = 1)
//	public void fail() throws InterruptedException, FailedLoginException {
//		createR.doCreateTest("fail");
//		func.openToURL(siteUrl+"123");
//	}

	@AfterMethod
	public void log_Case_Status(ITestResult result) {
		resultL.log_Case(result);
	}
	
	@AfterClass
	public void end_Test() throws InterruptedException {
		bd.stopDriver();
		createR.do_Flush_Test();
	}
}
