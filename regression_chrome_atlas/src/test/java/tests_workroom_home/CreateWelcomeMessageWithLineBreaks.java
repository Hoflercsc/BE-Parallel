package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.LineBreaksPage;
import static constants.ConstantsFile.*;

public class CreateWelcomeMessageWithLineBreaks extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_On_Edit_Icon")
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		obj_linebreaks = new LineBreaksPage(driver);
		obj_linebreaks.user_Clicks_On_Edit_Icon();
	}

	@Test(priority = 3, description = "switch_To_Iframe_Insert_Line_Breaks")
	public void switch_To_Iframe_Insert_Line_Breaks() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		obj_linebreaks = new LineBreaksPage(driver);
		obj_linebreaks.switch_To_Iframe_Insert_Line_Breaks();
	}

	@Test(priority = 4, description = "verify_Content_Appears")
	public void verify_Content_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		obj_linebreaks = new LineBreaksPage(driver);
		obj_linebreaks.verify_Content_Appears();
	}

	@Test(priority = 5, description = "delete_Insert_Previous_Message")
	public void delete_Insert_Previous_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		obj_linebreaks = new LineBreaksPage(driver);
		obj_linebreaks.delete_Insert_Previous_Message();
	}

	@Test(priority = 6, description = "verify_Previous_Message")
	public void verify_Previous_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-With-Line-Breaks");
		
		obj_linebreaks = new LineBreaksPage(driver);
		obj_linebreaks.verify_Previous_Message();
	}
}