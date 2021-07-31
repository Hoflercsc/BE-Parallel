package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class DeactivateMessagingForUser extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Set_Permissions")
	public void open_User_Profile_Set_Permissions() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_3_Set_Permissions(autoUser3);
	}

	@Test(priority = 4, description = "click_To_Deactivate_Messaging")
	public void click_To_Activate_Deactivate_Messaging() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.click_To_Activate_Deactivate_Messaging();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.click_Sign_Out();
	}
	
	@Test(priority = 7, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser3, password);
	}
	
	@Test(priority = 8, description = "verify_Message_Users_Disabled")
	public void verify_Message_Users_Disabled() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Message_Users_Disabled();
	}
	
	@Test(priority = 9, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "Open_Auto_User_3_Profile_Set_Permissions")
	public void Open_Auto_User_3_Profile_Set_Permissions() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_3_Set_Permissions(autoUser3);
	}
	
	@Test(priority = 13, description = "activate_Messaging")
	public void click_To_Deactivate_Messaging() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.click_To_Deactivate_Messaging();
	}

	@Test(priority = 14, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objNavigation = new HomeNavigationPage();
		objNavigation.user_Close_Directory();
	}
	
}