package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class LoginForeignLanguageWorkroomAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectHomePage = new HomeNavigationPage(driver);
		objectHomePage.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Automation_Tester")
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_Automation_Tester();
	}

	@Test(priority = 4, description = "select_Foreign_Language_Spanish")
	public void select_Foreign_Language_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.select_Foreign_Language_Spanish();
	}
	
	@Test(priority = 5, description = "close_Profile_And_Directory")
	public void close_Profile_And_Directory() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.close_Profile_And_Directory();
	}
	
	@Test(priority = 6, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");

		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 7, description = "systemAdmin_Login_Spanish")
	public void systemAdmin_Login_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 8, description = "verify_Spanish_Welcome_Heading")
	public void verify_Spanish_Welcome_Heading() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.verify_Spanish_Welcome_Heading();
	}

	@Test(priority = 9, description = "user_Can_Open_Directory_Spanish")
	public void user_Can_Open_Directory_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objectHomePage = new HomeNavigationPage(driver);
		objectHomePage.user_Can_Open_Directory_Spanish();
	}

	@Test(priority = 10, description = "open_User_Profile_SystemAdmin_Spanish")
	public void open_User_Profile_Automation_Tester_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.open_User_Profile_Automation_Tester_Spanish();
	}

	@Test(priority = 11, description = "select_Foreign_Language_English")
	public void select_Foreign_Language_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.select_Foreign_Language_English();
	}
	
	@Test(priority = 12, description = "close_Profile_And_Directory")
	public void close_Profile_And_Directory_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.close_Profile_And_Directory();
	}
	
	@Test(priority = 13, description = "automation_Tester_Logout_Spanish")
	public void automation_Tester_Logout_Spanish() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");

		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 14, description = "systemAdmin_Login_Spanish")
	public void automation_Tester_Login_English() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		Thread.sleep(3000);
		driver.get(HOME_PAGE);
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 15, description = "verify_Spanish_Welcome_Message")
	public void verify_English_Welcome_Message() throws InterruptedException {
		test.assignCategory("login_foreign_language_workroomadmin");
		
		objForeignLanguage = new ForeignLanguagePage(driver);
		objForeignLanguage.verify_English_Welcome_Heading();
	}

	
}