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

public class EditTermInfo extends BaseTestDirectory {
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "Open_User_Profile")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 4, description = "configure_TermInfo_with_Officer_Role")
	public void configure_TermInfo_with_Officer_Role() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.configure_TermInfo_with_Officer_Role();
		driver.navigate().refresh();
	}

	@Test(priority = 5, description = "user_Can_Open_Dirctory_Again")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 6, description = "Open_User_Profile_Again")
	public void Open_User_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}
	
	@Test(priority = 7, description = "edit_TermInfo_with_Officer_Role")
	public void edit_TermInfo_with_Officer_Role() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.edit_TermInfo_with_Officer_Role();
		driver.navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Dirctory_3rd_Time")
	public void user_Can_Open_Dirctory_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 9, description = "Open_User_Profile_3rd_Time")
	public void Open_User_Profile_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}
	
	@Test(priority = 10, description = "verify_Term_Change")
	public void verify_Term_Change() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Term_Change();
	}

	@Test(priority = 11, description = "deleted_Edited_Term_Info")
	public void deleted_Edited_Term_Info() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.deleted_Edited_Term_Info();
	}

	@Test(priority = 12, description = "verify_TermInfo_Deleted")
	public void verify_TermInfo_Deleted() throws InterruptedException {
		test.assignCategory("Directory >> Edit-Term-Info");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_TermInfo_Deleted();
	}
}