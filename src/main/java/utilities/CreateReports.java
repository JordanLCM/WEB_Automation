package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateReports {

	private static CreateReports createR = new CreateReports();
	
	public static CreateReports getInstance() {
		return createR;
	}
	
	BaseDrivers bd = BaseDrivers.getInstance();

	private ExtentSparkReporter sparkReport;
	private ExtentReports extentReport;
	private ExtentTest extentTest;
	
	private String userDir = System.getProperty("user.dir");
	private String pathOfReport = userDir + ".\\src\\main\\resources\\Reports\\";
	
	public void doGenerateReport(String nameOfReport) {
		extentReport = new ExtentReports();
		sparkReport = new ExtentSparkReporter(pathOfReport + nameOfReport + " test report.html");
		extentReport.attachReporter(sparkReport);

		extentReport.setSystemInfo("Platform", "Windows");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Java version", "JDK 17");
		extentReport.setSystemInfo("User", "Jordan");
	}
	
	public void doCreateTest(String testName) {
		extentTest = extentReport.createTest(testName);
	}
	
	public void doFlushTest() {
		extentReport.flush();
	}
	
	public ExtentReports getExtentReport() {
		return extentReport;
	}
	
	public ExtentTest getExtentTest() {
		return extentTest;
	}
}
