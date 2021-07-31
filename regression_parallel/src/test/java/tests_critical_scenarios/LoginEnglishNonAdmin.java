package tests_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.ForeignLanguagePage;
import page_critical_scenarios.WorkgroupPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class LoginEnglishNonAdmin extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("login_english_nondmin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser1, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("login_english_nondmin");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_NonAdmin")
	public void open_User_Profile_Non_Admin_Auto_User_1_Profile() throws InterruptedException {
		test.assignCategory("login_english_nondmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.open_User_Profile_Non_Admin_Auto_User_1(autoUser1);
	}

	@Test(priority = 4, description = "navigate_To_English_Language")
	public void select_Foreign_Language_English() throws InterruptedException {
		test.assignCategory("login_english_nondmin");
		
		objForeignLanguage = new ForeignLanguagePage();
		objForeignLanguage.navigate_To_English_Language();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 6, description = "steve_System_Logout")
	public void system_Admin_Logout() throws InterruptedException {
		test.assignCategory("login_english_nondmin");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}
	
	
}