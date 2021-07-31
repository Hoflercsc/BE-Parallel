package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class BoardMemberNaviagteToMinutesManager extends BaseTestBoardMemberAccess {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 2, description = "Login UserName Password.")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 3, description = "navigate_To_Workroom_Library")
	public void navigate_To_Workroom_Library() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 4, description = "open_Book_Verify_Take_Minutes_Not_Present")
	public void open_Book_Verify_Take_Minutes_Not_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.open_Book_Verify_Take_Minutes_Not_Present();
	}
	
	@Test(priority = 5, description = "navigate_To_Minutes_Through_Workroom_Library")
	public void navigate_To_Minutes_Through_Workroom_Library() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_Minutes_Through_Workroom_Library();
	}

	@Test(priority =6, description = "switch_To_Minutes_Manager_Page")
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		test.assignCategory("Board-Member-Access >> Navigate-To-Take-Minutes-Manager");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.switch_To_Minutes_Manager_Page();
	}


}