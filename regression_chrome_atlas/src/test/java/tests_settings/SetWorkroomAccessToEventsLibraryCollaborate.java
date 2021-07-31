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
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkroomPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class SetWorkroomAccessToEventsLibraryCollaborate extends BaseTestSettings {
	
	//-----------set_workroom_to_view_only-------------------------
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "disable_Workroom_Access_To_Events_Library_Discussions_Collaborate")
	public void disable_Workroom_Access_To_Events_Library_Collaborate() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.disable_Workroom_Access_To_Events_Library_Collaborate();
	}
	
	//-------------log out login as auto director--------------------
	@Test(priority = 4, description = "systemAdmin_Can_Logout")
	public void systemAdmin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 5, description = "autoDirector_Can_Login")
	public void autoDirector_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	//------------verify user cant see events library discussions collaborate --------------
	@Test(priority = 6, description = "open_DC_Workroom_Verify_Disabled_Access")
	public void open_DC_Workroom_Verify_Disabled_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Disabled_Access_For_DC_Workroom();
	}
	
	//-------------log out log in as system admin --------------------
	@Test(priority = 7, description = "autoDirector_Can_Logout")
	public void autoDirector_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "systemAdmin_Can_Login")
	public void systemAdmin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	//--------------- disable view only workroom option--------------------------------
	@Test(priority = 9, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 10, description = "enable_Workroom_Access_To_Events_Library_Collaborate")
	public void enable_Workroom_Access_To_Events_Library_Collaborate() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.enable_Workroom_Access_To_Events_Library_Collaborate();
	}
	
	//-------------log out log in as autodirector --------------------
	@Test(priority = 11, description = "systemAdmin_Can_Logout_Again")
	public void systemAdmin_Can_Logout_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 12, description = "autoDirector_Can_Login_Agaim")
	public void autoDirector_Can_Login_Agaim() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	//------------verify user can see events library discussions collaborate --------------
	@Test(priority = 13, description = "open_DC_Workroom_Verify_Enabled_Access")
	public void open_DC_Workroom_Verify_Enabled_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-Access-To-Events-Library-Collaborate");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Enabled_Access_For_DC_Workroom();
	}
	
}