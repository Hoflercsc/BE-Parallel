package tests_settings;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteGroup extends BaseTestSettings {
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Group")
	public void user_Can_Create_New_Group() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Create_New_Group_A();
	}
	
	@Test(priority = 4, description = "user_Can_Edit_New_Group")
	public void user_Can_Edit_New_Group() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Edit_New_Group_A();
	}
	
	@Test(priority = 5, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Opens_Settings_Opens_Workroom_And_Group_Settings_A();
	}
	
	@Test(priority = 6, description = "user_Can_Delete_New_Group")
	public void user_Can_Delete_New_Group() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Delete_New_Group_A();
	}

	@Test(priority = 7, description = "verify_Group_Deleted")
	public void verify_Group_Deleted() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Create-Edit-Delete-Group");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.verify_Group_Deleted_A();
	}
}