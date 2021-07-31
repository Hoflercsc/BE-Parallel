package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookEventResourcePage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateBookCreateEventAttachBookAttachResource extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_New_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Create_New_Book_And_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.make_Book_Visible();
	}

	@Test(priority = 11, description = "user_Can_Create_New_Event")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Create_New_Event();
	}

	@Test(priority = 12, description = "user_Click_Attach_Create_And_Click_Resource_Tab")
	public void user_Click_Attach_Create_And_Click_Resource_Tab() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Click_Attach_Create_And_Click_Resource_Tab();
	}

	@Test(priority = 13, description = "user_Can_Attach_Resource_To_Event_And_Save")
	public void user_Can_Attach_Resource_To_Event_And_Save() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Attach_Resource_To_Event_And_Save();
	}

	@Test(priority = 14, description = "user_Can_Attach_Book_To_Event")
	public void user_Can_Attach_Book_To_Event() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.user_Can_Attach_Book_To_Event();
	}

	@Test(priority = 15, description = "verify_Book_And_Resource_Tabs_Appear_On_Event_Card")
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Card() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.verify_Book_And_Resource_Tabs_Appear_On_Event_Card();
	}

	@Test(priority = 16, description = "verify_Book_And_Resource_Tabs_Appear_On_Event_Details")
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Details() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.verify_Book_And_Resource_Tabs_Appear_On_Event_Details();
	}

	@Test(priority = 17, description = "delete_Event")
	public void delete_Event() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.delete_Event();
	}

	@Test(priority = 18, description = "delete_Book")
	public void delete_Book() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.delete_Book();
	}

	@Test(priority = 19, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("CreateBookCreateEventAttachBookAttachResource");
		
		objectBookEventResource = new BookEventResourcePage(driver);
		objectBookEventResource.verify_Book_Deleted();
	}
}