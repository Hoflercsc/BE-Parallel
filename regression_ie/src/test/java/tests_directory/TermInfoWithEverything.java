package tests_directory;

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

public class TermInfoWithEverything extends BaseTestDirectory {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "Directory >> Term-Info-With-Everything")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 4, description = "configure_TermInfo_with_Officer_Role")
	public void configure_TermInfo_with_Officer_Role() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.configure_TermInfo_with_Officer_Role();
	}

	@Test(priority = 5, description = "close_User_Profile")
	public void close_Profile_TermInfo() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.close_Profile_TermInfo();
	}

	@Test(priority = 6, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 7, description = "Directory >> Term-Info-With-Everything")
	public void Open_User_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 8, description = "delete_TermInfo")
	public void delete_TermInfo() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.delete_TermInfo();
	}

	@Test(priority = 9, description = "verify_TermInfo_Deleted")
	public void verify_TermInfo_Deleted() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_TermInfo_Deleted();
	}
}