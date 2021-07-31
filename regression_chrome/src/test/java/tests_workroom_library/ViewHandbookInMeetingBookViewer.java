package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class ViewHandbookInMeetingBookViewer extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_New_Handbook();
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_PDF_To_First_Catagory")
	public void user_Add_PDF_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_PDF_To_First_Catagory();
	}

	@Test(priority = 9, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Handbook_Visible")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Handbook_Visible_2();
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	@Test(priority = 12, description = "user_Opens_Meeting_Book_Viewer_And_Scroll")
	public void user_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Opens_Meeting_Book_Viewer_And_Scroll_2();
	}
	
	@Test(priority = 13, description = "navigate_Back_To_Handbook")
	public void navigate_Back_To_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_Handbook_2();
	}
	
	@Test(priority = 14, description = "delete_Handbook")
	public void delete_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Handbook_Visible();
		obj_meeting_book.delete_Handbook();
	}
	
	@Test(priority = 15, description = "navigate_Back_To_Handbook_Agian")
	public void navigate_Back_To_Handbook_Agian() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_Handbook_2();
	}

	@Test(priority = 16, description = "verify_handbook_Deleted")
	public void verify_Handbook_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> View-Handbook-In-Meeting-Book-Viewer");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Handbook_NOT_Visible();
	}
}