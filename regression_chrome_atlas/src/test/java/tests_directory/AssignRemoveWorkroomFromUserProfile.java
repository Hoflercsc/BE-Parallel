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

public class AssignRemoveWorkroomFromUserProfile extends BaseTestDirectory {	
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void login_BE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile")
	public void open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 4, description = "add_Workroom_To_Profile")
	public void add_Workroom_To_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.add_Workroom_To_Profile();
	}

	@Test(priority = 5, description = "user_Can_Open_Dirctory_Again")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 6, description = "Open_User_Profile_Again")
	public void Open_User_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 7, description = "remove_Workroom_From_Profile")
	public void remove_Workroom_From_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.remove_Workroom_From_Profile();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory_3rd_Time")
	public void user_Can_Open_Directory_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 9, description = "Open_User_Profile_3rd_Time")
	public void Open_User_Profile_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}
	
	@Test(priority = 10, description = "verify_Workroom_Removed")
	public void verify_Workroom_Removed() throws InterruptedException {
		test.assignCategory("Directory >> Assign-Remove-Workroom-From-User-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Workroom_Removed();
	}

}