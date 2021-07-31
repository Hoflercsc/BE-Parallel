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
import page_directory.DirectoryPage;
import page_intergrations.GoToMeetingPage;
import page_set_permissions.PermissionsPage;
import static constants.ConstantsFile.*;

public class EnableDisableDisclaimer extends BaseTestSettings {
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Settings_Security_Summary")
	public void open_Settings_Security_Summary() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Security_Summary();
	}

	@Test(priority = 3, description = "enable_Disclaimer_Option")
	public void enable_Disclaimer_Option() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.enable_Disclaimer_Option();
	}
	
	@Test(priority = 4, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 5, description = "user_Can_Login")
	public void user_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Deactivate-Messaging-For-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 6, description = "verify_Disclaimer_And_Login")
	public void verify_Disclaimer_And_Login() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Login_Disclaimer();
	}
	
	@Test(priority = 7, description = "open_Settings_Security_Summary_2nd_Time")
	public void open_Settings_Security_Summary_2nd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Security_Summary();
	}
	
	@Test(priority = 8, description = "disable_Disclaimer_Option")
	public void disable_Disclaimer_Option() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.disable_Disclaimer_Option();
	}
	
	@Test(priority = 9, description = "open_Settings_Security_Summary_3rd_Time")
	public void open_Settings_Security_Summary_3rd_Time() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.open_Settings_Security_Summary();
	}
	
	@Test(priority = 10, description = "verify_Disclaimer_Disabled")
	public void verify_Disclaimer_Disabled() throws InterruptedException {
		test.assignCategory("Settings >> Enable-Disable-Disclaimer");
		
		objPermissions = new PermissionsPage(driver);
		objPermissions.verify_Disclaimer_Disabled();
	}




}