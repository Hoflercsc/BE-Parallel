package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class AddWorkroomNewsMessage extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_Workroom_News_Plus_Symbol")
	public void user_Clicks_Workroom_News_Plus_Symbol() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.user_Clicks_Workroom_News_Plus_Symbol();
	}

	@Test(priority = 3, description = "Add_Title_Insert_Custom_Message")
	public void Add_Title_Insert_Custom_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.Add_Title_Insert_Custom_Message();
	}

	@Test(priority = 4, description = "verify_Workroom_Message_Appears")
	public void verify_Workroom_Message_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_Workroom_News_Message();
	}

	@Test(priority = 5, description = "delete_Workroom_News_Message")
	public void delete_Workroom_News_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.delete_Workroom_News_Message();
	}

	@Test(priority = 6, description = "verify_Workroom_News_NOT_Present")
	public void verify_Workroom_News_NOT_Present() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Workroom-News-Message");
		
		obj_iframevideo = new IframeVideoPage();
		obj_iframevideo.verify_Workroom_News_NOT_Present();
	}
}