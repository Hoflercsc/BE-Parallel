package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserAccessToManageFiles extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Auto_User_15_Set_Permissions")
	public void open_User_Profile_Auto_User_15_Set_Permissions() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_15_Set_Permissions(autoUser15);
	}

	@Test(priority = 4, description = "enable_User_To_Manage_Files")
	public void enable_User_To_Manage_Files() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objPermissions = new PermissionsPage();
		objPermissions.enable_User_To_Manage_Files();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.click_Sign_Out();
	}
	
	@Test(priority = 6, description = "test_User_Can_Login")
	public void test_User_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser15, password);
	}
	
	@Test(priority = 7, description = "user_Can_Open_Libraries_Form_2")
	public void user_Can_Open_Test_User_Libraries_Form() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Library_2();
	}
	
	@Test(priority = 8, description = "verify_New_Folder_Present_And_Close")
	public void verify_New_Folder_Present_And_Close() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_New_Folder_Present_And_Close();
	}

	@Test(priority = 9, description = "test_Reset_User_Can_Logout")
	public void test_Reset_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
		
	@Test(priority = 11, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "open_User_Profile_Auto_User_15_Set_Permissions_2nd_Time")
	public void open_User_Profile_Auto_User_15_Set_Permissions_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_15_Set_Permissions(autoUser15);
	}
	
	@Test(priority = 13, description = "disable_User_To_Mobile_Only")
	public void disable_User_To_Mobile_Only() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objPermissions = new PermissionsPage();
		objPermissions.disable_User_To_Manage_Files();
	}

	@Test(priority = 14, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Manage-Files");
		
		objNavigation = new HomeNavigationPage();
		objNavigation.user_Close_Directory();
	}
	
}