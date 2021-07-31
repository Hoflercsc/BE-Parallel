package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class AssignRemoveWorkroomAdmin extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "remove_Workroom_Admin_As_Admin")
	public void enable_Workroom_Admin_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.enable_Workroom_Admin_As_Admin();
	}

	@Test(priority = 3, description = "verify_WorkroomAdmin_Enabled_As_Admin")
	public void verify_WorkroomAdmin_Enabled_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_WorkroomAdmin_Enabled_As_Admin();
	}
	
	@Test(priority = 4, description = "disable_Workroom_Admin_As_Admin")
	public void disable_Workroom_Admin_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Admin");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.disable_Workroom_Admin_As_Admin();
	}


}