package methodFunctions;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;

import utilities.BaseDrivers;
import utilities.CreateReports;
import utilities.GenerateRandomNumbers;
import utilities.ResultListener;
import utilities.TakeScreenShot;

public class Functions {

	private static Functions func = new Functions();

	public static Functions get_Instance() {
		return func;
	}

	CreateReports createR = CreateReports.get_Instance();
	BaseDrivers bd = BaseDrivers.get_Instance();
	ResultListener resultL = ResultListener.get_Instance();
	TakeScreenShot takeSS = TakeScreenShot.getInstance();
	GenerateRandomNumbers genRN = GenerateRandomNumbers.getInstance();

	private String fieldAttributes = "placeholder";
	private String loginAttributesEnabled = "class";

	public void console_Log_Fail_Test(String caseFailed) throws InterruptedException, FailedLoginException {
		throw new FailedLoginException(caseFailed + " is fail");
	}

	public void console_Log_Skip_Test(String caseFailed) throws InterruptedException {
		throw new SkipException(caseFailed + " is skipped");
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void open_To_URL(String siteUrl) throws FailedLoginException, InterruptedException {
		String page_Url = bd.getDriver().getCurrentUrl();
		if (page_Url.equals(siteUrl)) {
			createR.get_Extent_Test().info("Website = " + page_Url);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(750);
	}

	public void close_Announcement() {

	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void click_Login_Option() throws FailedLoginException, InterruptedException {
		WebElement login_Option_Button = bd.getDriver().findElement(By.id("header_login"));
		if (login_Option_Button.isDisplayed()) {
			login_Option_Button.click();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}

	public void click_Register_Option() throws FailedLoginException, InterruptedException {
		WebElement register_Option_Button = bd.getDriver().findElement(By.id("header_register"));
		if (register_Option_Button.isDisplayed()) {
			register_Option_Button.click();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void login_Pop_Up_User_ID(String userID) throws FailedLoginException, InterruptedException {
		WebElement login_Option = bd.getDriver().findElement(By.xpath("//div[@class='login_popup_title']"));
		if (login_Option.isDisplayed()) {
			createR.get_Extent_Test().info(login_Option.getText() + " visible");

			WebElement enterUserField = bd.getDriver().findElement(By.id("username"));
			createR.get_Extent_Test().info("Clicked " + enterUserField.getAttribute(fieldAttributes));
			enterUserField.clear();
			enterUserField.sendKeys(userID);
			createR.get_Extent_Test().info("Keyed " + userID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void login_Pop_Up_Pass_ID(String passID) throws FailedLoginException, InterruptedException {
		WebElement enter_Pass_Field = bd.getDriver().findElement(By.id("password"));
		if (enter_Pass_Field.isDisplayed()) {
			createR.get_Extent_Test().info("Clicked " + enter_Pass_Field.getAttribute(fieldAttributes));
			enter_Pass_Field.clear();
			enter_Pass_Field.sendKeys(passID);
			createR.get_Extent_Test().info("Keyed " + passID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void login_Pop_Up_Otp(String otp) throws FailedLoginException, InterruptedException {
		WebElement otp_Field = bd.getDriver().findElement(By.id("captcha_code"));
		if (otp_Field.isDisplayed()) {
			createR.get_Extent_Test().info("Clicked " + otp_Field.getAttribute(fieldAttributes));
			otp_Field.clear();
			otp_Field.sendKeys(otp);
			createR.get_Extent_Test().info("Keyed " + otp);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void click_Login_Button() throws FailedLoginException, InterruptedException {
		WebElement login_Button = bd.getDriver().findElement(By.id("login_popup_btn"));
		String login_Button_Enabled = login_Button.getAttribute(loginAttributesEnabled);
		if (login_Button_Enabled.equals("btn btn_major active")) {
			login_Button.click();
			createR.get_Extent_Test().info("Clicked " + login_Button.getText());
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	String qctesterR;

	public void register_Pop_Up_User_ID(String userID) throws FailedLoginException, InterruptedException {
		WebElement Register_Pop_Up_User_ID_Option = bd.getDriver().findElement(By.xpath("//div[@class='register_popup_title']"));
		String Register_Pop_Up_User_ID_Text = Register_Pop_Up_User_ID_Option.getText();
		if (Register_Pop_Up_User_ID_Option.isDisplayed()) {
			createR.get_Extent_Test().info(Register_Pop_Up_User_ID_Text + " is visible");

			WebElement Register_Enter_User_Field = bd.getDriver().findElement(By.id("r_username"));

			String Register_Enter_User_Field_Attribute = Register_Enter_User_Field.getAttribute(fieldAttributes);
			qctesterR = userID + genRN.generateRandomNumbers();
			createR.get_Extent_Test().info("Clicked " + Register_Enter_User_Field_Attribute);
			Register_Enter_User_Field.clear();
			Register_Enter_User_Field.sendKeys(qctesterR);
			createR.get_Extent_Test().info("Keyed " + qctesterR);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Pop_Up_Pass_ID(String passID) throws FailedLoginException, InterruptedException {
		WebElement Register_Enter_Pass_Field = bd.getDriver().findElement(By.id("r_password"));
		String Register_Enter_Pass_Field_Attribute = Register_Enter_Pass_Field.getAttribute(fieldAttributes);
		if (Register_Enter_Pass_Field_Attribute.equals("请输入密码（6-15 位英文及数字）")) {
			createR.get_Extent_Test().info("Clicked " + Register_Enter_Pass_Field_Attribute);
			Register_Enter_Pass_Field.clear();
			Register_Enter_Pass_Field.sendKeys(passID);
			createR.get_Extent_Test().info("Keyed " + passID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Pop_Up_Otp(String otp) throws FailedLoginException, InterruptedException {
		WebElement Register_Enter_Otp_Field = bd.getDriver().findElement(By.id("ipt_code3"));
		String Register_Enter_Otp_Field_Attribute = Register_Enter_Otp_Field.getAttribute(fieldAttributes);
		if (Register_Enter_Otp_Field_Attribute.equals("请输入验证码")) {
			createR.get_Extent_Test().info("Clicked " + Register_Enter_Otp_Field_Attribute);
			Register_Enter_Otp_Field.clear();
			Register_Enter_Otp_Field.sendKeys(otp);
			createR.get_Extent_Test().info("Keyed " + otp);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Pop_Up_Pass_Eyeicon() throws FailedLoginException, InterruptedException {
		WebElement register_Pop_Up_Pass_Eyeicon_Button_Close = bd.getDriver().findElement(By.xpath("(//div[@class='ico ico-eye_close'])[2]"));
		String register_Pop_Up_Pass_Eyeicon_Button_Close_Attribute = register_Pop_Up_Pass_Eyeicon_Button_Close.getAttribute(loginAttributesEnabled);
		if (register_Pop_Up_Pass_Eyeicon_Button_Close_Attribute.equals("ico ico-eye_close")) {
			register_Pop_Up_Pass_Eyeicon_Button_Close.click();
			createR.get_Extent_Test().info("Clicked eye icon");
			Thread.sleep(500);

			WebElement register_Pop_Up_Pass_Eyeicon_Button_Open = bd.getDriver().findElement(By.xpath("(//div[@class='ico ico-eye_open'])[1]"));
			String register_Pop_Up_Pass_Eyeicon_Button_Open_Attribute = register_Pop_Up_Pass_Eyeicon_Button_Open.getAttribute(loginAttributesEnabled);
			if (register_Pop_Up_Pass_Eyeicon_Button_Open_Attribute.equals("ico ico-eye_open")) {
				register_Pop_Up_Pass_Eyeicon_Button_Open.click();
				createR.get_Extent_Test().info("Clicked eye icon again");
			}
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Pop_Up_Referral_Optional(String referralID) throws FailedLoginException, InterruptedException {
		WebElement register_Enter_Referral_Optional_Field = bd.getDriver().findElement(By.id("referral_code"));
		String register_Enter_Referral_Optional_Field_Attribute = register_Enter_Referral_Optional_Field.getAttribute(fieldAttributes);
		if (register_Enter_Referral_Optional_Field_Attribute.equals("请输入推荐码（非必填）")) {
			createR.get_Extent_Test().info("Clicked " + register_Enter_Referral_Optional_Field_Attribute);
			register_Enter_Referral_Optional_Field.clear();
			register_Enter_Referral_Optional_Field.sendKeys(referralID);
			Thread.sleep(500);
			register_Enter_Referral_Optional_Field.clear();
			createR.get_Extent_Test().info("Keyed " + referralID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Pop_Up_Date_Of_Birth() throws FailedLoginException, InterruptedException {
		WebElement register_Pop_Up_Date_Of_Birth_Field = bd.getDriver().findElement(By.id("r_dob"));
		String register_Pop_Up_Date_Of_Birth_Field_Attribute = register_Pop_Up_Date_Of_Birth_Field.getAttribute(fieldAttributes);
		if (register_Pop_Up_Date_Of_Birth_Field_Attribute.equals("出生日期")) {
			createR.get_Extent_Test().info("Clicked " + register_Pop_Up_Date_Of_Birth_Field_Attribute);
			register_Pop_Up_Date_Of_Birth_Field.click();
			WebElement select_Year = bd.getDriver().findElement(By.xpath("(//select[@class='yearselect'])[1]"));
			if (select_Year.isDisplayed()) {
				Select select = new Select(select_Year);
				Thread.sleep(500);
				select.selectByValue("1994");

				WebElement select_Day = bd.getDriver().findElement(By.xpath("//td[@class='weekend available'][normalize-space()='2']"));
				select_Day.click();
			}
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void register_Click_Register_Button() throws FailedLoginException, InterruptedException {
		WebElement register_Click_Register_Button_Enabled = bd.getDriver().findElement(By.id("register_btn"));
		String register_Click_Register_Button_Enabled_Text = register_Click_Register_Button_Enabled.getText();
		String register_Click_Register_Button_Enabled_Attribute = register_Click_Register_Button_Enabled.getAttribute(loginAttributesEnabled);
		if (register_Click_Register_Button_Enabled_Attribute.equals("btn btn_major active")) {
			createR.get_Extent_Test().info("Clicked " + register_Click_Register_Button_Enabled_Text);
			register_Click_Register_Button_Enabled.click();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void input_Login_BO_User_ID(String userID) throws FailedLoginException, InterruptedException {
		WebElement enterUserField = bd.getDriver().findElement(By.id("userEmail"));
		String enterUserFieldText = enterUserField.getAttribute(fieldAttributes);
		if (enterUserFieldText.equals("账号")) {
			createR.get_Extent_Test().info("Clicked " + enterUserFieldText);
			enterUserField.clear();
			enterUserField.sendKeys(userID);
			createR.get_Extent_Test().info("Keyed " + userID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void input_Login_BO_Pass_ID(String passID) throws FailedLoginException, InterruptedException {
		WebElement enter_Pass_Field = bd.getDriver().findElement(By.id("userPassword"));
		String enter_Pass_Field_Text = enter_Pass_Field.getAttribute(fieldAttributes);
		if (enter_Pass_Field_Text.equals("密码")) {
			createR.get_Extent_Test().info("Clicked " + enter_Pass_Field_Text);
			enter_Pass_Field.clear();
			enter_Pass_Field.sendKeys(passID);
			createR.get_Extent_Test().info("Keyed " + passID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void input_Login_BO_Otp(String otp) throws FailedLoginException, InterruptedException {
		WebElement enter_Otp_Field = bd.getDriver().findElement(By.id("totp"));
		String enter_Otp_Field_Text = enter_Otp_Field.getAttribute(fieldAttributes);
		if (enter_Otp_Field_Text.equals("一次性密码")) {
			createR.get_Extent_Test().info("Clicked " + enter_Otp_Field_Text);
			enter_Otp_Field.clear();
			enter_Otp_Field.sendKeys(otp);
			createR.get_Extent_Test().info("Keyed " + otp);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(500);
	}

	public void click_Login_BO_Button() throws FailedLoginException, InterruptedException {
		WebElement login_BO_Button = bd.getDriver().findElement(By.tagName("button"));
		String login_Button_Enabled = login_BO_Button.getText();
		if (login_Button_Enabled.equals("登录")) {
			login_BO_Button.click();
			createR.get_Extent_Test().info("Clicked " + login_Button_Enabled);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void verify_User_ID(String userID) throws InterruptedException, FailedLoginException {
		WebElement logged_In_User_ID = bd.getDriver().findElement(By.xpath("(//a[contains(text(),'" + userID + "')])[1]"));
		String user_ID_Text = logged_In_User_ID.getText();
		if (logged_In_User_ID.isDisplayed()) {
			Actions action = new Actions(bd.getDriver());
			action.moveToElement(logged_In_User_ID).perform();
			createR.get_Extent_Test().info("Logged in to " + user_ID_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}

	public void logout_Of_User_ID() throws InterruptedException, FailedLoginException {
		WebElement logout_Button = bd.getDriver().findElement(By.xpath("//button[contains(text(),'登出')]"));
		String logout_Text = logout_Button.getText();
		if (logout_Text.equals("登出")) {
			logout_Button.click();
			createR.get_Extent_Test().info("Clicked " + logout_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}

	public void verify_Registered_User_ID(String userID) throws InterruptedException, FailedLoginException {
		WebElement logged_In_User_ID = bd.getDriver().findElement(By.xpath("(//a[contains(text(),'" + qctesterR + "')])[1]"));
		String user_ID_Text = logged_In_User_ID.getText();
		if (logged_In_User_ID.isDisplayed()) {
			Actions action = new Actions(bd.getDriver());
			action.moveToElement(logged_In_User_ID).perform();
			createR.get_Extent_Test().info("Registered " + user_ID_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void verify_BO_User_ID(String userID) throws InterruptedException, FailedLoginException {
		WebElement logged_In_User_ID = bd.getDriver().findElement(By.xpath("//a[normalize-space()='" + userID + "']"));
		String user_ID_Text = logged_In_User_ID.getText();
		if (logged_In_User_ID.isDisplayed()) {
			logged_In_User_ID.click();
			createR.get_Extent_Test().info("Logged in to " + user_ID_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}

	public void logout_Of_BO_User_ID() throws InterruptedException, FailedLoginException {
		WebElement logout_Button_BO = bd.getDriver().findElement(By.xpath("//a[contains(text(),'登出')]"));
		String BO_Logout_Text = logout_Button_BO.getText();
		if (BO_Logout_Text.equals("登出")) {
			logout_Button_BO.click();
			createR.get_Extent_Test().info("Clicked " + BO_Logout_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void screen_Capture_If_Passed_Final_Step() {
		takeSS.getTakeScreenShot(resultL.result_Of_Case_Status_Extent() + " test end");
		createR.get_Extent_Test().info("Final step " + resultL.result_Of_Case_Status_Extent() + " is passed!");
		createR.get_Extent_Test().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + resultL.result_Of_Case_Status_Extent() + ".png", resultL.result_Of_Case_Status_Extent());
	}

//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>
	public void go_To_Deposit_Option() throws InterruptedException, FailedLoginException {
		WebElement Deposit_Option = bd.getDriver().findElement(By.xpath("//div[@class='nav_label'][contains(text(),'存款')]"));
		String Deposit_Option_Text = Deposit_Option.getText();
		if (Deposit_Option_Text.equals("存款")) {
			Deposit_Option.click();
			createR.get_Extent_Test().info("Clicked " + Deposit_Option_Text);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}

	public void go_To_Deposit_Option_Via_Floating_Icon() throws InterruptedException, FailedLoginException {
		WebElement floating_Wallet_Option = bd.getDriver().findElement(By.xpath("//div[@class='float_menu_icon wallet']"));
		if (floating_Wallet_Option.isDisplayed()) {
			Actions action = new Actions(bd.getDriver());
			action.moveToElement(floating_Wallet_Option).perform();

			Thread.sleep(500);
			WebElement floating_Wallet_Deposit_Option = bd.getDriver().findElement(By.xpath("//button[@class='btn btn_white btn_style'][contains(text(),'存款')]"));
			String floating_Wallet_Deposit_Option_Text = floating_Wallet_Deposit_Option.getText();
			if (floating_Wallet_Deposit_Option_Text.equals("存款")) {
				floating_Wallet_Deposit_Option.click();
			}
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}
//	>>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>> >>>

	public void choose_Module_Member_Management_BO() throws InterruptedException, FailedLoginException {
		WebElement module_Option_BO = bd.getDriver().findElement(By.xpath("(//a[@class='new_tab'])[2]"));
		String module_Option_BO_Text = module_Option_BO.getText();
		if (module_Option_BO_Text.equals("会员管理")) {
			Actions action = new Actions(bd.getDriver());
			action.moveToElement(module_Option_BO).perform();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}

	public void choose_Module_Member_List_BO() throws InterruptedException, FailedLoginException {
		WebElement module_Member_List_BO = bd.getDriver().findElement(By.xpath("//a[contains(text(),'会员列表')]"));
		String module_Member_List_BO_Text = module_Member_List_BO.getText();
		if (module_Member_List_BO_Text.equals("会员列表")) {
			module_Member_List_BO.click();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}

	public void choose_Module_Member_List_User_Searchbox_BO(String userID) throws InterruptedException, FailedLoginException {
		WebElement module_Filtered_Member_BO = bd.getDriver().findElement(By.xpath("//input[@placeholder='账户']"));
		String module_Filtered_Member_BO_Text = module_Filtered_Member_BO.getAttribute(fieldAttributes);
		if (module_Filtered_Member_BO_Text.equals("账户")) {
			module_Filtered_Member_BO.clear();
			module_Filtered_Member_BO.sendKeys("qctester" + userID);
			Thread.sleep(1000);
			module_Filtered_Member_BO.sendKeys(Keys.ENTER);
			createR.get_Extent_Test().info("Keyed qctester" + userID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}

	public void click_Search_Button_BO() throws InterruptedException, FailedLoginException {
		WebElement click_Search_Button_BO = bd.getDriver().findElement(By.xpath("//button[@id='search_member_btn']"));
		String click_Search_Button_BO_Text = click_Search_Button_BO.getText();
		if (click_Search_Button_BO_Text.equals("搜索")) {
			click_Search_Button_BO.click();
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(1000);
	}

	public void choose_Filtered_User_BO(String userID) throws InterruptedException, FailedLoginException {
		WebElement choose_Filtered_User_BO = bd.getDriver().findElement(By.xpath("//a[normalize-space()='qctester" + userID + "']"));
		if (choose_Filtered_User_BO.isDisplayed()) {
			choose_Filtered_User_BO.click();
			createR.get_Extent_Test().info("Clicked qctester" + userID);
		} else {
			Thread.sleep(1000);
			console_Log_Fail_Test(resultL.result_Of_Case_Status_Extent());
		}
		Thread.sleep(3000);
	}
}