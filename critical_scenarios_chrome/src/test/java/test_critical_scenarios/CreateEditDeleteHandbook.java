package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteHandbook extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user can open library page for workroom")
	public void user_Opens_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Opens_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Handbook")
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Can_Create_New_Handbook();
	}

	@Test(priority = 4, description = "user_Add_CoverPage_To_HandBook")
	public void user_Add_CoverPage_To_HandBook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Add_CoverPage_To_HandBook();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_HandBook")
	public void user_Add_Agenda_To_HandBook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Add_Agenda_To_HandBook();
	}

	@Test(priority = 6, description = "user_Save_HandBook")
	public void user_Save_HandBook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Save_HandBook();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_HandBook")
	public void user_Add_First_Catagory_To_HandBook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Add_First_Catagory_To_HandBook();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Add_Second_Catagory")
	public void user_Add_Second_Catagory_To_Handbook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.user_Add_Second_Catagory_To_Handbook();
	}

	@Test(priority = 10, description = "add_File_To_Second_Catagory")
	public void add_File_To_Second_Catagory() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.add_File_To_Second_Catagory();
	}

	@Test(priority = 11, description = "build_Handbook")
	public void build_Handbook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.build_Handbook();
	}

	@Test(priority = 12, description = "make_Handbook_Visible")
	public void make_Handbook_Visible() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.make_Handbook_Visible();
	}

	@Test(priority = 13, description = "edit_Handbook")
	public void edit_Handbook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.edit_Handbook();
	}

	@Test(priority = 14, description = "delete_Handbook")
	public void delete_Handbook() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.delete_Handbook();
	}

	@Test(priority = 15, description = "verify_handbook_Deleted")
	public void verify_Handbook_Deleted() throws InterruptedException {
		test.assignCategory("create_delete_handbook");
		
		objectHandbook = new HandbookPage(driver);
		objectHandbook.verify_Handbook_Deleted();
	}
}