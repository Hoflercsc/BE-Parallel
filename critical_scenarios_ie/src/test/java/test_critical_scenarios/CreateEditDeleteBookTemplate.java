package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteBookTemplate extends BaseTestCriticalScenarios {	
	// ----Completed For IE -------
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.open_Library_Page_for_Workroom();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Create_New_BookTemplate();
	}

	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Add_Coverpage_To_Book_Template();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Save_Book_Template();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Add_Second_Catagory")
	public void user_Add_Second_Catagory_To_Handbook() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.user_Add_Second_Catagory_To_Handbook();
	}

	@Test(priority = 10, description = "add_File_To_Second_Catagory")
	public void add_File_To_Second_Catagory() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.add_File_To_Second_Catagory();
	}

	@Test(priority = 11, description = "open_Book_From_Templates_Page")
	public void open_Book_From_Templates_Page() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.open_Book_From_Templates_Page();
	}

	@Test(priority = 12, description = "edit_Book_Template")
	public void edit_Book_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.edit_Book_Template();
	}

	@Test(priority = 13, description = "delete_Book_Template")
	public void delete_Book_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.delete_Book_Template();
	}

	@Test(priority = 14, description = "verify_Book_Template_Deleted")
	public void verify_Book_Template_Deleted() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookTemplate");
		
		objectBookTemplate = new BookTemplatePage(driver);
		objectBookTemplate.verify_Book_Template_Deleted();
	}
}