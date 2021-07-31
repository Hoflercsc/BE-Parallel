package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class EditWelcomeText extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_On_Edit_Icon_DC_WR")
	public void user_Clicks_On_Edit_Icon_DC_WR() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.user_Clicks_On_Edit_Icon_DC_WR();
	}

	@Test(priority = 3, description = "switch_To_Iframe_Insert_Custom_Message")
	public void switch_To_Iframe_Insert_Custom_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.switch_To_Iframe_Insert_Custom_Message();
	}

	@Test(priority = 4, description = "verify_Customized_Content_Appears")
	public void verify_Customized_Content_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_Customized_Content_Appears();
	}

	@Test(priority = 5, description = "delete_Insert_Previous_Message")
	public void delete_Insert_Previous_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.delete_Insert_Previous_Message();
	}

	@Test(priority = 6, description = "verify_Previous_Message_Appears")
	public void verify_Previous_Message_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Edit-Welcome-Text");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_Previous_Message();
	}
}