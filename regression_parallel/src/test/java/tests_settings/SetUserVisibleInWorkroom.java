package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_resource_library.MoveResourceFolderPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class SetUserVisibleInWorkroom extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "systemAdmin_Set_Workroom_Admin_2_To_Hidden")
	public void systemAdmin_Set_Workroom_Admin_2_To_Hidden() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.systemAdmin_Set_Workroom_Admin_2_To_Hidden();
	}
	
	@Test(priority = 4, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 5, description = "Auto_Director_Login.")
	public void Auto_Director_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser15, password);
	}
	
	@Test(priority = 6, description = "verify_Workroom_Admin_2_Hidden")
	public void verify_Workroom_Admin_2_Hidden() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Workroom_Admin_2_Hidden();
	}
	
	@Test(priority = 7, description = "user_Can_Logout_2nd_Time")
	public void user_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 9, description = "navigate_Back_To_Workroom_Members")
	public void navigate_Back_To_Workroom_Members() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.navigate_Back_To_Workroom_Members();
	}
	
	@Test(priority = 10, description = "make_Workroom_Admin_2_Visible")
	public void make_Workroom_Admin_2_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.make_Workroom_Admin_2_Visible();
	}
	
	@Test(priority = 11, description = "navigate_Back_To_Workroom_Members_Again")
	public void navigate_Back_To_Workroom_Members_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.navigate_Back_To_Workroom_Members();
	}
	
	@Test(priority = 12, description = "verify_Workroom_Admin_2_Hidden_Icon_Not_Present")
	public void verify_Workroom_Admin_2_Hidden_Icon_Not_Present() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Workroom_Admin_2_Hidden_Icon_Not_Present();
	}
	
	@Test(priority = 13, description = "user_Can_Logout_3rd_Time")
	public void user_Can_Logout_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 14, description = "system_Admin_Login_3rd_Time.")
	public void system_Admin_Login_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser15, password);
	}
	
	@Test(priority = 15, description = "verify_Workroom_Admin_Visible")
	public void verify_Workroom_Admin_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-Visible-In-Workroom");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Workroom_Admin_2_Visible();
	}

	
}