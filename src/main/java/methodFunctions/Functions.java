package methodFunctions;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;

import utilities.BaseDrivers;
import utilities.CreateReports;
import utilities.ResultListener;
import utilities.TakeScreenShot;

public class Functions {

	private static Functions func = new Functions();

	public static Functions getInstance() {
		return func;
	}

	CreateReports createR = CreateReports.getInstance();
	BaseDrivers bd = BaseDrivers.getInstance();
	ResultListener resultL = ResultListener.getInstance();
	TakeScreenShot takeSS = TakeScreenShot.getInstance();

	public void consoleLogFailTest(String caseFailed) throws InterruptedException, FailedLoginException {
		throw new FailedLoginException(caseFailed + " is fail");
	}

	public void consoleLogSkipTest(String caseFailed) throws InterruptedException {
		throw new SkipException(caseFailed + " is skipped");
	}

	public void openToURL(String siteUrl) throws FailedLoginException, InterruptedException {
		String pageUrl = bd.getDriver().getCurrentUrl();
		if (pageUrl.equals(siteUrl)) {
			createR.getExtentTest().info("Website = " + pageUrl);
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(750);
	}

	public void closeAnnouncement() {

	}

	public void clickLoginOption() throws FailedLoginException, InterruptedException {
		WebElement loginOptionButton = bd.getDriver().findElement(By.id("header_login"));
		if (loginOptionButton.isDisplayed()) {
			loginOptionButton.click();
		} else {
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(750);
	}

	private String loginAttributes = "placeholder";

	public void loginPopUpUserID(String userID) throws FailedLoginException, InterruptedException {
		WebElement loginOption = bd.getDriver().findElement(By.xpath("//div[@class='login_popup_title']"));
		if (loginOption.isDisplayed()) {
			createR.getExtentTest().info(loginOption.getText() + " visible");

			WebElement enterUserField = bd.getDriver().findElement(By.id("username"));
			createR.getExtentTest().info("Clicked " + enterUserField.getAttribute(loginAttributes));
			enterUserField.clear();
			enterUserField.sendKeys(userID);
			createR.getExtentTest().info("Keyed " + userID);
		} else {
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(500);
	}

	public void loginPopUpPassID(String passID) throws FailedLoginException, InterruptedException {
		WebElement enterPassField = bd.getDriver().findElement(By.id("password"));
		if (enterPassField.isDisplayed()) {
			createR.getExtentTest().info("Clicked " + enterPassField.getAttribute(loginAttributes));
			enterPassField.clear();
			enterPassField.sendKeys(passID);
			createR.getExtentTest().info("Keyed " + passID);
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(500);
	}

	public void loginPopUpOtp(String otp) throws FailedLoginException, InterruptedException {
		WebElement otpField = bd.getDriver().findElement(By.id("captcha_code"));
		if (otpField.isDisplayed()) {
			createR.getExtentTest().info("Clicked " + otpField.getAttribute(loginAttributes));
			otpField.clear();
			otpField.sendKeys(otp);
			createR.getExtentTest().info("Keyed " + otp);
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(500);
	}

	private String loginAttributesEnabled = "class";

	public void clickLoginButton() throws FailedLoginException, InterruptedException {
		WebElement loginButton = bd.getDriver().findElement(By.id("login_popup_btn"));
		String loginButtonEnabled = loginButton.getAttribute(loginAttributesEnabled);
		if (loginButtonEnabled.equals("btn btn_major active")) {
			loginButton.click();
			createR.getExtentTest().info("Clicked " + loginButton.getText());
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(1000);
	}

	public void verifyUserID(String userID) throws InterruptedException, FailedLoginException {
		WebElement loggedInUserID = bd.getDriver().findElement(By.xpath("(//a[contains(text(),'" + userID + "')])[1]"));
		String UserIDText = loggedInUserID.getText();
		if (loggedInUserID.isDisplayed()) {
			Actions action = new Actions(bd.getDriver());
			action.moveToElement(loggedInUserID).perform();
			createR.getExtentTest().info("Logged in to " + UserIDText);
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(1000);
	}

	public void logoutOfUserID() throws InterruptedException, FailedLoginException {
		WebElement logoutButton = bd.getDriver().findElement(By.xpath("//button[contains(text(),'登出')]"));
		String logoutText = logoutButton.getText();
		if (logoutText.equals("登出")) {
			logoutButton.click();
			createR.getExtentTest().info("Clicked " + logoutText);
		} else {
			Thread.sleep(1000);
			consoleLogFailTest(resultL.resultOfCaseStatusExtent());
		}
		Thread.sleep(1000);
	}

	public void screenCaptureIfPassedFinalStep() {
		takeSS.getTakeScreenShot(resultL.resultOfCaseStatusExtent() + " test end");
		createR.getExtentTest().info("Final step " + resultL.resultOfCaseStatusExtent() + " is passed!");
		createR.getExtentTest().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + resultL.resultOfCaseStatusExtent() + " test end.png", resultL.resultOfCaseStatusExtent());
	}
}