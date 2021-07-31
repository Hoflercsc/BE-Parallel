package tests_workroom_home;

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

public class MessageWorkroomUsersDiffTabs extends BaseTestWorkroomHome {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Home >> Message-Workroom-Users-Different-Tabs");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "message_Workroom_Users_Diff_Tabs")
	public void message_Workroom_Users_Diff_Tabs() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Home >> Message-Workroom-Users-Different-Tabs");
		
		obj_directory = new DirectoryPage();
		obj_directory.message_Workroom_Users_Diff_Tabs();
	}
	
	@Test(priority = 4, description = "verify_Message_Sent_To_BoardMembers")
	public void verify_Message_Sent_To_BoardMembers() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Home >> Message-Workroom-Users-Different-Tabs");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Message_Sent_To_BoardMembers();
	}

}