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

public class VoteForApprovalMultipleFilesUnorderedWorkflowViaDrawer extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Create_New_Book_Add_Title(meetingBook41);
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Multiple_PDF_Files_To_New_Catagory")
	public void user_Add_Multiple_PDF_Files_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Multiple_PDF_Files_To_New_Catagory();
	}
	
	//--------- add workflow first file----------------------------
	@Test(priority = 9, description = "add_Unordered_Workflow_To_Meeting_Book_File")
	public void add_Unordered_Workflow_To_Meeting_Book_File() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File();
	}
	
	@Test(priority = 10, description = "add_Single_User_Unordered_Approval_WorkroomAdmin")
	public void add_Single_User_Unordered_Approval_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.add_Single_User_Unordered_Approval_WorkroomAdmin();
	}
	
	@Test(priority = 11, description = "add_Workflow_Dates")
	public void add_Workflow_Dates() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 12, description = "verify_Workflow_Created")
	public void verify_Workflow_Created() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Workflow_Created();
		obj_meeting_book.verify_Response_Pending_1();
	}
	
	//--------- add workflow second file----------------------------
	@Test(priority = 13, description = "add_Unordered_Workflow_To_Meeting_Book_File")
	public void add_Unordered_Workflow_To_Meeting_Book_File_2() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File_2();
	}
	
	@Test(priority = 14, description = "add_Single_User_Unordered_Approval_WorkroomAdmin")
	public void add_Single_User_Unordered_Approval_WorkroomAdmin_2() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.add_Single_User_Unordered_Approval_WorkroomAdmin();;
	}
	
	@Test(priority = 15, description = "add_Workflow_Dates")
	public void add_Workflow_Dates_2() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 16, description = "verify_Workflow_Created")
	public void verify_Workflow_Created_And_Response() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Workflow_Created();
		obj_meeting_book.verify_Response_Pending_2();
	}
	
	//--------- add workflow 3rd file----------------------------

	@Test(priority = 17, description = "add_Unordered_Workflow_To_Meeting_Book_File")
	public void add_Unordered_Workflow_To_Meeting_Book_File_3() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File_3();
	}
	
	@Test(priority = 18, description = "add_Single_User_Unordered_Approval_WorkroomAdmin")
	public void add_Single_User_Unordered_Approval_WorkroomAdmin_3() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.add_Single_User_Unordered_Approval_WorkroomAdmin();;
	}
	
	@Test(priority = 19, description = "add_Workflow_Dates")
	public void add_Workflow_Dates_3() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 20, description = "verify_Workflow_Created_And_Response_3")
	public void verify_Workflow_Created_And_Response_3() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Workflow_Created();
		obj_meeting_book.verify_Response_Pending_3();
	}

	//----------------login an another user ------------------
	
	@Test(priority = 21, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 22, description = "workroomAdmin_Login")
	public void workroomAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin,password);
	}
	
	@Test(priority = 23, description = "user_Can_Open_Actions_Menu_For_Workflow")
	public void user_Can_Open_Actions_Menu_For_Workflow() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.user_Can_Approve_Workflow();
		obj_move_resource.user_Can_Deny_Approve_Workflow();
	}
	
	@Test(priority = 24, description = "verify_Workflow_Approved")
	public void verify_Workflow_Approved() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_move_resource = new MoveResourceFolderPage();
		obj_move_resource.verify_Workflow_Approved();
	}
	
	@Test(priority = 25, description = "user_Can_Logout_Again")
	public void user_Can_Logout_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 26, description = "systemAdmin_Login")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin,password);
	}
	
	@Test(priority = 27, description = "user_Open_Library_Page_For_Workroom_2nd_Time")
	public void user_Open_Library_Page_For_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	//verify_Workflow_Response_Received
	@Test(priority = 28, description = "navigate_To_Book_Verify_Responses_Received")
	public void navigate_To_Book_Verify_Responses_Received() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Approval_Response_File_One_Received_Book_41();
		obj_meeting_book.verify_Deny_Response_File_Two_Received();
		obj_meeting_book.verify_Approval_Response_File_Three_Received();
	}
	
	@Test(priority = 29, description = "delete_Scanned_Book")
	public void delete_Meeting_Book_41() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		objectScannedPDF = new BookScannedPDFPage();
		obj_meeting_book = new BookPage();

		objectScannedPDF.click_Workroom_Library_Crumb();
		obj_meeting_book.delete_Meeting_Book_41();
	}

	@Test(priority = 30, description = "verify_Scanned_Book_Deleted")
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Vote-For-Approval-Multiple-Files-Unordered-Workflow-ViaDrawer");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_41_NOT_VISIBLE();
	}
}