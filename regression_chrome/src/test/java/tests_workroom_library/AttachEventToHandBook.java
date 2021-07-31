package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class AttachEventToHandBook extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");

		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_New_Handbook();
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Handbook_Visible")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Handbook_Visible();
	}
	
   //-----------------------------------------------------
	@Test(priority = 11, description = "go_To_Events_For_Workroom")
	public void go_To_Events_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.go_To_Events_For_Workroom();
	}

	@Test(priority = 12, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 13, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 14, description = "attach_Hand_Book")
	public void attach_Hand_Book() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.attach_Hand_Book();
	}
	
	@Test(priority = 15, description = "verify_Handbook_Added_To_Event")
	public void verify_Handbook_Added_To_Event() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Handbook_Added_To_Event();
	}
	
	@Test(priority = 16, description = "delete_Handbook")
	public void delete_Handbooks() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Handbook();
	}
	
	@Test(priority = 17, description = "navigate_Back_To_Handbook")
	public void navigate_Back_To_Handbook() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_Back_To_Handbook_2();
	}

	@Test(priority = 18, description = "verify_handbook_Deleted")
	public void verify_Handbook_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Handbook_NOT_Visible();
	}
	
	@Test(priority = 19, description = "go_To_Events_For_Workroom")
	public void go_To_Events_For_Workroom_Agian() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.go_To_Events_For_Workroom();
	}
	
	@Test(priority = 20, description = "user_Delete_Print_Upcoming_Event")
	public void user_Delete_Print_Upcoming_Event() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 21, description = "user_Delete_Print_Upcoming_Event")
	public void verify_Event_And_Copy_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Attach-Events-To-Handbook");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_And_Copy_Deleted();
	}	
	

}
