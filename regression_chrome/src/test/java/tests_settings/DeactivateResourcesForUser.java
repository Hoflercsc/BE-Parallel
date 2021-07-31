package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class DeactivateResourcesForUser extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Deactivate_Resource")
	public void open_User_Profile_Deactivate_Resource() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Deactivate_Resource();
	}

	@Test(priority = 4, description = "user_Close_Directory")
	public void user_Close_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Close_Directory();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 6, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(testReset, password);
	}
	
	@Test(priority = 7, description = "verify_Resource_Library_Hidden")
	public void verify_Resource_Library_Hidden() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Resource_Library_Hidden();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 11, description = "open_User_Profile_Activate_Resource")
	public void open_User_Profile_Activate_Resource() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Activate_Resource();
	}

	@Test(priority = 12, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Close_Directory();
	}
	
}