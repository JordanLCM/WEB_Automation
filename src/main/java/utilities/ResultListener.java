package utilities;

import org.testng.ITestResult;

public class ResultListener {

	private static ResultListener resultL = new ResultListener();

	public static ResultListener getInstance() {
		return resultL;
	}

	CreateReports createR = CreateReports.getInstance();
	TakeScreenShot takeSS = TakeScreenShot.getInstance();

	private String resultOfCaseStatus;

	public void logCase(ITestResult result) {
		resultOfCaseStatus = result.getName();

		if (result.getStatus() == ITestResult.SUCCESS) {
			createR.getExtentTest().pass("Step : " + resultOfCaseStatus + " is passed!");
		}
		if (result.getStatus() == ITestResult.SKIP) {
			createR.getExtentTest().skip("Step : " + resultOfCaseStatus + " is skipped!");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			takeSS.getTakeScreenShot(resultOfCaseStatus);
			createR.getExtentTest().fail("Step : " + resultOfCaseStatus + " is failed!");
			createR.getExtentTest().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + resultOfCaseStatus + ".png", resultOfCaseStatus);
		}
	}
	
	public String resultOfCaseStatusExtent() {
		return resultOfCaseStatus;
	}
}