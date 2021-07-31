package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class ViewSchedulersExpandedTileListView extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect_Jhofelr_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verifyworkroomSubnav();
		objCreateSurvey.clickSchedulersSubNav();
	}

	@Test(priority = 3, description = "select_And_Verify_Schedulers_Expanded_View")
	public void select_And_Verify_Schedulers_Expanded_View() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_And_Verify_Schedulers_Expanded_View();
	}
	
	@Test(priority = 4, description = "view_And_Verify_Schedulers_Tile_View")
	public void view_And_Verify_Schedulers_Tile_View() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_And_Verify_Schedulers_Tile_View();
	}
	
	@Test(priority = 5, description = "view_And_Verify_Schedulers_List_View")
	public void view_And_Verify_Schedulers_List_View() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Schedulers-Expanded-Tile-List-View");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_And_Verify_Schedulers_List_View();
	}
}