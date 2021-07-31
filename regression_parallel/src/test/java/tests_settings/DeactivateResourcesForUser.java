package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class DeactivateResourcesForUser extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Auto_User_4_Deactivate_Resource")
	public void open_User_Profile_Auto_User_13_Deactivate_Resource() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_13_Deactivate_Resource(autoUser13);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.click_Sign_Out();
	}
	
	@Test(priority = 6, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser13, password);
	}
	
	@Test(priority = 7, description = "verify_Resource_Library_Hidden")
	public void verify_Resource_Library_Hidden() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Resource_Library_Hidden();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.click_Sign_Out();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 11, description = "open_User_Profile_Auto_User_13_Activate_Resource")
	public void open_User_Profile_Auto_User_13_Activate_Resource() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_13_Activate_Resource(autoUser13);
	}

	@Test(priority = 12, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Resources-For-User");
		
		objNavigation = new HomeNavigationPage();
		objNavigation.user_Close_Directory();
	}
	
}