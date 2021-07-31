package extentreports;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.html'").format(new Date());
		ExtentHtmlReporter html = new ExtentHtmlReporter("target//surefire-reports//Extent.html" + out);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		return extent;
	}
	/*
	 * https://stackoverflow.com/questions/57878566/extent-reports-3-1-5-not-
	 * appending-after-each-test-run/57891768#57891768
	 * 
	 * @BeforeSuite public void OneTimesetUp() throws InterruptedException{
	 * //--------Extent Report-------- report = ExtentFactory.getInstance();
	 * //-----------------------------
	 * 
	 * }
	 */
	/*
	 * public class ExtentFactory {
	 * 
	 * public static ExtentReports getInstance() { ExtentReports extent; String Path
	 * = "target//surefire-reports//Extent.html"; extent = new ExtentReports(Path,
	 * false); extent .addSystemInfo("Selenium Version", "3.141.59")
	 * .addSystemInfo("Platform", "Windows");
	 * 
	 * 
	 * return extent; }
	 */
}
