package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDrivers {

	private static BaseDrivers baseD = new BaseDrivers();

	public static BaseDrivers get_Instance() {
		return baseD;
	}

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
	
	private String driverPath = ".\\src\\main\\resources\\";

	public void setDriverProperty(String driverType, String path) {
		System.setProperty(driverType, driverPath + path);
	}
	
	public void startDriver(String siteUrl) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(siteUrl);
	}
	
	public void stopDriver() throws InterruptedException {
		Thread.sleep(1500);
		driver.quit();
	}
}
