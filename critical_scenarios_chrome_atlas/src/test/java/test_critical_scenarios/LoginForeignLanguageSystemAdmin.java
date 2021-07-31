package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class LoginForeignLanguageSystemAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_SystemAdmin")
	public void open_User_Profile_SystemAdmin() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_SystemAdmin();
	}

	@Test(priority = 4, description = "select_Foreign_Language_Spanish")
	public void select_Foreign_Language_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.select_Foreign_Language_Spanish();
		driver.navigate().refresh();
	}
	
	@Test(priority = 5, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");

		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 6, description = "systemAdmin_Login_Spanish")
	public void systemAdmin_Login_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 7, description = "user_Can_Open_Directory_Spanish")
	public void user_Can_Open_Directory_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 8, description = "open_User_Profile_SystemAdmin_Spanish")
	public void open_User_Profile_SystemAdmin_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_SystemAdmin_Spanish();
	}

	@Test(priority = 9, description = "select_Foreign_Language_English")
	public void select_Foreign_Language_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.select_Foreign_Language_English();
		driver.navigate().refresh();
	}
	
	@Test(priority = 10, description = "steve_System_Logout")
	public void steve_System_Logout_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");

		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "systemAdmin_Login_Spanish")
	public void systemAdmin_Login_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			driver.get(HOME_PAGE);
		}else {
			driver.get(HOME_PAGE_3);
		}	
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "verify_Atlas_Left_Nav_Bar")
	public void verify_Atlas_Left_Nav_Bar() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.verify_Atlas_Left_Nav_Bar();
	}


	
}