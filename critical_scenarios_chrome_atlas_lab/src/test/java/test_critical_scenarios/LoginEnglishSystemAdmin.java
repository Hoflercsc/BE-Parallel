package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class LoginEnglishSystemAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_english_systemadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdminEng, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_english_systemadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_SystemAdminEng")
	public void open_User_Profile_SystemAdminEng() throws InterruptedException {
		test.assignCategory("login_english_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_SystemAdminEng();
	}

	@Test(priority = 4, description = "navigate_To_English_Language")
	public void navigate_To_English_Language() throws InterruptedException {
		test.assignCategory("login_english_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.navigate_To_English_Language();
		driver.navigate().refresh();
	}
	
	@Test(priority = 6, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_english_nondmin");

		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	
}