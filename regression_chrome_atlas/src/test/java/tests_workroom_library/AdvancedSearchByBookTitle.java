package tests_workroom_library;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AdvancedSearchByBookTitle extends BaseTestWorkroomLibrary {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Library_Page();
	}

	@Test(priority = 3, description = "advanced_Search_Search_By_Book_Title_A")
	public void advanced_Search_Search_By_Book_Title_A() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.advanced_Search_Search_By_Book_Title_A();
	}
	
	@Test(priority = 4, description = "verify_Only_Book_Title_A_Present")
	public void verify_Only_Book_Title_A_Present() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Only_Book_Title_A_Present();
		driver.navigate().refresh();
	}
	
	@Test(priority = 5, description = "advanced_Search_Search_By_Book_Title_B")
	public void advanced_Search_Search_By_Book_Title_B() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.advanced_Search_Search_By_Book_Title_B();
	}
	
	@Test(priority = 6, description = "verify_Only_Book_Title_B_Present")
	public void verify_Only_Book_Title_B_Present() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Advanced-Search-By-BookTitle");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Only_Book_Title_B_Present();
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	

}