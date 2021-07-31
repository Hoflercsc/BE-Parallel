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

public class LoginForeignLanguageWorkroomAdminEng extends BaseTestCriticalScenarios {
	@Test(priority = 0, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 1, description = "admin_Opens_Site_Settings_Workrooms_And_Groups")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 2, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_WorkroomAdminEng_As_WorkroomAdmin();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

	@Test(priority = 3, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 4, description = "open_User_Profile_WorkroomAdmin")
	public void open_User_Profile_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_User_Profile_Workroom_Admin();
	}

	@Test(priority = 5, description = "select_Foreign_Language_Spanish")
	public void select_Foreign_Language_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.select_Foreign_Language_Spanish();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "systemAdmin_Login_Spanish")
	public void workroomAdmin_Login_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdminEng, password);
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory_Spanish")
	public void user_Can_Open_Directory_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 9, description = "open_User_Profile_WorkroomAdmin_Spanish")
	public void open_User_Profile_WorkroomAdmin_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_User_Profile_Workroom_Admin_Spanish();
	}

	@Test(priority = 10, description = "select_Foreign_Language_English")
	public void select_Foreign_Language_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.select_Foreign_Language_English();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 11, description = "steve_System_Logout")
	public void steve_System_Logout_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 12, description = "systemAdmin_Login_Spanish")
	public void automation_Tester_Login_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
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
	
	@Test(priority = 13, description = "admin_Opens_Site_Settings_Workrooms_And_Groups_Agian")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups_Agian() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 14, description = "systemAdmin_Set_User_As_Workroom_Member")
	public void set_User_Back_As_Workroom_Member() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectPermision = new PermissionPage();
		objectPermision.systemAdmin_Set_User_As_WorkroomAdminEng_As_Workroom_Member();
	}

	
}