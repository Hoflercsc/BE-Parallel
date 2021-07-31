package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AdvancedSearchByBookVisible extends BaseTestWorkroomLibrary {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Book-Visible");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Book-Visible");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Book-Visible");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom_4();
	}

	@Test(priority = 3, description = "advanced_Search_Search_By_Book_Title_A")
	public void advanced_Search_Search_By_Book_Title_A() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Book-Visible");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.advanced_Search_Search_By_Book_Visible();
	}
	
	@Test(priority = 4, description = "verify_Only_Books_E_And_F_Visible")
	public void verify_Only_Books_E_And_F_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-Book-Visible");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Only_Books_E_And_F_Visible();
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

}