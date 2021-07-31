package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class NavigateToTakeMinutesViaHandbook extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");

		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_New_Handbook(handBook8);
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Handbook_Visible")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Handbook_Visible();
	}

	@Test(priority = 11, description = "open_Handbook_8_Navigate_To_Take_Minutes")
	public void open_Handbook_8_Navigate_To_Take_Minutes() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.open_Handbook_8_Navigate_To_Take_Minutes();
	}
	
	@Test(priority = 12, description = "switch_To_Minutes_Manager_Page")
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.switch_To_Minutes_Manager_Page_B();
	}

	@Test(priority = 13, description = "delete_Handbook")
	public void delete_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Handbook_Crumb();
		obj_meeting_book.click_Handbook_Crumb();
		obj_meeting_book.delete_Handbook_8();
	}
	
	@Test(priority = 14, description = "navigate_Back_To_Handbook_2")
	public void navigate_Back_To_Handbook_2() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_Back_To_Handbook_2();
	}

	@Test(priority = 15, description = "verify_Handbook_8_NOT_Visible")
	public void verify_Handbook_8_NOT_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Navigate-To-Minutes-Via-Handbook");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Handbook_8_NOT_Visible();
	}
}