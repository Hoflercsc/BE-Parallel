package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkgroupPageB;
import static constants.ConstantsFile.*;

public class CreateWorkgroupAttachWorkroom extends BaseTestCriticalScenarios {	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Group")
	public void user_Can_Create_New_Group() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.user_Can_Create_New_Group();
	}

	@Test(priority = 4, description = "user_attach_workgroup_to_workroom")
	public void user_attach_workgroup_to_workroom() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.user_attach_workgroup_to_workroom();
	}

	@Test(priority = 5, description = "verify_Workroom_Attached")
	public void verify_Workroom_Attached() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.verify_Workroom_Attached();
	}

	@Test(priority = 6, description = "deactivate_Workgroup")
	public void deactivate_Workroom() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.deactivate_Workgroup();
	}

	@Test(priority = 7, description = "delete_Workgroup")
	public void delete_Workroom() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.delete_Workgroup();
	}

	@Test(priority = 8, description = "verify_Group_Deleted")
	public void verify_Group_Deleted() throws InterruptedException {
		test.assignCategory("CreateWorkgroupAttachWorkroom");
		
		objectWorkgroup_B = new WorkgroupPageB(driver);
		objectWorkgroup_B.verify_Group_Deleted();
	}
}