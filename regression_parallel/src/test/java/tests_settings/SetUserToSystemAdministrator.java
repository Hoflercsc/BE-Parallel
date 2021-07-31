package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserToSystemAdministrator extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "directory_with_officer_role")
	public void Open_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_19(autoUser19);
	}

	@Test(priority = 4, description = "enable_User_As_System_Administrator")
	public void enable_User_As_System_Administrator() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objPermissions = new PermissionsPage();
		objPermissions.enable_User_As_System_Administrator();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser19, password);
	}
	
	@Test(priority = 8, description = "user_Can_See_Settings_Option")
	public void user_Can_See_Settings_Option() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objPermissions = new PermissionsPage();
		objPermissions.user_Can_See_Settings_Option();
	}
	
	@Test(priority = 9, description = "user_Can_Logout_2nd_Time")
	public void user_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "Open_User_Profile_2nd_Time")
	public void Open_User_Profile_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_19(autoUser19);
	}
	
	@Test(priority = 13, description = "disable_User_As_System_Administrator")
	public void disable_User_As_System_Administrator() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objPermissions = new PermissionsPage();
		objPermissions.disable_User_As_System_Administrator();
	}

	@Test(priority = 14, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-System-Administrator");
		
		objNavigation = new HomeNavigationPage();
		objNavigation.user_Close_Directory();
	}
	
}