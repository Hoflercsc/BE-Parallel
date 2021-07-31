package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class LoginEnglishWorkroomAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdminEng, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");
		
		objectHomePage = new HomeNavigationPage(driver);
		objectHomePage.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Automation_Tester")
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_Workroom_Admin();
	}

	@Test(priority = 4, description = "navigate_To_English_Language")
	public void navigate_To_English_Language() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.navigate_To_English_Language();
	}
	
	@Test(priority = 5, description = "close_Profile_And_Directory")
	public void close_Profile_And_Directory() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.close_Profile_And_Directory();
	}
	
	@Test(priority = 6, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_engish_workroomadmin");

		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
}