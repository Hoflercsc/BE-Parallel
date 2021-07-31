package tests_directory;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class MakeCompanyPersonalInfoPreferredContact extends BaseTestDirectory {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory_2nd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 7, description = "open_Edit_User_Profile")
	public void open_Edit_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Edit_User_Profile();
	}
	
	@Test(priority = 8, description = "make_Company_Info_Preferred_Contact")
	public void make_Company_Info_Preferred_Contact() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.make_Company_Info_Preferred_Contact();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objNavigation = new HomeNavigationPage(driver);
		objNavigation.user_Can_Open_Directory();
	}

	@Test(priority = 10, description = "open_View_User_Profile")
	public void open_View_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Edit_User_Profile();
	}
	
	@Test(priority = 11, description = "make_Preferred_Contact_Company")
	public void make_Personal_Info_Preferred_Contact() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.make_Personal_Info_Preferred_Contact();
	}
	
	
}