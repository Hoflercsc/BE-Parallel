package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserToMobileOnly extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "directory_with_officer_role")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_18(autoUser18);
	}

	@Test(priority = 4, description = "enable_User_As_System_Administrator")
	public void enable_User_To_Mobile_Only() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objPermissions = new PermissionsPage();
		objPermissions.enable_User_To_Mobile_Only_Save();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser18, password);
	}
	
	@Test(priority = 8, description = "user_Can_See_Settings_Option")
	public void user_Login_Should_Fail() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objPermissions = new PermissionsPage();
		objPermissions.user_Login_Declined();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 11, description = "Open_User_Profile_2nd_Time")
	public void Open_User_Profile_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_18(autoUser18);
	}
	
	@Test(priority = 12, description = "disable_User_To_Mobile_Only")
	public void disable_User_To_Mobile_Only() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objPermissions = new PermissionsPage();
		objPermissions.disable_User_To_Mobile_Only_Save();
	}

	@Test(priority = 13, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Mobile-Only");
		
		objNavigation = new HomeNavigationPage();
		objNavigation.user_Close_Directory();
	}
	
}