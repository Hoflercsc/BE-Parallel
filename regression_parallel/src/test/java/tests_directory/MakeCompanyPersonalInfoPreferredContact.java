package tests_directory;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
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
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Test_Reset_User_Profile")
	public void open_Test_Reset_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_9_Profile(autoUser9);
	}
	
	@Test(priority = 4, description = "make_Company_Info_Preferred_Contact")
	public void make_Company_Info_Preferred_Contact() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage();
		objPermissions.make_Company_Info_Preferred_Contact();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 6, description = "open_View_User_Profile")
	public void open_View_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_9_Profile(autoUser9);
	}
	
	@Test(priority = 7, description = "make_Preferred_Contact_Company")
	public void make_Personal_Info_Preferred_Contact() throws InterruptedException {
		test.assignCategory("Directory >> Make-Company-Personal-Info-Preferred-Contact");
		
		objPermissions = new PermissionsPage();
		objPermissions.make_Personal_Info_Preferred_Contact();
	}
	
	
}