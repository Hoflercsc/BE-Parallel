package tests_workroom_library;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.SecuredCategoryPage;
import page_critical_scenarios.WorkroomPage;
import page_resource_library.MoveResourceFolderPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class WorkflowStatusOverview extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Create_New_Book_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}
	
	@Test(priority = 9, description = "add_Unordered_Workflow_To_Meeting_Book_File_Part_One")
	public void add_Unordered_Workflow_To_Meeting_Book_File_Part_One() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File();
	}
	
	@Test(priority = 10, description = "add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director")
	public void add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectSecuredCategory = new SecuredCategoryPage(driver);
		objectSecuredCategory.add_Single_User_Unordered_Approval_WorkroomAdmin();
	}
	
	@Test(priority = 11, description = "add_Workflow_Dates")
	public void add_Workflow_Dates() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 12, description = "verify_Workflow_Created")
	public void verify_Workflow_Created() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Workflow_Created();
	}
	
	//--------------------------------------------------
	@Test(priority = 13, description = "verify_Workflow_Created")
	public void add_Second_User_Workflow() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		obj_meeting_book = new BookPage(driver);
		objectSecuredCategory = new SecuredCategoryPage(driver);
		
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File_2();
		objectSecuredCategory.add_Single_User_Unordered_Approval_AutoDirector();
		obj_meeting_book.add_Workflow_Dates();
		obj_meeting_book.verify_Workflow_Created_2();
	}
	
	@Test(priority = 14, description = "force_Workflow_Approvals_B")
	public void force_Workflow_Approvals_B() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.force_Workflow_Approvals_B();
	}
	
	@Test(priority = 15, description = "finalize_Workflow_Response")
	public void finalize_Workflow_Response() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.finalize_Workflow_Response();
	}
	
	@Test(priority = 16, description = "verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin")
	public void verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin();
	}
	
	@Test(priority = 17, description = "delete_Scanned_Book")
	public void delete_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Workroom_Library_Crumb();
		objectScannedPDF.click_Workroom_Library_Crumb();
		objectScannedPDF.verify_Scanned_Book_Visible();
		objectScannedPDF.delete_Scanned_Book();
	}

	@Test(priority = 18, description = "verify_Scanned_Book_Deleted")
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Scanned_Book_Deleted_2();
	}
}