package tests_set_permissions;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class RestrictWorkroomForUser extends BaseTestSetPermissions {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Click_Manage_Workrooms")
	public void open_User_Profile_Click_Manage_Workrooms() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Click_Manage_Workrooms();
	}
	
	@Test(priority = 4, description = "restrict_Workroom_Access")
	public void restrict_Workroom_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.restrict_Workroom_Access();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 6, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(testReset, password);
	}
	
	@Test(priority = 7, description = "verify_AutoAttend_Workroom_Deactivated")
	public void verify_AutoAttend_Workroom_Deactivated() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_AutoAttend_Workroom_Deactivated();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 11, description = "open_User_Profile_Click_Manage_Workrooms_Again")
	public void open_User_Profile_Click_Manage_Workrooms_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Click_Manage_Workrooms();
	}

	@Test(priority = 12, description = "enable_Workroom_Access")
	public void enable_Workroom_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.enable_Workroom_Access();
	}
	
	
}