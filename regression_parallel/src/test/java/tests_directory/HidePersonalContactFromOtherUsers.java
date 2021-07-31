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
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class HidePersonalContactFromOtherUsers extends BaseTestDirectory {
	@Test(priority = 1, description = "loginBE_SystemAdmin")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 3, description = "open_Features_Navigate_To_Configure")
	public void open_Features_Navigate_To_Configure() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Features_Navigate_To_Configure();
	}

	@Test(priority = 4, description = "activate_Hide_Company_Feature")
	public void activate_Hide_Company_Feature_For_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.activate_Hide_Company_Feature();
		DriverFactory.getInstance().getDriver().navigate().refresh();

	}

	@Test(priority = 6, description = "System_Admin_Can_Open_Directory")
	public void system_Admin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "open_AutoAdminUserGS1_Profile")
	public void open_AutoAdminUserGS1_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_AutoAdminUserGS1_Profile(autoAdminUserGS1);
	}
	
	@Test(priority = 8, description = "enable_Hide_Personal_Contact_From_Other_Users")
	public void check_Box_hide_personal_contact_from_other_users() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.enable_Hide_Personal_Contact_From_Other_Users();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 10, description = "System_Admin_Can_Logout")
	public void System_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "autoTester_Can_Login")
	public void autoTester_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser7,password); // autoUser Login
	}
	
	@Test(priority = 12, description = "WorkroomAdmin_Can_Open_Directory")
	public void WorkroomAdmin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 13, description = "view_AutoAdminUserGS1_Profile")
	public void view_AutoAdminUserGS1_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.view_AutoAdminUserGS1_Profile(autoAdminUserGS1);
	}
	
	@Test(priority = 14, description = "verify_Company_Contact_Info_Not_Visible")
	public void verify_Company_Contact_Info_Not_Visible() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Personal_Contact_Info_Not_Visible();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 16, description = "Workroom_Admin_Can_Logout")
	public void Workroom_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 17, description = "loginBE_SystemAdmin_2nd_Time")
	public void loginBE_SystemAdmin_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}
	
	@Test(priority = 18, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 19, description = "open_Features_Navigate_To_Configure_2nd_Time")
	public void open_Features_Navigate_To_Configure_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Features_Navigate_To_Configure();
	}
	
	@Test(priority = 20, description = "disable_Hide_Personal_Contact_From_Other_Users")
	public void disable_Hide_Personal_Contact_From_Other_Users() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Personal-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.deactivate_Hide_Company_Feature();
	}

	
	
	
}