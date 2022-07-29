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

public class Register {

	static String siteUrl = "https://wl003.the777888.com/";
	static String driverType = "webdriver.chrome.driver";
	static String driverPath = "chromedriver.exe";
	static String reportName = "Register";
	static String userID = "qctester";
	static String passID = "test123";
	static String otp = "123456";
	static String referralID = "abc123";

	BaseDrivers bd = BaseDrivers.get_Instance();
	CreateReports createR = CreateReports.get_Instance();
	ResultListener resultL = ResultListener.get_Instance();
	Functions func = Functions.get_Instance();

	@BeforeClass
	public void Set_Property() throws InterruptedException {
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
	public void click_Register_Option() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("click_Register_Option".toUpperCase());
		func.click_Register_Option();
	}
	
	@Test(dependsOnMethods = { "click_Register_Option" }, priority = 2)
	public void register_Fill_In_Details() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("register_Fill_In_Details".toUpperCase());
		func.register_Pop_Up_User_ID(userID);
		func.register_Pop_Up_Pass_ID(passID);
		func.register_Pop_Up_Pass_Eyeicon();
		func.register_Pop_Up_Otp(otp);
		func.register_Pop_Up_Referral_Optional(referralID);
		func.register_Pop_Up_Date_Of_Birth();
		func.register_Click_Register_Button();
	}
	
	@Test(dependsOnMethods = { "register_Fill_In_Details" }, priority = 5)
	public void verify_Register() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("verify_Register".toUpperCase());
		func.verify_Registered_User_ID(userID);
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
