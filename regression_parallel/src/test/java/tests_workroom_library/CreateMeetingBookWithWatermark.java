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

public class CreateMeetingBookWithWatermark extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_Planet_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Create_New_Book_Add_Title(meetingBook29);
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}
	
	@Test(priority = 9, description = "enable_Watermark_For_Book")
	public void enable_Watermark_For_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.enable_Watermark_For_Book();
	}
	
	@Test(priority = 10, description = "user_Can_Build_Book_WaterMark")
	public void user_Can_Build_Book_WaterMark() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Build_Book_WaterMark();
	}

	@Test(priority = 11, description = "make_Meeting_Book_Visible")
	public void make_Meeting_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.make_Meeting_Book_Visible();
	}
	
	@Test(priority = 12, description = "verify_Watermark")
	public void verify_Watermark() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		objectScannedPDF = new BookScannedPDFPage();
		obj_meeting_book.navigate_To_Edit_Status_Book_29();
		obj_meeting_book.verify_Watermark_Enabled();
		objectScannedPDF.click_Workroom_Library_Crumb();
	}
	
	@Test(priority = 13, description = "delete_Meeting_Book_29")
	public void delete_Meeting_Book_29() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_29();
	}

	@Test(priority = 14, description = "verify_Meeting_Book_29_NOT_VISIBLE")
	public void verify_Meeting_Book_29_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-Meeting-Book-With-Watermark");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_29_NOT_VISIBLE();
	}
}