package tests_general_settings;

import java.awt.AWTException;
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
import static constants.ConstantsFile.*;

public class SetTimeZone extends BaseTestGeneralSettings {
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 2, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}

	@Test(priority = 3, description = "navigate_To_Look_And_Feel")
	public void navigate_To_Look_And_Feel() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.navigate_To_Look_And_Feel();
	}
	
	@Test(priority = 4, description = "set_Time_Zone_To_Pacific_Time")
	public void set_Time_Zone_To_Pacific_Time() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.set_Time_Zone_To_Pacific_Time();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Settings")
	public void user_Can_Open_Dirctory_Agian() throws InterruptedException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Settings();
	}
	
	@Test(priority = 6, description = "navigate_To_Look_And_Feel_Agian")
	public void navigate_To_Look_And_Feel_Agian() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.navigate_To_Look_And_Feel();
	}
	
	@Test(priority = 7, description = "set_New_Time_Zone_Back_To_Eastern_Time")
	public void set_New_Time_Zone_Back_To_Eastern_Time() throws InterruptedException {
		test.assignCategory("Directory >> Set-Time-Zone");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.set_New_Time_Zone_To_Eastern_Time();
	}
	
}