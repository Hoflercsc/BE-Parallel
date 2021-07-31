package tests_workroom_library;


import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookTemplatePage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class ShareBookTemplateAllWorkrooms extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Create_New_BookTemplate();
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}
	
	@Test(priority = 9, description = "open_Book_From_Templates_Page")
	public void open_Book_From_Templates_Page() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.open_Book_From_Templates_Page();
	}
	
	@Test(priority = 10, description = "share_Book_Tempate_All_Workrooms")
	public void share_Book_Tempate_All_Workrooms() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.share_Book_Tempate_All_Workrooms();
	}
	
	@Test(priority = 11, description = "verify_Book_Template_Shared")
	public void verify_Book_Template_Shared() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Template_Shared();
	}
	
	@Test(priority = 12, description = "navigate_Back_To_Auto_Attend_Library")
	public void navigate_Back_To_Auto_Attend_Library() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_Auto_Attend_Library();
	}
	
	@Test(priority = 13, description = "delete_Book_Template")
	public void delete_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_Template();
	}

	@Test(priority = 14, description = "verify_Book_Template_Deleted")
	public void verify_Book_Template_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Template_Deleted();
	}
	
	

	

	
}