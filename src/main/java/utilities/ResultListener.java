package utilities;

import org.testng.ITestResult;

public class ResultListener {

	private static ResultListener resultL = new ResultListener();

	public static ResultListener get_Instance() {
		return resultL;
	}

	CreateReports createR = CreateReports.get_Instance();
	TakeScreenShot takeSS = TakeScreenShot.getInstance();

	private String resultOfCaseStatus;

	public void log_Case(ITestResult result) {
		resultOfCaseStatus = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			createR.get_Extent_Test().pass("Step = " + resultOfCaseStatus + " is passed!");
		}
		if (result.getStatus() == ITestResult.SKIP) {
			createR.get_Extent_Test().skip("Step = " + resultOfCaseStatus + " is skipped!");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			takeSS.getTakeScreenShot(resultOfCaseStatus);
			createR.get_Extent_Test().fail("Step = " + resultOfCaseStatus + " is failed!");
			createR.get_Extent_Test().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + resultOfCaseStatus + ".png", resultOfCaseStatus);
		}
	}
	
	public String result_Of_Case_Status_Extent() {
		return resultOfCaseStatus;
	}
}