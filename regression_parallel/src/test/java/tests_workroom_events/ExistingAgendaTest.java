package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_published_books.BooksPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class ExistingAgendaTest extends BaseTestWorkroomEvents {
	
	@Test(priority = 1, description = "home_Page_Redirect_JHofler_Staging")
	public void home_Page_Redirect_JHofler_Staging() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Agenda-Tab-Check");
		
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING); //redirect to jhofler.staging to execute test

		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Navigate_To_December_25th_Event")
	public void user_Navigate_To_December_25th_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Agenda-Tab-Check");
		
		books = new BooksPage();
		books.user_Navigate_To_December_25th_Event();
	}

	@Test(priority = 3, description = "verify_IEEE_Book_And_Outline")
	public void verify_IEEE_Book_Agenda_Outline() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Agenda-Tab-Check");
		
		books = new BooksPage();
		books.verify_IEEE_Book_Agenda_Outline();
	}

	@Test(priority = 4, description = "open_IEEE_Meeting_Book")
	public void open_IEEE_Meeting_Book() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Agenda-Tab-Check");
		
		books = new BooksPage();
		books.open_IEEE_Meeting_Book();
	}

	@Test(priority = 5, description = "close_IEEE_Meeting_Book")
	public void verify_Back_To_Orginal_Tab() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Agenda-Tab-Check");
		
		books = new BooksPage();
		books.verify_Back_To_Orginal_Tab();
	}
}