package tests_workroom_home;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_home.IframeVideoPage;
import static constants.ConstantsFile.*;

public class AddRemoveWorkroomAccounts extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "loginBE_AutoUser.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Remove-Workroom-Accounts");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Remove_Workroom_Account")
	public void user_Remove_Workroom_Account() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Remove-Workroom-Accounts");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.user_Remove_Workroom_Account();
	}

	@Test(priority = 3, description = "verify_User_Removed_From_Workroom")
	public void verify_User_Removed_From_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Remove-Workroom-Accounts");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_User_Removed_From_Workroom();
	}
	
	@Test(priority = 4, description = "user_Add_Back_Workroom_Account")
	public void user_Add_Back_Workroom_Account() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Remove-Workroom-Accounts");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.user_Add_Back_Workroom_Account();
	}

	@Test(priority = 5, description = "verify_Account_Added_Back_To_Workroom")
	public void verify_Account_Added_Back_To_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Add-Remove-Workroom-Accounts");
		
		obj_iframevideo = new IframeVideoPage(driver);
		obj_iframevideo.verify_Account_Added_Back_To_Workroom();
	}

	
}