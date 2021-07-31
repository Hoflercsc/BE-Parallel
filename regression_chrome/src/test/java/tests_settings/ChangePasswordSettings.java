package tests_settings;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.RsUserPwPage;
import page_directory.DirectoryPage;
import page_intergrations.GoToMeetingPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class ChangePasswordSettings extends BaseTestSettings {
	
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Unlock-Profile");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Settings_Security_Summary")
	public void open_Settings_Security_Summary() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Security_Summary();
	}
	
	@Test(priority = 3, description = "modify_Password_Settings")
	public void modify_Password_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.modify_Password_Settings();
	}
	
	@Test(priority = 4, description = "modify_Password_For_Password_Settings_1")
	public void modify_Password_For_Password_Settings_1() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.reset_Password_For_Password_Settings_1();
	}
	
	@Test(priority = 5, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 6, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password_Settings_1);
	}
	
	@Test(priority = 7, description = "open_Settings_Security_Summary_Agian")
	public void open_Settings_Security_Summary_Agian() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Security_Summary();
	}
	
	@Test(priority = 8, description = "back_To_Original_Password_Settings")
	public void back_To_Original_Password_Settings() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.back_To_Original_Password_Settings();
	}
	
	@Test(priority = 9, description = "modify_Password_For_Password_Settings_2")
	public void modify_Password_For_Password_Settings_2() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objectRSPW = new RsUserPwPage(driver);
		objectRSPW.reset_Password_For_Password_Settings_2();
	}
	
	@Test(priority = 10, description = "user_Can_Logout_Again")
	public void user_Can_Logout_Again() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 11, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin_() throws InterruptedException {
		test.assignCategory("Settings >> Change-Password-Settings");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
		objPermissions.verify_AutoBE();
	}


}