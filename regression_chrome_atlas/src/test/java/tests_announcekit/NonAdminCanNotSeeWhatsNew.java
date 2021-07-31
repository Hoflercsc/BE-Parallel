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
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class NonAdminCanNotSeeWhatsNew extends BaseTestAnnouncekit {
	
	@Test(priority = 1, description = "sysAdmin_Login")
	public void sysAdmin_Login() throws InterruptedException {
		test.assignCategory("Announcekit >> Non-Admin-Can-Not-See-Whats-New");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}

	@Test(priority = 2, description = "verify_WhatsNew_Link")
	public void verify_WhatsNew_Link() throws InterruptedException {
		test.assignCategory("Announcekit >> Non-Admin-Can-Not-See-Whats-New");
		
		objAnnouncekit = new AnnouncekitPage(driver);
		objAnnouncekit.verify_Workroom_Side_Nav();
	}
	
	@Test(priority = 3, description = "open_Interact_With_WhatsNew")
	public void open_Interact_With_WhatsNew() throws InterruptedException {
		test.assignCategory("Announcekit >> Non-Admin-Can-Not-See-Whats-New");
		
		objAnnouncekit = new AnnouncekitPage(driver);
		objAnnouncekit.verify_Whats_New_Not_Visible();
	}
	
	
}