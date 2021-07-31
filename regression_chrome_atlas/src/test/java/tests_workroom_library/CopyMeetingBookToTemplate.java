package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CopyMeetingBookToTemplate extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_Book_And_Add_Title();
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Book_Visible();
	}

	@Test(priority = 11, description = "copy_Meetings_Book_To_Template")
	public void copy_Meetings_Book_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.copy_Meetings_Book_To_Template();
	}
	
	@Test(priority = 12, description = "verify_Copied_Meeting_Book")
	public void verify_Copied_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Copied_Archived_Meeting_Book();
	}
	
	@Test(priority = 13, description = "delete_BookTemplate")
	public void delete_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_Template();
		Thread.sleep(1500);
		driver.navigate().refresh();
	}

	@Test(priority = 14, description = "delete_Meeting_Book")
	public void delete_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Archived_Meeting_Book();
		Thread.sleep(1500);
		driver.navigate().refresh();
	}

	@Test(priority = 15, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-Meeting-Book-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Deleted_2();
	}
}