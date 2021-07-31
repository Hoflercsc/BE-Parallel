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

public class AddUnorderedWorkflowToMeetingBookFile extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Create_New_Book_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}
	
	@Test(priority = 9, description = "add_Unordered_Workflow_To_Meeting_Book_File_Part_One")
	public void add_Unordered_Workflow_To_Meeting_Book_File_Part_One() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Unordered_Workflow_To_Meeting_Book_File();
	}
	
	@Test(priority = 10, description = "add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director")
	public void add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectSecuredCategory = new SecuredCategoryPage(driver);
		objectSecuredCategory.add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director();;
	}
	
	@Test(priority = 11, description = "add_Workflow_Dates")
	public void add_Workflow_Dates() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.add_Workflow_Dates();
	}
	
	@Test(priority = 12, description = "verify_Workflow_Created")
	public void verify_Workflow_Created() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Workflow_Created();
	}
	//----------------login an another user ------------------
	
	@Test(priority = 13, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 14, description = "workroomAdmin_Login")
	public void workroomAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdmin,password);
	}
	
	@Test(priority = 15, description = "user_Can_Open_Actions_Menu_For_Workflow")
	public void user_Can_Open_Actions_Menu_For_Workflow() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Approve_Workflow();
	}
	
	@Test(priority = 16, description = "verify_Workflow_Approved")
	public void verify_Workflow_Approved() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Workflow_Approved();
	}
	
	@Test(priority = 17, description = "user_Can_Logout_Again")
	public void user_Can_Logout_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 18, description = "autoDirector_Login")
	public void autoDirector_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector,password);
	}
	
	@Test(priority = 19, description = "user_Can_Open_Actions_Menu_For_Workflow_Again")
	public void user_Can_Open_Actions_Menu_For_Workflow_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.user_Can_Approve_Workflow();
	}
	
	@Test(priority = 20, description = "verify_Workflow_Approved_Again")
	public void verify_Workflow_Approved_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_move_resource = new MoveResourceFolderPage(driver);
		obj_move_resource.verify_Workflow_Approved();
	}
	
	@Test(priority = 21, description = "user_Can_Logout_3rd_Time")
	public void user_Can_Logout_3rd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 22, description = "systemAdmin_Login")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password);
	}
	
	@Test(priority = 23, description = "user_Open_Library_Page_For_Workroom_2nd_Time")
	public void user_Open_Library_Page_For_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}
	//verify_Workflow_Response_Received
	@Test(priority = 24, description = "navigate_To_Book_Verify_Response_Received")
	public void navigate_To_Book_Verify_Response_Received() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.navigate_To_Book_Verify_Response_Received();
	}
	
	@Test(priority = 25, description = "finalize_Workflow_Response")
	public void finalize_Workflow_Response() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.finalize_Workflow_Response();
	}
	
	@Test(priority = 26, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Build_Book();
	}

	@Test(priority = 27, description = "make_Scanned_Book_Visible")
	public void make_Scanned_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.make_Scanned_Book_Visible();
	}
	
	@Test(priority = 28, description = "delete_Scanned_Book")
	public void delete_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.delete_Scanned_Book();
	}

	@Test(priority = 29, description = "verify_Scanned_Book_Deleted")
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Unordered-Workflow-To-Meeting-Book-File");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Scanned_Book_Deleted_2();
	}
}