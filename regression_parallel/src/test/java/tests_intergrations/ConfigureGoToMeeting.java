package tests_intergrations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_intergrations.GoToMeetingPage;
import static constants.ConstantsFile.*;

public class ConfigureGoToMeeting extends BaseTestIntergations {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 3, description = "navigate_To_Video_Conferencing")
	public void navigate_To_Video_Conferencing() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		obj_meeting = new GoToMeetingPage();
		obj_meeting.navigate_To_Video_Conferencing();
	}

	@Test(priority = 4, description = "deactivate_GoTo_Meeting")
	public void deactivate_GoTo_Meeting() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		obj_meeting = new GoToMeetingPage();
		obj_meeting.deactivate_GoTo_Meeting();
	}

	@Test(priority = 5, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}

	@Test(priority = 6, description = "navigate_To_Video_Conferencing")
	public void navigate_To_Video_Conferencing_2nd_time() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		obj_meeting = new GoToMeetingPage();
		obj_meeting.navigate_To_Video_Conferencing();
	}

	@Test(priority = 7, description = "reactivate_GoTo_Meeting")
	public void reactivate_GoTo_Meeting() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		obj_meeting = new GoToMeetingPage();
		obj_meeting.reactivate_GoTo_Meeting();
	}

	@Test(priority = 8, description = "verify_GoTo_Meeting_Reactivation")
	public void verify_GoTo_Meeting_Reactivation() throws InterruptedException {
		test.assignCategory("Intergrations >> Configure-GoTo-Meeting");
		
		obj_meeting = new GoToMeetingPage();
		obj_meeting.verify_GoTo_Meeting_Reactivation();
	}
}