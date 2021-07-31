package tests_boardmember_access;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.BookScannedPDFPage;
import page_workroom_library.BookPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class BoardMemberCanViewMinutes extends BaseTestBoardMemberAccess {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-View-Minutes");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 2, description = "Login UserName Password.")
	public void systemAdmin_Login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-View-Minutes");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 3, description = "navigate_To_Workroom_Library")
	public void navigate_To_Workroom_Library() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-View-Minutes");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoBE_Library_Page();
	}
	
	@Test(priority = 4, description = "open_Book_Verify_Take_Minutes_Not_Present")
	public void open_Book_Verify_Take_Minutes_Not_Present() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Board-Member-Can-View-Minutes");
		
		objectScannedPDF = new BookScannedPDFPage();
		objectScannedPDF.boardmember_Meeting_Book_Viewer_See_Minutes();
	}

}