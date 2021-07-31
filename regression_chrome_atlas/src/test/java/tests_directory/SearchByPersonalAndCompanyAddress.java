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

public class SearchByPersonalAndCompanyAddress extends BaseTestDirectory {
	@Test(priority = 1, description = "Login systemAdmin UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 3, description = "open_Advanced_Search")
	public void open_Advanced_Search() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_Advanced_Search();
	}

	@Test(priority = 4, description = "search_By_Personal_Address")
	public void search_By_Personal_Address() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.search_By_Personal_Address();
		driver.navigate().refresh();
	}
	
	@Test(priority = 5, description = "user_Can_Open_Directory_Agian")
	public void user_Can_Open_Directory_Agian() throws InterruptedException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Directory();
	}
	
	@Test(priority = 6, description = "open_Advanced_Search_Agian")
	public void open_Advanced_Search_Agian() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.open_Advanced_Search();
	}
	
	@Test(priority = 7, description = "search_By_Company_Address")
	public void search_By_Company_Address() throws InterruptedException, AWTException {
		test.assignCategory("Directory >> Search-By-Personal-And-Company-Address");
		
		obj_directory = new DirectoryPage(driver);
		obj_directory.search_By_Company_Address();
		driver.navigate().refresh();
	}
	

	
}