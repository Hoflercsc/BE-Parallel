package tests_critical_scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.PermissionPage;
import page_critical_scenarios.SecuredCategoryPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateBookSecuredCategory extends BaseTestCriticalScenarios {
	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void Workroom_Admin_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 3, description = "user_Can_Create_New_Book_And_Title")
	public void Workroom_Admin_Can_Create_New_Book_And_Add_Title() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Create_New_Book_And_Add_Title();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 4, description = "user_Can_Add_Agenda")
	public void Workroom_Admin_Can_Add_Agenda() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Add_Agenda();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 5, description = "click_Save_Continue_Btn")
	public void Workroom_Admin_Click_Save_Continue_Btn() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.click_Save_Continue_Btn();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 6, description = "user_Add_First_Catagory_To_Book")
	public void Workroom_Admin_Add_First_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Add_First_Catagory_To_Book();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 7, description = "user_Add_File_To_First_Catagory")
	public void Workroom_Admin_Add_File_To_First_Catagory() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Add_File_To_First_Catagory();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 8, description = "Workroom_Admin_Can_Open_Secured_Category")
	public void Workroom_Admin_Can_Open_Secured_Category() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Open_Secured_Category();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 9, description = "Workroom_Admin_2_Can_Add_User_As_Secured_Category_User")
	public void Workroom_Admin_2_Can_Add_User_As_Secured_Category_User() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.Workroom_Admin_2_Can_Add_User_As_Secured_Category_User();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 10, description = "user_Add_First_Catagory_To_Book")
	public void Workroom_Admin_Add_Second_Catagory_To_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Add_Second_Catagory_To_Book();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 11, description = "Workroom_Admin_add_File_To_Second_Catagory")
	public void Workroom_Admin_add_File_To_Second_Catagory() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.add_File_To_Second_Catagory();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 12, description = "user_Can_Build_Book")
	public void user_Can_Build_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.user_Can_Build_Book();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 13, description = "make_Book_Visible")
	public void make_Book_Visible() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.make_Secured_Book_Visible();
	}

	// ----Below workroom Member represents user -> autoTester ------
	@Test(priority = 14, description = "make_Book_Visible")
	public void workroomAdmin_Close_And_Logout() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	// ----Below workroom Member represents user -> autoDirector ------
	@Test(priority = 15, description = "workroom_Member_Login_To_BoardEffect")
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector,password);
	}

	// ----Below workroom Member represents user -> autoDirector ------
	@Test(priority = 16, description = "workroom_Member_Open_Workroom_AutoBE_Library_Page")
	public void workroom_Member_Open_Workroom_AutoBE_Library_Page() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}

	// ----Below workroom Member represents user -> autoDirector ------
	@Test(priority = 17, description = "workroom_Member_Navigate_To_Book_Secured_Category_Not_Displayed")
	public void workroom_Member_Secured_Category_Not_Displayed() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.workroom_Member_Secured_Category_Not_Displayed();
	}

	// ----Below workroom Member represents user -> autoDirector ------
	@Test(priority = 18, description = "workroom_Member_Verify_New_Category_2_Present")
	public void workroom_Member_Sees_New_Category_2_Present() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.workroom_Member_Sees_New_Category_2_Present();
	}

	// ----Below workroom Member represents user -> autoTester ------
	@Test(priority = 19, description = "make_Book_Visible")
	public void autoDirector_Close_And_Logout() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	// ----Below WorkroomAdmin represents user -> ***WorkroomAdmin***
	@Test(priority = 20, description = "loginBE_WorkroomAdmin")
	public void loginBE_WorkroomAdmin() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin2,password);
	}

	// ----Below WorkroomAdmin represents user -> ***WorkroomAdmin***
	@Test(priority = 21, description = "workroom_Member_Open_Library_Page_For_Workroom")
	public void workroom_Member_Open_Library_Page_For_Workroom_2nd_Time() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}

	// ----Below WorkroomAdmin represents user -> ***WorkroomAdmin***
	@Test(priority = 22, description = "workroom_Member_Navigate_To_Book_Secured_Category_Is_Displayed")
	public void workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed();
	}

	// ----Below WorkroomAdmin represents user -> ***WorkroomAdmin***
	@Test(priority = 23, description = "make_Book_Visible")
	public void workroomAdmin_Close_And_Logout_2nd_Time() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.user_Can_Sign_Out();
	}

	// ----Below workroom Admin represents user -> autoTester------
	@Test(priority = 24, description = "Login UserName Password.")
	public void autoUser_login_2nd_Time() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester,password);;
	}

	// ----Below WorkroomAdmin represents user -> ***WorkroomAdmin***
	@Test(priority = 25, description = "workroom_Member_Open_Library_Page_For_Workroom_3rd_Time")
	public void workroom_Member_Open_Library_Page_For_Workroom_3rd_Time() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Open_Workroom_AutoBE_Library_Page();
	}

	// ----Below represents user -> ***autoUser***
	@Test(priority = 26, description = "user_Can_Delete_Book")
	public void user_Can_Delete_Book() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.delete_Book_Secured_Category();
	}

	// ----Below represents user -> ***autoUser***
	@Test(priority = 27, description = "verify_Book_Deleted")
	public void verify_Book_Deleted() throws InterruptedException {
		test.assignCategory("Create-Book-Secured-Category");
		
		objectSecuredCategory = new SecuredCategoryPage();
		objectSecuredCategory.verify_Book_Deleted();
	}
}