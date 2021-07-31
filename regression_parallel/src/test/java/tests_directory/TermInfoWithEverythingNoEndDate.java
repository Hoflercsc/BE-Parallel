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

public class TermInfoWithEverythingNoEndDate extends BaseTestDirectory {
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "directory_with_officer_role")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_12_Profile(autoUser12);
	}

	@Test(priority = 4, description = "configure_TermInfo_Workroom_No_End_Date")
	public void configure_TermInfo_Workroom_No_End_Date() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.configure_TermInfo_Workroom_No_End_Date();
	}

	@Test(priority = 5, description = "close_User_Profile")
	public void close_Profile_TermInfo() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.close_Profile_TermInfo();
	}

	@Test(priority = 6, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "directory_with_officer_role")
	public void Open_User_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_12_Profile(autoUser12);
	}

	@Test(priority = 8, description = "delete_TermInfo")
	public void delete_TermInfo() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.delete_TermInfo();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Dirctory_3rd_Time")
	public void user_Can_Open_Dirctory_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 10, description = "Open_User_Profile_3rd_Time")
	public void Open_User_Profile_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_12_Profile(autoUser12);
	}

	@Test(priority = 11, description = "verify_TermInfo_Deleted")
	public void verify_TermInfo_Deleted() throws InterruptedException {
		
		test.assignCategory("Directory >> Term-Info-With-Everything-No-End-Date");
		obj_directory = new DirectoryPage();
		obj_directory.verify_TermInfo_Deleted();
	}
}