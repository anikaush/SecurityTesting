package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static String URL = "http://localhost/inventory-management-system/";

	
	/*
	 * Initialize the Firefox driver and connect to the main page
	 * 
	 * */
	@BeforeClass
	public static void setUp() throws InterruptedException {
		driver = getDriver();
		driver.get(URL);
	}

	/*
	 * Terminate the driver after all the tests
	 * */
	@AfterClass
	public static void tearDown() {
		driver.quit();
		driver = null;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			// Uncomment to use Opera (suggested alternative)
			// WebDriverManager.operadriver().setup();
			// driver = new OperaDriver();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}

}