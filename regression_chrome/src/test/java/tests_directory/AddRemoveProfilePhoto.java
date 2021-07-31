package tests_directory;

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

public class AddRemoveProfilePhoto extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void login_BE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Dirctory() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 3, description = "open_User_Profile")
	public void open_User_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 4, description = "add_Photo_To_Profile")
	public void add_Photo_To_Profile() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.add_Photo_To_Profile();
	}

	@Test(priority = 5, description = "close_Profile_Photo")
	public void close_Profile_Photo() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.close_Profile_Photo();
	}

	@Test(priority = 6, description = "user_Can_Open_Dirctory_Again")
	public void user_Can_Open_Dirctory_Again() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 7, description = "Open_User_Profile_Again")
	public void Open_User_Profile_Again() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 8, description = "delete_Photo")
	public void delete_Photo() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.delete_Photo();
		driver.navigate().refresh();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Dirctory_Again")
	public void user_Can_Open_Dirctory_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}

	@Test(priority = 10, description = "Open_User_Profile_Again")
	public void Open_User_Profile_3rd_Time() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_User_Profile();
	}

	@Test(priority = 11, description = "delete_Photo")
	public void verify_Photo_Deleted() throws InterruptedException {
		test.assignCategory("Directory >> Add-Remove-Profile-Photo");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.verify_Photo_Deleted();
	}
}