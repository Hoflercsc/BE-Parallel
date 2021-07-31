package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AdvancedSearchByArchivedBook extends BaseTestWorkroomLibrary {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Archived-Book");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING); //redirect from ozzie to staging
	}
	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Archived-Book");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Archived-Book");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Library_Page();
	}

	@Test(priority = 3, description = "advanced_Search_Search_By_Created_Date_After_Before")
	public void advanced_Search_Search_By_Archived_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Archived-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.advanced_Search_Search_By_Archived_Book();
	}
	
	@Test(priority = 4, description = "verify_Book_Achived_Book_Visible")
	public void verify_Book_Achived_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Archived-Book");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Book_Achived_Book_Visible();
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}

}