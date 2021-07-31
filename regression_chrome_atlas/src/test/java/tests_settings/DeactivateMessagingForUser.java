package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class DeactivateMessagingForUser extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "directory_with_officer_role")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile();
	}

	@Test(priority = 4, description = "click_To_Deactivate_Messaging")
	public void click_To_Activate_Deactivate_Messaging() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.click_To_Activate_Deactivate_Messaging();
		driver.navigate().refresh();
	}

//	@Test(priority = 5, description = "user_Close_Directory")
//	public void user_Close_Directory() throws InterruptedException {
//		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
//		
//		objNavigation = new HomeNavigationPage(driver);
//		objNavigation.user_Close_Directory();
//	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.click_Sign_Out();
	}
	
	@Test(priority = 7, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(testReset, password);
	}
	
	@Test(priority = 8, description = "verify_Message_Users_Disabled")
	public void verify_Message_Users_Disabled() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Message_Users_Disabled();
	}
	
	@Test(priority = 9, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "Open_User_Profile_2nd_Time")
	public void Open_Test_User_Profile_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile();
	}
	
	@Test(priority = 13, description = "activate_Messaging")
	public void click_To_Deactivate_Messaging() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.click_To_Deactivate_Messaging();
	}

	@Test(priority = 14, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Close_Directory();
	}
	
}