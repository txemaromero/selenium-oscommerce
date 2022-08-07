package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import Processes.Process;
import io.github.bonigarcia.wdm.WebDriverManager;

class TestCase1 {
	
	public static final String OSCOMMERCE_URL = "http://sqademosatp.net/catalog/";
	
	private static WebDriver driver;
	private static ChromeOptions chromeOptions;
	private Process process; 
	
	public static void createAndStartService() throws IOException {
		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<String>();
		chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	}
	
	public static void createDriver() {
		driver = new ChromeDriver(chromeOptions);
	}
	
	public static void quitDriver() {
		driver.quit();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createAndStartService();	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}
	
	@BeforeEach
	void setUp() throws Exception {
		createDriver();
		driver.manage().window().maximize();
		process = new Process(driver);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		quitDriver();
	}
	
	@Test
	void test1() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Samsung");
		process.addToCart();
		process.updateQuantity("2");
		process.signInProcess();
		process.processOrderAndConfirm();
	}
	
	@Test
	void test2() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Beloved");
		process.addToCart();
		process.updateQuantity("3");
		process.signInProcess();
		process.processOrderAndConfirm();
	}

}
