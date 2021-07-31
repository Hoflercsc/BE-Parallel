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
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.WorkroomPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class CreateViewOnlyMeetingBook extends BaseTestWorkroomLibrary {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Open_Library_Page_For_Workroom")
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Book_Add_Title")
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Create_New_Book_Add_Title();
	}

	@Test(priority = 4, description = "user_Can_Add_CoverPage")
	public void user_Can_Add_CoverPage() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Add_CoverPage();
	}

	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Agenda_To_Template();
	}

	@Test(priority = 6, description = "user_Can_Save_Scanned_Book")
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Save_Scanned_Book();
	}

	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_First_Catagory_To_Scanned_Book();
	}

	@Test(priority = 8, description = "user_Add_Scanned_Book_To_New_Catagory")
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Add_Scanned_Book_To_New_Catagory();
	}

	@Test(priority = 9, description = "set_Book_To_View_Only")
	public void set_Book_To_View_Only() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.set_Book_To_View_Only();
	}
	
	@Test(priority = 10, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Can_Build_Book();
	}

	@Test(priority = 11, description = "make_Scanned_Book_Visible")
	public void make_Scanned_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.make_Scanned_Book_Visible();
	}

	@Test(priority = 12, description = "user_Can_Logout_2nd_Time")
	public void user_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
		
	@Test(priority = 13, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector,password);
	}
	
	@Test(priority = 14, description = "nonAdmin_Open_Library_Page_For_Workroom")
	public void nonAdmin_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Open_Library_Page_For_Workroom();
	}
	
	@Test(priority = 15, description = "verify_Book_Is_View_Only")
	public void verify_Book_Is_View_Only() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Book_Is_View_Only();
	}
	
	@Test(priority = 16, description = "nonAdmin_Can_Logout_2nd_Time")
	public void nonAdmin_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
		
	@Test(priority = 17, description = "sysAdmin_Login_To_BoardEffect")
	public void sysAdmin_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin,password);
	}
	
	@Test(priority = 18, description = "user_Open_Library_Page_For_Workroom_Again")
	public void user_Open_Library_Page_For_Workroom_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.user_Open_Library_Page_For_Workroom();
	}

	@Test(priority = 19, description = "delete_Scanned_Book")
	public void delete_Scanned_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.delete_Scanned_Book();
	}

	@Test(priority = 20, description = "verify_Scanned_Book_Deleted")
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Create-View-Only-Meeting-Book");
		
		objectScannedPDF = new BookScannedPDFPage(driver);
		objectScannedPDF.verify_Scanned_Book_Deleted();
	}
}