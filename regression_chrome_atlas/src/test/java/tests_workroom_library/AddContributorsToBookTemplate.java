package tests_workroom_library;

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
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.SecuredCategoryPage;
import page_critical_scenarios.WorkroomPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AddContributorsToBookTemplate extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password); // autoUser Login
	}

	//-----Create Book Template File  ----------------------
	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Create_New_BookTemplate();
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}
	
	@Test(priority = 9, description = "user_Can_Open_Manage_Contributors_Add_Contributor")
	public void user_Can_Open_Manage_Contributors_Add_Contributor() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage(driver);
		objectSecuredCategory.user_Can_Open_Manage_Contributors();
		objectSecuredCategory.user_Can_Add_Workroom_Admin_As_Contributor();
	}

	@Test(priority = 10, description = "set_Contributor_Notification_Email")
	public void set_Contributor_Notification_Email() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.set_Contributor_Notification_Email();
		obj_meeting_book.verify_Book_Template_Crumb();
		obj_meeting_book.click_Book_Template_Crumb();
		Thread.sleep(1000);
		obj_meeting_book.verify_Template_Title();
	}
	
	@Test(priority = 11, description = "delete_Book_Template")
	public void delete_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_Template();
	}
	
	@Test(priority = 12, description = "navigate_Back_To_BookTemplate")
	public void navigate_Back_To_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_BookTemplate();
	}

	@Test(priority = 13, description = "verify_Book_Template_NOT_Visible")
	public void verify_Book_Template_NOT_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Contributors-To-Book-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Template_NOT_Visible();
	}
}