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

public class ForceWorkflowApprovalsForMeetingBookFile extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Create_New_Book_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}
	
	@Test(priority = 9, description = "add_Unordered_Workflow_To_Meeting_Book_File_Part_One")
	public void add_Ordered_Workflow_To_Meeting_Book_File_Part_One() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Ordered_Workflow_To_Meeting_Book_File_Part_One();
	}
	
	@Test(priority = 10, description = "Add_Ordered_Approval_Users_WorkroomAdmin_AutoDirector")
	public void Add_Ordered_Approval_Users_WorkroomAdmin_AutoDirector() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectSecuredCategory = new SecuredCategoryPage(driver);
		objectSecuredCategory.Add_Ordered_Approval_Users_WorkroomAdmin_AutoDirector();;
	}
	
	@Test(priority = 11, description = "add_Workflow_Dates")
	public void add_Workflow_Dates() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Workflow_Dates();;
	}
	
	@Test(priority = 12, description = "force_Workflow_Approvals_And_Finalize_Responses")
	public void force_Workflow_Approvals_And_Finalize_Responses() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.force_Workflow_Approvals();
		obj_meeting_book.finalize_Workflow_Response();
	}
	
	@Test(priority = 13, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Build_Book();
	}

	@Test(priority = 14, description = "make_Scanned_Book_Visible")
	public void make_Scanned_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.make_Scanned_Book_Visible();
	}
	
	@Test(priority = 15, description = "delete_Scanned_Book")
	public void delete_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.delete_Scanned_Book();
	}

	@Test(priority = 16, description = "verify_Scanned_Book_Deleted")
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Force-Workflow-Approvals-For-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Scanned_Book_Deleted_2();
	}
}