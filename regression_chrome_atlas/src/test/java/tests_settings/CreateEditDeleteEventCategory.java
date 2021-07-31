package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteEventCategory extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 3, description = "open_Event_Settings")
	public void open_Event_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Event_Settings();
	}
	
	@Test(priority = 4, description = "create_Event_Category")
	public void create_Event_Category() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.create_Event_Category();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Settings")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 6, description = "open_Event_Settings_2nd_Time")
	public void open_Event_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Event_Settings();
	}

	@Test(priority = 7, description = "edit_Created_Category")
	public void edit_Created_Category() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.edit_Created_Category();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory_3rd_Time")
	public void user_Can_Open_Directory_3rd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 9, description = "open_Event_Settings_3rd_Time")
	public void open_Event_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Event_Settings();
	}
	
	@Test(priority = 10, description = "delete_Category_One")
	public void delete_Category_One() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.delete_Category_One();
	}
	
	@Test(priority = 11, description = "verify_Category_Not_Present")
	public void verify_Category_Not_Present() throws InterruptedException {
		test.assignCategory("Settings >> Create-Edit-Delete-Event-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Category_Not_Present();
	}
	
}