package tests_resource_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CopyArchivedMeetingBook extends BaseTestResourceLibrary {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Create_Book_And_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.make_Book_Visible();
	}

	@Test(priority = 11, description = "delete_Book")
	public void archive_Meeting_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.archive_Meeting_Book();
	}
	
	@Test(priority = 12, description = "Resource-Library >> Copy-Archived-Meeting-Book")
	public void copy_Archived_Meeting_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.copy_Archived_Meeting_Book();
	}
	
	@Test(priority = 13, description = "verify_Copied_Archived_Meeting_Book_Created")
	public void verify_Copied_Archived_Meeting_Book_Created() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.verify_Copied_Archived_Meeting_Book_Created();
	}
	
	@Test(priority = 14, description = "delete_Archived_Meeting_Book")
	public void delete_Archived_Meeting_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.delete_Archived_Meeting_Book();
	}
	
	@Test(priority = 15, description = "delete_Copied_Archived_Meeting_Book")
	public void delete_Copied_Archived_Meeting_Book() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.delete_Copied_Archived_Meeting_Book();
	}

	@Test(priority = 16, description = "verify_Meeting_Books_Deleted")
	public void verify_Meeting_Books_Deleted() throws InterruptedException {
		test.assignCategory("Resource-Library >> Copy-Archived-Meeting-Book");
		
		objBook = new BookPage(driver);
		objBook.verify_Book_Deleted();
	}
}