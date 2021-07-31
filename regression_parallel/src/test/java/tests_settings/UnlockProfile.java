package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkgroupPage;
import page_set_permissions.PermissionsPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class UnlockProfile extends BaseTestSettings {
	
	@Test(priority = 1, description = "home_Page_Redirect_Jhofler_Staging")
	public void home_Page_Redirect_Jhofler_Staging() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 2, description = "lockOutUser_Login")
	public void lockOutUser_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		objBELogin = new LoginLogoutPage();
		
		for (int i = 0; i < 2; i++) {
		objBELogin.login_BE(lockOutUser, wrongPassword);
		objBELogin.verify_Username_Field();
		objBELogin.clear_Login_Username_Password_Fields();

		}
	}
	
	@Test(priority = 3, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 4, description = "open_Settings_Manage_Users")
	public void open_Settings_Manage_Users() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Manage_Users();
	}

	@Test(priority = 5, description = "unlock_Locked_User_Profile")
	public void unlock_Locked_User_Profile() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objPermissions = new PermissionsPage();
		objPermissions.unlock_Locked_User_Profile();
	}
	
	@Test(priority = 6, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "Login System Admin UserName Password.")
	public void lockoutuser_login_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(lockOutUser, correctPassword);
	}
	
	@Test(priority = 8, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.verify_Atlas_Left_Nav();
	}
	
	
}