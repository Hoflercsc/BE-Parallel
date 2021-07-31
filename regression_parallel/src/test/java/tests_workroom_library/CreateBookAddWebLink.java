package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_general_settings.GeneralSettingsPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CreateBookAddWebLink extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_New_Book(meetingBook26);
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_Web_Link")
	public void user_Add_Web_Link() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Web_Link();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Book_Visible();
	}
	
	@Test(priority = 11, description = "switch_Tabs_To_Web_Site")
	public void switch_Tabs_To_Web_Site() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_general_settings = new GeneralSettingsPage();

		obj_meeting_book.scroll_And_Click_Link_On_Book_26();
		obj_general_settings.switch_Tabs_To_Web_Site();
		obj_meeting_book.navigate_To_Meeting_Book_3();
	}
	
	@Test(priority = 12, description = "delete_Meeting_Book_26")
	public void delete_Meeting_Book_26() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_26();
	}

	@Test(priority = 13, description = "verify_Meeting_Book_26_NOT_VISIBLE")
	public void verify_Meeting_Book_26_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Create-Book-Add-Web-Link");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_26_NOT_VISIBLE();
	}
}