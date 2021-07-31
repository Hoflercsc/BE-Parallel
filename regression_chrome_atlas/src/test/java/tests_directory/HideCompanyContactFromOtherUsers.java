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

public class HideCompanyContactFromOtherUsers extends BaseTestDirectory {
	@Test(priority = 1, description = "loginBE_SystemAdmin")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 3, description = "open_Features_Navigate_To_Configure")
	public void open_Features_Navigate_To_Configure() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_Features_Navigate_To_Configure();
	}

	@Test(priority = 4, description = "activate_Hide_Company_Feature")
	public void activate_Hide_Company_Feature_For_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.activate_Hide_Company_Feature();
	}

	@Test(priority = 5, description = "Reload_Home_Page")
	public void reload_Home_Page() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Test(priority = 6, description = "System_Admin_Can_Open_Directory")
	public void system_Admin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_AutoTester();
	}
	
	@Test(priority = 8, description = "enable_Hide_Company_Contact_From_Other_Users")
	public void check_Box_Hide_Company_Contact_From_Other_Users() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.enable_Hide_Company_Contact_From_Other_Users();
		driver.navigate().refresh();
	}
	
//	@Test(priority = 9, description = "enable_Hide_Company_Contact_From_Other_Users")
//	public void close_profile_And_Directory() throws InterruptedException {
//		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
//		
//		objAtlasNavBar = new AtlasNavBar(driver);
//		objAtlasNavBar.admin_Open_Directory();
//	}
//	
	@Test(priority = 10, description = "System_Admin_Can_Logout")
	public void System_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "autoTester_Can_Login")
	public void autoTester_Can_Login() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdmin,password); // autoUser Login
	}
	
	@Test(priority = 12, description = "WorkroomAdmin_Can_Open_Directory")
	public void WorkroomAdmin_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 13, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.view_Profile_AutoTester();
	}
	
	@Test(priority = 14, description = "verify_Company_Contact_Info_Not_Visible")
	public void verify_Company_Contact_Info_Not_Visible() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Company_Contact_Info_Not_Visible();
		driver.navigate().refresh();
	}
	
	@Test(priority = 16, description = "System_Admin_Can_Logout")
	public void Workroom_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 17, description = "loginBE_SystemAdmin_2nd_Time")
	public void loginBE_SystemAdmin_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}
	
	@Test(priority = 18, description = "user_Can_Open_Settings_2nd_Time")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 19, description = "open_Features_Navigate_To_Configure_2nd_Time")
	public void open_Features_Navigate_To_Configure_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_Features_Navigate_To_Configure();
	}
	
	@Test(priority = 20, description = "disable_Hide_Company_Contact_From_Other_Users")
	public void disable_Hide_Company_Contact_From_Other_Users() throws InterruptedException {
		test.assignCategory("Directory >> Hide-Company-Contact-From-Other-Users");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.deactivate_Hide_Company_Feature();
	}

	
	
	
}