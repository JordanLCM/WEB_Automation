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
import utilities.ResultListener;

public class LoginBO {

	static String siteUrl = "https://wl003-bo.the777888.com/";
	static String driverType = "webdriver.chrome.driver";
	static String driverPath = "chromedriver.exe";
	static String reportName = "Login BO";
	static String userID = "jordan";
	static String passID = "test123";
	static String otp = "123456";


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
	
	@Test(dependsOnMethods = { "openWebsiteBO" }, priority = 1)
	public void loginFillInDetailsBO() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Fill in login details & login BO");
		func.inputloginBOUserID(userID);
		func.inputloginBOPassID(passID);
		func.inputloginBOOtp(otp);
		func.clickLoginBOButton();
	}
	
	@Test(dependsOnMethods = { "loginFillInDetails" }, priority = 2)
	public void verifyLoginBO() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Verify login BO");
		func.verifyBOUserID(userID);
	}

	@AfterMethod
	public void logCaseStatus(ITestResult result) {
		resultL.logCase(result);
	}
	
	@AfterClass
	public void endTest() throws InterruptedException {
		func.screenCaptureIfPassedFinalStep();
		bd.stopDriver();
		createR.doFlushTest();
	}
}
