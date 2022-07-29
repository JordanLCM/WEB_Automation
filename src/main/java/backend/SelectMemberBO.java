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

public class SelectMemberBO {

	static String siteUrl = "https://wl003-bo.the777888.com/";
	static String driverType = "webdriver.chrome.driver";
	static String driverPath = "chromedriver.exe";
	static String reportName = "Select member BO";
	static String userID = "jordan";
	static String passID = "test123";
	static String otp = "123456";
	static String searchUserID = "20661";


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
	
	@Test(dependsOnMethods = { "open_Website_BO" }, priority = 1)
	public void login_Fill_In_Details_BO() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("login_Fill_In_Details_BO".toUpperCase());
		func.input_Login_BO_User_ID(userID);
		func.input_Login_BO_Pass_ID(passID);
		func.input_Login_BO_Otp(otp);
		func.click_Login_BO_Button();
	}
	
	@Test(dependsOnMethods = { "login_Fill_In_Details_BO" }, priority = 2)
	public void select_Member_Module_BO() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("select_Member_Module_BO".toUpperCase());
		func.choose_Module_Member_Management_BO();
		func.choose_Module_Member_List_BO();
	}
	
	@Test(dependsOnMethods = { "select_Member_Module_BO" }, priority = 3)
	public void select_Filtered_Member() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("select_Filtered_Member".toUpperCase());
		func.choose_Module_Member_List_User_Searchbox_BO(searchUserID);
		func.click_Search_Button_BO();
	}
	
	@Test(dependsOnMethods = { "select_Filtered_Member" }, priority = 3)
	public void select_Member() throws FailedLoginException, InterruptedException {
		createR.do_Create_Test("select_Member".toUpperCase());
		func.choose_Filtered_User_BO(searchUserID);
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
