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
import page_common_functions.AtlasNavBar;
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
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_Test_Rest();
	}

	@Test(priority = 4, description = "enable_Hide_User_From_Directory")
	public void enable_Hide_User_From_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.enable_Hide_User_From_Directory();
		driver.navigate().refresh();
	}

	@Test(priority = 5, description = "System_Admin_Can_Logout")
	public void System_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 6, description = "test_Reset_Can_Login")
	public void test_Reset_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(testReset,password); // autoUser Login
	}

	@Test(priority = 7, description = "test_Reset_Can_Open_Directory")
	public void test_Reset_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 8, description = "verify_Test_Reset_Not_Present")
	public void verify_Test_Reset_Not_Present() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Test_Reset_Not_Present();
		driver.navigate().refresh();
	}
	
	@Test(priority = 9, description = "test_Reset_Can_Logout")
	public void test_Reset_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "system_Admin_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}
	
	@Test(priority = 11, description = "system_Admin_Can_Open_Directory")
	public void system_Admin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "open_User_Profile_Test_Reset_2nd_Time")
	public void open_User_Profile_Test_Reset_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_Test_Rest();
	}
	
	@Test(priority = 13, description = "disable_Hide_User_From_Directory")
	public void disable_Hide_User_From_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-User-From-Directory");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.disable_Hide_User_From_Directory();
	}
	
}