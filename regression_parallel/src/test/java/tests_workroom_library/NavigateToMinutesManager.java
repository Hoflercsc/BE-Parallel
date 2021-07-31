package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class NavigateToMinutesManager extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "navigate_To_Minutes_Through_Workroom_Library")
	public void navigate_To_Minutes_Through_Workroom_Library() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_Minutes_Through_Workroom_Library();
	}

	@Test(priority = 3, description = "switch_To_Minutes_Manager_Page")
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Minutes-Manager");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.switch_To_Minutes_Manager_Page();
	}
	
}