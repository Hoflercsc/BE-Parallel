package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class RenameFileInMeetingBook extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 2, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 3, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 4, description = "navigate_To_File_In_Book")
	public void navigate_To_File_In_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_To_File_In_Book();
	}
	
	@Test(priority = 5, description = "edit_File_In_Book")
	public void edit_File_In_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.edit_File_In_Book();
	}
	
	@Test(priority = 5, description = "edit_File_In_Book")
	public void verify_File_Name_Change() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Build_Book();
		obj_meeting_book.verify_Edited_File_Title_Drp_Dwn();
	}
	
	@Test(priority = 6, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book_2();
	}
	
	@Test(priority = 7, description = "navigate_To_File_In_Book_2nd_Time")
	public void navigate_To_File_In_Book_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_To_File_In_Book_2();
	}
	
	@Test(priority = 8, description = "edit_File_Back_To_Orginal_Name")
	public void edit_File_Back_To_Orginal_Name() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.edit_File_Back_To_Orginal_Name();
	}
	
	@Test(priority = 9, description = "verify_Orginal_File_Name_Changed")
	public void verify_Orginal_File_Name_Changed() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Build_Book();
		obj_meeting_book.verify_Orginal_File_Title_Drp_Dwn();
	}

	@Test(priority = 10, description = "user_Can_Build_Book_2nd_Time")
	public void user_Can_Build_Book_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book_2();
	}
	
	@Test(priority = 11, description = "verify_File_Title")
	public void verify_Orginal_File_Title() throws InterruptedException {
		test.assignCategory("Workroom-Library >> Rename-File-In-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Built_File_Title();
	}
	
}