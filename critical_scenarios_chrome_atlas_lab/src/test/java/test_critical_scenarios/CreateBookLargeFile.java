package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.BookLargeFilePage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

//--This test has been commented out---

public class CreateBookLargeFile extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Can_Create_Book_And_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("create_Large_Book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_Large_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Add_Large_File_1_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Add_Large_File_2_To_First_Catagory")
	public void user_Add_Large_File_2_To_First_Catagory() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Add_Large_File_2_To_First_Catagory();
	}

	@Test(priority = 10, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.user_Can_Build_Book();
	}

	@Test(priority = 11, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.make_Book_Visible();
	}

	@Test(priority = 12, description = "delete_Book")
	public void delete_Book() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.delete_Book();
	}

	@Test(priority = 13, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("create_large_book");
		
		objectLargeFile = new BookLargeFilePage(driver);
		objectLargeFile.verify_Book_Deleted();
	}
}