package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CopyArchivedMeetingBook extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_Constellation_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_New_Book(meetingBook18);
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Book_Visible();
	}

	@Test(priority = 11, description = "archive_Meeting_Book_18")
	public void archive_Meeting_Book_19() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.archive_Meeting_Book_18();
	}
	
	@Test(priority = 12, description = "copy_Archived_Meeting_Book_18")
	public void copy_Archived_Meeting_Book_18() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.copy_Archived_Meeting_Book_18(meetingBook19);
	}
	
	@Test(priority = 13, description = "verify_Archived_Meeting_Book_18_19_VISIBLE")
	public void verify_Archived_Meeting_Book_18_19_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Archived_Books_Heading();
		obj_meeting_book.verify_Archived_Meeting_Book_18_19_VISIBLE();
	}
	
	@Test(priority = 14, description = "delete_Archive_Meeting_Book_18")
	public void delete_Archive_Meeting_Book_18() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Archive_Meeting_Book_18();
	}
	
	@Test(priority = 15, description = "navigate_To_Archived_Books")
	public void navigate_To_Archived_Books() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_Archived_Books();
	}
	
	@Test(priority = 16, description = "delete_Meeting_Book_19")
	public void delete_Meeting_Book_19() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_19();
	}

	@Test(priority = 17, description = "verify_Archived_Meeting_Book_18_19_Deleted")
	public void verify_Archived_Meeting_Book_18_19_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Copy-Archived-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Archived_Meeting_Book_18_19_NOT_VISIBLE();
	}
}