package tests_workroom_library;


import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookEventResourcePage;
import page_critical_scenarios.BookScannedPDFPage;
import page_critical_scenarios.BookTemplatePage;
import page_critical_scenarios.SecuredCategoryPage;
import page_set_permissions.PermissionsPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;

public class AddSecurityToBookTemplate extends BaseTestWorkroomLibrary {	
	@Test(priority = 1, description = "Login AutoUser UserName Password.")
	public void loginBE_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	//-----Create Book Template File  ----------------------
	
	@Test(priority = 2, description = "open_Library_Page_for_Workroom")
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 3, description = "user_Create_New_BookTemplate")
	public void user_Create_New_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Create_New_BookTemplate(meetingBook10);
	}
	
	@Test(priority = 4, description = "user_Add_Coverpage_To_Book_Template")
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Coverpage_To_Book_Template();
	}
	
	@Test(priority = 5, description = "user_Add_Agenda_To_Template")
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_Agenda_To_Template();
	}
	
	@Test(priority = 6, description = "user_Save_Book_Template")
	public void user_Save_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Save_Book_Template();
	}
	
	@Test(priority = 7, description = "user_Add_First_Catagory_To_Book_Template")
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_First_Catagory_To_Book_Template();
	}

	@Test(priority = 8, description = "user_Add_File_To_First_Catagory")
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.user_Add_File_To_First_Catagory();
	}
	
	@Test(priority = 9, description = "open_Book_Template_Secured_Category")
	public void open_Book_Template_Secured_Category() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Open_Secured_Category();
	}
	
	@Test(priority = 10, description = "Workroom_Admin_Eng_2_Can_Add_User_As_Secured_Category_User")
	public void Workroom_Admin_Eng_2_Can_Add_User_As_Secured_Category_User() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.Workroom_Admin_Eng_2_Can_Add_User_As_Secured_Category_User();
	}
	
	//-----Create Book with Book Template ----------------------

	@Test(priority = 11, description = "navigate_To_Meeting_Book")
	public void navigate_To_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_Meeting_Book();
	}
	
	@Test(priority = 12, description = "create_Book_From_Template_With_Secured_Category")
	public void create_Book_From_Template_With_Secured_Category() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.create_Book_From_Template_With_Secured_Category(meetingBook11);
	}
	
	@Test(priority = 13, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Build_Book();
	}

	@Test(priority = 14, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.make_Meeting_Book_Visible();
	}
	
	//-----Verify User Restricted From Seeing Book Template File  --------

	@Test(priority = 15, description = "user_Can_Logout_2nd_Time")
	public void user_Can_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
		
	@Test(priority = 16, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser13,password);
	}
	
	@Test(priority = 17, description = "make_Book_Visible")
	public void workroom_Member_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 18, description = "workroom_Member_Book_11_Secured_Category_Not_Displayed")
	public void workroom_Member_Book_11_Secured_Category_Not_Displayed() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.workroom_Member_Book_11_Secured_Category_Not_Displayed();
	}
	
	//-----Verify Correct User Can See Secured Template File  --------
	
	@Test(priority = 19, description = "user_Can_Logout")
	public void user_Can_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 20, description = "Login AutoUser UserName Password.")
	public void loginBE_AutoTester() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdminEng2, password); // autoUser Login
	}

	@Test(priority = 21, description = "workroom_Member_Open_Library_Page_For_Workroom")
	public void workroom_Member_Open_Library_Page_For_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}

	@Test(priority = 22, description = "workroom_Member_Book_11_NewCatagory_Is_Displayed")
	public void workroom_Member_Book_11_NewCatagory_Is_Displayed() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.workroom_Member_Book_11_NewCatagory_Is_Displayed();
	}
	
	@Test(priority = 23, description = "user_Can_Logout")
	public void user_Can_Logout_Agian() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	//-----Delete Secured Book Template -----
	
	@Test(priority = 24, description = "loginBE_WorkroomAdmin")
	public void loginBE_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester,password);
	}
	
	@Test(priority = 25, description = "navigate_To_BookTemplate")
	public void navigate_To_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_BookTemplate();
	}
	
	@Test(priority = 26, description = "delete_Book_10")
	public void delete_Book_10() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_10();
	}
	
	@Test(priority = 27, description = "navigate_Back_To_BookTemplate")
	public void navigate_Back_To_BookTemplate() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_Back_To_BookTemplate();
	}

	@Test(priority = 28, description = "verify_Meeting_Book_10_NOT_VISIBLE")
	public void verify_Meeting_Book_10_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_10_NOT_VISIBLE();
	}
	
	//-----Delete Meeting Book  -----
	
	@Test(priority = 29, description = "navigate_To_Meeting_Book_Again")
	public void navigate_To_Meeting_Book_Again() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.navigate_To_Meeting_Book_2();
	}
	
	@Test(priority = 30, description = "delete_Book_11")
	public void delete_Book_11() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.delete_Meeting_Book_11();
	}

	@Test(priority = 31, description = "verify_Meeting_Book_11_NOT_VISIBLE")
	public void verify_Meeting_Book_11_NOT_VISIBLE() throws InterruptedException {
		test.assignCategory("Workroom-Libary >> Add-Security-To-Book-Template");
		
		obj_meeting_book = new BookPage();
		obj_meeting_book.verify_Meeting_Book_11_NOT_VISIBLE();
	}
	
}