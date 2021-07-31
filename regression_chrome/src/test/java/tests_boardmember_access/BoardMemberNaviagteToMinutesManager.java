package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class BoardMemberNaviagteToMinutesManager extends BaseTestBoardMemberAccess {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Manager");
		
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 2, description = "Login UserName Password.")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Manager");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 3, description = "navigate_To_Workroom_Library")
	public void navigate_To_Workroom_Library() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_To_Workroom_Library();
	}
	
	@Test(priority = 4, description = "open_Book_Verify_Take_Minutes_Not_Present")
	public void open_Book_Verify_Take_Minutes_Not_Present() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.open_Book_Verify_Take_Minutes_Not_Present();
	}
	
	@Test(priority = 5, description = "navigate_To_Minutes_Through_Workroom_Library")
	public void navigate_To_Minutes_Through_Workroom_Library() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.navigate_To_Minutes_Through_Workroom_Library();
	}

	@Test(priority =6, description = "switch_To_Minutes_Manager_Page")
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.switch_To_Minutes_Manager_Page();
	}


}