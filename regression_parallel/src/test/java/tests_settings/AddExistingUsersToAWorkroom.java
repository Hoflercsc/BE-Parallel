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

public class AddExistingUsersToAWorkroom extends BaseTestSettings {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Settings_Then_Workroom_And_Group_Settings")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "add_Auto_Director_2_To_A_Workroom")
	public void add_Auto_Director_2_To_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(); // using function from Critical Senaiors
		objPermissions.add_Auto_Director_2_To_A_Workroom(); 
	}
	
	@Test(priority = 4, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 5, description = "add_Test_2_User_To_A_Workroom")
	public void add_Test_2_User_To_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(); // using function from Critical Senaiors
		objPermissions.add_Test_2_User_To_A_Workroom(); 
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "auto_Director2_Can_Login")
	public void auto_Director2_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector2, password);
	}
	
	@Test(priority = 8, description = "user_Verify_Comics_Workroom")
	public void user_Verify_Comics_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Verify_Comics_Workroom();
	}
	
	@Test(priority = 9, description = "user_Can_Logout")
	public void auto_Director_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "test_User_Can_Login")
	public void test_User_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(testReset2, password);
	}
	
	@Test(priority = 11, description = "user_Verify_Comics_Workroom_Again")
	public void user_Verify_Comics_Workroom_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Verify_Comics_Workroom();
	}
	
	@Test(priority = 12, description = "user_Can_Logout")
	public void test_User_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 13, description = "test_User_Can_Login")
	public void system_Admin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 14, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 15, description = "remove_Auto_Director_2_From_A_Workroom")
	public void remove_Auto_Director_2_From_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(); // using function from Critical Senaiors
		objPermissions.remove_Auto_Director_2_From_A_Workroom(); 
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 16, description = "systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time")
	public void systemAdmin_Open_Settings_Then_Workroom_And_Group_Settings_4th_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 17, description = "remove_Test_Reset_2_From_A_Workroom")
	public void remove_Test_Reset_2_From_A_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Add-Existing-Users-To-A-Workroom");
		
		objPermissions = new PermissionsPage(); // using function from Critical Senaiors
		objPermissions.remove_Test_Reset_2_From_A_Workroom(); 
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	
	
	
	
}