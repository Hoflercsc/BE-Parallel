package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class ValidateUserRolePermissions extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoadmin1, password);
	}

	@Test(priority = 2, description = "verify_AutoBE_Add_Remove_Accounts_Visible")
	public void verify_AutoBE_Add_Remove_Accounts_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_AutoBE_Add_Remove_Accounts_Visible();
	}

	@Test(priority = 3, description = "verify_AutoBE_User_Accounts_Visible")
	public void verify_AutoBE_User_Accounts_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_AutoBE_User_Accounts_Visible();
	}
	
	@Test(priority = 4, description = "verify_Group1_Nebula")
	public void verify_Group1_Nebula() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Group1_Nebula();
	}
	
	@Test(priority = 5, description = "verify_Group1_Galaxy")
	public void verify_Group1_Galaxy() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Group1_Galaxy();
	}
	
	@Test(priority = 6, description = "autoAdmin1_Can_Logout")
	public void autoAdmin1_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "autoAdmin3_Can_Login.")
	public void autoAdmin3_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoadmin3, password);
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 9, description = "Auto_Admin3_Verify_All_Users_In_Directory")
	public void Auto_Admin3_Verify_All_Users_In_Directory() throws InterruptedException {
		test.assignCategory("Set-Permissions >>Validate-User-Role-Permissions");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.Auto_Admin3_Verify_All_Users_In_Directory();
	}

	
}