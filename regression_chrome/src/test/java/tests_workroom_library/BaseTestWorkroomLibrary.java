package tests_workroom_library;

import static constants.ConstantsFile.COMPLETE_NODE_URL;
import static constants.ConstantsFile.HOME_PAGE;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extentreports.ExtentManager;
import extentreports.GetScreenShot;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.SecuredCategoryPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;

public class BaseTestWorkroomLibrary {
	// -------Reference Variables-------------
	// ----- Regression Test Cases -----
	LoginLogoutPage objBELogin;
	HomeNavigationPage obj_navigation;
	DirectoryPage obj_directory;
	BookPage obj_meeting_book;
	BookScannedPDFPage objectScannedPDF;
	EventPage objectEvent;
	SecuredCategoryPage objectSecuredCategory;
	PermissionsPage objPermissions;
	// -------------------------------
	protected static WebDriver driver;
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	protected ExtentTest test;// --parent test
	ExtentReports report;
	ExtentTest childTest;

	@BeforeClass
	public void setUp() throws InterruptedException, MalformedURLException {
		// --------Extent Report--------
		// report = ExtentFactory.getInstance();
		report = ExtentManager.getInstance();
		// -----------------------------
		System.setProperty("webdriver.chrome.driver", "C:\\GRID\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		// --https://stackoverflow.com/questions/43143014/chrome-is-being-controlled-by-automated-test-software
		option.setExperimentalOption("useAutomationExtension", false);
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		// --https://stackoverflow.com/questions/56311000/how-can-i-disable-save-password-popup-in-selenium
		option.addArguments("--disable-features=VizDisplayCompositor");
		option.addArguments("--start-maximized");
		option.addArguments("--disable-gpu");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		option.setExperimentalOption("prefs", prefs);
		System.out.println(System.getenv("BUILD_NUMBER"));
		String env = System.getProperty("BUILD_NUMBER");
		
		if (env == null) {
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			capability.setCapability(ChromeOptions.CAPABILITY, option);
			option.merge(capability);
			driver = new RemoteWebDriver(new URL(COMPLETE_NODE_URL), capability);
			driver.get(HOME_PAGE);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			driver = new ChromeDriver(option);
			driver.get(HOME_PAGE);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}


	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		test = report.createTest(testName);
	}

	@AfterMethod
	public void catureStatus(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Method named as : " + result.getName() + " is passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String temp=GetScreenShot.getScreenshot(driver);
			test.log(Status.FAIL,"Test failure : " + (result.getThrowable().getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.PASS, "Test Method named as : " + result.getName() + " is skipped");
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		report.flush();
	}
}
