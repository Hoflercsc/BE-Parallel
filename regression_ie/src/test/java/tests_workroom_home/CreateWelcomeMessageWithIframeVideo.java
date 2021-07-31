package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class CreateWelcomeMessageWithIframeVideo extends BaseTestWorkroomHome {	
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_On_Edit_Icon")
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.user_Clicks_On_Edit_Icon();
	}

	@Test(priority = 3, description = "switch_To_Iframe_Insert_Iframe_Video")
	public void switch_To_Iframe_Insert_Iframe_Video() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.switch_To_Iframe_Insert_Iframe_Video();
	}

	@Test(priority = 4, description = "verify_Content_Appears")
	public void verify_Content_Appears() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_Content_Appears();
	}

	@Test(priority = 5, description = "delete_Insert_Previous_Message")
	public void delete_Insert_Previous_Message() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.delete_Insert_Previous_Message();
	}

	@Test(priority = 6, description = "verify_Previous_Message")
	public void verify_Previous_Message() throws InterruptedException {
		test.assignCategory("message_iframe_video");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_Previous_Message();
	}
}