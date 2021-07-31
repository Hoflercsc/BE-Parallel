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
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Enable_Private_Directory")
	public void open_User_Profile_Enable_Private_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Enable_Private_Directory();
	}
	
	@Test(priority = 4, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 5, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(wandaMartin, password);
	}
	
	@Test(priority = 6, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "verify_Only_Wanda_Martin_Visible")
	public void verify_Only_Wanda_Martin_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Only_Wanda_Martin_Visible();
	}
	
	@Test(priority = 8, description = "Wanda_Martin_Can_Logout")
	public void Wanda_Martin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 10, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 11, description = "verify_Profile_Enable_Private_Directory")
	public void verify_Profile_Enable_Private_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Enable-Private-Directory");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile_Enable_Private_Directory();

	}
	
}