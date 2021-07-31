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
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_directory.DirectoryPage;
import page_intergrations.GoToMeetingPage;
import static constants.ConstantsFile.*;

public class ContactUser extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Contact-User");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Contact-User");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Test_Reset_Profile_Click_Contact_User")
	public void open_Test_Reset_Profile_Click_Contact_User() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Contact-User");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Test_Reset_Profile_Click_Contact_User();
	}
	
	@Test(priority = 4, description = "send_Contact_User_Message")
	public void send_Contact_User_Message() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Contact-User");
		
		obj_directory = new DirectoryPage();
		obj_directory.send_Contact_User_Message();
	}
	
	@Test(priority = 5, description = "verify_Message_Sent")
	public void verify_Message_Sent() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Contact-User");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Message_Sent_1();
	}


	
}