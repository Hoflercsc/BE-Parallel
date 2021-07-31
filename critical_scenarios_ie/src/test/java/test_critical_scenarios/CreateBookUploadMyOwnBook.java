package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookEventResourcePage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.MyOwnBookPage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateBookUploadMyOwnBook extends BaseTestCriticalScenarios {
	// ----Completed For IE -------
	@Test(priority = 1, description = "Login UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book")
	public void user_Can_Create_New_Book() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.user_Can_Create_New_Book();
	}

	@Test(priority = 3, description = "user_Can_Upload_New_Book")
	public void user_Can_Upload_New_Book() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.user_Can_Upload_New_Book();
	}

	@Test(priority = 4, description = "user_Can_Make_Book_Visible")
	public void user_Can_Make_Book_Visible() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.user_Can_Make_Book_Visible();
	}

	@Test(priority = 5, description = "user_Can_Delete_Book")
	public void user_Can_Delete_Book() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.user_Can_Delete_Book();
	}

	@Test(priority = 6, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("CreateBookUploadMyOwnBook");
		
		objectMyOwnBook = new MyOwnBookPage(driver);
		objectMyOwnBook.verify_Book_Deleted();
	}
}