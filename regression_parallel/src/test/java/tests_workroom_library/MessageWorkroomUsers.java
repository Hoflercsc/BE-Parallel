package tests_workroom_library;

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

public class MessageWorkroomUsers extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Message-Workroom-Users");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "message_Workroom_Users")
	public void message_Workroom_Users() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Message-Workroom-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.message_Workroom_Users();
	}
	
	@Test(priority = 3, description = "verify_Message_Sent")
	public void verify_Message_Sent() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Message-Workroom-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Message_Sent_2();
	}
	
}