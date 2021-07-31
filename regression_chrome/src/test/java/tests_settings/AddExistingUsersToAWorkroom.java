package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class AddExistingUsersToAWorkroom extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.user_Open_Settings_Then_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "add_Auto_Director_To_A_Workroom")
	public void add_Auto_Director_To_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.add_Auto_Director_To_A_Workroom(); 
	}
	
	@Test(priority = 4, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.user_Open_Settings_Then_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 5, description = "add_Test_User_To_A_Workroom")
	public void add_Test_User_To_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.add_Test_User_To_A_Workroom(); 
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 7, description = "auto_Director_Can_Login")
	public void auto_Director_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "verify_Marvel_Workroom")
	public void verify_Marvel_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.verify_Marvel_Workroom(); 
	}
	
	@Test(priority = 9, description = "user_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 10, description = "test_User_Can_Login")
	public void test_User_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(testReset, password);
	}
	
	@Test(priority = 11, description = "verify_Marvel_Workroom")
	public void verify_Marvel_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.verify_Marvel_Workroom(); 
	}
	
	@Test(priority = 12, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 13, description = "test_User_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Allow-User-To-Edit-Profile-Contact-Info");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.user_Open_Settings_Then_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 15, description = "remove_Auto_Director_From_Workroom")
	public void remove_Auto_Director_From_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.remove_Auto_Director_From_A_Workroom(); 
		driver.navigate().refresh();
	}
	
	@Test(priority = 16, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.user_Open_Settings_Then_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 17, description = "remove_Test_User_From_Workroom")
	public void remove_Test_User_From_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(driver); // using function from Critical Senaiors
		objPermissions.remove_Test_User_From_A_Workroom(); 
		driver.navigate().refresh();

	}

	
	
	
	
}