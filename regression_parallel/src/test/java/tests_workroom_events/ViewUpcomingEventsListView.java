package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class ViewUpcomingEventsListView extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_Constellation_Events")
	public void admin_Open_Workroom_Constellation_Events() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_Constellation_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS_2(event34);
	}
	
	@Test(priority = 4, description = "user_Can_Create_New_Event_RSVPS_2")
	public void user_Can_Create_New_Event_RSVPS_2() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS_2(event35);
	}
	
	@Test(priority = 5, description = "user_Can_View_Upcoming_Events_List_View")
	public void user_Can_View_Upcoming_Events_List_View() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_View_Upcoming_Events_List_View();
	}

	@Test(priority = 6, description = "delete_Event_34")
	public void delete_Event_34() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_34();
	}
	
	@Test(priority = 7, description = "delete_Event_35")
	public void delete_Event_35() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_35();
	}
	
	@Test(priority = 8, description = "verify_Event_34_35_Deleted")
	public void verify_Event_34_35_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events-List-View");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_34_35_Deleted();
	}
	
}