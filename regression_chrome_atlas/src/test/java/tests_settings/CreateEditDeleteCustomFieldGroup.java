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

public class CreateEditDeleteCustomFieldGroup extends BaseTestSettings {
	
	//-----------set_workroom_to_view_only-------------------------
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Custom_Fields();
	}

	@Test(priority = 3, description = "create_Custom_Field")
	public void create_Custom_Field() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.create_Custom_Field();
	}
	
	@Test(priority = 4, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Custom_Fields();
	}
	
	@Test(priority = 5, description = "create_Custom_Field")
	public void edit_Custom_Field() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.edit_Custom_Field();
	}
	
	@Test(priority = 6, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_3rd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Custom_Fields();
	}
	
	@Test(priority = 7, description = "delete_Custom_Field")
	public void delete_Custom_Field() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.delete_Custom_Field();
	}
	
	@Test(priority = 8, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_4th_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_4th_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Custom_Fields();
	}
	
	@Test(priority = 9, description = "verify_Custom_Field_Deleted")
	public void verify_Custom_Field_Deleted() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Custom-Field-Group");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.verify_Custom_Field_Deleted();
	}
	
}