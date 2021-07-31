package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
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
	
	@Test(priority = 1, description = "admin_Opens_Site_Settings_Workrooms_And_Groups")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 2, description = "systemAdmin_Set_User_As_Workroom_Admin")
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage(driver);
		objectPermision.systemAdmin_Set_User_As_Workroom_Admin_2();
		driver.navigate().refresh();
	}
	
	@Test(priority = 3, description = "system_Admin_Logout_2nd_Time")
	public void system_Admin_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 4, description = "Login System Admin UserName Password.")
	public void workroomAdminEng_Login() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdminEng, password);
	}

	@Test(priority = 5, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 6, description = "open_User_Profile_Automation_Tester")
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_Workroom_Admin();
	}

	@Test(priority = 7, description = "navigate_To_English_Language")
	public void navigate_To_English_Language() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.navigate_To_English_Language();
		driver.navigate().refresh();
	}
		
	@Test(priority = 8, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");

		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 9, description = "systemAdmin_Login_Spanish")
	public void automation_Tester_Login_English() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		String url = driver.getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			driver.get(HOME_PAGE);
		}else {
			driver.get(HOME_PAGE_3);
		}		
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 10, description = "admin_Opens_Site_Settings_Workrooms_And_Groups_Agian")
	public void admin_Opens_Site_Settings_Workrooms_And_Groups_Agian() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 11, description = "systemAdmin_Set_User_As_Workroom_Member")
	public void set_User_Back_As_Workroom_Member() throws InterruptedException {
		test.assignCategory("login_english_workroomadmin");
		
		objectPermision = new PermissionPage(driver);
		objectPermision.systemAdmin_Set_User_As_Workroom_Member_Eng();
	}
	
}