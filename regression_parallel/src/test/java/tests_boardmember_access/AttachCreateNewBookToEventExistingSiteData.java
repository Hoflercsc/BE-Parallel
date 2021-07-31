package tests_boardmember_access;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AttachCreateNewBookToEventExistingSiteData extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "create_New_Event_On_JH_Staging")
	public void create_New_Event_On_JH_Staging() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.create_New_Event_On_JH_Staging_1(eventTitleStaging1);
	}
	
	@Test(priority = 4, description = "switch_To_Creating_Book")
	public void switch_To_Creating_Book() throws InterruptedException, AWTException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Creating_Book_For_Event_Title_Staging_1();
	}
	
	@Test(priority = 5, description = "user_Can_Create_Book_And_Add_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_Book_And_Add_Title(bookTitleStaging1);
	}

	@Test(priority = 6, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 7, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 8, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 9, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 10, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 11, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 12, description = "make_Book_Board_Member_Access_1_Visible")
	public void make_Book_Board_Member_Access_1_Visible() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Book_Board_Member_Access_1_Visible();
	}
	
	@Test(priority = 13, description = "verify_Book_Added_To_Event_Staging_1")
	public void verify_Book_Added_To_Event_Staging_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Book_Added_To_Event_Staging_1();
	}

	@Test(priority = 14, description = "delete_Event_Title_On_Staging_1")
	public void delete_Event_Title_On_Staging_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_Title_On_Staging_1();
	}
	
	@Test(priority = 15, description = "verify_Event_Deleted_2")
	public void verify_Event_Title_On_Staging_1_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_Title_On_Staging_1_Deleted();
	}
	
	@Test(priority = 16, description = "user_navigates_To_Book")
	public void user_navigates_To_Book() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_navigates_To_Book();
	}
	
	@Test(priority = 17, description = "delete_Book_On_Staging_Board_Member_Access_1")
	public void delete_Book_On_Staging_Board_Member_Access_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Book_On_Staging_Board_Member_Access_1();
	}
	
	@Test(priority = 18, description = "verify_Book_Title_On_Staging_1_NOT_VISIBLE")
	public void verify_Book_Title_On_Staging_1_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Create-New-Book-To-Event");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Book_Title_On_Staging_1_NOT_VISIBLE();
	}
	
}