package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class ManageWorkroomMemberVisibility extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Manage-Workroom-Member-Visibility");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "enable_Workroom_Admin_Visibility")
	public void enable_Workroom_Admin_Visibility() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Manage-Workroom-Member-Visibility");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.enable_Workroom_Admin_Visibility();
	}

	@Test(priority = 3, description = "verify_Workroom_Admin_Visibility_Enabled")
	public void verify_Workroom_Admin_Visibility_Enabled() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Manage-Workroom-Member-Visibility");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_Workroom_Admin_Visibility_Enabled();
	}
	
	@Test(priority = 4, description = "disable_Workroom_Admin_Visibility")
	public void disable_Workroom_Admin_Visibility() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Manage-Workroom-Member-Visibility");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.disable_Workroom_Admin_Visibility();
	}
	
	@Test(priority = 5, description = "verify_WorkroomAdmin_IS_Hidden")
	public void verify_WorkroomAdmin_IS_Hidden() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Manage-Workroom-Member-Visibility");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_WorkroomAdmin_IS_Hidden();
	}


}