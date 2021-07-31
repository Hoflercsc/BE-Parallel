package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class AssignRemoveWorkroomChair extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Chair");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS11, password);
	}

	@Test(priority = 2, description = "enable_Auto_Director_As_Chair")
	public void enable_Auto_Director_As_Chair() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Chair");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.enable_Auto_Director_As_Chair();
	}

	@Test(priority = 3, description = "verify_AutoDirector_Promoted_As_Chair")
	public void verify_AutoDirector_Promoted_As_Chair() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Chair");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_AutoDirector_Promoted_As_Chair();
	}
	
	@Test(priority = 4, description = "disable_AutoDirector_As_Chair")
	public void disable_AutoDirector_As_Chair() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Chair");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.disable_AutoDirector_As_Chair();
	}
	
	@Test(priority = 5, description = "verify_AutoDirector_Disabled_As_Chair")
	public void verify_AutoDirector_Disabled_As_Chair() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Assign-Remove-Workroom-Chair");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_Auto_Director_Disabled_As_Chair();
	}


}