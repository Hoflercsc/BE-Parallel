package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class LoginEnglishWorkroomAdmin extends BaseTestCriticalScenarios {
	
	
	@Test(priority = 0, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 1, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 2, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage(driver);
		objectPermision.systemAdmin_Set_User_As_Workroom_Admin_2();
	}
	
	@Test(priority = 3, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 4, description = "Login System Admin UserName Password.")
	public void workroomAdminEng() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdminEng, password);
	}

	@Test(priority = 5, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectHomePage = new HomeNavigationPage(driver);
		objectHomePage.user_Can_Open_Directory();
	}

	@Test(priority = 6, description = "open_User_Profile_Automation_Tester")
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_Workroom_Admin_Eng();
	}

	@Test(priority = 7, description = "navigate_To_English_Language")
	public void navigate_To_English_Language() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.navigate_To_English_Language();
		driver.navigate().refresh();
	}
	
	@Test(priority = 8, description = "steve_System_Logout")
	public void system_Admin_Logout_Again() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 9, description = "systemAdmin_Login_Spanish")
	public void automation_Tester_Login_English() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		Thread.sleep(2000);
		driver.get(HOME_PAGE);
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 10, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectWorkgroup = new WorkgroupPage(driver);
		objectWorkgroup.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 11, description = "systemAdmin_Set_User_As_Workroom_Member")
	public void set_User_Back_As_Workroom_Member() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage(driver);
		objectPermision.systemAdmin_Set_User_As_Workroom_Member_Eng();
	}
	
}