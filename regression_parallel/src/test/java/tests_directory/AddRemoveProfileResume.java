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

public class AddRemoveProfileResume extends BaseTestDirectory {	
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void login_BE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile")
	public void open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_Profile(autoUser2);
	}

	@Test(priority = 4, description = "add_Photo_To_Profile")
	public void add_Resume_To_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.add_Resume_To_Profile();
	}

	@Test(priority = 6, description = "user_Can_Open_Dirctory_Again")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "open_Auto_User_2_Profile")
	public void open_Auto_User_2_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_Profile(autoUser2);
	}

	@Test(priority = 8, description = "delete_Photo")
	public void delete_Resume() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.delete_Resume();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Dirctory_3rd_Time")
	public void user_Can_Open_Dirctory_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 10, description = "open_Auto_User_2_Profile_3rd_Time")
	public void open_Auto_User_2_Profile_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_Profile(autoUser2);
	}

	@Test(priority = 11, description = "verify_Resume_Deleted")
	public void verify_Resume_Deleted() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Resume");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Resume_Deleted();
	}
}