package tests_settings;

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
import page_critical_scenarios.WorkroomPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class SetWorkroomToViewOnlyBooks extends BaseTestSettings {
	
	//-----------set_workroom_to_view_only-------------------------
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "set_Workroom_To_View_Only_Books")
	public void set_Workroom_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.enable_Workroom_To_View_Only_Books();
	}
	
	//---------------create_Book------------------------------------
	@Test(priority = 4, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom_2();
	}

	@Test(priority = 5, description = "user_Can_Create_New_Book_And_Title")
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Create_Book_And_Add_Title();
	}

	@Test(priority = 6, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 7, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 8, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 9, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 10, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 11, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 12, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.make_Book_Visible();
	}
	
	//-------------log out login as auto director--------------------
	@Test(priority = 13, description = "systemAdmin_Can_Logout")
	public void systemAdmin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 14, description = "autoDirector_Can_Login")
	public void autoDirector_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	//-----------------verify user cant download book ----------------
	@Test(priority = 15, description = "open_Library_Page_For_Board_Member")
	public void open_Library_Page_For_Board_Member() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.open_Library_Page_For_Board_Member();
	}
	
	@Test(priority = 16, description = "verify_Book_Download_Btn_Not_Present")
	public void verify_Book_Download_Btn_Not_Present() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Download_Btn_Not_Present();
	}
	
	//-------------log out log in as system admin --------------------
	@Test(priority = 17, description = "autoDirector_Can_Logout")
	public void autoDirector_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 18, description = "systemAdmin_Can_Login")
	public void systemAdmin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	//---------------delete book --------------------------------
	@Test(priority = 19, description = "user_Can_Open_Library_Page_For_Workroom_Again")
	public void user_Can_Open_Library_Page_For_Workroom_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.user_Can_Open_Library_Page_For_Workroom_2();
	}
	
	@Test(priority = 20, description = "user_Can_Delete_Book")
	public void user_Can_Delete_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.delete_Book_2();
	}
	
	@Test(priority = 21, description = "verify_Book_Not_Present")
	public void verify_Book_Not_Present() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage(driver);
		obj_meeting_book.verify_Book_Not_Present();
	}
	
	//--------------- disable view only workroom option--------------------------------
	@Test(priority = 22, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 23, description = "disable_Workroom_To_View_Only_Books")
	public void disable_Workroom_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.disable_Workroom_To_View_Only_Books();
	}
	
	//--------------- verify view only workroom disable--------------------------------
	
	@Test(priority = 24, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_3rd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_3rd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}
	
	@Test(priority = 25, description = "verify_View_Only_Books_Not_Checked")
	public void verify_View_Only_Books_Not_Checked() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.verify_View_Only_Books_Not_Checked();
	}
}