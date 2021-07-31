package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AdvancedSearchByBookAlphabeticalOrderDecendingAccending extends BaseTestWorkroomLibrary {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Alphabetical-Order");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Alphabetical-Order");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Alphabetical-Order");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Library_Page();
	}

	@Test(priority = 3, description = "advanced_Search_Verify_Alphabetical_Decending_Order")
	public void advanced_Search_Verify_Alphabetical_Decending_Order() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Alphabetical-Order");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.advanced_Search_Verify_Alphabetical_Descending_Order();
	}
	
	@Test(priority = 4, description = "advanced_Search_Verify_Alphabetical_Accending_Order")
	public void advanced_Search_Verify_Alphabetical_Accending_Order() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Alphabetical-Order");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.advanced_Search_Verify_Alphabetical_Accending_Order();
	}
	

}