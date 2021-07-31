package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class LoginEnglishWorkroomAdminEng2 extends BaseTestCriticalScenarios {
	
	@Test(priority = 0, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 1, description = "admin_Opens_Site_Settings_Workrooms_And_Groups")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 2, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Admin();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 3, description = "system_Admin_Logout_2nd_Time")
	public void system_Admin_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 4, description = "Login System Admin UserName Password.")
	public void workroomAdminEng_Login() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdminEng2, password);
	}

	@Test(priority = 5, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 6, description = "open_User_Profile_Workroom_Admin_Eng_2")
	public void open_User_Profile_Workroom_Admin_Eng_2() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_User_Profile_Workroom_Admin_Eng_2(workroomAdminEng2);
	}

	@Test(priority = 7, description = "navigate_To_English_Language")
	public void navigate_To_English_Language() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.navigate_To_English_Language();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
		
	@Test(priority = 8, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "systemAdmin_Login_Spanish")
	public void automation_Tester_Login_English() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		String url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			DriverFactory.getInstance().getDriver().get(HOME_PAGE);
		}else {
			DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
		}		
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 10, description = "admin_Opens_Site_Settings_Workrooms_And_Groups_Agian")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups_Agian() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 11, description = "systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Member")
	public void systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Member() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Member();
	}
	
}