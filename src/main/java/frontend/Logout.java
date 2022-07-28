package frontend;

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

public class Logout {

	static String siteUrl = "https://wl003.the777888.com/";
	static String driverType = "webdriver.chrome.driver";
	static String driverPath = "chromedriver.exe";
	static String reportName = "Logout";
	static String userID = "qctester4047";
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
	public void openWebsite() throws InterruptedException, FailedLoginException {
		createR.doCreateTest("Open website");
		func.openToURL(siteUrl);
	}

	@Test(priority = 1)
	public void closeAnnouncement() {
		createR.doCreateTest("Close Announcement");
	}

	@Test(dependsOnMethods = { "openWebsite" }, priority = 2)
	public void clickLoginOption() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Click login option");
		func.clickLoginOption();
	}

	@Test(dependsOnMethods = { "clickLoginOption" }, priority = 3)
	public void loginPopUpFillInDetails() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Login pop up fill in details");
		func.loginPopUpUserID(userID);
		func.loginPopUpPassID(passID);
		func.loginPopUpOtp(otp);
	}

	@Test(dependsOnMethods = { "loginPopUpFillInDetails" }, priority = 4)
	public void clickLoginButton() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Click login button");
		func.clickLoginButton();
	}

	@Test(dependsOnMethods = { "clickLoginButton" }, priority = 5)
	public void verifyLogin() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Verify login");
//		will remove when the Webpage is fixed
		bd.getDriver().get(siteUrl);
		func.verifyUserID(userID);
	}
	
	@Test(dependsOnMethods = { "verifyLogin" }, priority = 6)
	public void clickLogoutButton() throws FailedLoginException, InterruptedException {
		createR.doCreateTest("Click logout button");
		func.logoutOfUserID();
//		will remove when the Webpage is fixed
		bd.getDriver().get(siteUrl);
		Thread.sleep(1000);
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
