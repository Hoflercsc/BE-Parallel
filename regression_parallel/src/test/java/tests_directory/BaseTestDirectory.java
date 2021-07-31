package tests_directory;

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
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extentreports.ExtentManager;
import extentreports.GetScreenShot;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_intergrations.GoToMeetingPage;
import page_intergrations.ZoomPage;
import page_resource_library.EditResourceFolderPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import page_workroom_events.EventPage;
import page_workroom_home.IframeVideoPage;
import page_workroom_home.LargeSrcDataPage;
import page_workroom_home.LineBreaksPage;
import page_workroom_home.UploadedImagePage;
import parallel.BrowserFactory;
import parallel.DriverFactory;
import parallel.PropertiesOperations;
import static constants.ConstantsFile.*; //https://veerasundar.com/blog/2012/04/java-constants-using-class-interface-static-imports/

public class BaseTestDirectory {
	// -------Reference Variables-------------
	// ----- Regression Test Cases -----
	LoginLogoutPage objBELogin;
	HomeNavigationPage obj_navigation;
	DirectoryPage obj_directory;
	PermissionPage objPermissionCS;// from critical senarios
	PermissionsPage objPermissions;
	HomeNavigationPage objNavigation;
	AtlasNavBar objAtlasNavBar;

	// -------------------------------
	protected static WebDriver driver;
	protected ExtentTest test;// --parent test
	ExtentReports report;
	
	BrowserFactory bf = new BrowserFactory();

	@BeforeClass
	@Parameters(value={"browser"})
	public void LaunchApplication() throws IOException, InterruptedException {
		
	    report = ExtentManager.getInstance();
	    String browser = PropertiesOperations.getPropertyValueByKey("browser");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(HOME_PAGE);
		
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
			String temp=GetScreenShot.getScreenshot();
			test.log(Status.FAIL,"Test failure : " + (result.getThrowable().getMessage()), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.PASS, "Test Method named as : " + result.getName() + " is skipped");
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		DriverFactory.getInstance().closeBrowser();
		report.flush();
	}
}
