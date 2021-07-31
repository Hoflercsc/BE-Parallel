package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AttdReportPage;
import page_critical_scenarios.RsUserPwPage;
import page_critical_scenarios.WorkgroupPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

//---may ability to reset password
public class ResetUserPassword extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "LoginLogoutPage")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void systemAdmin_Opens_Directory_Search_For_User() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage();
		objectRSPW.systemAdmin_Opens_Directory_Search_For_User();
	}

	@Test(priority = 3, description = "systemAdmin_Update_User_Password")
	public void systemAdmin_Update_User_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage();
		objectRSPW.systemAdmin_Update_User_Password();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 4, description = "systemAdmin_Close_Profile_And_Logout")
	public void systemAdmin_Close_Profile_And_Logout() throws InterruptedException {
		test.assignCategory("rest_user_password");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 5, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage();
		objectRSPW.workroom_Member_Login_To_BoardEffect_2();
	}

	@Test(priority = 6, description = "systemAdmin_Close_Profile_And_Logout")
	public void workroom_Member_Close_Profile_And_Logout() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "systemAdmin_Login_2nd_Time")
	public void systemAdmin_Login_2nd_Time() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 8, description = "systemAdmin_Update_User_Password_Back_To_Original")
	public void systemAdmin_Update_User_Password_Back_To_Original() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory_With_Refresh();
		
		objectRSPW = new RsUserPwPage();
		objectRSPW.click_Search_Field_Sendkeys_Enter();
		
		objectRSPW.systemAdmin_Update_User_Password_Back_To_Original();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 9, description = "systemAdmin_Can_Sign_Out")
	public void systemAdmin_Can_Sign_Out() throws InterruptedException {
		test.assignCategory("rest_user_password");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 10, description = "workroom_Member_Login_To_BoardEffect_Orginal_Password")
	public void workroom_Member_Login_To_BoardEffect_Orginal_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectRSPW = new RsUserPwPage();
		objectRSPW.workroom_Member_Login_To_BoardEffect_Orginal_Password();
	}
	
	@Test(priority = 11, description = "workroom_Member_Login_With_Updated_Password")
	public void workroom_Member_Login_With_Updated_Password() throws InterruptedException {
		test.assignCategory("rest_user_password");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.verify_Atlas_Left_Nav();
		Thread.sleep(1000);
	}
}