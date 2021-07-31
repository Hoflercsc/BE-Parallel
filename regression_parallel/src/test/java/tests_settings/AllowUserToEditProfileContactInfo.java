package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AllowUserToEditProfileContactInfo extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissionCS = new PermissionPage(); 
		objPermissionCS.systemAdmin_Set_User_As_Workroom_Admin(); 
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 4, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 5, description = "workroom_Admin_Can_Login")
	public void workroom_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin, password);
	}
	
	@Test(priority = 6, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "open_Edit_User_Profile")
	public void open_Edit_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_Profile(autoUser2);
	}
	
	@Test(priority = 8, description = "verify_Contact_Info_Saved_2nd_Time")
	public void edit_With_New_Contact_Information() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissions = new PermissionsPage();
		objPermissions.edit_With_New_Contact_Information_AutoUser2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 9, description = "workroom_Admin_Can_Logout")
	public void workroom_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "test_User_Login.")
	public void test_User_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser2, password);
	}
	
	@Test(priority = 11, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 12, description = "open_View_User_Profile")
	public void open_View_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_View_Profile(autoUser2);
	}

	@Test(priority = 13, description = "AutoUser2_Verify_Contact_Info_Saved")
	public void AutoUser2_Verify_Contact_Info_Saved() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissions = new PermissionsPage();
		objPermissions.AutoUser2_Verify_Contact_Info_Saved();
	}
	
	@Test(priority = 14, description = "test_User_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 15, description = "workroom_Admin_Can_Login_2nd_Time")
	public void workroom_Admin_Can_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin, password);
	}
	
	@Test(priority = 16, description = "user_Can_Open_Directory_3rd_Time")
	public void user_Can_Open_Directory_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 17, description = "open_Edit_User_Profile_2nd_Time")
	public void open_Edit_User_Profile_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");

		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_2_Profile(autoUser2);
	}
	
	@Test(priority = 18, description = "edit_With_Old_Contact_Information_AutoUser2")
	public void edit_With_Old_Contact_Information_AutoUser2() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissions = new PermissionsPage();
		objPermissions.edit_With_Old_Contact_Information_AutoUser2();
	}
	
	@Test(priority = 19, description = "verify_Old_Contact_Info_Auto_User_2_Saved")
	public void verify_Old_Contact_Info_Auto_User_2_Saved() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Old_Contact_Info_Auto_User_2_Saved();
	}
	
	@Test(priority = 20, description = "workroom_Admin_Can_Logout_3rd_Time")
	public void workroom_Admin_Can_Logout_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 21, description = "system_Admin_Login_2nd_Time")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 22, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 23, description = "systemAdmin_Disables_User_As_Workroom_Admin")
	public void systemAdmin_Disables_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objPermissionCS = new PermissionPage(); // using function from Critical Senaiors
		objPermissionCS.systemAdmin_Set_User_As_Workroom_Member(); 
	}
	
	
}