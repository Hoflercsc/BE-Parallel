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

public class ViewProfile extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> View-Profile");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> View-Profile");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile_Contact_User")
	public void open_User_Profile_Contact_User() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> View-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.view_User_Profile();
	}
	
	@Test(priority = 4, description = "verify_Member_Profile_Contents")
	public void verify_Member_Profile_Contents() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> View-Profile");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Member_Profile_Contents();
	}


	
}