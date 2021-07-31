package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class SetUserToHidden extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "Open_User_Test_User_Profile")
	public void Open_User_Test_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile();
	}

	@Test(priority = 4, description = "set_Test_User_To_Hidden")
	public void set_Test_User_To_Hidden() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.set_User_To_Hidden();
		driver.navigate().refresh();
	}

//	@Test(priority = 5, description = "user_Close_Directory")
//	public void user_Close_Directory() throws InterruptedException {
//		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
//		
//		objNavigation = new HomeNavigationPage(driver);
//		objNavigation.user_Close_Directory();
//	}
	
	@Test(priority = 6, description = "user_Can_Logout_System_Admin")
	public void user_Can_Logout_System_Admin() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory_Auto_Director")
	public void user_Can_Open_Directory_Auto_Director() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 9, description = "verify_Test_User_Not_In_List")
	public void verify_Test_User_NOT_In_List() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Test_User_Not_In_List();
		driver.navigate().refresh();
	}
	
//	@Test(priority = 10, description = "user_Close_Directory_Auto_Director")
//	public void user_Close_Directory_Auto_Director() throws InterruptedException {
//		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
//		
//		objNavigation = new HomeNavigationPage(driver);
//		objNavigation.user_Close_Directory();
//	}
	
	@Test(priority = 11, description = "user_Can_Logout_Auto_Director")
	public void user_Can_Logout_Auto_Director() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 12, description = "system_Admin_Login_2nd_Time.")
	public void system_Admin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 13, description = "system_Admin_Open_Directory_2nd_Time")
	public void system_Admin_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 14, description = "Open_User_Profile_2nd_Time")
	public void open_Test_User_Permisions_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_User_Profile();
	}
	
	@Test(priority = 15, description = "verify_User_Set_Back_To_Visible")
	public void verify_User_Set_Back_To_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.set_User_To_Visible();
	}

	@Test(priority = 16, description = "user_Close_Directory_2nd_time")
	public void user_Close_Directory_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-User-To-Hidden");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Close_Directory();
	}
	
	
	
}