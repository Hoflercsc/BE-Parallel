package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class ViewWorkroomMemberProfile extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> View-Workroom-Member-Profile");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "view_Workroom_Member_Profile")
	public void view_Workroom_Member_Profile() throws InterruptedException {
		test.assignCategory("Workroom-Home >> View-Workroom-Member-Profile");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.view_Workroom_Member_Profile();
	}

	@Test(priority = 3, description = "verify_Member_Profile_Contents")
	public void verify_Member_Profile_Contents() throws InterruptedException {
		test.assignCategory("Workroom-Home >> View-Workroom-Member-Profile");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_Member_Profile_Contents();
	}
	
	@Test(priority = 4, description = "close_Profile")
	public void close_Profile() throws InterruptedException {
		test.assignCategory("Workroom-Home >> View-Workroom-Member-Profile");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.click_Close_Profile_Top();
	}

}