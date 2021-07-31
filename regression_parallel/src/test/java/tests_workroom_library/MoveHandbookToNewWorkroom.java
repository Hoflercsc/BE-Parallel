package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class MoveHandbookToNewWorkroom extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");

		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_New_Handbook(handBook7);
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Handbook_Visible_2")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Handbook_Visible_2();
	}

	@Test(priority = 11, description = "move_Handbook_To_New_Workroom")
	public void move_Handbook_To_New_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.move_Handbook_To_New_Workroom();
	}
	
	@Test(priority = 12, description = "verify_Handbook_Workroom_Move")
	public void verify_Handbook_Workroom_Move() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Handbook_Workroom_Move();
	}

	@Test(priority = 13, description = "delete_Handbook_7")
	public void delete_Handbook_7() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Handbook_7();
	}
	
	@Test(priority = 14, description = "navigate_Back_To_Handbook_2")
	public void navigate_Back_To_Handbook_2() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_Back_To_Handbook_2();
	}

	@Test(priority = 15, description = "verify_Handbook_7_NOT_Visible")
	public void verify_Handbook_7_NOT_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Move-Handbook-To-New-Workroom");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Handbook_7_NOT_Visible();
	}
}