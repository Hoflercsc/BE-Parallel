package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class AllowUserToAddFilesToWorkroom extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.user_Open_Settings_Then_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "verify_Add_Files_Disable_For_Workroom_For_User")
	public void verify_Add_Files_Disable_For_Workroom_For_User() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		// make sure manage files is disabled and add files to workroom is enabled
		//normal board member should not have to have (manage files enabled to see files in workroom:
		objPermissions = new PermissionsPage(driver); 
		objPermissions.disable_Add_Files_To_Workroom_For_User(); 
	}
	
	@Test(priority = 4, description = "system_Admin")
	public void system_Admin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 5, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 6, description = "user_Can_Open_Other_Files")
	public void user_Can_Open_Other_Files() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Open_Other_Files(); 
	}
	
	@Test(priority = 7, description = "user_Can_Add_File_To_Workroom")
	public void user_Can_Add_File_To_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Add_File_To_Workroom(); 
	}
	
	@Test(priority = 8, description = "user_Can_Open_Other_Files_2nd_time")
	public void user_Can_Open_Other_Files_2nd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Open_Other_Files(); 
	}
	
	@Test(priority = 9, description = "user_Can_Verify_File_Added")
	public void user_Can_Verify_File_Added() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Verify_File_Added(); 
	}
	
	@Test(priority = 10, description = "user_Can_Delete_Document")
	public void user_Can_Delete_Document() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Delete_Document(); 
	}
	
	@Test(priority = 11, description = "user_Can_Open_Other_Files_3rd_time")
	public void user_Can_Open_Other_Files_3rd_time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Open_Other_Files(); 
	}
	
	@Test(priority = 12, description = "user_Can_Verify_File_Deleted")
	public void user_Can_Verify_File_Deleted() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objPermissions = new PermissionsPage(driver); 
		objPermissions.user_Can_Verify_File_Deleted(); 
	}
	
	@Test(priority = 13, description = "user_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 14, description = "test_User_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Add-Files-To-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
		Thread.sleep(5000);
	}
	
}