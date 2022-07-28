package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenShot {
	
	private static TakeScreenShot takeSS = new TakeScreenShot();
	
	public static TakeScreenShot getInstance() {
		return takeSS;
	}
	
	private String userDir = System.getProperty("user.dir");
	private String screenShotPath = userDir + ".\\src\\main\\resources\\Screenshots\\";

	BaseDrivers bd = BaseDrivers.getInstance();
	
	public void getTakeScreenShot(String fileName) {
		File screenShot = ((TakesScreenshot) bd.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String screenShotPathExtent() {
		String screenShotPathExtent = screenShotPath;
		return screenShotPath;
	}
}
