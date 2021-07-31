package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CopyHandBookToTemplate extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_New_Handbook();
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 11, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 12, description = "make_Handbook_Visible")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Handbook_Visible();
	}

	@Test(priority = 13, description = "copy_Handbook_To_Template")
	public void copy_Handbook_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.copy_Handbook_To_Template();
	}
	
	@Test(priority = 14, description = "verify_Handbook_Template_Created")
	public void verify_Handbook_Template_Created() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Handbook_Template_Created();
	}
	
	@Test(priority = 15, description = "delete_BookTemplate")
	public void delete_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_Template();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Test(priority = 16, description = "delete_Handbook")
	public void delete_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_Handbook();
		obj_meeting_book.delete_Handbook();
	}

	@Test(priority = 17, description = "verify_handbook_Deleted")
	public void verify_Handbook_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Copy-HandBook-To-Template");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Handbook_Deleted();
	}
}