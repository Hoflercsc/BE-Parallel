package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class LoginForeignLanguageSystemAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Admin_Profile_AutoAdminUserGS11")
	public void open_Admin_Profile_AutoAdminUserGS11() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_Admin_Profile_AutoAdminUserGS11(autoAdminUserGS11);
	}

	@Test(priority = 4, description = "select_Foreign_Language_Spanish")
	public void select_Foreign_Language_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.select_Foreign_Language_Spanish();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 6, description = "systemAdmin_Login_Spanish")
	public void systemAdmin_Login_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoAdminUserGS11, password);
	}

	@Test(priority = 7, description = "user_Can_Open_Directory_Spanish")
	public void user_Can_Open_Directory_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 8, description = "open_Admin_Profile_AutoAdminUserGS11_Spanish")
	public void open_Admin_Profile_AutoAdminUserGS11_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_Admin_Profile_AutoAdminUserGS11_Spanish(autoAdminUserGS11);
	}

	@Test(priority = 9, description = "select_Foreign_Language_English")
	public void select_Foreign_Language_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.select_Foreign_Language_English();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 10, description = "steve_System_Logout")
	public void steve_System_Logout_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "systemAdmin_Login_Spanish")
	public void systemAdmin_Login_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		Thread.sleep(2000);
		
		String url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			DriverFactory.getInstance().getDriver().get(HOME_PAGE);
		}else {
			DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
		}	
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "verify_Atlas_Left_Nav_Bar")
	public void verify_Atlas_Left_Nav_Bar() throws InterruptedException {
		test.assignCategory("login_foreign_language_systemadmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.verify_Atlas_Left_Nav_Bar();
	}


	
}