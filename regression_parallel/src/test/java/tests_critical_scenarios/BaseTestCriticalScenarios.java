package tests_critical_scenarios;


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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import page_common_functions.AtlasNavBar;
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
import page_directory.DirectoryPage;
import parallel.BrowserFactory;
import parallel.DriverFactory;
import parallel.PropertiesOperations;
import static constants.ConstantsFile.*; //https://veerasundar.com/blog/2012/04/java-constants-using-class-interface-static-imports/
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extentreports.ExtentManager;
import extentreports.GetScreenShot;

public class BaseTestCriticalScenarios {
	// -------Reference Variables-------------
	LoginLogoutPage objBELogin;
	PollPage objCreatePoll;
	SurveyPage objCreateSurvey;
	TaskPage objCreateTaskGroup;
	DiscussionPage objCreateDiscussion;
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
	AtlasNavBar objectAtlasNavBar;

	// -----------------------------
	protected ExtentTest test;// --parent test
	ExtentReports report;

	BrowserFactory bf = new BrowserFactory();
	@BeforeClass
	public void setUp() throws Exception {
		report = ExtentManager.getInstance();
		
	    String browser = PropertiesOperations.getPropertyValueByKey("browser");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
