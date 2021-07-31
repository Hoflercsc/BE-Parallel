package tests_workroom_home;

import java.io.IOException;
import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.LargeSrcDataPage;
import static constants.ConstantsFile.*;

public class CreateWelcomeMessageWithLargeSourceData extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("message_with_large_source_data");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_On_Edit_Icon")
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		test.assignCategory("message_with_large_source_data");
		
		obj_source_data = new LargeSrcDataPage(driver);
		obj_source_data.user_Clicks_On_Edit_Icon();
	}

	@Test(priority = 3, description = "switch_To_Iframe_Copy_Paste_Content")
	public void switch_To_Iframe_Copy_Paste_Content() throws InterruptedException, IOException {
		test.assignCategory("message_with_large_source_data");
		
		obj_source_data = new LargeSrcDataPage(driver);
		obj_source_data.switch_To_Iframe_Copy_Paste_Content();
	}

	@Test(priority = 4, description = "verify_Content_Appears")
	public void verify_Content_Appears() throws InterruptedException {
		test.assignCategory("message_with_large_source_data");
		
		obj_source_data = new LargeSrcDataPage(driver);
		obj_source_data.verify_Content_Appears();
	}

	@Test(priority = 5, description = "delete_Insert_Previous_Message")
	public void delete_Insert_Previous_Message() throws InterruptedException {
		test.assignCategory("message_with_large_source_data");
		
		obj_source_data = new LargeSrcDataPage(driver);
		obj_source_data.delete_Insert_Previous_Message();
	}

	@Test(priority = 6, description = "verify_Previous_Message")
	public void verify_Previous_Message() throws InterruptedException {
		test.assignCategory("message_with_large_source_data");
		
		obj_source_data = new LargeSrcDataPage(driver);
		obj_source_data.verify_Previous_Message();
	}
}