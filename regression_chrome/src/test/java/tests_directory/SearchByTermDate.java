package tests_directory;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_intergrations.GoToMeetingPage;
import static constants.ConstantsFile.*;

public class SearchByTermDate extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Search-By-Term-Date");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Search-By-Term-Date");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 3, description = "open_Advanced_Search")
	public void open_Advanced_Search() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Term-Date");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_Advanced_Search();
	}

	@Test(priority = 4, description = "search_By_Term_Date")
	public void search_By_Term_Date() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Term-Date");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.search_By_Term_Date();
		driver.navigate().refresh();
	}
	
}