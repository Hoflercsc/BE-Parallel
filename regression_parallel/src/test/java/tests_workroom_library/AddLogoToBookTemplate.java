package tests_workroom_library;


import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookEventResourcePage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.SecuredCategoryPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AddLogoToBookTemplate extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	//-----Create Book Template File  ----------------------
	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Create_New_BookTemplate(meetingBook8);
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}
	
	@Test(priority = 9, description = "add_Logo_To_Book_Template")
	public void add_Logo_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Logo_To_Book_Template();
	}
	
	@Test(priority = 10, description = "verify_Logo_To_Book_Template_Added")
	public void verify_Logo_To_Book_Template_Added() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Logo_To_Book_Template_Added();
	}
	
	@Test(priority = 11, description = "delete_Meeting_Book_7")
	public void delete_Meeting_Book_7() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_8();
	}
	
	@Test(priority = 12, description = "navigate_Back_To_BookTemplate")
	public void navigate_Back_To_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_Back_To_BookTemplate();
	}

	@Test(priority = 13, description = "verify_Book_Template_NOT_Visible")
	public void verify_Book_Template_NOT_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Logo-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_8_NOT_VISIBLE();
	}
	
}