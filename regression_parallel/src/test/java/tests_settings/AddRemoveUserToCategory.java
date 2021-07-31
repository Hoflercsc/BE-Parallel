package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

//------------------Selenium cant find this nested/layered continue button exhausted all solutions. confirmation has number atatched to it
/*
public class AddRemoveUserToCategory extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 3, description = "open_Manage_Users")
	public void open_Manage_Users() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Manage_Users();
	}
	
	@Test(priority = 4, description = "create_User_Category")
	public void create_User_Category() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.create_User_Category();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Settings")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 6, description = "open_Manage_Users_2nd_Time")
	public void open_Manage_Users_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Manage_Users();
	}
	
	@Test(priority = 7, description = "navigate_To_User_Catergories")
	public void navigate_To_User_Catergories() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.navigate_To_User_Catergories();
	}
	
	@Test(priority = 8, description = "add_User_To_Category")
	public void add_User_To_Category() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.add_User_To_User_Category();
	}
	
	@Test(priority = 9, description = "verify_User_Added_Then_Delete")
	public void verify_User_Added_Then_Delete() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objNavigation.user_Can_Open_Settings();
		objPermissions.open_Manage_Users();
		objPermissions.navigate_To_User_Catergories();
		objPermissions.verify_User_Added_Then_Delete();
	}
	
	@Test(priority = 10, description = "verify_Category_Not_Present")
	public void verify_Category_Not_Present() throws InterruptedException {
		test.assignCategory("Settings >> Add-Remove-User-To-Category");
		
		objPermissions = new PermissionsPage(driver);
		objNavigation.user_Can_Open_Settings();
		objPermissions.open_Manage_Users();
		objPermissions.navigate_To_User_Catergories();
		objPermissions.verify_Category_Not_Present_B();
	}
	
}

*/