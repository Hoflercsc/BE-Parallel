package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class NavigateToTakeMinutesViaMeetingBook extends BaseTestWorkroomLibrary {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Via-Meeting-Book");
		
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING); //redirect from staging to lab to execute test
	}
	
	@Test(priority = 2, description = "Login UserName Password.")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Via-Meeting-Book");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 3, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Via-Meeting-Book");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 4, description = "open_Book_Navigate_To_Take_Minutes")
	public void open_Book_Navigate_To_Take_Minutes() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Via-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.open_Book_Navigate_To_Take_Minutes();
	}
	
	@Test(priority = 5, description = "switch_To_Minutes_Manager_Page")
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Libary >> Navigate-To-Take-Minutes-Via-Meeting-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.switch_To_Minutes_Manager_Page_C();
	}
	
}