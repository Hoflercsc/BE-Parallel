package test_critical_scenarios;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
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
import extentreports.ExtentFactory;
import extentreports.ExtentManager;
import extentreports.GetScreenShot;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AttdReportPage;
import page_critical_scenarios.BookEventResourcePage;
import page_critical_scenarios.BookLargeFilePage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.DiscussionPage;
import page_critical_scenarios.EventPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.LibrariesPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.MyOwnBookPage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.PollPage;
import page_critical_scenarios.RsUserPwPage;
import page_critical_scenarios.SecuredCategoryPage;
import page_critical_scenarios.SurveyPage;
import page_critical_scenarios.TaskPage;
import page_critical_scenarios.UserProfilePage;
import page_critical_scenarios.WorkgroupPage;
import page_critical_scenarios.WorkgroupPageB;
import page_critical_scenarios.WorkroomPage;
import static constants.ConstantsFile.*; //https://veerasundar.com/blog/2012/04/java-constants-using-class-interface-static-imports/

public class BaseTestCriticalScenarios {
	// -------Reference Variables-------------
	// ----- High Level Test Cases -----
	LoginLogoutPage objBELogin;
	PollPage objCreatePoll;
	SurveyPage objCreateSurvey;
	TaskPage objCreateTaskGroup;
	DiscussionPage objCreateDiscussion;
	// -------------------------------
	UserProfilePage objUserProfile;
	EventPage objectEvent;
	WorkgroupPage objectWorkgroup;
	WorkgroupPageB objectWorkgroup_B;
	WorkroomPage objectWorkroom;
	HandbookPage objectHandbook;
	MessagePage objectMessage;
	LibrariesPage objectLibraries;
	BookTemplatePage objectBookTemplate;
	AttdReportPage objectAttdReport;
	RsUserPwPage objectRSPW;
	BookScannedPDFPage objectScannedPDF;
	PermissionPage objectPermision;
	BookEventResourcePage objectBookEventResource;
	MyOwnBookPage objectMyOwnBook;
	SecuredCategoryPage objectSecuredCategory;
	BookLargeFilePage objectLargeFile;
	ForeignLanguagePage objForeignLanguage;
	HomeNavigationPage objectHomePage;
	// -----------------------------
	protected static WebDriver driver;
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	public static String downloadPath = "C:\\IE";
	protected ExtentTest test;// --parent test
	ExtentReports report;
	ExtentTest childTest;

	@BeforeClass
	public void setUp() throws InterruptedException, MalformedURLException {
		// --------Extent Report--------
		// report = ExtentFactory.getInstance();
		report = ExtentManager.getInstance();
		// -----------------------------
		System.setProperty("webdriver.ie.driver", "C:\\GRID\\IEDriverServer.exe");
		InternetExplorerOptions capabilities = new InternetExplorerOptions();
		capabilities.ignoreZoomSettings();
		capabilities.setCapability("browser.download.folderList", 2);
		capabilities.setCapability("browser.download.manager.showWhenStarting", false);
		capabilities.setCapability("browser.download.dir", downloadPath);
		capabilities.setCapability("browser.helperApps.neverAsk.saveToDisk","application/octet-stream;application/csv;text/csv;application/vnd.ms-excel;");
		capabilities.setCapability("browser.helperApps.alwaysAsk.force", false);
		capabilities.setCapability("browser.download.manager.alertOnEXEOpen", false);
		capabilities.setCapability("browser.download.manager.focusWhenStarting", false);
		capabilities.setCapability("browser.download.manager.useWindow", false);
		capabilities.setCapability("browser.download.manager.showAlertOnComplete", false);
		capabilities.setCapability("browser.download.manager.closeWhenDone", false);
		System.out.println(System.getenv("BUILD_NUMBER"));
		String env = System.getProperty("BUILD_NUMBER");
		if (env == null) {
			driver = new RemoteWebDriver(new URL(COMPLETE_NODE_URL), capabilities);
			driver.manage().window().maximize();
			driver.get(HOME_PAGE);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
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
