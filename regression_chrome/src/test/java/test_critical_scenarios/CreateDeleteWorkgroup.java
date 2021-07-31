package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateDeleteWorkgroup extends BaseTestCriticalScenarios {
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateEditDeleteGroup");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("CreateEditDeleteGroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Group")
	public void user_Can_Create_New_Group() throws InterruptedException {
		test.assignCategory("CreateEditDeleteGroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Create_New_Group();
	}

	@Test(priority = 4, description = "user_Can_Delete_New_Group")
	public void user_Can_Delete_New_Group() throws InterruptedException {
		test.assignCategory("CreateEditDeleteGroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Can_Delete_New_Group();
	}

	@Test(priority = 5, description = "verify_Group_Deleted")
	public void verify_Group_Deleted() throws InterruptedException {
		test.assignCategory("CreateEditDeleteGroup");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.verify_Group_Deleted();
	}
}