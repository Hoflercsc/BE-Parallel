package tests_critical_scenarios;

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
import page_critical_scenarios.WorkroomPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteBookScannedPDF extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Workroom_Constellation_Library_Page();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Create_New_Book_Add_Title(scannedBook);
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}

	@Test(priority = 9, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Can_Build_Book();
	}

	@Test(priority = 10, description = "make_Scanned_Book_Visible")
	public void make_Scanned_Book_Visible() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.make_Scanned_Book_Visible();
	}

	@Test(priority = 11, description = "edit_Scanned_Book")
	public void edit_Scanned_Book() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.edit_Scanned_Book();
	}

	@Test(priority = 12, description = "user_Opens_Meeting_Book_Viewer_And_Scroll")
	public void user_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.user_Opens_Meeting_Book_Viewer_And_Scroll();
	}

	@Test(priority = 13, description = "delete_Edited_Scanned_Book")
	public void delete_Edited_Scanned_Book() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.delete_Edited_Scanned_Book();
	}

	@Test(priority = 14, description = "verify_Scanned_Book_Deleted")
	public void verify_Edited_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("CreateEditDeleteBookScannedPDF");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.verify_Edited_Scanned_Book_Deleted();
	}
}