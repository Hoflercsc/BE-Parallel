package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class SetUserToEnablePrivateDirectory extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Enable_Private_Directory")
	public void open_User_Profile_Auto_User_16_Enable_Private_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_16_Enable_Private_Directory(autoUser16);
	}
	
	@Test(priority = 4, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 5, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser16, password);
	}
	
	@Test(priority = 6, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "verify_Only_Auto_User_16_Visible")
	public void verify_Only_Auto_User_16_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage();
		objPermissions.verify_Only_Auto_User_16_Visible();
	}
	
	@Test(priority = 8, description = "Wanda_Martin_Can_Logout")
	public void Wanda_Martin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 11, description = "open_User_Profile_Auto_User_16_Disable_Private_Directory")
	public void open_User_Profile_Auto_User_16_Disable_Private_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_16_Disable_Private_Directory(autoUser16);
	}
	
	@Test(priority = 12, description = "user_Can_Open_Directory_3rd_Time_")
	public void user_Can_Open_Directory_3rd_Time_() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 13, description = "open_Profile_Auto_User_16_Disable_Private_Directory")
	public void open_Profile_Auto_User_16_Disable_Private_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage();
		objPermissions.open_User_Profile_Auto_User_16_Disable_Private_Directory(autoUser16);
	}
	
}