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
	public void open_Website() throws InterruptedException, FailedLoginException {
		createR.do_Create_Test("open_Website".toUpperCase());
		func.open_To_URL(siteUrl);
	}

	@Test(priority = 1)
	public void close_Announcement() {
		createR.do_Create_Test("close_Announcement".toUpperCase());
	}

	@Test(dependsOnMethods = { "open_Website" }, priority = 2)
	public void click_Login_Option() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("click_Login_Option".toUpperCase());
		func.click_Login_Option();
	}

	@Test(dependsOnMethods = { "click_Login_Option" }, priority = 3)
	public void login_Pop_Up_Fill_In_Details() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("login_Pop_Up_Fill_In_Details".toUpperCase());
		func.login_Pop_Up_User_ID(userID);
		func.login_Pop_Up_Pass_ID(passID);
		func.login_Pop_Up_Otp(otp);
	}

	@Test(dependsOnMethods = { "login_Pop_Up_Fill_In_Details" }, priority = 4)
	public void click_Login_Button() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("click_Login_Button".toUpperCase());
		func.click_Login_Button();
	}

	@Test(dependsOnMethods = { "click_Login_Button" }, priority = 5)
	public void verify_Login() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("verify_Login".toUpperCase());
		func.verify_User_ID(userID);
	}
	
	@Test(dependsOnMethods = { "verify_Login" }, priority = 6)
	public void click_Logout_Button() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("click_Logout_Button".toUpperCase());
		func.logout_Of_User_ID();
	}

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
