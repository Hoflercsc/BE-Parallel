package tests_settings;

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
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class TermInfoWithEverythingSettings extends BaseTestSettings {
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Settings_Manage_Users")
	public void open_Settings_Manage_Users() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Manage_Users();
	}

	@Test(priority = 3, description = "configure_TermInfo_with_Officer_Role_Settings")
	public void configure_TermInfo_with_Officer_Role_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage();
		obj_directory.configure_TermInfo_with_Officer_Role_Settings();
	}

	@Test(priority = 4, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 5, description = "pen_Test_Reset_User_Profile")
	public void open_Test_Reset_User_Profile() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Test_Reset_User_Profile(testReset);;
	}

	@Test(priority = 6, description = "verify_Delete_TermInfo")
	public void verify_Delete_TermInfo() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Delete_TermInfo();
	}

	@Test(priority = 7, description = "verify_TermInfo_Deleted")
	public void verify_TermInfo_Deleted() throws InterruptedException {
		test.assignCategory("Settings >> Term-Info-With-Everything");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_TermInfo_Deleted();
	}
}