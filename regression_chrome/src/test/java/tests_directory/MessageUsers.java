package tests_directory;

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

public class MessageUsers extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Message-User");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}
	
	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Contact-User");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "message_Users")
	public void message_Users() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Message-User");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.message_Users();
	}
	
	@Test(priority = 4, description = "verify_Message_Sent")
	public void verify_Message_Sent() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Message-User");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Message_Sent_2();
	}


	
}