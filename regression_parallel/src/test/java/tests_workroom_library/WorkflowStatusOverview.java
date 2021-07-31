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
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Create_New_Book_Add_Title(meetingBook42);
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}
	
	@Test(priority = 9, description = "add_Unordered_Workflow_To_Meeting_Book_File_Part_One")
	public void add_Unordered_Workflow_To_Meeting_Book_File_Part_One() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File();
	}
	
	@Test(priority = 10, description = "add_Single_User_Unordered_Approval_AutoUser15")
	public void add_Single_User_Unordered_Approval_AutoUser15() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.add_Single_User_Unordered_Approval_AutoUser15();
	}
	
	@Test(priority = 11, description = "add_Workflow_Dates")
	public void add_Workflow_Dates() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 12, description = "verify_Workflow_Created_Auto_User_15")
	public void verify_Workflow_Created_Auto_User_15() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Workflow_Created_Auto_User_15();
	}
	
	//--------------------------------------------------
	@Test(priority = 13, description = "verify_Workflow_Created")
	public void add_Second_User_Workflow() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		objectScannedPDF = new BookScannedPDFPage();
		obj_meeting_book = new BookPage();
		objectSecuredCategory = new SecuredCategoryPage();
		
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File_2();
		objectSecuredCategory.add_Single_User_Unordered_Approval_AutoUser2();
		obj_meeting_book.add_Workflow_Dates();
		obj_meeting_book.verify_Workflow_Created_Auto_User_2();
	}
	
	@Test(priority = 14, description = "force_Workflow_Approvals_Book_42")
	public void force_Workflow_Approvals_Book_42() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.force_Workflow_Approvals_Book_42();
	}
	
	@Test(priority = 15, description = "finalize_Workflow_Response")
	public void finalize_Workflow_Response() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.finalize_Workflow_Response_Updated();
	}
	
	@Test(priority = 16, description = "verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin")
	public void verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Pending_AutoUser15_And_Finalized_AutoUser2();
		objectScannedPDF.verify_Workroom_Library_Crumb();
		objectScannedPDF.click_Workroom_Library_Crumb();
	}
	
	@Test(priority = 17, description = "delete_Meeting_Book_42")
	public void delete_Meeting_Book_42() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_42();	
	}

	@Test(priority = 18, description = "verify_Meeting_Book_42_NOT_VISIBLE")
	public void verify_Meeting_Book_42_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Workflow-Status-Overview");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_42_NOT_VISIBLE();
	}
}