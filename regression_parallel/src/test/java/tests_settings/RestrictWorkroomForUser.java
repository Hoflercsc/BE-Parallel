package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class RestrictWorkroomForUser extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Auto_User_14_Profile_Click_Manage_Workrooms")
	public void open_Auto_User_14_Profile_Click_Manage_Workrooms() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_Auto_User_14_Profile_Click_Manage_Workrooms(autoUser14);
	}
	
	@Test(priority = 4, description = "restrict_Workroom_Access")
	public void restrict_Workroom_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.restrict_Workroom_Access();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 6, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser14, password);
	}
	
	@Test(priority = 7, description = "verify_AutoAttend_Workroom_Deactivated")
	public void verify_AutoAttend_Workroom_Deactivated() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_AutoAttend_Workroom_Deactivated();
	}
	
	@Test(priority = 8, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 11, description = "open_User_Profile_Click_Manage_Workrooms_Again")
	public void open_User_Profile_Click_Manage_Workrooms_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_Auto_User_14_Profile_Click_Manage_Workrooms(autoUser14);
	}

	@Test(priority = 12, description = "enable_Workroom_Access")
	public void enable_Workroom_Access() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.enable_Workroom_Access();
	}
	
	@Test(priority = 13, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 14, description = "verify_Workroom_Access_Enabled")
	public void verify_Workroom_Access_Enabled() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Restrict-Workroom-For-User");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Workroom_Access_Enabled();
	}
	
	
}