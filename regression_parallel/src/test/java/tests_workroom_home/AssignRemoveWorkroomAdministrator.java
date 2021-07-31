package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class AssignRemoveWorkroomAdministrator extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS10, password);
	}

	@Test(priority = 2, description = "enable_Test_Reset_Admin_As_Admin")
	public void enable_Test_Reset_Admin_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.enable_Test_Reset_Admin_As_Admin();
	}

	@Test(priority = 3, description = "verify_WorkroomAdmin_Enabled_As_Admin")
	public void verify_TestReset_Enabled_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_TestReset_Enabled_As_Admin();
	}
	
	@Test(priority = 4, description = "disable_Workroom_Admin_As_Admin")
	public void disable_Workroom_Admin_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.disable_TestReset_As_Admin();
	}


}