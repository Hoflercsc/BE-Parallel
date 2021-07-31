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
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkroomPage;
import page_directory.DirectoryPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class UpdateProfilesWithCustomFieldData extends BaseTestSettings {
	
	//-----------set_workroom_to_view_only-------------------------
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Opens_Settings_Opens_Custom_Fields")
	public void user_Opens_Settings_Opens_Custom_Fields() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Custom_Fields();
	}

	@Test(priority = 3, description = "create_Custom_Field_Group")
	public void create_Custom_Field_Group() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.create_Custom_Field();
	}
	
	@Test(priority = 4, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 5, description = "open_User_Profile_AutoTester")
	public void open_User_Profile_AutoTester() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_AutoTester();
	}
	
	@Test(priority = 6, description = "verify_Custom_Field_Created")
	public void verify_Custom_Field_Created() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Custom_Field_Created();
	}
	
	@Test(priority = 7, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory_Agian() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 8, description = "open_User_Profile_AutoDirector")
	public void open_User_Profile_AutoDirector() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile_AutoDirector();
	}
	
	@Test(priority = 9, description = "verify_Custom_Field_Created_Again")
	public void verify_Custom_Field_Created_Again() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Custom_Field_Created();
	}
	
	@Test(priority = 10, description = "user_Opens_Settings_Opens_Custom_Fields_Again")
	public void user_Opens_Settings_Opens_Custom_Fields_Again() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Custom_Fields();
	}
	
	@Test(priority = 11, description = "delete_Custom_Field_Group")
	public void delete_Custom_Field_Group() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.delete_Custom_Field_Group_2();
	}
	
	@Test(priority = 11, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_4th_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_4th_Time() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Custom_Fields();
	}
	
	@Test(priority = 12, description = "verify_Custom_Field_Group_Deleted")
	public void verify_Custom_Field_Group_Deleted() throws InterruptedException {
		test.assignCategory("Settings >> Update-Profiles-With-Custom-Field-Data");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.verify_Custom_Field_Group_Deleted_2();
	}
	
}