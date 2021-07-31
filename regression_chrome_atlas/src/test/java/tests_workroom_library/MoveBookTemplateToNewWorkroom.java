package tests_workroom_library;


import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookTemplatePage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class MoveBookTemplateToNewWorkroom extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Create_New_BookTemplate();
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}
	
	@Test(priority = 9, description = "open_Book_From_Templates_Page")
	public void open_Book_From_Templates_Page() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.open_Book_From_Templates_Page();
	}
	
	@Test(priority = 10, description = "move_Book_Tempate_To_New_Workroom")
	public void move_Book_Tempate_To_New_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.move_Book_Tempate_To_New_Workroom();
	}
	
	@Test(priority = 10, description = "verify_Workroom_Move")
	public void verify_Workroom_Move() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Workroom_Move();
	}
	
	@Test(priority = 11, description = "delete_Book_Template")
	public void delete_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_Template();
	}

	@Test(priority = 12, description = "verify_Book_Template_Deleted")
	public void verify_Book_Template_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Move-Book-Template-To-New-Workroom");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Template_Deleted();
	}
	
}