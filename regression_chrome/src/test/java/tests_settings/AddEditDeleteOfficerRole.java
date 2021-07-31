package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkgroupPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class AddEditDeleteOfficerRole extends BaseTestSettings {
	
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 2, description = "open_Settings_Manage_Users")
	public void open_Settings_Manage_Users() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Manage_Users();
	}

	@Test(priority = 3, description = "add_Officer_Role")
	public void add_Officer_Role() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.add_Officer_Role();
	}
	
	@Test(priority = 4, description = "open_Settings_Manage_Users_2nd_Time")
	public void open_Settings_Manage_Users_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Manage_Users();
	}
	
	@Test(priority = 5, description = "edit_Officer_Role")
	public void edit_Officer_Role() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.edit_Officer_Role();
	}
	
	@Test(priority = 6, description = "open_Settings_Manage_Users_3rd_Time")
	public void open_Settings_Manage_Users_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Manage_Users();
	}
	
	@Test(priority = 7, description = "delete_Officer_Role")
	public void delete_Officer_Role() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.delete_Officer_Role();
	}
	
	@Test(priority = 8, description = "open_Settings_Manage_Users_4th_Time")
	public void open_Settings_Manage_Users_4th_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Manage_Users();
	}
	
	@Test(priority = 9, description = "verify_New_Role_Deleted")
	public void verify_New_Role_Deleted() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Edit-Delete-Officer-Role");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_New_Role_Deleted();
	}
	
	
	
}