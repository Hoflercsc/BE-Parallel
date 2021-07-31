package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.SecuredCategoryPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class AdminSelectImportViewMinutes extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");

		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Create_New_Book_Add_Title(meetingBook16);
	}
	
	@Test(priority = 4, description = "user_Can_Add_Agenda_B")
	public void user_Can_Add_Agenda_B() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda_B();
	}
	
	@Test(priority = 5, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 6, description = "user_Add_Meeting_Minutes_To_First_Catagory")
	public void user_Add_Meeting_Minutes_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Meeting_Minutes_To_First_Catagory();
	}
	
	@Test(priority = 7, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}
	
	@Test(priority = 8, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Book_Visible_2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 9, description = "opens_Meeting_Book_Viewer_See_Minutes")
	public void opens_Meeting_Book_Viewer_See_Minutes() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.open_Meeting_Book_Viewer_See_Minutes();// must be in AutoBE workroom
	}

	@Test(priority = 10, description = "delete_Book")
	public void delete_Meeting_Book_16() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_16();
	}
	
	@Test(priority = 11, description = "verify_Meeting_Book_16_NOT_VISIBLE")
	public void verify_Meeting_Book_16_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> System-Admin-Select-Import-View-Minutes");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_16_NOT_VISIBLE();
		
	}
	
}