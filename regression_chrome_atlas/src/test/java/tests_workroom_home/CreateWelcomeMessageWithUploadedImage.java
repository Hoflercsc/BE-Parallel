package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.UploadedImagePage;
import static constants.ConstantsFile.*;

public class CreateWelcomeMessageWithUploadedImage extends BaseTestWorkroomHome {	
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Clicks_On_Edit_Icon")
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		obj_uploaded_image = new UploadedImagePage(driver);
		obj_uploaded_image.user_Clicks_On_Edit_Icon();
	}

	@Test(priority = 3, description = "switch_To_Iframe_Insert_Image")
	public void switch_To_Iframe_Insert_Image() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		obj_uploaded_image = new UploadedImagePage(driver);
		obj_uploaded_image.switch_To_Iframe_Insert_Image();
	}

	@Test(priority = 4, description = "verify_Content_Appears")
	public void verify_Content_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		obj_uploaded_image = new UploadedImagePage(driver);
		obj_uploaded_image.verify_Content_Appears();
	}

	@Test(priority = 5, description = "delete_Insert_Previous_Message")
	public void delete_Insert_Previous_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		obj_uploaded_image = new UploadedImagePage(driver);
		obj_uploaded_image.delete_Insert_Previous_Message();
	}

	@Test(priority = 6, description = "verify_Previous_Message")
	public void verify_Previous_Message() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Welcome-Message-Uploaded-Image");
		
		obj_uploaded_image = new UploadedImagePage(driver);
		obj_uploaded_image.verify_Previous_Message();
	}
}