package tests_workroom_library;


import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookTemplatePage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class ShareBookTemplateAllWorkrooms extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Create_New_BookTemplate(meetingBook39);
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_To_First_Catagory();
		//obj_meeting_book.click_Book_Template_Crumb();
	}
	
	@Test(priority = 10, description = "share_Book_Tempate_All_Workrooms")
	public void share_Book_Tempate_All_Workrooms() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.share_Book_Tempate_All_Workrooms();
	}
	
	@Test(priority = 11, description = "verify_Book_39_Template_Shared")
	public void verify_Book_39_Template_Shared() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Book_39_Template_Shared();
	}
	
	@Test(priority = 12, description = "navigate_Back_To_AutoBE_Library")
	public void navigate_Back_To_AutoBE_Library() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_Back_To_AutoBE_Library();
	}
	
	@Test(priority = 13, description = "delete_Meeting_Book_39")
	public void delete_Meeting_Book_39() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_39();
	}

	@Test(priority = 14, description = "verify_Meeting_Book_39_NOT_VISIBLE")
	public void verify_Meeting_Book_39_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Share-Book-Template-All-Workrooms");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_39_NOT_VISIBLE();
	}
	
}