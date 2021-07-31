package tests_directory;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.PermissionPage;
import page_directory.DirectoryPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class SaveAlternateContactInformation extends BaseTestDirectory {
	@Test(priority = 1, description = "system_Admin_Login.")
	public void system_Admin_Login() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 7, description = "open_Auto_User_9_Profile")
	public void open_Auto_User_10_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Auto_User_10_Profile(autoUser10);
	}
	
	@Test(priority = 8, description = "make_Company_Info_Preferred_Contact")
	public void make_Company_Info_Preferred_Contact() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objPermissions = new PermissionsPage();
		objPermissions.save_Alternate_Contact_Information();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Dirctory_2nd_Time")
	public void user_Can_Open_Directory_2nd_Time_() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 10, description = "open_Auto_User_9_Profile_Again")
	public void open_Auto_User_9_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objPermissions = new PermissionsPage();
		obj_directory.open_Auto_User_10_Profile(autoUser10);
	}
	
	@Test(priority = 11, description = "remove_Alternate_Contact_Information")
	public void remove_Alternate_Contact_Information() throws InterruptedException {
		test.assignCategory("Directory >> Save-Alternant-Contact-Information");
		
		objPermissions = new PermissionsPage();
		objPermissions.remove_Alternate_Contact_Information();
	}
	
	
}