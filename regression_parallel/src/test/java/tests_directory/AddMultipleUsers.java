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

public class AddMultipleUsers extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}

	@Test(priority = 3, description = "open_Multiple_User_Form")
	public void open_Multiple_User_Form() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.open_Multiple_User_Form();
	}
	
	@Test(priority = 4, description = "fill_Multiple_User_Form")
	public void fill_Multiple_User_Form() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.fill_Multiple_User_Form();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Directory_Agian")
	public void user_Can_Open_Directory_Agian() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 6, description = "verify_Multiple_Users_Created")
	public void verify_Multiple_Users_Created() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Multiple_Users_Created();
	}
	
	@Test(priority = 7, description = "deactivate_Angela_Moore")
	public void deactivate_Angela_Moore() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.deactivate_Angela_Moore();
	}
	
	@Test(priority = 8, description = "user_Can_Open_Directory_3rd_time")
	public void user_Can_Open_Directory_3rd_time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 9, description = "deactivate_Angela_Morgan")
	public void deactivate_Angela_Morgan() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.deactivate_Angela_Morgan();
	}
	
	@Test(priority = 10, description = "user_Can_Open_Settings")
	public void user_Can_Open_Settings() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 11, description = "delete_User_Angela_Moore")
	public void delete_User_Angela_Moore() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.delete_Angela_Moore(userLastName1);
	}
	
	@Test(priority = 12, description = "user_Can_Open_Settings_Agian")
	public void user_Can_Open_Settings_Agian() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings();
	}
	
	@Test(priority = 13, description = "delete_Angel_Morgan")
	public void delete_Angel_Morgan() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.delete_Angel_Morgan(userLastName2);
	}
	
	@Test(priority = 14, description = "user_Can_Open_Directory_3rd_time")
	public void user_Can_Open_Directory_4th_time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 15, description = "verify_Users_Moore_Morgan_Deleted")
	public void verify_Users_Moore_Morgan_Deleted() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Add-Multiple-Users");
		
		obj_directory = new DirectoryPage();
		obj_directory.verify_Users_Moore_Morgan_Deleted();
	}
	
	
	

	
}