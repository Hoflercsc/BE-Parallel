package page_poll;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;
import org.openqa.selenium.support.ui.Select;

public class PollPage extends BaseTestCriticalScenarios{
	// ----------- POM Page Object model -----------------------------
	
	String pollTitle = "This is a Poll Title";
	String pollQuestion = "what is your favorite food?";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By pollsSubMenu = By.xpath("//a[contains(text(),'Polls')]");
	By newPollsBtn = By.xpath("//a[@class='btn btn-success pull-right']");
	By pollTitleInputField = By.xpath("//input[@id='survey_title']");
	By saveBtn = By.xpath("//*[@id=\"new_survey\"]/button");
	By pollSucessMessage = By.xpath("//div//p[contains(text(),'Successfully created')]");
	By newQuestionOne = By.xpath("(//a[contains(text(),'New Question')])[1]");
	By newQuestionBox = By.xpath("//h4[contains(text(),'New Question')]");
	By pollTextBox = By.xpath("//textarea[@id='poll-question-name']");
	By radioButtonOne = By.xpath("//input[@id='survey_question_values_default_option_1']");
	By radioTextOne = By.xpath("//input[@id='survey_question_values_1_value']");
	By radioButtonTwo = By.xpath("//input[@id='survey_question_values_default_option_2']");
	By radioTextTwo = By.xpath("//input[@id='survey_question_values_2_value']");
	By radioButtonThree = By.xpath("//input[@id='survey_question_values_default_option_3']");
	By radioTextThree = By.xpath("//input[@id='survey_question_values_3_value']");
	By manageRespondents = By.xpath("//a[contains(text(),'Manage Respondents')]");
	By saveBtnbox = By.xpath("//div[@id='questionModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By respondents = By.xpath("//a[contains(text(),'Respondents')]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By pollBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By pollSucessResponseMessage = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully responded to poll: This is a Poll Tit')]");
	By breadCrumbWorkroom = By.xpath("//a[contains(text(),'Workroom Polls')]");

	//-------------------new-------------------
	By pollTitleOnStaging1 = By.xpath("//*[normalize-space(text())='Poll Board Member Access 1']");

	
	public void verifyPollTitleOnStaging1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollTitleOnStaging1)));
	}
	
	// ------------------ Methods ---------------------
	public void verifyWelcomeHeader() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(WelcomeHeader)));
	}

	public void verifyCollaborateActiveOff() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(collaborateActiveOff)));
	}

	public void verifyworkroomSubnav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomSubnav)));
	}

	public void verifyNewPollBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newPollsBtn)));
	}

	public void verifyPollInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(8)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollTitleInputField)));
	}

	public void verifyPollSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollSucessMessage)));
	}

	public void verifyNewQuestionOne() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionOne)));
	}

	public void verifyNewQuestionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionBox)));
	}

	public void verifyRespondents() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents)));
	}

	public void verifyPollTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_1_Title)));
	}

	public void verifySubmitBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(submitBtn)));
	}

	public void verifyBuildBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(buildBtn)));
	}

	public void verifyContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verifyPollisVisiable() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollVisibleGreen)));
	}

	public void verifyPollSucessResponseMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollSucessResponseMessage)));
	}
	
	public void verifyAutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(AutoBE)));
	}

	// ------------------ Elements ---------------------
	public void clickAutoBEWorkRoom() {
		DriverFactory.getInstance().getDriver().findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		DriverFactory.getInstance().getDriver().findElement(collaborateActiveOff).click();
	}

	public void clickPolls() {
		DriverFactory.getInstance().getDriver().findElement(pollsSubMenu).click();
	}

	public void clickNewPollBtn() {
		DriverFactory.getInstance().getDriver().findElement(newPollsBtn).click();
	}

	public void clickNewQuestionOne() {
		DriverFactory.getInstance().getDriver().findElement(newQuestionOne).click();
	}

	public void clickandTypePollTitleInputField(String pollTitleStaging1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(pollTitleInputField).click();
		DriverFactory.getInstance().getDriver().findElement(pollTitleInputField).sendKeys(pollTitleStaging1);
	}

	public void clickSaveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	public void clickSubmitBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(submitBtn).click();
		Thread.sleep(1500);
	}

	public void clickBuildBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(buildBtn).click();
		Thread.sleep(1000);
	}

	public void clickPollBtnOn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(pollBtnOn).click();
		Thread.sleep(1000);
	}

	public void clickContinueBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
		Thread.sleep(1000);
	}

	public void clickBreadCrumbWorkroom() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(breadCrumbWorkroom).click();
		Thread.sleep(1000);
	}

	public void clickPollTextBoxSendKeysSave() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(1000);
		iframeBody.sendKeys(pollQuestion);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		DriverFactory.getInstance().getDriver().findElement(radioButtonOne).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextOne).sendKeys("apple pie");
		DriverFactory.getInstance().getDriver().findElement(radioButtonTwo).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextTwo).sendKeys("ice cream");
		DriverFactory.getInstance().getDriver().findElement(radioButtonThree).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextThree).sendKeys("pudding");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}

	public void verifyPollQuestionExist() throws InterruptedException {
		String pollquestion = "//*[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollquestion)).size() != 0);
	}

	public void clickManageRespondentsAddUser() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement automationTester2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		automationTester2.click();
		Thread.sleep(2000);
		String automationTester3 = "//*[@class ='people-snippet row small-left']/div[contains(text(),'Automation Tester')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automationTester3)).size() > 0);
		Thread.sleep(1000);
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	By autoTesterCard = By.xpath("//span[contains(text(),'Respondents')]/following::div[contains(.,'Automation Tester')]");

	public void clickManageRespondentsAddUser_B() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement automationTester2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		automationTester2.click();
		Thread.sleep(1000);
		//----------wait for auto director card ---
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoTesterCard)));
		//-----------------
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(1500);
		saveBtn.click();
	}
	
	By autoDirectorCard = By.xpath("//span[contains(text(),'Respondents')]/following::div[contains(.,'Auto Director')]");

	public void clickManageRespondentsAddUser_C() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement autoDirector = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(2000);
		//----------------------------------------------
		WebElement automationTester = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", automationTester);
		automationTester.click();
		Thread.sleep(1500);
		//----------wait for auto director card ---
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoDirectorCard)));
		
		String automation_Tester = "//span[contains(text(),'Respondents')]/following::div[contains(.,'Automation Tester')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automation_Tester)).size() > 0);
		Thread.sleep(2000);
		//---------------------------------------------
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUser_D() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		//----------------------------------------------
		By people_Auto_Admin_User_GS_11_ = By.xpath("//*[@class='person-name'][contains(text(),'Auto Admin User GS 11')]");
		By people_Auto_User_5 = By.xpath("//*[@class='person-name'][contains(text(),'Auto User5')]");
		
		By auto_Admin_User_GS_11_5 = By.xpath("//span[contains(text(),'Respondents')]/following::div[contains(.,'Auto Admin User GS 11')]");
		By auto_User_5 = By.xpath("//span[contains(text(),'Respondents')]/following::div[contains(.,'Auto User5')]");

		DriverFactory.getInstance().getDriver().findElement(people_Auto_Admin_User_GS_11_).click();
		Thread.sleep(2000);
		
		WebElement autoUser5 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto User5')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", autoUser5);
		
		DriverFactory.getInstance().getDriver().findElement(people_Auto_User_5).click();
		Thread.sleep(2000);
		//----------wait for auto user 5 to come up ---

		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User_5)));
		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_Admin_User_GS_11_5)));
		//---------------------------------------------
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(1500);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserE() throws InterruptedException {
		// click Manage Respondents
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1500);
		WebElement autoDirector = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(1500);
		
		WebElement steveSystem = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'steve System')]"));
		steveSystem.click();
		Thread.sleep(1500);
		
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2500);
		saveBtn.click();
	}

	public void verifyPollTitleAndQuestionExist() throws InterruptedException {
		String pollTitle = "//h1[contains(text(),'This is a Poll Title')]";
		String pollQuestion = "//p[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollTitle)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollQuestion)).size() != 0);
	}
	
	public void verify_Poll_Board_Member_Access_1_Created() throws InterruptedException {
		String pollTitle = "//h1[contains(text(),'Poll Board Member Access 1')]";
		String pollQuestion = "//p[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollTitle)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollQuestion)).size() != 0);
	}

	// ------------------ Iframe Text Box Send Keys ---------------------
	public void pollDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	public void clickCheckBoxes() throws InterruptedException {
		By allowComments = By.xpath("//span[contains(text(),'Allow Comments')]");
		DriverFactory.getInstance().getDriver().findElement(allowComments).click();
		Thread.sleep(1000);
	}

	// ------------------ Functions ----------------------
	public void create_Poll(String poll1) throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickPolls();
		this.verifyNewPollBtn();
		this.clickNewPollBtn();
		this.verifyPollInputField();
		this.clickandTypePollTitleInputField(poll1);
		this.pollDescriptionTextBox();
		this.clickCheckBoxes();
		this.clickSaveBtn();
		this.verifyPollSucessMessage();
		System.out.println("------- Completed --> create_Poll() -----------");
	}
	
	// ------------------ Functions ----------------------
	public void user_navigates_To_Poll() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		this.verifyNewPollBtn();
		System.out.println("------- Completed --> user_navigates_To_Poll() -----------");
	}
	
	public void user_Navigates_To_Poll_B() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickPolls();
		Thread.sleep(1000);
		this.verifyPollTitle();
		this.click_Poll_1_Title();
		System.out.println("------- Completed --> user_Navigates_To_Poll_B() -----------");
	}
	
	public void user_Navigates_To_Poll_4() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickPolls();
		Thread.sleep(1000);
		this.verify_Poll_4_Dropdown();
		this.click_Poll_4_Title();
		System.out.println("------- Completed --> user_Navigates_To_Poll_4() -----------");
	}
	
	public void user_Navigates_To_Poll_5() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickPolls();
		Thread.sleep(1000);
		this.verify_Poll_5_Title();
		this.click_Poll_5_Title();
		System.out.println("------- Completed --> user_Navigates_To_Poll_4() -----------");
	}

	// ------------------ new functions ----------------------
	public void creating_Poll_For_Event(String pollTitleStaging1) throws InterruptedException {
		this.verifyPollInputField();
		this.clickandTypePollTitleInputField(pollTitleStaging1);
		this.pollDescriptionTextBox();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifyPollSucessMessage();
		System.out.println("------- Completed --> creating_Poll_For_Event() -----------");
	}
	
	public void build_Poll_Make_Visible_On_Staging_1() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickPollBtnOn();
		this.clickSubmitBtn();
		this.verify_Poll_Board_Member_Access_1_Created();
		this.clickBreadCrumbWorkroom();
		this.verifyPollTitleOnStaging1();
		System.out.println("------- Completed --> build_Poll_Make_Visible() -----------");
	}
	//---------------------------------------------------
	
	public void build_Poll_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(500);
		this.verifySubmitBtn();
		this.clickPollBtnOn();
		Thread.sleep(500);
		this.clickSubmitBtn();
		Thread.sleep(500);
		this.clickBreadCrumbWorkroom();
		Thread.sleep(500);
		this.verifyNewPollBtn();
		System.out.println("------- Completed --> build_Poll_Make_Visible() -----------");
	}
		
	public void create_Poll_Question() throws InterruptedException {
		this.verifyNewQuestionOne();
		this.clickNewQuestionOne();
		Thread.sleep(1000);
		this.verifyNewQuestionBox();
		this.clickPollTextBoxSendKeysSave();
		Thread.sleep(1000);
		this.verifyPollSucessMessage();
		Thread.sleep(1000);
		this.verifyPollQuestionExist();
		System.out.println("------- Completed --> create_Poll_Question() -----------");
	}

	public void manageRespondents() throws InterruptedException {
		this.clickManageRespondentsAddUser();
		this.verifyBuildBtn();
	}
	
	public void manageRespondents_B() throws InterruptedException {
		this.clickManageRespondentsAddUser_B();
		this.verifyBuildBtn();
	}
	
	public void manageRespondents_C() throws InterruptedException {
		this.clickManageRespondentsAddUser_C();
		this.verifyBuildBtn();
	}
	
	public void manageRespondents_D() throws InterruptedException {
		this.clickManageRespondentsAddUser_D();
		this.verifyBuildBtn();
	}

	
	
	// --------------View/Respond_To_Survey ----------------------
	By poll_Respond_Message = By.xpath("//div//p[contains(text(),'Successfully')]");
	By results = By.xpath("//a[contains(text(),'Results')]");
	By results_Summary = By.xpath("//div[@class='result-summary']");
	By individual_Results = By.xpath("//p[contains(text(),'Individual Results')]");
	By question = By.xpath("//p[contains(text(),'what happened to the good old days?')]");
	By poll_Title_Results = By.xpath("//h3[contains(text(),'This is a Poll Title')]");
	By poll_5_Title_Results = By.xpath("//h3[contains(text(),'Poll 5')]");

	By high_Charts = By.xpath("//div[@id='highcharts-0']");
	
	public void verify_Poll_Respond_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Respond_Message)));
	}
	
	public void verifiy_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results)));
	}
	
	public void verify_Results_Summary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results_Summary)));
	}
	
	public void verify_Question() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(question)));
	}
	
	public void verify_Individual_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(individual_Results)));
	}
	
	public void verify_Poll_Title_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title_Results)));
	}
	
	public void verify_Poll_5_Title_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_5_Title_Results)));
	}
	
	public void verify_High_Charts() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(high_Charts)));
	}
	
	public void clickSecondChoice() {
		WebElement radio = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//input[starts-with(@id,'survey_answers_')])[2]"));

		if (!radio.isSelected()) {
			//WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//input[starts-with(@id,'survey_answers_')])[2]"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", radio);
		}
	}
	
	public void click_Results() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(results).click();
	}
	
	public void click_Results_Summary() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(results_Summary).click();
	}
	
	public void click_Individual_Results() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(individual_Results).click();
	}
	
	public void verify_User_Reponse() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'Automation Tester')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
	}
	
	public void verify_User_Reponse_Non_Admin() throws InterruptedException {
		String user = "//td[contains(text(),'Auto Director')]";
		String check = "//tbody/tr[1]/td[3]/i[@class='fa fa-check']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(check)).size() > 0);		
	}
	
	public void verify_Poll_5_User_Reponse_Non_Admin() throws InterruptedException {
		String user = "//td[contains(text(),'Auto Admin User GS 11')]";
		String check = "(//*[contains(text(),'Auto User5')]/following::td/i[@class='fa fa-check'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(check)).size() > 0);		
	}
	
	public void respond_To_Poll() throws InterruptedException {
		Thread.sleep(1000);
		this.verifyPollTitle();
		this.clickSecondChoice();
		Thread.sleep(1000);
		this.clickSubmitBtn();
		Thread.sleep(1000);
		this.verify_Poll_Respond_Message();
		System.out.println("------- Completed --> respond_To_Poll() -----------");
	}
	
	public void respond_To_Poll_4() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Poll_4_Title_H1();
		this.clickSecondChoice();
		Thread.sleep(1000);
		this.clickSubmitBtn();
		Thread.sleep(1000);
		this.verify_Poll_Respond_Message();
		System.out.println("------- Completed --> respond_To_Poll_4() -----------");
	}
	
	public void respond_To_Poll_5() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Poll_5_Title_H1();
		this.clickSecondChoice();
		Thread.sleep(1000);
		this.clickSubmitBtn();
		Thread.sleep(1000);
		this.verify_Poll_Respond_Message();
		System.out.println("------- Completed --> respond_To_Poll_4() -----------");
	}
	
	public void view_Poll_Reponses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_High_Charts();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verify_Poll_1_Dropdown();
		System.out.println("------- Completed --> view_Survey_Reponses() -----------");
	}
	
	public void view_Poll_4_Reponses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_High_Charts();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Poll_4_Reponses() -----------");
	}
	
	public void view_Poll_Individual_Reponses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Individual_Results();
		this.click_Individual_Results();;
		Thread.sleep(1000);
		this.verify_Poll_Title_Results();
		this.verify_User_Reponse_Non_Admin();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Poll_Individual_Reponses() -----------");
	}
	
	public void view_Poll_5_Individual_Reponses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Individual_Results();
		this.click_Individual_Results();;
		Thread.sleep(1000);
		this.verify_Poll_5_Title_Results();
		this.verify_Poll_5_User_Reponse_Non_Admin();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Poll_Individual_Reponses() -----------");
	}
	
	//-----------------------------------------------------
	By edit_Poll_Questions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Poll Questions')]");
	By edit_Question_Arrow = By.xpath("(//p[contains(text(),'what is your favorite food?')]/following::div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By edit_Question_Box = By.xpath("//h4[contains(text(),'Edit Question')]");

	public void verify_Edit_Poll_Questions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Poll_Questions)));
	}
	
	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}
	
	public void verify_Edit_Question_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Question_Box)));
	}
	
	public void wait_For_Invisibility_Of_Edit_Question_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(edit_Question_Box)));
	}
	
	public void click_Edit_Poll_Questions() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Poll_Questions).click();
	}
	
	public void click_Edit_Question_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Question_Arrow).click();
	}
	
	public void click_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
	}
	
	public void editPollTextBoxSendKeysSave() throws InterruptedException {
		String editedPollQuestion = "who is your favorite person?";
		
		By radioButtonOne = By.xpath("//input[@id='survey_question_values_default_option_0']");
		By radioTextOne = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[1]");
		By radioButtonTwo = By.xpath("//input[@id='survey_question_values_default_option_1']");
		By radioTextTwo = By.xpath("( //input[starts-with (@id,'survey_question_values_1')])[2]");
		By radioButtonThree = By.xpath("//input[@id='survey_question_values_default_option_2']");
		By radioTextThree = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[3]");

		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(1000);
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(editedPollQuestion);
		
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		
		DriverFactory.getInstance().getDriver().findElement(radioButtonOne).click();
		
		DriverFactory.getInstance().getDriver().findElement(radioTextOne).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioTextOne).clear();
		DriverFactory.getInstance().getDriver().findElement(radioTextOne).sendKeys("son");
		
		DriverFactory.getInstance().getDriver().findElement(radioButtonTwo).click();
		
		DriverFactory.getInstance().getDriver().findElement(radioTextTwo).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioTextTwo).clear();
		DriverFactory.getInstance().getDriver().findElement(radioTextTwo).sendKeys("daughter");
		
		DriverFactory.getInstance().getDriver().findElement(radioButtonThree).click();

		DriverFactory.getInstance().getDriver().findElement(radioTextThree).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioTextThree).clear();
		DriverFactory.getInstance().getDriver().findElement(radioTextThree).sendKeys("wife");
		
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}
	
	public void verify_Edited_Question_Exist() throws InterruptedException {
		String pollquestion = "//*[contains(text(),'who is your favorite person?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollquestion)).size() > 0);
	}
	
	public void navigate_To_Edit_Poll() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(500);
		this.verify_Edit_Poll_Questions();
        this.click_Edit_Poll_Questions();
		Thread.sleep(500);
	}
	
	public void edit_Poll_Question() throws InterruptedException {
		this.verifyBuildBtn();
		this.click_Edit_Question_Arrow();
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.editPollTextBoxSendKeysSave();
		Thread.sleep(500);
		this.wait_For_Invisibility_Of_Edit_Question_Box();
		this.verify_Edited_Question_Exist();
		System.out.println("------- Completed --> edit_Poll_Question() -----------");
	}
	
	public void edit_Poll_2_Question() throws InterruptedException {
		this.verifyBuildBtn();
		this.click_Edit_Question_Arrow();
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.editPollTextBoxSendKeysSave();
		Thread.sleep(500);
		this.wait_For_Invisibility_Of_Edit_Question_Box();
		this.verify_Edited_Question_Exist();
		System.out.println("------- Completed --> edit_Poll_2_Question() -----------");
	}
	
	public void build_Survey_Make_Visible_2() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1000);
		this.verify_Edit_Poll_Questions();
		this.clickPollBtnOn();
		Thread.sleep(2000);
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyPollTitle();
		System.out.println("------- Completed --> build_Survey_Make_Visible_2() -----------");
	}
	
	// ------------------ archive_Poll ----------------------
	By archive = By.xpath("//a[contains(text(),'Archive')]");
	By archive_Header = By.xpath("//h1[contains(text(),'Archived')]");
	By archiveBtn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");


	public void verify_Archive_Header() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archive_Header)));
	}
	
		
	public void verify_Archive_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveBtn)));
	}
	
	public void click_Archive() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(archive).click();
	}
	
	public void click_Archive_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(archiveBtn).click();
	}
	
	
	public void veirfy_Poll_1_Archived() throws InterruptedException {
		this.clickPolls();
		Thread.sleep(1500);
		this.verify_Archive_Btn();
		this.click_Archive_Btn();
		Thread.sleep(1500);
		this.verify_Archive_Header();
		this.verify_Poll_1_Dropdown();
		System.out.println("------- Completed --> veirfy_Poll_1_Archived() -----------");
	}
	
	// ------------------ move_Poll_To_Another_Workroom ----------------------
	By move_To_Dropdown = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By autoAttend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By move_Here = By.xpath("//button[@class='btn-sidebar move-btn btn-success']");
	By autoAttend_Workroom = By.xpath("//*[@id='wrap']//main//div/ol//a[contains(text(),'AutoAttend')]");
	By autoAttend_2 = By.xpath("//*[@id='wrap']//main//div/ol//a[contains(text(),'AutoAttend')]");

	public void verify_Move_To_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_To_Dropdown)));
	}
	
	public void verify_AutoAttend() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend)));
	}
	
	public void verify_Move_Here() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Here)));
	}
	
	public void verify_AutoAttend_Workroom() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend_Workroom)));
	}
	
	public void scroll_Move_To_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='filter-option pull-left']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void click_Move_To_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(move_To_Dropdown).click();
	}
	
	public void click_AutoAttend() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(autoAttend).click();
	}
	
	public void click_Move_Here() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(move_Here).click();
	}
	
	public void click_AutoAttend_2() {
		DriverFactory.getInstance().getDriver().findElement(autoAttend_2).click();
	}
	
	public void move_Poll_3_To_Another_Workroom() throws InterruptedException {
		this.click_Poll_3_Title();
		Thread.sleep(1000);
		this.verify_Move_To_Dropdown();
		this.scroll_Move_To_Dropdown();
		this.click_Move_To_Dropdown();
		Thread.sleep(1000);
		this.verify_AutoAttend();
		this.click_AutoAttend();
		Thread.sleep(1000);
		this.verify_Move_Here();
		this.click_Move_Here();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		System.out.println("------- Completed --> move_Poll_3_To_Another_Workroom() -----------");
	}
	
	public void verify_Move_Workroom_AutoAttend() throws InterruptedException {
		this.verify_AutoAttend_Workroom();
		this.click_AutoAttend_2();
		Thread.sleep(1000);
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		System.out.println("------- Completed --> verify_Move_Workroom_AutoAttend() -----------");
	}
	
	
	//-------Delete Poll ---------
	By poll_Board_Member_Access_1_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll Board Member Access 1']/following::div[@class='dropdown header-actions'])[1]");
	By poll_Board_Member_Access_1_Delete_Option = By.xpath("//*[normalize-space(text())='Poll Board Member Access 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By poll_1_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 1']/following::div[@class='dropdown header-actions'])[1]");
	By poll_1_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By poll_1_Title = By.xpath("//*[normalize-space(text())='Poll 1']");
	By poll_2_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 2']/following::div[@class='dropdown header-actions'])[1]");
	By poll_2_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By poll_3_Title = By.xpath("//*[normalize-space(text())='Poll 3']");
	By poll_3_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 3']/following::div[@class='dropdown header-actions'])[1]");
	By poll_3_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By poll_4_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 4']/following::div[@class='dropdown header-actions'])[1]");
	By poll_4_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 4']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By poll_4_Title = By.xpath("//*[normalize-space(text())='Poll 4']");
	By poll_4_Title_H1 = By.xpath("(//*[normalize-space(text())='Poll 4'])[2]");
	
	By poll_5_Title = By.xpath("//*[normalize-space(text())='Poll 5']");
	By poll_5_Title_H1 = By.xpath("(//*[normalize-space(text())='Poll 5'])[2]");

	By poll_5_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 5']/following::div[@class='dropdown header-actions'])[1]");
	By poll_5_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By poll_7_Dropdown = By.xpath("(//*[normalize-space(text()) = 'Poll 7']/following::div[@class='dropdown header-actions'])[1]");
	By poll_7_Delete_Option = By.xpath("//*[normalize-space(text())='Poll 7']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	
	public void verify_Poll_Board_Member_Access_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Board_Member_Access_1_Dropdown)));
	}
	
	public void verify_Poll_Board_Member_Access_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Board_Member_Access_1_Delete_Option)));
	}

	public void verify_Poll_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_1_Dropdown)));
	}
	
	public void verify_Poll_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_1_Delete_Option)));
	}
	
	public void verify_Poll_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_2_Dropdown)));
	}
	
	public void verify_Poll_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_2_Delete_Option)));
	}
	
	public void verify_Poll_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_3_Dropdown)));
	}
	
	public void verify_Poll_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_3_Delete_Option)));
	}
	
	public void verify_Poll_4_Title_H1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_4_Title_H1)));
	}
	
	public void verify_Poll_5_Title_H1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_5_Title_H1)));
	}
	
	
	public void verify_Poll_4_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_4_Dropdown)));
	}
	
	public void verify_Poll_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_4_Delete_Option)));
	}
	
	public void verify_Poll_5_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_5_Title)));
	}
	
	public void verify_Poll_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_5_Dropdown)));
	}
	
	public void verify_Poll_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_5_Delete_Option)));
	}
	
	public void verify_Poll_7_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_7_Dropdown)));
	}
	
	public void verify_Poll_7_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_7_Delete_Option)));
	}
	
	
	public void click_Poll_Board_Member_Access_1_Dropdown() throws InterruptedException {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_Board_Member_Access_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_Board_Member_Access_1_Dropdown).click();
	}

	public void click_Poll_Board_Member_Access_1_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_Board_Member_Access_1_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_1_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_1_Dropdown).click();
	}
	
	public void click_Poll_2_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_2_Dropdown).click();
	}
	
	public void click_Poll_3_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_3_Dropdown).click();
	}
	
	public void click_Poll_4_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_4_Dropdown).click();
	}
	
	public void click_Poll_5_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_5_Dropdown).click();
	}
	
	public void click_Poll_7_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_7_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(poll_7_Dropdown).click();
	}
	
	public void click_Poll_1_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_1_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_2_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_2_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_3_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_3_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_4_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_4_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_5_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_5_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_7_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_7_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Poll_1_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_1_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(poll_1_Title).click();
	}
	
	public void click_Poll_3_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_3_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(poll_3_Title).click();
	}
	
	public void click_Poll_4_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_4_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(poll_4_Title).click();
	}
	
	public void click_Poll_5_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_5_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(poll_5_Title).click();
	}
	
	public void verify_Poll_Board_Member_Access_1_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh(); // used to refreshe page and verify poll not exist due misbehaving web app 

		String poll = "//*[normalize-space(text()) = 'Poll Board Member Access 1']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void verify_Poll_1_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1000);
		String poll = "//*[normalize-space(text()) = 'Poll 1']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void verify_Poll_2_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1000);
		String poll = "//*[normalize-space(text()) = 'Poll 2']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void verify_Poll_3_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1000);
		String poll = "//*[normalize-space(text()) = 'Poll 3']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void verify_Poll_5_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1000);
		String poll = "//*[normalize-space(text()) = 'Poll 5']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void verify_Poll_7_NOT_EXIST() throws InterruptedException {
		Thread.sleep(1000);
		String poll = "//*[normalize-space(text()) = 'Poll 7']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}
	
	public void archive_Poll_1() throws InterruptedException {
		this.click_Poll_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Archive();
		Thread.sleep(1000);
		this.verify_Archive_Header();
		System.out.println("------- Completed --> click_Poll_1_Dropdown() -----------");
	}
	

	public void delete_Poll_On_Staging_Board_Member_Access_1() throws InterruptedException {
		this.verify_Poll_Board_Member_Access_1_Dropdown();
		this.click_Poll_Board_Member_Access_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_Board_Member_Access_1_Delete_Option();
		this.click_Poll_Board_Member_Access_1_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_On_Staging_Board_Member_Access_1() -----------");
	}
	
	public void delete_Poll_1() throws InterruptedException {
		this.verify_Poll_1_Dropdown();
		this.click_Poll_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_1_Delete_Option();
		this.click_Poll_1_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_1() -----------");
	}
	
	public void delete_Poll_2() throws InterruptedException {
		this.verify_Poll_2_Dropdown();
		this.click_Poll_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_2_Delete_Option();
		this.click_Poll_2_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_2() -----------");
	}
	
	public void delete_Poll_3() throws InterruptedException {
		this.verify_Poll_3_Dropdown();
		this.click_Poll_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_3_Delete_Option();
		this.click_Poll_3_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_3() -----------");
	}
	
	public void delete_Poll_4() throws InterruptedException {
		this.verify_Poll_4_Dropdown();
		this.click_Poll_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_4_Delete_Option();
		this.click_Poll_4_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_4() -----------");
	}
	
	public void delete_Poll_5() throws InterruptedException {
		this.verify_Poll_5_Dropdown();
		this.click_Poll_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_5_Delete_Option();
		this.click_Poll_5_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_5() -----------");
	}
	
	public void delete_Poll_7() throws InterruptedException {
		this.verify_Poll_7_Dropdown();
		this.click_Poll_7_Dropdown();
		Thread.sleep(1000);
		this.verify_Poll_7_Delete_Option();
		this.click_Poll_7_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll_7() -----------");
	}
	

	
}
