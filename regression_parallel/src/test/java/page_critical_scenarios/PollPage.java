package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class PollPage {
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
	By pollSucessMessage = By.xpath("//p[contains(text(),'Successfully created This is a Poll Title')]");
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
	By poll_Title = By.xpath("//h1[contains(text(),'This is a Poll Title')]");
	By poll_Title_2 = By.xpath("(//a[contains(text(),'This is a Poll Title')])[1]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By pollBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By pollSucessResponseMessage = By.xpath("//p[contains(text(),'Successfully responded to poll: This is a Poll Tit')]");
	By breadCrumbWorkroom = By.xpath("//a[contains(text(),'Workroom Polls')]");

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
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title)));
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

	public void verifyPollTitle_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Title_2)));
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

	public void clickandTypePollTitleInputField() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(pollTitleInputField).click();
		DriverFactory.getInstance().getDriver().findElement(pollTitleInputField).sendKeys(pollTitle);
	}

	public void clickSaveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	public void clickSubmitBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(submitBtn).click();
		Thread.sleep(2000);
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
		Thread.sleep(500);
		iframeBody.sendKeys(pollQuestion);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioButtonOne).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextOne).sendKeys("apple pie");
		DriverFactory.getInstance().getDriver().findElement(radioButtonTwo).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextTwo).sendKeys("ice cream");
		DriverFactory.getInstance().getDriver().findElement(radioButtonThree).click();
		DriverFactory.getInstance().getDriver().findElement(radioTextThree).sendKeys("pudding");
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}

	public void verifyPollQuestionExist() throws InterruptedException {
		String pollquestion = "//*[contains(text(),'what is your favorite food?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pollquestion)).size() != 0);
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean question = DriverFactory.getInstance().getDriver().findElements(By.xpath(pollquestion)).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void clickManageRespondentsAddUser() throws InterruptedException {
		// click Manage Respondents
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		this.verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement automationTester2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		automationTester2.click();
		Thread.sleep(2000);
		String automationTester3 = "//*[@class='people-snippet row small-left']/div[contains(text(),'Automation Tester')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automationTester3)).size() > 0);
		Thread.sleep(1000);
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUser_Lab() throws InterruptedException {
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
		String automationTester3 = "(//*[contains(text(),'Automation Tester')])[2]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automationTester3)).size() > 0);
		Thread.sleep(1000);
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}

	public void verifyPollTitleAndQuestionExist() throws InterruptedException {
		String pollTitle = "//h1[contains(text(),'This is a Poll Title')]";
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

	// ------------------ Functions ----------------------
	public void create_Poll() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickPolls();
		this.verifyNewPollBtn();
		this.clickNewPollBtn();
		this.verifyPollInputField();
		this.clickandTypePollTitleInputField();
		this.pollDescriptionTextBox();
		this.clickSaveBtn();
		this.verifyPollSucessMessage();
		System.out.println("------- Completed --> create_Poll() -----------");
	}

	public void create_Poll_Question() throws InterruptedException {
		this.verifyNewQuestionOne();
		this.clickNewQuestionOne();
		this.verifyNewQuestionBox();
		this.clickPollTextBoxSendKeysSave();
		this.verifyPollSucessMessage();
		Thread.sleep(1000);
		this.verifyPollQuestionExist();
		System.out.println("------- Completed --> create_Poll_Question() -----------");
	}

	public void manageRespondents() throws InterruptedException {
		String url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			this.clickManageRespondentsAddUser();
		}else {
			this.clickManageRespondentsAddUser_Lab();
		}
		
		this.verifyBuildBtn();
	}

	public void build_Poll_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickPollBtnOn();
		this.clickSubmitBtn();
		this.verifyPollSucessResponseMessage();
		this.verifyPollTitleAndQuestionExist();
		this.clickBreadCrumbWorkroom();
		this.verifyPollTitle_2();
		System.out.println("------- Completed --> build_Poll_Make_Visible() -----------");
	}
	By poll_Title_Dropdown = By.xpath("(//a[contains(text(),'This is a Poll Title')]/following::div[@class='dropdown header-actions'])[1]");
	By deleteOption = By.xpath("//div[@class='dropdown header-actions open']//a[contains(text(),'Delete')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteOption)));
	}

	public void click_Poll_Title_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Title_Dropdown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(deleteOption).click();
	}

	public void verify_Poll_NOT_Exist() throws InterruptedException {
		Thread.sleep(2000);
		String poll = "(//li[@class='active']/following::text()[contains(., 'This is a Poll Title')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(poll)).size() < 1);
	}

	public void delete_Poll() throws InterruptedException {
		this.click_Poll_Title_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Poll() -----------");
	}

	public void verify_Poll_Deletion() throws InterruptedException {
		this.verify_Poll_NOT_Exist();
		System.out.println("------- Completed --> verify_Poll_Deletion() -----------");
	}
}
