package test_critical_scenarios;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.AttdReportPage;
import page_critical_scenarios.WorkgroupPage;
import static constants.ConstantsFile.*;

public class RunAttendanceReport extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Form_Open_Reports() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Opens_Site_Settings_Reports();
	}

	@Test(priority = 3, description = "user_Can_Open_Attendance_Menu")
	public void user_Can_Open_Attendance_Menu() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAttdReport = new AttdReportPage(driver);
		objectAttdReport.user_Can_Open_Attendance_Menu();
	}

	@Test(priority = 4, description = "user_Can_Configure_Attendence_Report")
	public void user_Can_Configure_Attendence_Report() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAttdReport = new AttdReportPage(driver);
		objectAttdReport.user_Can_Configure_Attendence_Report();
	}

	@Test(priority = 5, description = "user_Can_Verify_Filter_Change")
	public void user_Can_Verify_Filter_Change() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAttdReport = new AttdReportPage(driver);
		objectAttdReport.user_Can_Verify_Filter_Change();
	}

	@Test(priority = 6, description = "user_Generate_And_Download_PDF_Report")
	public void user_Generate_And_Download_PDF_Report() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAttdReport = new AttdReportPage(driver);
		objectAttdReport.user_Generate_And_Download_PDF_Report();
	}

	@Test(priority = 7, description = "user_Generate_And_Download_Excel_Report")
	public void user_Generate_And_Download_Excel_Report() throws InterruptedException {
		test.assignCategory("attendance_report");
		
		objectAttdReport = new AttdReportPage(driver);
		objectAttdReport.user_Generate_And_Download_Excel_Report();
	}
}