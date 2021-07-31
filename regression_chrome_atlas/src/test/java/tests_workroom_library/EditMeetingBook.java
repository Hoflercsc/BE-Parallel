package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class EditMeetingBook extends BaseTestWorkroomLibrary {
	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_Book_And_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Book_Visible();
	}

	@Test(priority = 11, description = "user_Can_Edit_Meeting_Book")
	public void user_Can_Edit_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.edit_Meeting_Book();
	}
	
	@Test(priority = 12, description = "delete_Edited_Meeting_Book")
	public void delete_Edited_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Edited_Meeting_Book();
	}

	@Test(priority = 13, description = "verify_Edited_Book_Deleted")
	public void verify_Edited_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Edit-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Edited_Book_Deleted();
	}
}