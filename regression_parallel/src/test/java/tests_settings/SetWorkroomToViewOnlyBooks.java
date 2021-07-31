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
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkroomPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class SetWorkroomToViewOnlyBooks extends BaseTestSettings {
	
	//-----------set_workroom_to_view_only-------------------------
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "enable_Comics_Workroom_To_View_Only_Books")
	public void enable_Comics_Workroom_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage();
		objectWorkroom.enable_Comics_Workroom_To_View_Only_Books();
	}
	
	//---------------create_Book------------------------------------
	@Test(priority = 4, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Comics_Workroom_Library_Page();
	}

	@Test(priority = 5, description = "user_Can_Create_New_Book")
	public void user_Can_Create_New_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Create_New_Book(meetingBook2);
	}

	@Test(priority = 6, description = "user_Can_Add_Cover_Page")
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Cover_Page();
	}

	@Test(priority = 7, description = "user_Can_Add_Agenda")
	public void user_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Add_Agenda();
	}

	@Test(priority = 8, description = "user_Can_Add_Agenda")
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Save_Book_And_Continue();
	}

	@Test(priority = 9, description = "user_Add_First_Catagory_To_Book")
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book();
	}

	@Test(priority = 10, description = "user_Add_File_1_To_First_Catagory")
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_1_To_First_Catagory();
	}

	@Test(priority = 11, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Can_Build_Book();
	}

	@Test(priority = 12, description = "make_Meeting_Book_2_Visible")
	public void make_Meeting_Book_2_Visible() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.make_Meeting_Book_2_Visible();
	}
	
	//-------------log out login as auto director--------------------
	@Test(priority = 13, description = "systemAdmin_Can_Logout")
	public void systemAdmin_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 14, description = "autoUser22_Can_Login")
	public void autoUser22_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser22, password);
	}
	
	//-----------------verify user cant download book ----------------
	@Test(priority = 15, description = "open_Library_Page_For_AutoUser22")
	public void open_Library_Page_For_AutoUser22() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Comics_Workroom_Library_Page();
	}
	
	@Test(priority = 16, description = "verify_Book_Download_Btn_Not_Present")
	public void verify_Book_Meeting_Book2_Download_Btn_Not_Present() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Book_Meeting_Book2_Download_Btn_Not_Present();
	}
	
	//-------------log out  --------------------
	@Test(priority = 17, description = "autoDirector_Can_Logout")
	public void autoDirector_Can_Logout() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 18, description = "systemAdmin_Can_Login")
	public void systemAdmin_Can_Login() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 19, description = "open_Settings_Then_Workroom_And_Group_Settings_Again")
	public void open_Settings_Then_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	//--------------- disable view only workroom option--------------------------------
	@Test(priority = 20, description = "disable_Comics_Workroom_To_View_Only_Books")
	public void disable_Comics_Workroom_To_View_Only_Books() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage();
		objectWorkroom.disable_Comics_Workroom_To_View_Only_Books();
	}
	
	@Test(priority = 21, description = "workroom_Member_Open_Comics_Workroom_Library_Page")
	public void workroom_Member_Open_Comics_Workroom_Library_Page() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Comics_Workroom_Library_Page();
	}
	
	//---------------delete book --------------------------------
	@Test(priority = 22, description = "delete_Meeting_Book_2")
	public void delete_Meeting_Book_2() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_2();
	}
	
	@Test(priority = 23, description = "verify_Meeting_Book_2_NOT_VISIBLE")
	public void verify_Meeting_Book_2_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_2_NOT_VISIBLE();
	}
	
	@Test(priority = 24, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_2nd_Time() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}
	
	@Test(priority = 25, description = "verify_View_Only_Books_Not_Checked")
	public void verify_View_Only_Books_Not_Checked() throws InterruptedException {
		test.assignCategory("Set-Permissions >> Set-Workroom-To-View-Only-Books");
		
		objectWorkroom = new WorkroomPage();
		objectWorkroom.verify_Comics_Workroom_View_Only_Books_Not_Checked();
	}
}