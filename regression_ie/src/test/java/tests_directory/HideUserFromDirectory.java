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

public class HideUserFromDirectory extends BaseTestDirectory {
	@Test(priority = 1, description = "loginBE_SystemAdmin")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_AutoTester();
	}

	@Test(priority = 4, description = "enable_Hide_User_From_Directory")
	public void enable_Hide_User_From_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.enable_Hide_User_From_Directory();
	}

	@Test(priority = 5, description = "close_Profile_AutoTester")
	public void close_Profile_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.close_Profile_AutoTester();
	}

	@Test(priority = 6, description = "System_Admin_Can_Logout")
	public void System_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}

	@Test(priority = 7, description = "autoTester_Can_Login")
	public void autoTester_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester,password); // autoUser Login
	}

	@Test(priority = 8, description = "AutoTester_Can_Open_Directory")
	public void AutoTester_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 9, description = "verify_AutoTester_Not_Present")
	public void verify_AutoTester_Not_Present() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_AutoTester_Not_Present();
	}
	
	@Test(priority = 10, description = "AutoTester_Close_Directory")
	public void AutoTester_Close_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Close_Directory();
	}
	
	@Test(priority = 11, description = "autoTester_Can_Logout")
	public void autoTester_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 12, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}
	
	@Test(priority = 13, description = "system_Admin_Can_Open_Directory")
	public void system_Admin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 14, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_AutoTester();
	}
	
	@Test(priority = 15, description = "disable_Hide_User_From_Directory")
	public void disable_Hide_User_From_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.enable_Hide_User_From_Directory();
	}
	
}