package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.HandbookPage;
import page_critical_scenarios.MessagePage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class CreateMessageWorkroom extends BaseTestCriticalScenarios {	
	@Test(priority = 1, description = "Login UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Open_Workroom")
	public void user_Open_Workroom() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.workroom_Member_Open_Workroom_AutoBE();
	}

	@Test(priority = 3, description = "user_Open_Message_Workroom_Window")
	public void user_Open_Message_Workroom_Window() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectMessage = new MessagePage(driver);
		objectMessage.user_Open_Message_Workroom_Window();
	}

	@Test(priority = 4, description = "user_Can_Remove_User_From_List")
	public void user_Can_Remove_User_From_List() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectMessage = new MessagePage(driver);
		objectMessage.user_Can_Remove_User_From_List();
	}

	@Test(priority = 5, description = "user_Can_Add_Manual_Email_To_List")
	public void user_Can_Add_Manual_Email_To_List() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectMessage = new MessagePage(driver);
		objectMessage.user_Can_Add_Manual_Email_To_List();
	}

	@Test(priority = 5, description = "user_Populate_Email_Form_Send_Message")
	public void user_Populate_Email_Form_Send_Message() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectMessage = new MessagePage(driver);
		objectMessage.user_Populate_Email_Form_Send_Message();
	}

	@Test(priority = 6, description = "verify_Email_Sent_Message")
	public void verify_Email_Sent_Verification_Messages() throws InterruptedException {
		test.assignCategory("message_workroom");
		
		objectMessage = new MessagePage(driver);
		objectMessage.verify_Email_Sent_Verification_Messages();
	}
}