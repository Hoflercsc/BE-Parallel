package tests_announcekit;

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
import page_announcekit.AnnouncekitPage;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class SysAdminCanSeeWhatsNew extends BaseTestAnnouncekit {
	
	@Test(priority = 1, description = "sysAdmin_Login")
	public void sysAdmin_Login() throws InterruptedException {
		test.assignCategory("Announcekit >> SysAdmin-Can-See-Whats-New");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "verify_WhatsNew_Link")
	public void verify_WhatsNew_Link() throws InterruptedException {
		test.assignCategory("Announcekit >> SysAdmin-Can-See-Whats-New");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.verify_Atlas_Left_Nav();

		objAnnouncekit = new AnnouncekitPage();
		objAnnouncekit.verify_WhatsNew_Link();
	}
	
	@Test(priority = 3, description = "open_Interact_With_WhatsNew")
	public void open_Interact_With_WhatsNew() throws InterruptedException {
		test.assignCategory("Announcekit >> SysAdmin-Can-See-Whats-New");
		
		objAnnouncekit = new AnnouncekitPage();
		objAnnouncekit.open_Interact_With_WhatsNew();
	}
	
	@Test(priority = 4, description = "verify_AutoBE")
	public void verify_AutoBE() throws InterruptedException {
		test.assignCategory("Announcekit >> SysAdmin-Can-See-Whats-New");
		
		objAnnouncekit = new AnnouncekitPage();
		objAtlasNavBar.verify_Atlas_Left_Nav();
	}

	
	
}