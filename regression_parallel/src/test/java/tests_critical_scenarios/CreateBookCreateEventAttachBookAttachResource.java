package tests_critical_scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
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
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "create_Book_Add_Title_A")
	public void create_Book_Add_Title_A() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.create_Book_And_Title_A();
	}

	@Test(priority = 4, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Add_Cover_Page();
	}

	@Test(priority = 5, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Add_Agenda();
	}

	@Test(priority = 6, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Add_File_To_First_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Book_A_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.make_Book_A_Visible();
	}

	@Test(priority = 11, description = "create_New_Event_A")
	public void create_New_Event_A() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.create_New_Event_A();
	}

	@Test(priority = 12, description = "user_Click_Attach_Create_And_Click_Resource_Tab")
	public void user_Click_Attach_Create_And_Click_Resource_Tab() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Click_Attach_Create_And_Click_Resource_Tab();
	}

	@Test(priority = 13, description = "user_Can_Attach_Resource_To_Event_And_Save")
	public void user_Can_Attach_Resource_To_Event_And_Save() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Attach_Resource_To_Event_And_Save();
	}

	@Test(priority = 14, description = "user_Can_Attach_Book_To_Event")
	public void user_Can_Attach_Book_To_Event() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.user_Can_Attach_Book_To_Event();
	}

	@Test(priority = 15, description = "verify_Book_And_Resource_Tabs_Appear_On_Event_Card")
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Card() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.verify_Book_And_Resource_Tabs_Appear_On_Event_Card();
	}

	@Test(priority = 16, description = "verify_Book_And_Resource_Tabs_Appear_On_Event_Details")
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Details() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.verify_Book_And_Resource_Tabs_Appear_On_Event_Details();
	}

	@Test(priority = 17, description = "delete_Event_Verify_Deleted")
	public void delete_Event_Verify_Deleted() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.delete_Event_Verify_Deleted();
	}

	@Test(priority = 18, description = "delete_Book")
	public void delete_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.delete_Book_With_Atatched_Event();
	}

	@Test(priority = 19, description = "verify_Book_Deleted")
	public void verify_Book_A_Deleted() throws InterruptedException {
		test.assignCategory("Create-Book-Create-Event-Attach-Book-Attach-Resource");
		
		objectBookEventResource = new BookEventResourcePage();
		objectBookEventResource.verify_Book_A_Deleted();
	}
}