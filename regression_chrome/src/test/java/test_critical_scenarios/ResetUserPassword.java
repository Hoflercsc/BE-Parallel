package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AttdReportPage;
import page_critical_scenarios.RsUserPwPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class ResetUserPassword extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void systemAdmin_Opens_Directory_Search_For_User() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.systemAdmin_Opens_Directory_Search_For_User();
	}

	@Test(priority = 2, description = "systemAdmin_Update_User_Password")
	public void systemAdmin_Update_User_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.systemAdmin_Update_User_Password();
	}

	@Test(priority = 3, description = "systemAdmin_Close_Profile_And_Logout")
	public void systemAdmin_Close_Profile_And_Logout() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.systemAdmin_Close_Profile_And_Logout();
	}

	@Test(priority = 4, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.workroom_Member_Login_To_BoardEffect();
	}

	@Test(priority = 5, description = "systemAdmin_Close_Profile_And_Logout")
	public void workroom_Member_Reset_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.workroom_Member_Reset_Password();
	}

	@Test(priority = 6, description = "systemAdmin_Close_Profile_And_Logout")
	public void workroom_Member_Close_Profile_And_Logout() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.workroom_Member_Close_Profile_And_Logout();
	}

	@Test(priority = 7, description = "workroom_Member_Login_With_Updated_Password")
	public void workroom_Member_Login_With_Updated_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.workroom_Member_Login_With_Updated_Password();
	}
}