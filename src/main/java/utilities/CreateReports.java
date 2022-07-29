package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateReports {

	private static CreateReports createR = new CreateReports();
	
	public static CreateReports get_Instance() {
		return createR;
	}
	
	BaseDrivers bd = BaseDrivers.get_Instance();

	private ExtentSparkReporter sparkReport;
	private ExtentReports extentReport;
	private ExtentTest extentTest;
	
	private String userDir = System.getProperty("user.dir");
	private String pathOfReport = userDir + ".\\src\\main\\resources\\Reports\\";
	
	public void do_Generate_Report(String nameOfReport) {
		extentReport = new ExtentReports();
		sparkReport = new ExtentSparkReporter(pathOfReport + nameOfReport + "_Report.html");
		extentReport.attachReporter(sparkReport);

		extentReport.setSystemInfo("Platform", "Windows");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Java version", "JDK 17");
		extentReport.setSystemInfo("User", "Jordan");
	}
	
	public void do_Create_Test(String testName) {
		extentTest = extentReport.createTest(testName);
	}
	
	public void do_Flush_Test() {
		extentReport.flush();
	}
	
	public ExtentReports get_Extent_Report() {
		return extentReport;
	}
	
	public ExtentTest get_Extent_Test() {
		return extentTest;
	}
}
