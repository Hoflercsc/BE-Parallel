package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateDeleteWorkgroup extends BaseTestCriticalScenarios {
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "admin_opens_Site_Settings_Workrooms_And_Groups")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Group")
	public void user_Can_Create_New_Group() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Create_New_Group();
	}

	@Test(priority = 4, description = "user_Can_Delete_New_Group")
	public void user_Can_Delete_New_Group() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Delete_New_Group();
	}
	
	@Test(priority = 5, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 6, description = "navigate_To_Workgroups_Tab")
	public void navigate_To_Workgroups_Tab() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.navigate_To_Workgroups_Tab();
	}

	@Test(priority = 7, description = "verify_Group_Deleted")
	public void verify_Group_Deleted() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkgroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.verify_Workgroup_NOT_Present_Message();
	}
}