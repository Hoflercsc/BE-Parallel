package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class AttachExistingBookToEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Creating_Book")
	public void switch_To_Creating_Book() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Creating_Book();
	}

	@Test(priority = 6, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.verify_Title_Input_Field();
		objBook.enter_Book_Title();
	}

	@Test(priority = 7, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Add_Cover_Page();
	}

	@Test(priority = 8, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Add_Agenda();
	}

	@Test(priority = 9, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 10, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 11, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 12, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_Can_Build_Book();
	}

	@Test(priority = 13, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.make_Book_Visible();
	}
	
	@Test(priority = 14, description = "verify_Book_Added_To_Event")
	public void verify_Book_Added_To_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Book_Added_To_Event();
	}

	@Test(priority = 15, description = "user_Can_Delete_Event_With_Book")
	public void user_Can_Delete_Event_With_Book() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
	}
	
	@Test(priority = 16, description = "user_navigates_To_Book")
	public void user_navigates_To_Book() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.user_navigates_To_Book();
	}
	
	@Test(priority = 17, description = "delete_Poll")
	public void delete_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.delete_Archived_Meeting_Book();
	}
	
	@Test(priority = 18, description = "verify_Poll_Deletion")
	public void verify_Poll_Deletion() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Book-To-Event");
		
		objBook = new BookPage(driver);
		objBook.verify_Book_Deleted();
	}
	

}
