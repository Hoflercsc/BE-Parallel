package page_survey;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.naming.ldap.ExtendedRequest;
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

public class SurveyPage {
	
	// ----------- POM Page Object model -----------------------------
	String surveyTitle = "This is a Survey Title";
	String Question1 = "what happened to the good old days?";
	String Question2 = "what happened to Gilbert Grape?";
	String Question3 = "what happened to Micheal Jordan?";
	String Question4 = "what happened to Daffy Duck?";
	String Question5 = "Jack and Jill ran up the hill searching to fetch a pail of water. It was the best of times and he worst of times";
	String Question6 = "pick highest number between 1 and 10";
	String Option1 = "Relocated";
	String Option2 = "Got Sick";
	String Option3 = "Retired";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By collaborate = By.xpath("//span[contains(text(),'Collaborate')]");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By surveysSubMenu = By.xpath("//span[@class='label label-default']//a[contains(text(),'Surveys')]");
	By newSurveyBtn = By.xpath("//a[@class='btn btn-success']");
	By surveyTitleInputField = By.xpath("//input[@id='survey_title']");
	By surveyDueDate = By.xpath("//input[@id='survey_expiration_date']");
	By surveyReminderDate = By.xpath("//input[@id='survey_reminder_date']");
	By saveBtn = By.xpath("//*[@id=\"new_survey\"]/button");
	By surveySucessMessage = By.xpath("//div//p[contains(text(),'Successfully')]");
	// ---Text Field Question ----------
	By newQuestionOne = By.xpath("(//a[contains(text(),'Add Question')])[1]");
	By newQuestionBox = By.xpath("//h4[contains(text(),'New Question')]");
	By textFieldBtn = By.xpath("//a[contains(text(),'Text Field')]");
	By textArea = By.xpath("//textarea[@id='survey_question_question_name']");
	By saveBtnbox = By.xpath("//div[@id='questionModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	// By question = By.xpath("//*[contains(text(),'what happen to the good old
	// days?')]");
	// ---Check Box Question ----------
	By newQuestionBox2 = By.xpath("//h4[contains(text(),'New Question')]");
	By checkBoxes = By.xpath("//a[contains(text(),'Checkboxes')]");
	By textArea2 = By.xpath("//textarea[@id='survey_question_question_name']");
	By textArea3 = By.xpath("//textarea[@id='poll-question-name']");
	By checkBoxOne = By.xpath("//input[@id='survey_question_default_option_1']");
	By checkBoxOneInput = By.xpath("//input[@id='survey_question_values_1_value']");
	By checkBoxTwo = By.xpath("//input[@id='survey_question_default_option_2']");
	By checkBoxTwoInput = By.xpath("//input[@id='survey_question_values_2_value']");
	By checkBoxThree = By.xpath("//input[@id='survey_question_default_option_3']");
	By checkBoxThreeInput = By.xpath("//input[@id='survey_question_values_3_value']");
	// ---DropDown List Question ----------
	By dropDownList = By.xpath("//a[contains(text(),'Dropdown List')]");
	By radioOne = By.xpath("//input[@id='survey_question_values_default_option_1']");
	By radioOneInput = By.xpath("//input[@id='survey_question_values_1_value']");
	By radioTwo = By.xpath("//input[@id='survey_question_values_default_option_2']");
	By radioTwoInput = By.xpath("//input[@id='survey_question_values_2_value']");
	By radioThree = By.xpath("//input[@id='survey_question_values_default_option_3']");
	By radioThreeInput = By.xpath("//input[@id='survey_question_values_3_value']");
	// ---Radio Button Question------
	By radioButton = By.xpath("//a[contains(text(),'Radio Buttons')]");
	// ----Paragraph Question ---------
	By paragraph = By.xpath("//a[contains(text(),'Paragraph')]");
	// ----Heaidng Question ---------
	By heading = By.xpath("//a[contains(text(),'Heading')]");
	By description = By.xpath("//textarea[@id='survey_question_question_subtext']");
	String title = "Title";
	String info = "This is a description";
	// ----Linear Scale -------------
	By linearscale = By.xpath("//a[contains(text(),'Linear Scale')]");
	// ------------------------------------------------
	By manageRespondents = By.xpath("//a[contains(text(),'Manage Respondents')]");
	By respondents = By.xpath("//a[contains(text(),'Respondents')]");
	By respondents_2 = By.xpath("//*[contains(text(),'Respondents')]");
	By survey_Title = By.xpath("//h1[contains(text(),'This is a Survey Title')]");
	By buildBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue']");
	By submitBtn = By.xpath("//button[@id='survey-submit']");
	By surveyBtnOn = By.xpath("//label[@class='onoffswitch-label']");
	By pollVisibleGreen = By.xpath("//*[contains(text(),'Poll Is Visible')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By surveySucessResponseMessage = By.xpath("//div//p[contains(text(),'Successfully responded to survey:')]");
	By breadCrumbWorkroom = By.xpath("//a[contains(text(),'Workroom Surveys')]");
	// -----------------------------------------------------------------------------

	// ------------------ Expected Conditions ---------------------
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
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroomSubnav)));
	}

	public void verifyNewSurveyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(newSurveyBtn)));
	}

	public void verifySurveyTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(surveyTitleInputField)));
	}

	public void verifySurveySucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveySucessMessage)));
	}

	public void verifyAddQuestionOne() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(newQuestionOne)));
	}

	public void verifyNewQuestionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newQuestionBox)));
	}
	
	public void verifyAutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(AutoBE)));
	}

	public void verifyTextArea() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement textAreaBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(textAreaBody)));
		
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}

	// ------------------ General Elements ---------------------
	public void clickAutoBEWorkRoom() {
		DriverFactory.getInstance().getDriver().findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		DriverFactory.getInstance().getDriver().findElement(collaborateActiveOff).click();
	}

	public void clickSurveys() {
		DriverFactory.getInstance().getDriver().findElement(surveysSubMenu).click();
	}
	
	public void click_Collaborate() {
		DriverFactory.getInstance().getDriver().findElement(collaborate).click();
	}

	public void clickNewSurveyBtn() {
		DriverFactory.getInstance().getDriver().findElement(newSurveyBtn).click();
	}

	public void clickandTypeSurveyTitleInputField(String surveytitlestaging1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).click();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(surveytitlestaging1);
	}

	public void clickSaveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	public void clickSaveBtnBox() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}

	// --------Text Field Scenario Elements/Functions ----------------------------
	public void clickQuestionOne() {
		DriverFactory.getInstance().getDriver().findElement(newQuestionOne).click();
	}

	public void clickTextFieldBtn() {
		DriverFactory.getInstance().getDriver().findElement(textFieldBtn).click();
	}

	public void clickTextAreaSendKeysandSave() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question1);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}

	public void verifyQuestionCreated1() throws InterruptedException {
		String question1 = "//*[contains(text(),'what happened to the good old days?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Check Boxes Scenario Elements/Functions --------------------------
	public void clickCheckBoxBtn() {
		DriverFactory.getInstance().getDriver().findElement(checkBoxes).click();
	}

	public void clickTextAreaSendKeys2() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question2);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void clickCheckBoxOneAndInput1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(checkBoxOne).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxOneInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxOneInput).sendKeys(Option1);
	}

	public void clickCheckBoxTwoAndInput2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwo).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwoInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwoInput).sendKeys(Option2);
	}

	public void clickCheckBoxThreeAndInput3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(checkBoxThree).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxThreeInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxThreeInput).sendKeys(Option3);
	}

	public void verifyQuestionCreated2() throws InterruptedException {
		String question2 = "//*[contains(text(),'what happened to Gilbert Grape?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question2)).size() > 0);
		Thread.sleep(3000);
	}
	// -------- Dropdown List Scenario Elements/Functions --------------------------

	public void clickDropDownList() {
		DriverFactory.getInstance().getDriver().findElement(dropDownList).click();
	}

	public void clickTextAreaSendKeys3() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question3);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void clickRadioOneAndInput1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(radioOne).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioOneInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioOneInput).sendKeys(Option1);
	}

	public void clickRadioTwoAndInput2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(radioTwo).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioTwoInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioTwoInput).sendKeys(Option2);
	}

	public void clickRadioThreeAndInput3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(radioThree).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioThreeInput).click();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioThreeInput).sendKeys(Option3);
	}

	public void verifyQuestionCreated3() throws InterruptedException {
		String question3 = "//*[contains(text(),'what happened to Micheal Jordan?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question3)).size() != 0);
		Thread.sleep(3000);
	}
	// -------- Radio Button Scenario Elements/Functions --------------------------

	public void clickRadioButtons() {
		DriverFactory.getInstance().getDriver().findElement(radioButton).click();
	}

	public void clickTextArea3() {
		DriverFactory.getInstance().getDriver().findElement(textArea3).click();
	}

	public void clickTextAreaSendKeys4() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question4);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void verifyQuestionCreated4() throws InterruptedException {
		String question4 = "//*[contains(text(),'what happened to Daffy Duck?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question4)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Paragraph Scenario Elements/Functions --------------------------
	public void clickParagraph() {
		DriverFactory.getInstance().getDriver().findElement(paragraph).click();
	}

	public void clickTextAreaSendKeys5() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.click();
		Thread.sleep(500);
		iframeBody.sendKeys(Question5);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}

	public void verifyQuestionCreated5() throws InterruptedException {
		String question5 = "//*[contains(text(),'Jack and Jill ran up the hill searching to fetch a pail of water. It was the best of times and he worst of times')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question5)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Heading Scenario Elements/Functions --------------------------
	public void clickHeading() {
		DriverFactory.getInstance().getDriver().findElement(heading).click();
	}

	public void clickTextAreaSendKeys6() throws InterruptedException {
		//--switch to iframe---
		WebElement textBoxOne = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(textBoxOne);
		//--send keys to iframe body-----
		WebElement textBoxOneIframe = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		textBoxOneIframe.click();
		Thread.sleep(500);
		textBoxOneIframe.sendKeys(title);
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();

		//--switch to iframe---
		WebElement textBoxTwo = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[2]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(textBoxTwo);
		//--send keys to iframe body-----
		WebElement textBoxTwoIframe = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		textBoxTwoIframe.click();
		Thread.sleep(500);
		textBoxTwoIframe.sendKeys(info);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}

	public void verifyTitleAndDescription() throws InterruptedException {
		String info = "//*[contains(text(),'This is a description')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(info)).size() != 0);
		Thread.sleep(3000);
	}

	// -------- Linear Scale Scenario Elements/Functions --------------------------
	public void clickLinearScale() {
		DriverFactory.getInstance().getDriver().findElement(linearscale).click();
	}

	public void clickTextAreaSendKeysSelectChoices() throws InterruptedException {
		By tenDelete = By.xpath("//div[@id='choice_10']//a[@class='remove-opt btn btn-sm btn-danger'][contains(text(),'Delete')]");
		By radioBtn8 = By.xpath("//input[@id='survey_question_values_default_option_8']");
		By contnueBtn = By.xpath("//button[@class='btn commit btn-danger']");
		
		//--switch to iframe---
		WebElement textBoxOne = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(textBoxOne);
		//--send keys to iframe body-----
		WebElement textBoxOneIframe = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		textBoxOneIframe.click();
		Thread.sleep(500);
		textBoxOneIframe.sendKeys(Question6);
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		DriverFactory.getInstance().getDriver().findElement(tenDelete).click();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(contnueBtn).click();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(radioBtn8).click();
	}

	public void verifyLinearScaleTitle() throws InterruptedException {
		String question6 = "//*[contains(text(),'pick highest number between 1 and 10')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question6)).size() != 0);
		Thread.sleep(3000);
	}

	// ------------------ Calendar Functions ---------------------
	public void surveyDueDateCalendar() throws InterruptedException {
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		WebElement element = DriverFactory.getInstance().getDriver().findElement(surveyDueDate);
		action.doubleClick(element).perform();
		String day = "5";
		// WebElement dropdownlist =
		// DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='bootstrap-datetimepicker-widget
		// dropdown-menu top picker-open']"));
		WebElement calendar = DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top picker-open']//div[@class='datepicker-days']//tbody"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		for (WebElement option : opt) {
			if (option.getText().equals(day)) {
				option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='col-md-8']")).click();
	}

	public void surveyReminderCalendar() throws InterruptedException {
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		WebElement element = DriverFactory.getInstance().getDriver().findElement(surveyReminderDate);
		action.doubleClick(element).perform();
		String day = "20";
		// WebElement dropdownlist =
		// DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='bootstrap-datetimepicker-widget
		// dropdown-menu top picker-open']"));
		WebElement dropdownlist = DriverFactory.getInstance().getDriver().findElement(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top picker-open']//div[@class='datepicker-days']//tbody"));
		List<WebElement> options = dropdownlist.findElements(By.tagName("td"));
		for (WebElement option : options) {
			if (option.getText().equals(day)) {
				option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='col-md-8']")).click();
	}

	// ------------------ Iframe Text Box Send Keys ---------------------
	public void surveyDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(500);
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}	
	
	// ------------------------2nd Phase ------------------------------------------
	public void verifyRespondents() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents)));
	}
	
	public void verifyRespondents_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(respondents_2)));
	}

	public void verifyPollTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title)));
	}
	
	public void verifySurveyTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Title)));
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
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verifyPollisVisiable() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pollVisibleGreen)));
	}

	public void verifySurveySucessResponseMessage() throws InterruptedException {
		Thread.sleep(3000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveySucessResponseMessage)));
	}

	

	public void clickSubmitBtn() throws InterruptedException {
		WebElement submit = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@id='survey-submit']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", submit);
		DriverFactory.getInstance().getDriver().findElement(submitBtn).click();
		Thread.sleep(2000);
	}

	public void clickBuildBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(buildBtn).click();
		Thread.sleep(1000);
	}

	public void clickSurveyBtnOn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyBtnOn).click();
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
	
	public void verifySurveyTitleAndQuestionExist() throws InterruptedException {
		String surveyTitle = "//h1[contains(text(),'This is a Survey Title')]";
		String question1 = "//p[contains(text(),'what happened to the good old days?')]";
		String question2 = "//p[contains(text(),'what happened to Gilbert Grape?')]";
		String question3 = "//p[contains(text(),'what happened to Micheal Jordan?')]";
		String question4 = "//p[contains(text(),'what happened to Daffy Duck?')]";
		String question5 = "//p[contains(text(),'Jack and Jill ran up the hill searching to fetch a')]";
		String question6 = "//p[contains(text(),'pick highest number between 1 and 10')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(surveyTitle)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question2)).size() != 0);
	}
	
	public void verify_Survey_Board_Member_Access_1_Info() throws InterruptedException {
		String surveyTitle = "//h1[contains(text(),'Survey Board Member Access 1')]";
		String question1 = "//p[contains(text(),'what happened to the good old days?')]";
		String question2 = "//p[contains(text(),'what happened to Gilbert Grape?')]";
		String question3 = "//p[contains(text(),'what happened to Micheal Jordan?')]";
		String question4 = "//p[contains(text(),'what happened to Daffy Duck?')]";
		String question5 = "//p[contains(text(),'Jack and Jill ran up the hill searching to fetch a')]";
		String question6 = "//p[contains(text(),'pick highest number between 1 and 10')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(surveyTitle)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question2)).size() != 0);
	}

	public void clickManageRespondentsAddUser() throws InterruptedException {
		// click Manage Respondents
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(2000);
		WebElement automationTester2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Automation Tester')]"));
		automationTester2.click();
		Thread.sleep(3000);
//		String automationTester3 = "//*[contains(text(),'Automation Tester')]";
//		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automationTester3)).size() != 0);
//		Thread.sleep(1000);
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserB() throws InterruptedException {
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
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(3000);
		saveBtn.click();
	}
	
	public void clickManageRespondentsAddUserC() throws InterruptedException {
		// click Manage Respondents
		//DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Manage Respondents')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(1000);
		// verify respondents on page
		this.verifyRespondents_2();
		// scroll down to respondents
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1000);
		//----------
		WebElement autodirector = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", autodirector);
		Thread.sleep(1000);
		WebElement autoDirector = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='person-name'][contains(text(),'Auto Director')]"));
		autoDirector.click();
		Thread.sleep(1000);
		
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2000);
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
	
	public void clickManageRespondentsAddUserF() throws InterruptedException {
		// click Manage Respondents
		DriverFactory.getInstance().getDriver().findElement(manageRespondents).click();
		// verify respondents on page
		verifyRespondents();
		// scroll down to respondents
		
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Respondents')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1000);
		
		WebElement autoAdminUserGS12 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'User GS 12')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", autoAdminUserGS12);
		Thread.sleep(1000);
		
		autoAdminUserGS12.click();
		Thread.sleep(1500);

		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(2000);
		saveBtn.click();
	}
	
	
	// ------------------ Functions ----------------------
	public void create_Survey(String survey1) throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveys();
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField(survey1);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Survey() -----------");
	}
	
	public void create_Survey_4_Condensed(String survey4) throws InterruptedException {
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField(survey4);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Survey_4_Condensed() -----------");
	}
	
	public void user_Navigates_To_Survey() throws InterruptedException {
		this.click_Collaborate();
		Thread.sleep(1000);
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> user_Navigates_To_Survey() -----------");
	}
	
	// --------------View/Respond_To_Survey ----------------------
	By allow_Edit = By.xpath("//input[@id='survey_allow_answer_editing']");
	By allow_Comments = By.xpath("//input[@id='survey_comments']");
	By survey_Input_Field = By.xpath("(//input[starts-with(@id,'survey_answers_')])[1]");
	By results = By.xpath("//a[contains(text(),'Results')]");
	By results_Summary = By.xpath("//div[@class='result-summary']");
	By individual_Results_Circle = By.xpath("//p[contains(text(),'Individual Results')]");
	By individual_Results_Button = By.xpath("//*[@id='wrap']/main//div/a[contains(.,'Individual Results')]");

	By question = By.xpath("//p[contains(text(),'what happened to the good old days?')]");
	
	public void verifiy_Results() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(results)));
	}
	
	public void verify_Results_Summary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(results_Summary)));
	}
	
	public void verify_Question() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(question)));
	}
	
	public void verify_Submit() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(submitBtn)));
	}
	
	public void verify_Individual_Results_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(individual_Results_Button)));
	}
	
	public void scroll_Click_Input_Boxes() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='survey_allow_answer_editing']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(allow_Edit).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(allow_Comments).click();
		Thread.sleep(1000);
	}
	
	public void click_Results() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(results).click();
	}
	
	public void click_Results_Summary() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(results_Summary).click();
	}
	
	public void click_Individual_Results() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(individual_Results_Circle).click();
	}
	
	public void verify_User_Reponse() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'Automation Tester')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
	}
	
	public void verify_User_Reponse_Survey_17() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'User GS 12')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
	}
	
	
	
	public void verify_User_Reponse_Non_Admin() throws InterruptedException {
		String question = "//p[contains(text(),'They are gone')]";
		String user = "//a[contains(text(),'Auto Director')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question)).size() > 0);	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);	
	}
	
	// ------------------ Functions ----------------------
	public void create_Survey_Additional_Options(String survey17) throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField(survey17);
		Thread.sleep(2000);
		this.surveyDescriptionTextBox();
		this.scroll_Click_Input_Boxes();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Survey() -----------");
	}
	
	public void user_Goes_To_Survey() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		this.verifySurveyTitle();
		this.click_Survey_1_Title();
		System.out.println("------- Completed --> user_Goes_To_Survey() -----------");
	}
	
	public void user_Goes_To_Survey_17() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		this.click_Survey_17_Title();
		System.out.println("------- Completed --> user_Goes_To_Survey() -----------");
	}
	
	public void user_Goes_To_Survey_Non_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifySurveyTitle();
		this.click_Survey_1_Title();
		System.out.println("------- Completed --> user_Goes_To_Survey_Non_Admin() -----------");
	}
	
	public void user_Goes_To_Survey_18_Non_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.click_Survey_18_Title();
		System.out.println("------- Completed --> user_Goes_To_Survey_Non_Admin() -----------");
	}
	
	public void user_Goes_To_Survey_2() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> user_Goes_To_Survey_Results() -----------");
	}
	
	public void verify_Survey_Invited_And_Response() throws InterruptedException {
		String totalInvited = "//p[contains(text(),'Total Invited to survey: 2')]";
		String totalFinished = "//p[contains(text(),'Total Finished survey: 2')]";
		String systemSteve = "//p[contains(text(),'they past')]";
		String autoDirector = "//p[contains(text(),\"i don't know\")]";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(totalInvited)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(totalFinished)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(systemSteve)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(autoDirector)).size() > 0);
	}
	
	public void respond_To_Survey() throws InterruptedException {
		Thread.sleep(1000);
		String answer = "They are gone";
		DriverFactory.getInstance().getDriver().findElement(survey_Input_Field).sendKeys(answer);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//body")).sendKeys(Keys.RETURN);
		this.verify_Submit();
		DriverFactory.getInstance().getDriver().findElement(submitBtn).click();;
		System.out.println("------- Completed --> respond_To_Survey() -----------");
	}
	
	public void view_Survey_Responses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Question();
		this.verify_User_Reponse();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Survey_Reponses() -----------");
	}
	
	public void view_Survey_17_Responses() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Question();
		this.verify_User_Reponse_Survey_17();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Survey_17_Responses() -----------");
	}
	
	public void view_Survey_Responses_2() throws InterruptedException {
		this.click_Survey_Title_2();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Survey_Invited_And_Response();
		System.out.println("------- Completed --> view_Survey_Responses_2() -----------");
	}
	
	public void view_Survey_Reponses_Non_Admin() throws InterruptedException {
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Question();
		this.verify_User_Reponse_Non_Admin();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Survey_Reponses() -----------");
	}
	
	
	//-----------------------------------------------------
	// ------------------ Functions ----------------------
	public void creating_Survey_For_Event(String surveytitlestaging1) throws InterruptedException {
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField(surveytitlestaging1);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> creating_Poll_For_Event() -----------");
	}

	public void create_TextField_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickTextFieldBtn();
		this.verifyTextArea();
		this.clickTextAreaSendKeysandSave();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated1();
		System.out.println("------- Completed --> create_TextField_Question() -----------");
	}

	public void create_CheckBox_Question() throws InterruptedException {
		// ---Text CheckBox Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickCheckBoxBtn();
		this.verifyTextArea();
		this.clickTextAreaSendKeys2();
		this.clickCheckBoxOneAndInput1();
		this.clickCheckBoxTwoAndInput2();
		this.clickCheckBoxThreeAndInput3();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated2();
		System.out.println("------- Completed --> create_CheckBox_Question() -----------");
	}

	public void create_Dropdown_List_Question() throws InterruptedException {
		// ---DropDown List Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickDropDownList();
		this.verifyTextArea();
		this.clickTextAreaSendKeys3();
		this.clickRadioOneAndInput1();
		this.clickRadioTwoAndInput2();
		this.clickRadioThreeAndInput3();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated3();
		System.out.println("------- Completed --> create_Dropdown_List_Question() -----------");
	}

	public void create_RadioButtons_Question() throws InterruptedException {
		// ---Radio Button Question------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickRadioButtons();
		this.verifyTextArea();
		this.clickTextAreaSendKeys4();
		this.clickRadioOneAndInput1();
		this.clickRadioTwoAndInput2();
		this.clickRadioThreeAndInput3();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated4();
		System.out.println("------- Completed --> create_RadioButtons_Question() -----------");
	}

	public void create_Paragraph_Question() throws InterruptedException {
		// ---Paragraph Creation------
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickParagraph();
		this.verifyTextArea();
		this.clickTextAreaSendKeys5();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyQuestionCreated5();
		System.out.println("------- Completed --> create_Paragraph_Question() -----------");
	}

	public void create_Heading_Question() throws InterruptedException {
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickHeading();
		this.verifyTextArea();
		this.clickTextAreaSendKeys6();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyTitleAndDescription();
		System.out.println("------- Completed --> create_Heading_Question() -----------");
	}

	public void create_Linear_Scale() throws InterruptedException {
		this.clickQuestionOne();
		this.verifyNewQuestionBox();
		this.clickLinearScale();
		this.verifyTextArea();
		this.clickTextAreaSendKeysSelectChoices();
		this.clickSaveBtnBox();
		this.verifyAddQuestionOne();
		this.verifyLinearScaleTitle();
		System.out.println("------- Completed --> create_Linear_Scale() -----------");
	}

	// -------------------------------------------------------------------
	public void manage_Respondents() throws InterruptedException {
		this.clickManageRespondentsAddUser();
		this.verifyBuildBtn();
		System.out.println("------- Completed --> manage_Respondents() -----------");
	}
	
	public void manage_Respondents_B() throws InterruptedException {
		this.clickManageRespondentsAddUserB();
		this.verifyBuildBtn();
		System.out.println("------- Completed --> manage_Respondents() -----------");
	}
	
	public void manage_Respondents_C() throws InterruptedException {
		this.clickManageRespondentsAddUserE();
		this.verifyBuildBtn();
		System.out.println("------- Completed --> manage_Respondents() -----------");
	}

	public void build_Survey_Make_Visible_On_Staging_1() throws InterruptedException {
		this.clickBuildBtn();
		this.verifySubmitBtn();
		this.clickSurveyBtnOn();
		this.clickSubmitBtn();
		this.verifySurveySucessResponseMessage();
		this.verify_Survey_Board_Member_Access_1_Info();
		this.clickBreadCrumbWorkroom();
		this.verify_Survey_Board_Member_Access_1_Dropdown();
		System.out.println("------- Completed --> build_Survey_Make_Visible_On_Staging_1() -----------");
	}
	
	public void build_Survey_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1500);
		this.verifyEditSurveyQuestions();
		this.clickSurveyBtnOn();
		Thread.sleep(1500);
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> build_Survey_Make_Visible() -----------");
	}
	
	public void verify_Survey_14_Is_Visible() throws InterruptedException {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_14_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		By surveyVisible = By.xpath("(//*[normalize-space(text())='Survey 14']/following::a[@class='btn btn-default be-positive'])[1]");
		WebElement survey = DriverFactory.getInstance().getDriver().findElement(surveyVisible);
		Assert.assertEquals(true, survey.isEnabled());
	}
	
	//-----------------------------------------------------
	By edit_Survey_Questions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Survey Questions')]");
	
	public void verify_Edit_Survey_Questions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Survey_Questions)));
	}
	
	public void click_Edit_Survey_Questions() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Survey_Questions).click();
	}
	
	public void navigate_To_Edit_Survey() throws InterruptedException {
		this.clickBuildBtn();
		this.verify_Edit_Survey_Questions();
        this.click_Edit_Survey_Questions();
		Thread.sleep(2000);
	}
	
	//--------------------
	By question_One_Arrow = By.xpath("(//span[contains(text(),'1.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By question_Two_Arrow = By.xpath("(//span[contains(text(),'2.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By question_Three_Arrow = By.xpath("(//span[contains(text(),'3.')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Option = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]");
	By edit_Question_Box = By.xpath("//h4[contains(text(),'Edit Question')]");
	
	String editOption1 = "home";
	String editOption2 = "store";
	String editOption3 = "work";
	
	String editRadio1 = "promotion";
	String editRadio2 = "congress";
	String editRadio3 = "fishing";

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

	public void click_Question_One_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(question_One_Arrow).click();
	}
	
	public void click_Question_Two_Arrow() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(question_Two_Arrow).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(question_Two_Arrow);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Question_Three_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(question_Three_Arrow).click();
	}
	
	public void click_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
	}
	
	public void edit_Question_Box_Text_Field() throws InterruptedException {
		String editedQuestion1 = "what happened to the good?";
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(editedQuestion1);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(saveBtnbox).click();
	}
	
	public void verify_Edited_Text_Field_Question_Created() throws InterruptedException {
		String question1 = "//*[contains(text(),'what happened to the good?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() > 0);
		Thread.sleep(3000);
	}
	
	public void edit_Check_Box_Question_Field() throws InterruptedException {
		String checkBoxQuestion = "what happened to Gilbert?";
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(checkBoxQuestion);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}
	
	public void verify_Edited_Check_Box_Question() throws InterruptedException {
		String question2 = "//*[contains(text(),'what happened to Gilbert?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question2)).size() > 0);
		Thread.sleep(3000);
	}
		
	public void editCheckBoxOneAndInputs() throws InterruptedException {
		By checkBoxOneInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[1]");
		By checkBoxTwoInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[2]");
		By checkBoxThreeInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[3]");

		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxOneInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(checkBoxOneInput).clear();
		DriverFactory.getInstance().getDriver().findElement(checkBoxOneInput).sendKeys(editOption1);
		
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwoInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwoInput).clear();
		DriverFactory.getInstance().getDriver().findElement(checkBoxTwoInput).sendKeys(editOption2);
		
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(checkBoxThreeInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(checkBoxThreeInput).clear();
		DriverFactory.getInstance().getDriver().findElement(checkBoxThreeInput).sendKeys(editOption3);
		
	}

	public void edit_Dropdown_List_Question_Field() throws InterruptedException {
		String dropdownBoxQuestion = "what happened to Micheal?";
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		Thread.sleep(500);
		iframeBody.sendKeys(dropdownBoxQuestion);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(500);
	}
	
	public void verify_Edited_Drop_Down_Question() throws InterruptedException {
		String question3 = "//*[contains(text(),'what happened to Micheal?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question3)).size() > 0);
		Thread.sleep(3000);
	}
	
	public void editRadioOneAndInputs() throws InterruptedException {
		By radioOneInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[1]");
		By radioTwoInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[2]");
		By radioThreeInput = By.xpath("(//input[starts-with (@id,'survey_question_values_1')])[3]");

		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioOneInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioOneInput).clear();
		DriverFactory.getInstance().getDriver().findElement(radioOneInput).sendKeys(editRadio1);
		
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioTwoInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioTwoInput).clear();
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioTwoInput).sendKeys(editRadio2);
		
		Thread.sleep(500);
		DriverFactory.getInstance().getDriver().findElement(radioThreeInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(radioThreeInput).clear();
		DriverFactory.getInstance().getDriver().findElement(radioThreeInput).sendKeys(editRadio3);
		
	}
	
	public void edit_Text_Field_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_One_Arrow();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Question_Box_Text_Field();
		//this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Text_Field_Question_Created();
		System.out.println("------- Completed --> edit_Create_TextField_Question() -----------");
	}
	
	// finish making changes
	public void edit_Check_Box_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_Two_Arrow();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Check_Box_Question_Field();
		this.editCheckBoxOneAndInputs();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Check_Box_Question();
		System.out.println("------- Completed --> edit_Check_Box_Question() -----------");
	}
	
	public void edit_Dropdown_List_Question() throws InterruptedException {
		// ---Text Field Question------
		this.verifyAddQuestionOne();
		this.click_Question_Three_Arrow();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_Question_Box();
		this.verifyTextArea();
		this.edit_Dropdown_List_Question_Field();
		this.editRadioOneAndInputs();
		this.clickSaveBtnBox();
		Thread.sleep(1000);
		this.verifyAddQuestionOne();
		this.verify_Edited_Drop_Down_Question();
		System.out.println("------- Completed --> edit_Dropdown_List_Question() -----------");
	}

	//-----------------attach_Event_To_Survey-----------------------------
	By attach_Create_Meeting = By.xpath("//a[@class='btn-sidebar secondary-action-btn left'][contains(text(),' Attach/Create Meeting')]");
	By attach_Create_Modal = By.xpath("//div[@id='attach']//div[@class='modal-content']");
	By event_Title_Snippet = By.xpath("//span[contains(text(),'This is a New Event Title')]");
	By event_5_Snippet = By.xpath("//*[@id='attach_event']//span[@class='block'][contains(text(),'Event 5')]");
	By event_7_Snippet = By.xpath("//*[@id='attach_event']//span[@class='block'][contains(text(),'Event 7')]");
	By doneBtn = By.xpath("//button[@id='attached_event'][contains(text(),'Done')]");
	By event_Container = By.xpath("//div[@class='event_container']");
	By new_Event = By.partialLinkText("This is a New Ev.");
	By new_Event_Title = By.xpath("//h1[contains(text(),'This is a New Event Title')]");

	public void verify_Attach_Create_Meeting() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Meeting)));
	}
	
	public void verify_Attach_Create_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Modal)));
	}
	
	public void verify_Event_Container() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Container)));
	}
	
	public void verify_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void click_Event_5_Snippet() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_5_Snippet).click();
	}
	
	public void click_Event_7_Snippet() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_7_Snippet).click();
	}
	
	
	public void click_Attach_Create_Meeting() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Meeting).click();
	}
	
	public void click_DoneBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(doneBtn).click();
	}
	
	public void click_New_Event() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(new_Event).click();
	}
	
	public void verify_Event_7_Info() throws InterruptedException {
		String info1 = "//h4[@class='heading-surveys'][contains(text(),'Surveys & Polls')]";
		String info2 = "//li[starts-with(@class,'survey-')]//a[contains(text(),'Survey 4')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(info1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(info2)).size() > 0);
	}

	public void attach_Event_7_To_Survey_4() throws InterruptedException {
		this.click_Survey_4_Title();
		Thread.sleep(1000);
		this.verify_Attach_Create_Meeting();
		this.click_Attach_Create_Meeting();
		Thread.sleep(1000);
		this.verify_Attach_Create_Modal();
		this.click_Event_7_Snippet();
		Thread.sleep(1000);
		this.click_DoneBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> attach_Event_7_To_Survey_4() -----------");
	}
	
	public void attach_Event_5_To_Scheduler() throws InterruptedException {
		this.clickSchedulersTitle();
		Thread.sleep(1000);
		this.verify_Attach_Create_Meeting();
		this.click_Attach_Create_Meeting();
		Thread.sleep(1000);
		this.verify_Attach_Create_Modal();
		this.click_Event_5_Snippet();
		Thread.sleep(1000);
		this.click_DoneBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.clickBreadCrumbScheduler();
		System.out.println("------- Completed --> attach_Event_5_To_Scheduler() -----------");
	}
	
	public void verify_Event_7_Attached_To_Survey_4() throws InterruptedException {
		this.verify_Survey_4_Title();
		this.click_Survey_4_Title();
		Thread.sleep(1000);
		this.verify_Event_7_Title_In_Survey();
		this.click_Event_7_Title();
		Thread.sleep(1000);
		this.verify_Delete_Button();
		this.verify_Event_7_Info();
		System.out.println("------- Completed --> verify_Event_Attached_To_Survey() -----------");
	}
	
	//--------------duplicate_Survey----------------------------------------
	By duplicate_Survey = By.xpath("//a[contains(text(),'Duplicate Survey')]");
	String surveyCopy = "This is a Survey Title - Duplicate";

	public void verifyDuplicateSurveyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(duplicate_Survey)));
	}
	
	public void verifyBreadCrumbWorkroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbWorkroom)));
	}
	
	public void clickDuplicateSurveyBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(duplicate_Survey).click();
	}
	
	public void enterSurveyTitle(String survey11) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).clear();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(survey11);
	}
	
	public void duplicate_Survey_10(String survey11) throws InterruptedException {
		this.click_Survey_10_Title();
		Thread.sleep(1000);
		this.verifyDuplicateSurveyBtn();
		this.clickDuplicateSurveyBtn();
		this.verifySurveyTitleInputField();
		this.enterSurveyTitle(survey11);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> duplicate_Survey() -----------");
	}
	
	//--------------move_Survey_To_Another_Workroom----------------------------------------
	By move_To_Dropdown = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By autoAttend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By move_Here = By.xpath("//button[@class='btn-sidebar move-btn btn-success']");
	By autoAttend_Workroom = By.xpath("//a[contains(text(),'AutoAttend')]");
	By autoAttend_2 = By.xpath("//a[contains(text(),'AutoAttend')]");

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
	
	
	public void move_Survey_16_To_Another_Workroom() throws InterruptedException {
		this.click_Survey_16_Title();
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
		System.out.println("------- Completed --> move_Survey_16_To_Another_Workroom() -----------");
	}
	
	public void verify_Move_To_Workroom_AutoAttend() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Library_Page();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSurveys();
		System.out.println("------- Completed --> verify_Move_To_Workroom_AutoAttend() -----------");
	}
	
	public void verify_Move_Scheduler_5_To_Workroom_AutoAttend() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Library_Page();
		this.verifyCollaborateActiveOff();
		this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		Thread.sleep(1000);
		this.verify_Schedulers_5_Dropdown();
		System.out.println("------- Completed --> verify_Move_Scheduler_5_To_Workroom_AutoAttend() -----------");
	}
	
	// ------------------add_File_To_Survey----------------------
	By addFile = By.xpath("//a[contains(text(),'Add a File')]");
	By addFileInputField = By.xpath("//a[contains(text(),'Add a File')]");
	By saveFileBtn = By.xpath("//div[@id='newSurveyFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By surveyFile = By.xpath("//a[contains(text(),'survey file')]");
	String filetitle = "survey file";
	
	public void verifyAddFileBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addFile)));
	}
	
	public void verifyAddFileInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addFileInputField)));
	}
	
	public void verifySurveyFileAdded() {
		String surveyFile = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(surveyFile)).size() > 0);
	}
	
	public void clickAddFileBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(addFile).click();
	}
	
	public void fileTitleSendKeys() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(addFileInputField).sendKeys(filetitle);
	}
	

	public void clickSaveFileBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveFileBtn).click();
	}
	
	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_To_Survey_1() throws InterruptedException {
		this.click_Survey_1_Title();
		this.verifyAddFileBtn();
		this.clickAddFileBtn();
		Thread.sleep(1000);
		this.verifyAddFileInputField();
		this.fileTitleSendKeys();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveFileBtn();
		Thread.sleep(1500);
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_File_To_Survey_1() -----------");
	}
	
	public void verify_File_Added_To_Survey_1() throws InterruptedException {
		this.click_Survey_1_Title();
		Thread.sleep(1000);
		this.verify_Edit_Survey_Settings();
		this.verifySurveyFileAdded();
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> verify_File_Added_To_Survey_1() -----------");
	}
	
	// ------------------edit/view_Survey_Settings----------------------
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	By content = By.xpath("//div[@class='content']");
	By edit = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Edit')]");
	By signature_Required = By.xpath("//input[@id='survey_signature_required']");
	By edit_Survey_Settings = By.xpath("//a[@class='primary-action-btn btn btn-default btn-sidebar secondary-action-btn left'][contains(text(),' Edit Survey Settings')]");

	public void verify_Settings_Page() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(content)));
	}
	
	public void verify_Edit_Survey_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Survey_Settings)));
	}
	
	public void verify_Settings_Content() {
		String title = "//label[contains(text(),'Title')]";
		String expDate = "//label[contains(text(),'Expiration Date')]";
		String reminderDate = "//label[contains(text(),'Reminder Date')]";
		String description = "//label[contains(text(),'Description')]";
		String notify = "//label[contains(text(),'Notify')]";
		String box2 = "//span[contains(text(),'Cannot be changed')]";
		String box9 = "//span[contains(text(),'Automatically number questions')]";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(expDate)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(reminderDate)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(description)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(notify)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(box2)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(box9)).size() > 0);
	}
	
	public void click_Settings() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(settings).click();
	}
	
	public void click_Edit() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit).click();
	}
	
	public void click_Allow_Comments() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(allow_Comments).click();
	}
	
	public void click_Allow_Edits() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(allow_Edit).click();
	}
	
	public void click_Edit_Survey_Settings() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Survey_Settings).click();
	}
	
	public void scroll_To_Signature_Reguired() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='survey_signature_required']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}

	public void view_Survey_13_Settings() throws InterruptedException {
		this.click_Survey_13_Dropdown();
		this.verify_Survey_13_Settings_Option();
		this.click_Survey_13_Settings();
		Thread.sleep(1500);
		this.verify_Settings_Page();
		this.verify_Settings_Content();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> view_Survey_Settings() -----------");
	}
		
	
	public void view_Survey_15_Settings() throws InterruptedException {
		this.click_Survey_15_Dropdown();
		this.verify_Survey_15_Settings_Option();
		this.click_Survey_15_Settings();
		Thread.sleep(1500);
		this.verify_Settings_Page();
		this.verify_Settings_Content();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> view_Survey_Settings() -----------");
	}
	public void edit_Survey_13_Settings() throws InterruptedException {
		this.click_Survey_13_Title();
		Thread.sleep(1000);
        this.verify_Edit_Survey_Settings();
        this.click_Edit_Survey_Settings();
		Thread.sleep(1000);
		this.verifySurveyTitleInputField();
		this.scroll_To_Signature_Reguired();
		this.click_Allow_Comments();
		Thread.sleep(1000);
        this.click_Allow_Edits();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);;
		this.verifyBreadCrumbWorkroom();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		System.out.println("------- Completed --> edit_Survey_Settings() -----------");
	}
	
		
	public void verify_Archived_Survey_2() throws InterruptedException {
		String element = "(//a[contains(text(),'This is a Survey Title')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void archive_Survey_2() throws InterruptedException {
		this.verify_Survey_2_Dropdown();
		this.click_Survey_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_2_Archive_Option();
		this.click_Survey_2_Archive_Option();
		Thread.sleep(1000);
		this.verifyArchiveCard();
		System.out.println("------- Completed --> archive_Survey() -----------");
	}
	
	// ------------------delete_Survey---------------------
	By copy_Option = By.xpath("//div[@class='dropdown header-actions open']//a[contains(text(),'Copy')]");

	
	//------------------new --------------------------
	By survey_Board_Member_Access_1_Dropdown = By.xpath("(//a[normalize-space(text()) ='Survey Board Member Access 1']/following::div[@class='dropdown header-actions'])[1]");
	By survey_Board_Member_Access_1_Dropdown_Delete_Option = By.xpath("//*[normalize-space(text())='Survey Board Member Access 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By survey_1_Title = By.xpath("//*[normalize-space(text())='Survey 1']");
	By survey_Title_2 = By.xpath("//*[normalize-space(text())='This is a Survey Title 2']");

	By survey_4_Title = By.xpath("//*[normalize-space(text())='Survey 4']");
	By survey_10_Title = By.xpath("//*[normalize-space(text())='Survey 10']");
	By survey_13_Title = By.xpath("//*[normalize-space(text())='Survey 13']");
	By survey_16_Title = By.xpath("//*[normalize-space(text())='Survey 16']");
	By survey_17_Title = By.xpath("//*[normalize-space(text())='Survey 17']");
	By survey_18_Title = By.xpath("//*[normalize-space(text())='Survey 18']");

	By survey_1_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 1']/following::div[@class='dropdown header-actions'])[1]");
	By survey_1_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_2_Archive_Option = By.xpath("(//*[normalize-space(text())='Survey 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')])[1]");
	By survey_2_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 2']/following::div[@class='dropdown header-actions'])[1]");
	By survey_2_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_3_Archive_Option = By.xpath("(//*[normalize-space(text())='Survey 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')])[1]");
	By survey_3_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 3']/following::div[@class='dropdown header-actions'])[1]");
	By survey_3_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_4_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 4']/following::div[@class='dropdown header-actions'])[1]");
	By survey_4_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 4']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_5_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 5']/following::div[@class='dropdown header-actions'])[1]");
	By survey_5_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By survey_5_Copy_Option = By.xpath("(//*[normalize-space(text())='Survey 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy')])[1]");

	By survey_5_Template_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 5 Template']/following::div[@class='dropdown header-actions'])[1]");
	By survey_5_Template_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 5 Template']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_6_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 6']/following::div[@class='dropdown header-actions'])[1]");
	By survey_6_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By survey_6_Copy_To_Template_Option = By.xpath("(//*[normalize-space(text())='Survey 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy to Template')])[1]");
	
	By survey_6_Template_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 6 Template']/following::div[@class='dropdown header-actions'])[1]");
	By survey_6_Template_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 6 Template']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_7_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 7']/following::div[@class='dropdown header-actions'])[1]");
	By survey_7_Edit_Option = By.xpath("(//*[normalize-space(text())='Survey 7']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')])[1]");
	By survey_7_Template_Edited_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 7 Template Edited']/following::div[@class='dropdown header-actions'])[1]");
	By survey_7_Template_Edited_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 7 Template Edited']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_8_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 8']/following::div[@class='dropdown header-actions'])[1]");
	By survey_8_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 8']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_9_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 9']/following::div[@class='dropdown header-actions'])[1]");
	By survey_9_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 9']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_10_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 10']/following::div[@class='dropdown header-actions'])[1]");
	By survey_10_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 10']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_11_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 11']/following::div[@class='dropdown header-actions'])[1]");
	By survey_11_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 11']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By survey_12_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 12']/following::div[@class='dropdown header-actions'])[1]");
	By survey_12_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 12']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_13_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 13']/following::div[@class='dropdown header-actions'])[1]");
	By survey_13_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 13']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By survey_13_Settings_Option = By.xpath("(//*[normalize-space(text())='Survey 13']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Settings')])[1]");

	By survey_14_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 14']/following::div[@class='dropdown header-actions'])[1]");
	By survey_14_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 14']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_15_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 15']/following::div[@class='dropdown header-actions'])[1]");
	By survey_15_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 15']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By survey_15_Settings_Option = By.xpath("(//*[normalize-space(text())='Survey 15']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Settings')])[1]");

	By survey_16_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 16']/following::div[@class='dropdown header-actions'])[1]");
	By survey_16_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 16']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_17_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 17']/following::div[@class='dropdown header-actions'])[1]");
	By survey_17_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 17']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_18_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 18']/following::div[@class='dropdown header-actions'])[1]");
	By survey_18_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 18']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_19_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 19']/following::div[@class='dropdown header-actions'])[1]");
	By survey_19_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 19']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By survey_20_Dropdown = By.xpath("(//*[normalize-space(text())='Survey 20']/following::div[@class='dropdown header-actions'])[1]");
	By survey_20_Delete_Option = By.xpath("(//*[normalize-space(text())='Survey 20']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	
	By event_7_Title = By.xpath("//*[normalize-space(text())='Event 7']");
	By delete_Button = By.xpath("//a[contains(text(),'Delete')]");

	
	public void verify_Survey_Board_Member_Access_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Board_Member_Access_1_Dropdown)));
	}
	
	public void verify_Survey_Board_Member_Access_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Board_Member_Access_1_Dropdown_Delete_Option)));
	}
	
	public void verify_Survey_4_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_4_Title)));
	}
	
	public void verify_Event_7_Title_In_Survey() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_7_Title)));
	}
	
	public void click_Survey_Board_Member_Access_1_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_Board_Member_Access_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_Board_Member_Access_1_Dropdown).click();
	}
	
	public void click_Survey_Board_Member_Access_1_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Board_Member_Access_1_Dropdown_Delete_Option).click();
	}
	
	public void click_Survey_1_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_1_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_1_Title).click();
	}
	
	public void click_Survey_16_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_16_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_16_Title).click();
	}
	
	public void click_Survey_17_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_17_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_17_Title).click();
	}
	
	public void click_Survey_18_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_18_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_18_Title).click();
	}
	
	public void click_Survey_10_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_10_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_10_Title).click();
	}
	
	public void click_Survey_13_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_13_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_13_Title).click();
	}
	
	public void click_Survey_4_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_4_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(survey_4_Title).click();
	}
	
	public void click_Event_7_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_7_Title).click();
	}
	
	//-----------------------------------

	public void verify_Delete_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(delete_Button)));
	}
	
	public void verify_Survey_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_1_Delete_Option)));
	}
	
	public void verify_Survey_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_1_Dropdown)));
	}
	
	public void verify_Survey_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_2_Delete_Option)));
	}
	
	public void verify_Survey_2_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_2_Archive_Option)));
	}
	
	public void verify_Survey_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_2_Dropdown)));
	}
	
	
	public void verify_Survey_3_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_3_Archive_Option)));
	}
	
	public void verify_Survey_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_3_Dropdown)));
	}
	
	public void verify_Survey_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_3_Delete_Option)));
	}
	
	public void verify_Survey_4_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_4_Dropdown)));
	}
	
	public void verify_Survey_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_4_Delete_Option)));
	}
	
	public void verify_Survey_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_5_Dropdown)));
	}
	
	public void verify_Survey_5_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_5_Copy_Option)));
	}
	
	public void verify_Survey_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_5_Delete_Option)));
	}
	
	public void verify_Survey_6_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_6_Dropdown)));
	}
	
	public void verify_Survey_6_Copy_To_Template_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_6_Copy_To_Template_Option)));
	}
	
	public void verify_Survey_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_6_Delete_Option)));
	}
	
	public void verify_Survey_7_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_7_Dropdown)));
	}
	
	public void verify_Survey_7_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_7_Edit_Option)));
	}
	
	public void verify_Survey_7_Template_Edited_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_7_Template_Edited_Dropdown)));
	}
	
	public void verify_Survey_7_Template_Edited_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_7_Template_Edited_Delete_Option)));
	}
	
	public void verify_Survey_8_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_8_Dropdown)));
	}
	
	public void verify_Survey_8_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_8_Delete_Option)));
	}
	
	public void verify_Survey_9_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_9_Dropdown)));
	}
	
	public void verify_Survey_9_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_9_Delete_Option)));
	}
	
	public void verify_Survey_10_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_10_Dropdown)));
	}
	
	public void verify_Survey_10_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_10_Delete_Option)));
	}
	
	public void verify_Survey_11_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_11_Dropdown)));
	}
	
	public void verify_Survey_11_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_11_Delete_Option)));
	}
	
	public void verify_Survey_12_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_12_Dropdown)));
	}
	
	public void verify_Survey_12_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_12_Delete_Option)));
	}
	
	public void verify_Survey_13_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_13_Dropdown)));
	}
	
	public void verify_Survey_13_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_13_Delete_Option)));
	}
	
	public void verify_Survey_13_Settings_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_13_Settings_Option)));
	}
	
	public void verify_Survey_14_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_14_Dropdown)));
	}
	
	public void verify_Survey_14_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_14_Delete_Option)));
	}
	
	public void verify_Survey_15_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_15_Dropdown)));
	}
	
	public void verify_Survey_15_Settings_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_15_Settings_Option)));
	}
	
	public void verify_Survey_15_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_15_Delete_Option)));
	}
	
	public void verify_Survey_16_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_16_Dropdown)));
	}
	
	public void verify_Survey_16_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_16_Delete_Option)));
	}
	
	public void verify_Survey_17_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_17_Dropdown)));
	}
	
	public void verify_Survey_17_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_17_Delete_Option)));
	}

	public void verify_Survey_18_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_18_Dropdown)));
	}
	
	public void verify_Survey_18_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_18_Delete_Option)));
	}
	
	public void verify_Survey_19_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_19_Dropdown)));
	}
	
	public void verify_Survey_19_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_19_Delete_Option)));
	}
	
	public void verify_Survey_20_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_20_Dropdown)));
	}
	
	public void verify_Survey_20_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_20_Delete_Option)));
	}
	
	public void verify_Survey_5_Template_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_5_Template_Dropdown)));
	}
	
	public void verify_Survey_5_Template_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_5_Template_Delete_Option)));
	}
	
	public void verify_Survey_6_Template_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_6_Template_Delete_Option)));
	}
	
	public void verify_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(copy_Option)));
	}

	public void click_Survey_1_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_1_Dropdown).click();
	}
	
	public void click_Survey_1_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_1_Delete_Option).click();
	}
	
	public void click_Survey_2_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_2_Archive_Option).click();
	}
	
	public void click_Survey_2_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_2_Dropdown).click();
	}
	
	public void click_Survey_2_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_2_Delete_Option).click();
	}
	
	public void click_Survey_3_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_3_Dropdown).click();
	}
	
	public void click_Survey_4_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_4_Dropdown).click();
	}
	
	public void click_Survey_5_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_5_Dropdown).click();
	}
	
	public void click_Survey_5_Template_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_5_Template_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_5_Template_Dropdown).click();
	}
	
	public void click_Survey_6_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_6_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_6_Dropdown).click();
	}
	
	public void click_Survey_6_Template_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_6_Template_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_6_Template_Dropdown).click();
	}
	
	public void click_Survey_7_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_7_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_7_Dropdown).click();
	}
	
	public void click_Survey_7_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_7_Edit_Option).click();
	}
	
	public void click_Survey_7_Template_Edited_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_7_Template_Edited_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_7_Template_Edited_Dropdown).click();
	}
	
	public void click_Survey_8_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_8_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_8_Dropdown).click();
	}
	
	public void click_Survey_9_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_9_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_9_Dropdown).click();
	}
	
	public void click_Survey_10_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_10_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_10_Dropdown).click();
	}
	
	public void click_Survey_11_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_11_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_11_Dropdown).click();
	}
	
	public void click_Survey_12_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_12_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_12_Dropdown).click();
	}
	
	public void click_Survey_13_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_13_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_13_Dropdown).click();
	}
	
	public void click_Survey_13_Settings() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_13_Settings_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_13_Settings_Option).click();
	}
	
	public void click_Survey_14_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_14_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_14_Dropdown).click();
	}
	
	public void click_Survey_14_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_14_Delete_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_14_Delete_Option).click();
	}
	
	public void click_Survey_15_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_15_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_15_Dropdown).click();
	}
	
	public void click_Survey_15_Settings() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_15_Settings_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_15_Settings_Option).click();
	}
	
	public void click_Survey_16_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_16_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_16_Dropdown).click();
	}
	
	public void click_Survey_17_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_17_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_17_Dropdown).click();
	}
	
	public void click_Survey_18_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_18_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_18_Dropdown).click();
	}
	
	public void click_Survey_19_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_19_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_19_Dropdown).click();
	}
	
	public void click_Survey_20_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_20_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_20_Dropdown).click();
	}
	
	public void click_Survey_Title_2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(survey_Title_2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(survey_Title_2).click();
	}
	
	public void click_Survey_3_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_3_Archive_Option).click();
	}
	
	public void click_Survey_3_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_3_Delete_Option).click();
	}
	
	public void click_Survey_4_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_4_Delete_Option).click();
	}
	
	public void click_Survey_5_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_5_Delete_Option).click();
	}
	
	public void click_Survey_5_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_5_Copy_Option).click();
	}
	
	public void click_Survey_5_Template_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_5_Template_Delete_Option).click();
	}

	public void click_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copy_Option).click();
	}
	
	public void click_Survey_6_Copy_To_Template_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_6_Copy_To_Template_Option).click();
	}
	
	public void click_Survey_6_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_6_Delete_Option).click();
	}
	
	public void click_Survey_6_Template_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_6_Template_Delete_Option).click();
	}
	
	public void click_Survey_7_Template_Edited_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_7_Template_Edited_Delete_Option).click();
	}
	
	public void click_Survey_8_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_8_Delete_Option).click();
	}
	
	public void click_Survey_9_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_9_Delete_Option).click();
	}
	
	public void click_Survey_10_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_10_Delete_Option).click();
	}
	
	public void click_Survey_11_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_11_Delete_Option).click();
	}
	
	public void click_Survey_12_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_12_Delete_Option).click();
	}
	
	public void click_Survey_13_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_13_Delete_Option).click();
	}
	
	public void click_Survey_15_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_15_Delete_Option).click();
	}
	
	public void click_Survey_16_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_16_Delete_Option).click();
	}
	
	public void click_Survey_17_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_17_Delete_Option).click();
	}
	
	public void click_Survey_18_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_18_Delete_Option).click();
	}
	
	public void click_Survey_19_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_19_Delete_Option).click();
	}
	
	public void click_Survey_20_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_20_Delete_Option).click();
	}
	
	public void delete_Survey_Board_Member_Access_1() throws InterruptedException {
		this.verify_Survey_Board_Member_Access_1_Dropdown();
		this.click_Survey_Board_Member_Access_1_Dropdown();
		this.verify_Survey_Board_Member_Access_1_Delete_Option();
		this.click_Survey_Board_Member_Access_1_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_Board_Member_Access_1() -----------");
	}
	
	public void delete_Survey_1() throws InterruptedException {
		this.verify_Survey_1_Dropdown();
		this.click_Survey_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_1_Delete_Option();
		this.click_Survey_1_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_1() -----------");
	}
	
	
	public void delete_Archived_Survey_2() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveys();
		Thread.sleep(1000);
		this.verifyArchiveBtn();
		this.clickArchiveBtn();
		Thread.sleep(1000);
		this.verifyArchiveCard();
		this.verify_Survey_2_Dropdown();
		this.click_Survey_2_Dropdown();
		this.verify_Survey_2_Delete_Option();
		this.click_Survey_2_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Archived_Survey_2() -----------");
	}
	
	public void delete_Survey_4() throws InterruptedException {
		this.verify_Survey_4_Dropdown();
		this.click_Survey_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_4_Delete_Option();
		this.click_Survey_4_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_4() -----------");
	}
	
	public void delete_Survey_5() throws InterruptedException {
		this.verify_Survey_5_Dropdown();
		this.click_Survey_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_5_Delete_Option();
		this.click_Survey_5_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_5() -----------");
	}
	
	public void delete_Survey_5_Template() throws InterruptedException {
		this.click_Survey_5_Template_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_5_Template_Delete_Option();
		this.click_Survey_5_Template_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifyNewSurveyTemplate();
		System.out.println("------- Completed --> delete_Survey_5_Template() -----------");
	}
	
	public void delete_Survey_6() throws InterruptedException {
		this.verify_Survey_6_Dropdown();
		this.click_Survey_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_6_Delete_Option();
		this.click_Survey_6_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_5() -----------");
	}
	
	public void delete_Survey_6_Template() throws InterruptedException {
		this.click_Survey_6_Template_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_6_Template_Delete_Option();
		this.click_Survey_6_Template_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifyNewSurveyTemplate();
		System.out.println("------- Completed --> delete_Survey_5_Template() -----------");
	}
	
	public void delete_Survey_8_Template() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verify_Survey_8_Dropdown();
		this.click_Survey_8_Dropdown();
		Thread.sleep(1000);
		this.click_Survey_8_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		System.out.println("------- Completed --> delete_Survey_8_Template() -----------");
	}
	
	public void delete_Survey_9_From_Template() throws InterruptedException {
		this.verify_Survey_9_Dropdown();
		this.click_Survey_9_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_9_Delete_Option();
		this.click_Survey_9_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_9_From_Template() -----------");
	}
	
	public void delete_Survey_10() throws InterruptedException {
		this.verify_Survey_10_Dropdown();
		this.click_Survey_10_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_10_Delete_Option();
		this.click_Survey_10_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_10() -----------");
	}
	
	public void delete_Survey_11() throws InterruptedException {
		this.verify_Survey_11_Dropdown();
		this.click_Survey_11_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_11_Delete_Option();
		this.click_Survey_11_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_11() -----------");
	}
	
	public void delete_Survey_12() throws InterruptedException {
		this.verify_Survey_12_Dropdown();
		this.click_Survey_12_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_12_Delete_Option();
		this.click_Survey_12_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_11() -----------");
	}
	
	public void delete_Survey_13() throws InterruptedException {
		this.verify_Survey_13_Dropdown();
		this.click_Survey_13_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_13_Delete_Option();
		this.click_Survey_13_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_11() -----------");
	}
	
	public void delete_Survey_14() throws InterruptedException {
		this.verify_Survey_14_Dropdown();
		this.click_Survey_14_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_14_Delete_Option();
		this.click_Survey_14_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_11() -----------");
	}
	
	public void delete_Survey_15() throws InterruptedException {
		this.verify_Survey_15_Dropdown();
		this.click_Survey_15_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_15_Delete_Option();
		this.click_Survey_15_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_11() -----------");
	}
	
	public void delete_Survey_16() throws InterruptedException {
		this.verify_Survey_16_Dropdown();
		this.click_Survey_16_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_16_Delete_Option();
		this.click_Survey_16_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_16() -----------");
	}
	
	public void delete_Survey_17() throws InterruptedException {
		this.verify_Survey_17_Dropdown();
		this.click_Survey_17_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_17_Delete_Option();
		this.click_Survey_17_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_17() -----------");
	}
	
	public void delete_Survey_18() throws InterruptedException {
		this.verify_Survey_18_Dropdown();
		this.click_Survey_18_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_18_Delete_Option();
		this.click_Survey_18_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_18() -----------");
	}
	
	public void delete_Survey_19() throws InterruptedException {
		this.verify_Survey_19_Dropdown();
		this.click_Survey_19_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_19_Delete_Option();
		this.click_Survey_19_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_19() -----------");
	}
	
	public void delete_Survey_20() throws InterruptedException {
		this.verify_Survey_20_Dropdown();
		this.click_Survey_20_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_20_Delete_Option();
		this.click_Survey_20_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Survey_20() -----------");
	}
	
	// ------------------Survey_Not_Visible----------------------
	By survey_14_Not_Visible = By.xpath("(//*[normalize-space(text())='Survey 14']/following::span[@class='icon icon_mbm-notvisible active-off'])[1]");
	By notVisibleSurveys = By.xpath("//a[contains(text(),'Not Visible Surveys')]");

	public void click_Survey_14_Not_Visible() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_14_Not_Visible).click();
	}
	
	public void click_Not_Visible_Surveys() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(notVisibleSurveys).click();
	}
	
	//--------------verify survey not exist ---------------
	
	public void disable_Survey_14_Visiblility() throws InterruptedException {
		this.click_Survey_14_Not_Visible();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.click_Not_Visible_Surveys();
		Thread.sleep(2000);
		this.verify_Survey_14_Dropdown();
		System.out.println("------- Completed --> disable_Survey_Visiblility() -----------");
	}
	// ------------------create_Survey_Template----------------------
	By surveys = By.xpath("//a[contains(text(),'Surveys')]");
	By surveyTemplate = By.xpath("//a[contains(text(),'Survey Templates')]");
	By newSurveyTemplate = By.xpath("//a[@class='btn btn-success'][contains(text(),'New Survey Template')]");
	By templateSucessMessage = By.xpath("//p[contains(text(),'Successfully')]");
	By editedSurveyTemplateDropdown = By.xpath("(//a[contains(text(),'Edited Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]");
	By editTemplate = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Edit')]");
	By saveBtn2 = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By archive = By.xpath("//li[@class='no-mobile']//a[contains(text(),'Archive')]");
	By archiveCard = By.xpath("//div[@id='archived-surveys']");
	By archiveBtn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");
	By archivedSurveyTemplate = By.xpath("(//a[contains(text(),'Survey Template Title')]/following::button[@id='dropdownMenu1'])[1]");
	By copyTemplate = By.xpath("//li[5]//a[1][contains(text(),'Copy')]");
	By copyToTemplate = By.xpath("//a[contains(text(),'Copy to Template')]");
	By templateDropDown = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By survey_8_Template = By.xpath("//span[contains(text(),'Survey 8')]");
	By newSurveyTemplateTitle = By.xpath("//h1[contains(text(),'New')]");
	By newSurveyFromTemplateDropDown = By.xpath("(//a[contains(text(),'New Survey From Survey Template')]/following::button[@id='dropdownMenu1'])[1]");
	By editSurveyQuestions = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Survey Questions')]");
	By surveyVisible = By.xpath("//span[contains(text(),'Survey Is Visible')]");

	String surveyTemplateTitle = "Survey Template Title";
	String surveyTemplateTitle2 = "Edited Survey Template Title";
	String surveyTemplateTitle3 = "Survey Template Title - Copy";

	public void verifyNewSurveyTemplate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyTemplate)));
	}
	
	public void verifyTemplateSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(templateSucessMessage)));
	}
	
	public void verifyEditedSurveyTemplateDropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editedSurveyTemplateDropdown)));
	}
	
	public void verifyWorkroomBreachCrumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbWorkroom)));
	}
	
	public void verifyArchiveCard() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(archiveCard)));
	}
	
	public void verifyArchiveBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveBtn)));
	}
	
	public void verify_Survey_8_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(survey_8_Template)));
	}
	
	public void verifySurveyTemplateCreated() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(templateSucessMessage)));
	}
	
	public void verifyEditSurveyQuestions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editSurveyQuestions)));
	}
	
	public void verifySurveyVisible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(surveyVisible)));
	}
	
	public void verifyNewSurveyFromTemplate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSurveyFromTemplateDropDown)));
	}
	
	public void clickSurveyTemplate() {
		DriverFactory.getInstance().getDriver().findElement(surveyTemplate).click();
	}
	
	public void clickNewSurveyTemplate() {
		DriverFactory.getInstance().getDriver().findElement(newSurveyTemplate).click();
	}
	
	public void enterSurveyTemplateTitle2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).clear();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(surveyTemplateTitle2);
	}
	
	public void enterSurveyTemplateTitle(String survey5template) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).clear();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(survey5template);
	}
	
	
	public void verify_Survey_Board_Member_Access_1_NOT_VISIBLE() {
		String survey = "//*[normalize-space(text()) ='Survey Board Member Access 1']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(survey)).size() < 1);
	}
	
	public void verify_Survey_Template_3_Info_Created() throws InterruptedException {
		String question1 = "//p[contains(text(),'what happened to the good old days?')]";
		String question2 = "//p[contains(text(),'what happened to Gilbert Grape?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() != 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question2)).size() != 0);
	}
	
	public void verify_Survey_4_NOT_Exist() {
		String survey = "//h3//a[normalize-space(text())='Survey 4']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(survey)).size() < 1);
	}
	
	public void verify_Survey_5_Template() throws InterruptedException {
		String template = "//a[contains(text(),'Survey 5 Template')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template)).size() > 0);
	}
	
	public void verify_Survey_5_And_Survey_5_Template_Deleted() throws InterruptedException {
		String template = "//*[normalize-space(text())= 'Survey 5 Template']";
		String template2 = "//*[normalize-space(text())= 'Survey 5']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template2)).size() < 1);
		System.out.println("------- Completed --> verify_Survey_5_And_Survey_5_Template_Deleted() -----------");
	}
	
	public void verify_Survey_6_Template_Copy_Exists() throws InterruptedException {
		String template = "//a[contains(text(),'Survey 6 Template')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template)).size() > 0);
	}
	
	public void verify_Survey_6_And_Survey_6_Template_Deleted() throws InterruptedException {
		String template = "//*[normalize-space(text())= 'Survey 6 Template']";
		String template2 = "//*[normalize-space(text())= 'Survey 6']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template2)).size() < 1);
		System.out.println("------- Completed --> verify_Survey_6_And_Survey_6_Template_Deleted() -----------");
	}
	
	public void verify_Survey_7_Survey_7_Template_Edited_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Survey 7')]/following::button[@id='dropdownMenu1'])[1]";
		String element2 = "(//a[contains(text(),'Survey 7 Template Edited')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() < 1);
		
		System.out.println("------- Completed --> verify_Survey_7_Survey_7_Template_Edited_Deleted-----------");
	}
	
	public void verify_Survey_10_Survey_11_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 10']/following::button[@id='dropdownMenu1'])[1]";
		String element2 = "(//*[normalize-space(text())='Survey 11 Template Edited']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() < 1);
		
		System.out.println("------- Completed --> verify_Survey_10_Survey_11_Deleted-----------");
	}
	
	public void verify_Survey_12_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 12']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_13_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 13']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_14_Is_NOT_Visible() {
		By surveyNotVisible = By.xpath("(//*[normalize-space(text())='Survey 14']/following::a[@class='btn btn-default be-negative'])[1]");
		WebElement survey = DriverFactory.getInstance().getDriver().findElement(surveyNotVisible);
		Assert.assertEquals(true, survey.isEnabled());
	}
	
	public void verify_Survey_15_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 15']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_16_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 16']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_17_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 17']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_18_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 18']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_19_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 19']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_20_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 20']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Archived_Survey_3_Template() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 3']/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Archived_Survey_3_Template_NOT_Present() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 3']/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Survey_2_NOT_Present() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 2']/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		System.out.println("------- Completed --> verify_Archives_NOT_Present() -----------");
	}
	
	public void verify_Survey_8_Template_Deleted() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Survey 8']/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		
	}
	
	public void verify_Edited_Changes() throws InterruptedException {
		String title = "//h1[contains(text(),'This is an Edited Schedulers Title')]";
		String textBoxMessage = "//*[contains(text(),'This is an edited text box message')]";
		String attachment = "//*[@id=\"survey_files\"]/ul/li[contains(.,'Word_1.docx')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(textBoxMessage)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(attachment)).size() > 0);
	}
	
	
	public void clickEditedSurveyTemplateDropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(editedSurveyTemplateDropdown).click();
	}
	
	public void clickEditTemplate() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(editTemplate).click();
	}
	
	public void clickArchiveTemplate() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(editTemplate).click();
	}
	
	public void clickArchiveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(archiveBtn).click();
	}
	
	public void clickArchivedSurveyTemplateDropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(archivedSurveyTemplate).click();
	}

	public void clickCopyTemplate() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copyTemplate).click();
	}
	
	public void clickCopyTemplateToTemplate() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copyToTemplate).click();
	}
	
	public void clickTemplateDropDown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(templateDropDown).click();
	}
	
	public void click_Survey_8_Template() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_8_Template).click();
	}
	
	public void clickNewSurveyFromTemplateDropDown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(newSurveyFromTemplateDropDown).click();
	}
	
	public void clickSurveys2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveys).click();
	}
		
	public void clickSaveBtn2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(saveBtn2).click();
	}
	
	
	// ------------------ Iframe Text Box Send Keys ---------------------
	public void surveyTemplateDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a an Edited Message");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	// ------------------ Functions ----------------------
	public void create_Survey_Template(String survey3) throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verifyNewSurveyTemplate();
		this.clickNewSurveyTemplate();
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle(survey3);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verifyTemplateSucessMessage();
		System.out.println("------- Completed --> create_Survey_Template() -----------");
	}
	
	public void copy_Survey_5_As_Template(String survey5template) throws InterruptedException {
		this.click_Survey_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_5_Copy_Option();
		this.click_Survey_5_Copy_Option();
		Thread.sleep(1500);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle(survey5template);
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Survey_Template() -----------");
	}
	
	public void copy_Survey_Template_To_Template(String survey6template) throws InterruptedException {
		this.click_Survey_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_6_Copy_To_Template_Option();
		this.click_Survey_6_Copy_To_Template_Option();
		Thread.sleep(1000);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle(survey6template);
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyWorkroomBreachCrumb();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Survey_Template() -----------");
	}
	
	public void clickandTypeSurveyTitleInputField2(String surveytitle2) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).click();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(surveytitle2);
	}

	// ------------------ Functions ----------------------
	public void create_Survey_From_Survey_Template(String surveytitle2) throws InterruptedException {
		this.clickSurveys2();
		Thread.sleep(1000);
		this.verifyNewSurveyBtn();
		this.clickNewSurveyBtn();
		this.verifySurveyTitleInputField();
		this.clickandTypeSurveyTitleInputField2(surveytitle2);
		Thread.sleep(2000);
		this.clickTemplateDropDown();
		Thread.sleep(1000);
		this.verify_Survey_8_Template();
		this.click_Survey_8_Template();
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveyTemplateCreated();
		System.out.println("------- Completed --> create_Survey_From_Survey_Template() -----------");
	}
	
	public void build_Survey_Template_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1000);
		this.verifyEditSurveyQuestions();
		Thread.sleep(1000);
		this.clickSurveyBtnOn();
		Thread.sleep(1000);
		this.verifySurveyVisible();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> build_Survey_Template_Make_Visible() -----------");
	}
	
	public void back_To_Survey_Template_Home_Page() throws InterruptedException {
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(1000);
		this.verifyNewSurveyTemplate();
		System.out.println("------- Completed --> back_To_Survey_Template_Home_Page() -----------");
	}
	
	public void back_To_Survey_Template_Home_Page_Short() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(1000);
		this.verifyNewSurveyTemplate();
		System.out.println("------- Completed --> back_To_Survey_Template_Home_Page_Short() -----------");
	}
	
	public void edit_Survey_7_Template(String survey7templateedited) throws InterruptedException {
		this.click_Survey_7_Dropdown();
		Thread.sleep(1000);
		this.click_Survey_7_Edit_Option();
		Thread.sleep(1000);
		this.verifySurveyTitleInputField();
		this.enterSurveyTemplateTitle(survey7templateedited);
		Thread.sleep(1000);
		this.surveyTemplateDescriptionTextBox();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyWorkroomBreachCrumb();
		this.clickBreadCrumbWorkroom();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Survey_Template_Title() -----------");
	}
	
	public void archive_Survey_3_Template() throws InterruptedException {
		this.verify_Survey_3_Dropdown();
		this.click_Survey_3_Dropdown();
		Thread.sleep(1500);
		this.verify_Survey_3_Archive_Option();
		this.click_Survey_3_Archive_Option();
		Thread.sleep(1500);
		this.verifyArchiveCard();
		this.verify_Archived_Survey_3_Template();
		System.out.println("------- Completed --> archive_Survey_Template() -----------");
	}
	
	// ------------------ Functions ----------------------
	public void delete_Archived_Survey_3_Template() throws InterruptedException {
		this.click_Survey_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_3_Delete_Option();
		this.click_Survey_3_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Archived_Template_Survey() -----------");
	}

	public void delete_Survey_7_Template_Edited() throws InterruptedException {
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		this.verify_Survey_7_Template_Edited_Dropdown();
		this.click_Survey_7_Template_Edited_Dropdown();
		Thread.sleep(1000);
		this.verify_Survey_7_Template_Edited_Delete_Option();
		this.click_Survey_7_Template_Edited_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verifyworkroomSubnav();
		this.clickSurveyTemplate();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Template_Survey() -----------");
	}
	
	// ------------------ schedulers ----------------------
	By schedulers = By.xpath("//a[contains(text(),'Schedulers')]");
	By newSchedulers = By.xpath("//a[@class='btn btn-success'][contains(text(),'New Scheduler')]");
	By newOption = By.xpath("(//a[contains(.,' New Option')])[1]");
	By newOptionBox = By.xpath("//h4[contains(text(),'New Option')]");
	By breadCrumbScheduler = By.xpath("//a[contains(text(),'Workroom Schedulers')]");
	By edited_Schedulers_Title_Dropdown = By.xpath("(//a[contains(text(),'This is an Edited Schedulers Title')]/following::div[@class='dropdown header-actions'])[1]");

	By schedulers_1_Dropdown = By.xpath("(//a[contains(text(),'Schedulers 1')]/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_1_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By scheduler_Settings_Option = By.xpath("(//*[normalize-space(text())='Schedulers 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Settings')])[1]");
	By schedulers_2_Dropdown = By.xpath("(//a[contains(text(),'Schedulers 2')]/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_2_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By schedulers_2_Archive_Option = By.xpath("(//*[normalize-space(text())='Schedulers 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')])[1]");

	By schedulers_3_Dropdown = By.xpath("(//*[normalize-space(text())='Schedulers 3']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_3_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By schedulers_4_Dropdown = By.xpath("(//*[normalize-space(text())='Schedulers 4']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_4_Edit_Option = By.xpath("(//*[normalize-space(text())='Schedulers 4']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')])[1]");

	By schedulers_5_Dropdown = By.xpath("(//*[normalize-space(text())='Schedulers 5']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_5_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	
	By schedulers_6_Dropdown = By.xpath("(//*[normalize-space(text())='Schedulers 6']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_6_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");
	By schedulers_6_Results_Option = By.xpath("(//*[normalize-space(text())='Schedulers 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Results')])[1]");

	By schedulers_Title_Dropdown = By.xpath("(//*[normalize-space(text())='This is a Schedulers Title']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_Title_Copy_Option = By.xpath("(//*[normalize-space(text())='This is a Schedulers Title']/following::div[@class='dropdown header-actions open']/ul/child::li[contains(.,'Copy')])[1]");

	By schedulers_Title_Copy_Dropdown = By.xpath("(//*[normalize-space(text())='This is a Schedulers Title - Copy']/following::div[@class='dropdown header-actions'])[1]");
	By schedulers_Title_Copy_Delete_Option = By.xpath("(//*[normalize-space(text())='This is a Schedulers Title - Copy']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By edited_Schedulers_4_Dropdown = By.xpath("(//*[normalize-space(text())='Schedulers 4 Edited']/following::div[@class='dropdown header-actions'])[1]");
	By edited_Schedulers_4_Delete_Option = By.xpath("(//*[normalize-space(text())='Schedulers 4 Edited']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')])[1]");

	By schedulers_Title = By.xpath("//a[contains(text(),'This is a Schedulers Title')]");
	By schedulers_5_Title = By.xpath("//*[normalize-space(text())='Schedulers 5']");
	By schedulers_6_Title = By.xpath("//*[normalize-space(text())='Schedulers 6']");

	By respondAs = By.xpath("//select[@id='respond_as']");
	By user_AutomationTester = By.xpath("//option[contains(text(),'Automation Tester')]");
	By firstDateCheckBox = By.xpath("(//input[starts-with (@id,'survey_answers_')])[1]");
	By secondDateCheckBox = By.xpath("(//input[starts-with (@id,'survey_answers_')])[2]");
	By schedulerSucessMessage = By.xpath("//p[contains(text(),'Successfully')]");
	By schedulerQuestion = By.xpath("//p[contains(text(),'what happened to the good old days?')]");
	By pdf = By.partialLinkText("PDF");
	By excel = By.partialLinkText("Excel");
	
	String schedulersTitle = "This is a Schedulers Title";
	String editedSchedulersTitle = "This is an Edited Schedulers Title";
	String location = "NC";
	
	public void verifyNewSchedulers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newSchedulers)));
	}
	
	public void verifySchedulersTitleDropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title_Dropdown)));
	}
	
	public void verifyEditedSchedulersTitleDropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Schedulers_Title_Dropdown)));
	}
	public void verifySchedulerTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveyTitleInputField)));
	}
	
	public void verifyNewOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newOption)));
	}
	
	public void verifyNewOptionBox() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newOptionBox)));
	}
	
	public void verify_Schedulers_Title_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title_Copy_Option)));
	}
	
	public void verify_Schedulers_Title_Copy_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title_Copy_Delete_Option)));
	}
	
	public void verify_Schedulers_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_1_Dropdown)));
	}
	
	public void verify_Schedulers_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_1_Delete_Option)));
	}
	
	public void verify_Schedulers_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_2_Dropdown)));
	}
	
	public void verify_Schedulers_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_3_Dropdown)));
	}
	
	public void verify_Schedulers_4_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_4_Dropdown)));
	}
	
	public void verify_Schedulers_4_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_4_Edit_Option)));
	}
	
	public void verify_Schedulers_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_5_Dropdown)));
	}
	
	public void verify_Schedulers_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_2_Delete_Option)));
	}
	
	public void verify_Schedulers_2_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_2_Archive_Option)));
	}
	
	public void verify_Schedulers_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_3_Delete_Option)));
	}
	
	public void verify_Schedulers_4_Edited_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Schedulers_4_Dropdown)));
	}
	
	public void verify_Edited_Schedulers_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Schedulers_4_Delete_Option)));
	}
	
	public void verify_Schedulers_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_5_Delete_Option)));
	}
	
	public void verify_Schedulers_6_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_6_Title)));
	}
	
	public void verify_Schedulers_6_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_6_Dropdown)));
	}
	
	public void verify_Schedulers_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_6_Delete_Option)));
	}
	
	public void verify_Schedulers_6_Results_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_6_Results_Option)));
	}
	
	
	public void verify_Schedulers_Settings_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(scheduler_Settings_Option)));
	}
	
	public void verify_Schedulers_Title_Copy_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title_Copy_Dropdown)));
	}
	
	public void verifySchedulersTitle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulers_Title)));
	}
	
	public void verifySchedulerSucessMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(schedulerSucessMessage)));
	}
	
	public void verifyBreadCrumbScheduler() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(breadCrumbScheduler)));
	}
	
	public void clickSchedulersSubNav() {
		DriverFactory.getInstance().getDriver().findElement(schedulers).click();
	}
	
	public void clickNewSchedulersBtn() {
		DriverFactory.getInstance().getDriver().findElement(newSchedulers).click();
	}
	
	public void clickTypeSchedulersTitleField(String scheduler1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).clear();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(scheduler1);
	}
	
	public void editSchedulersTitleField(String schedulers4edited) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).clear();
		DriverFactory.getInstance().getDriver().findElement(surveyTitleInputField).sendKeys(schedulers4edited);
	}
	
	public void clickNewOption() {
		DriverFactory.getInstance().getDriver().findElement(newOption).click();
	}
	
	public void clickBreadCrumbScheduler() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(breadCrumbScheduler).click();
		Thread.sleep(1000);
	}
	
	public void click_Schedulers_Title_Copy_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Dropdown).click();
	}
	
	public void click_Schedulers_Title_Copy_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Delete_Option).click();
	}
	
	public void click_Schedulers_Title_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_1_Delete_Option).click();
	}
	
	public void click_Schedulers_Title_Copy_Option() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Option).click();
	}
	
	public void click_Schedulers_Title_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Dropdown).click();
	}
	
	public void click_Schedulers_1_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_1_Dropdown).click();
	}
	
	public void click_Schedulers_2_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_2_Dropdown).click();
	}
	
	public void click_Schedulers_3_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_3_Dropdown).click();
	}
	
	public void click_Schedulers_4_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_4_Dropdown).click();
	}
	
	public void click_Schedulers_4_Edited_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(edited_Schedulers_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(edited_Schedulers_4_Dropdown).click();
	}
	
	public void click_Schedulers_5_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_5_Dropdown).click();
	}
	
	public void click_Schedulers_6_Dropdown() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_6_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_6_Dropdown).click();
	}
	
	public void click_Edited_Schedulers_Title_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(edited_Schedulers_Title_Dropdown).click();
	}
	
	public void click_Schedulers_1_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_1_Delete_Option).click();
	}
	
	
	public void click_Schedulers_2_Archive_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_2_Archive_Option).click();
	}
	
	public void click_Schedulers_2_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_2_Delete_Option).click();
	}
	
	public void click_Schedulers_3_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_3_Delete_Option).click();
	}
	
	public void click_Schedulers_4_Edited_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(edited_Schedulers_4_Delete_Option).click();
	}
	
	public void click_Schedulers_4_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(schedulers_4_Edit_Option).click();
	}
	
	public void click_Schedulers_5_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_5_Delete_Option).click();
	}
	
	public void click_Schedulers_6_Results_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_6_Results_Option).click();
	}
	
	public void click_Schedulers_6_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_6_Delete_Option).click();
	}

//	public void click_Schedulers_Title_Copy_Dropdown() {
//		DriverFactory.getInstance().getDriver().findElement(schedulers_Title_Copy_Dropdown).click();
//	}
	
	public void click_Schedulers_5_Title() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_5_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_5_Title).click();
	}
	
	public void click_Schedulers_6_Title() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(schedulers_6_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(schedulers_6_Title).click();
	}
	
	public void click_Schedulers_1_Settings_Option() {
		DriverFactory.getInstance().getDriver().findElement(scheduler_Settings_Option).click();
	}

	public void typeInSchedulersTextBox() throws InterruptedException {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	public void formCalendarUpComingDate() throws InterruptedException {
		By startDate = By.xpath("//input[@id='survey_question_values_1_value_datetime']");
		By EndDate = By.xpath("//input[@id='survey_question_values_1_value_datetime_end']");
		By form_Location = By.xpath("//input[@id='survey_question_values_1_value_location']");
		//-----
		By startDate2 = By.xpath("//input[@id='survey_question_values_2_value_datetime']");
		By EndDate2 = By.xpath("//input[@id='survey_question_values_2_value_datetime_end']");
		By form_Location2 = By.xpath("//input[@id='survey_question_values_2_value_location']");
		//------
		By startDate3 = By.xpath("//input[@id='survey_question_values_3_value_datetime']");
		By EndDate3 = By.xpath("//input[@id='survey_question_values_3_value_datetime_end']");
		By form_Location3 = By.xpath("//input[@id='survey_question_values_3_value_location']");

		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 3); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionStart).click();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(strDateTwo);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		
		//--------
		DriverFactory.getInstance().getDriver().findElement(startDate2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate2).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate2).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate2).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate2).sendKeys(strDateTwo);
		DriverFactory.getInstance().getDriver().findElement(form_Location2).sendKeys(location);
		
		//--------
		DriverFactory.getInstance().getDriver().findElement(startDate3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate3).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate3).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate3).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate3).sendKeys(strDateTwo);
		DriverFactory.getInstance().getDriver().findElement(form_Location3).sendKeys(location);
	}
	
	public void clickRespondAs() {
		DriverFactory.getInstance().getDriver().findElement(respondAs).click();
	}
	
	public void clickOptionAutomationTester() {
		DriverFactory.getInstance().getDriver().findElement(user_AutomationTester).click();
	}
	
	public void clickFirstDateCheckBox() {
		DriverFactory.getInstance().getDriver().findElement(firstDateCheckBox).click();
	}
	
	public void clickSecondDateCheckBox() {
		DriverFactory.getInstance().getDriver().findElement(secondDateCheckBox).click();
	}
	
	public void clickSchedulersTitle() {
		DriverFactory.getInstance().getDriver().findElement(schedulers_Title).click();
	}
	
	public void click_PDF() {
		DriverFactory.getInstance().getDriver().findElement(pdf).click();
	}
	
	public void click_Excel() {
		DriverFactory.getInstance().getDriver().findElement(excel).click();
	}
	
	public void verify_Scheduler_Question_And_Chart() throws InterruptedException {
		String question1 = "//p[contains(text(),'This is a test that sending text through iframes w')]";
		String highChart = "//div[@id='highcharts-0']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(highChart)).size() > 0);
	}
	
	public void verify_Edited_Schedulers_4_Changes() throws InterruptedException {
		String title = "//h1[contains(text(),'Schedulers 4 Edited')]";
		String textBoxMessage = "//*[contains(text(),'This is an edited text box message')]";
		String attachment = "//*[@id=\"survey_files\"]/ul/li[contains(.,'Word_1.docx')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(textBoxMessage)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(attachment)).size() > 0);
	}
	
	public void verify_Orginal_Changes() throws InterruptedException {
		String title = "//h1[contains(text(),'This is a Schedulers Title')]";
		String textBoxMessage = "//*[contains(text(),'This is a test that sending text through iframes work!')]";
		String attachment = "//*[@id=\"survey_files\"]/ul/li[contains(.,'Word_1.docx')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(textBoxMessage)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(attachment)).size() > 0);
	}
	
	public void editedDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(500);
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is an edited text box message");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}

	public void create_Scheduler(String scheduler1) throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		this.verifyNewSchedulers();
		this.clickNewSchedulersBtn();
		this.verifySurveyTitleInputField();
		this.clickTypeSchedulersTitleField(scheduler1);
		this.surveyDescriptionTextBox();
		this.clickSaveBtn();
		this.verifySurveySucessMessage();
		System.out.println("------- Completed --> create_Scheduler() -----------");
	}
	
	public void navigate_To_Existing_Scheduler() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		this.verifyNewSchedulers();
		System.out.println("------- Completed --> navigate_To_Existing_Scheduler() -----------");
	}
	
	//---------------------------------------------
	
	By saveButton = By.xpath("//form/aside/button[contains(text(),'Save')]");
	
	public void click_Save_Button() {
		DriverFactory.getInstance().getDriver().findElement(saveButton).click();
	}
	
	public void copy_Scheduler() throws InterruptedException {
		// ---Text Field Question------
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_Title_Copy_Option();
		this.click_Schedulers_Title_Copy_Option();
		Thread.sleep(1000);
		this.click_Save_Button();
		Thread.sleep(1000);
		this.verifySurveySucessMessage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Scheduler() -----------");
	}
	
	public void create_Schedulers_Option() throws InterruptedException {
		// ---Text Field Question------
		this.verifyNewOption();
		this.clickNewOption();
		this.verifyNewOptionBox();
		this.typeInSchedulersTextBox();
		this.formCalendarUpComingDate();
		this.clickSaveBtnBox();
		Thread.sleep(1500);
		this.verifySurveySucessMessage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> create_Schedulers_Option() -----------");
	}
	
	public void build_Schedulers_Make_Visible() throws InterruptedException {
		this.clickBuildBtn();
		Thread.sleep(1000);
		this.verifySubmitBtn();
		this.clickSurveyBtnOn();		
		Thread.sleep(1000);
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifyNewSchedulers();
		System.out.println("------- Completed --> build_Scheduler_Make_Visible() -----------");
	}
	
	public void nonAdmin_Navigates_To_Schedulers() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_navigates_To_Schedulers() -----------");
	}
	
	public void admin_Navigates_To_Schedulers() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Collaborate();
		this.verifyworkroomSubnav();
		this.clickSchedulersSubNav();
		Thread.sleep(1000);
		this.verifyNewSchedulers();
		System.out.println("------- Completed --> user_navigates_To_Schedulers() -----------");
	}
	
	public void respond_To_Scheduler_6() throws InterruptedException {
		this.verify_Schedulers_6_Title();
		this.click_Schedulers_6_Title();
		Thread.sleep(1000);
		this.verify_Submit();
		this.clickSecondDateCheckBox();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(submitBtn).click();
		Thread.sleep(1000);
		this.verifySchedulerSucessMessage();
		System.out.println("------- Completed --> respond_To_Scheduler_6() -----------");
	}
	
	public void view_Schedulers_6_Reponses_Non_Admin() throws InterruptedException {
		this.verify_Schedulers_6_Dropdown();
		this.click_Schedulers_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_6_Results_Option();
		this.click_Schedulers_6_Results_Option();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Scheduler_Question_And_Chart();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Schedulers_6_Reponses_Non_Admin() -----------");
	}
	
	public void view_Schedulers_Reponses_As_Admin() throws InterruptedException {
		this.verifySchedulersTitle();
		this.clickSchedulersTitle();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Results();
		Thread.sleep(1000);
		this.verify_Results_Summary();
		this.click_Results_Summary();
		Thread.sleep(1000);
		this.verify_Individual_Results_Button();
		this.verify_Scheduler_Question_And_Chart();
		System.out.println("------- Completed --> view_Schedulers_Reponses_As_Admin() -----------");
	}
	
	
	//----switch tab pdf -----
	By download_Report_Btn = By.xpath("//a[@id='download_report_button']");
	
	public void verify_Download_Report_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(download_Report_Btn)));
	}
	
	public void switch_Tab_Verify_Job_Progress_Download_Btn() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		this.verify_Download_Report_Btn();
		DriverFactory.getInstance().getDriver().close();
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}

	public void download_Schedulers_As_PDF() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifySchedulersTitle();
		System.out.println("------- Completed --> download_As_PDF() -----------");
	}
	
	public void download_Schedulers_As_Excel() throws InterruptedException {
		this.click_Excel();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verifySchedulersTitle();
		System.out.println("------- Completed --> download_As_Excel() -----------");
	}
	
	public void download_Survey_As_PDF() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbWorkroom(); // survey bread crumb
		Thread.sleep(1000);
		System.out.println("------- Completed --> download_Survey_As_PDF() -----------");
	}
	
	public void download_Survey_As_Excel() throws InterruptedException {
		this.click_PDF();
		Thread.sleep(1000);
		this.switch_Tab_Verify_Job_Progress_Download_Btn();
		this.clickBreadCrumbWorkroom();// survey bread crumb
		Thread.sleep(1000);
		System.out.println("------- Completed --> download_Survey_As_Excel() -----------");
	}
	
	//---------------------------------------
	
	public void verify_Archived_Schedulers_2() throws InterruptedException {
		String element = "(//a[contains(text(),'Schedulers 2')]/following::button[@id='dropdownMenu1'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void archive_Schedulers_2() throws InterruptedException {
		this.click_Schedulers_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_2_Archive_Option();
		this.click_Schedulers_2_Archive_Option();
		Thread.sleep(1000);
		this.verifyArchiveCard();
		this.verify_Archived_Schedulers_2();
		System.out.println("------- Completed --> archive_Schedulers_2() -----------");
	}
	
	public void verify_Schedulers_Settings() {
		String title = "//label[contains(text(),'Title')]";
		String expDate = "//label[contains(text(),'Expiration Date')]";
		String reminderDate = "//label[contains(text(),'Reminder Date')]";
		String description = "//label[contains(text(),'Description')]";
		String notify = "//label[contains(text(),'Notify')]";
		String box1 = "//span[contains(text(),'Allow Comments')]";
		String box2 = "//span[contains(text(),'Allow respondents to edit responses after submissi')]";
		String box3 = "//span[contains(text(),'Allow admins to respond on behalf of users')]";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(expDate)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(reminderDate)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(description)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(notify)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(box1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(box2)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(box3)).size() > 0);
	}
	
	public void view_Schedulers_1_Settings() throws InterruptedException {
		this.click_Schedulers_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_Settings_Option();
		this.click_Schedulers_1_Settings_Option();
		Thread.sleep(1500);
		this.verify_Settings_Page();
		this.verify_Schedulers_Settings();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		this.verify_Schedulers_1_Dropdown();
		System.out.println("------- Completed --> archive_Schedulers() -----------");
	}
	
	public void edit_Schedulers_4(String schedulers4edited) throws InterruptedException {
		this.verify_Schedulers_4_Dropdown();
		this.click_Schedulers_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_4_Edit_Option();
		this.click_Schedulers_4_Edit_Option();
		this.verifySurveyTitleInputField();
		this.editSchedulersTitleField(schedulers4edited);
		this.editedDescriptionTextBox();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyBreadCrumbScheduler();
		this.verify_Edited_Schedulers_4_Changes();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Schedulers() -----------");
	}
	
	public void edit_Schedulers_On_Staging(String editedSchedulersTitle) throws InterruptedException {
		this.verifySchedulersTitleDropDown();
		this.click_Schedulers_Title_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Edit();
		this.verifySurveyTitleInputField();
		this.editSchedulersTitleField(editedSchedulersTitle);
		this.editedDescriptionTextBox();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyBreadCrumbScheduler();
		this.verify_Edited_Changes();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Schedulers_On_Staging() -----------");
	}
	
	public void edit_Schedulers_Back_To_Orginal() throws InterruptedException {
		this.verify_Schedulers_4_Edited_DropDown();
		this.click_Schedulers_4_Edited_Dropdown();
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Edit();
		this.verifySurveyTitleInputField();
		this.clickTypeSchedulersTitleField(Option1);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyBreadCrumbScheduler();
		this.verify_Orginal_Changes();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Schedulers_Back_To_Orginal -----------");
	}
	
	public void edit_Schedulers_Back_To_Orginal_On_Staging(String schedulersTitle) throws InterruptedException {
		this.verifyEditedSchedulersTitleDropDown();
		this.click_Edited_Schedulers_Title_Dropdown();;
		Thread.sleep(1000);
		this.verifiy_Results();
		this.click_Edit();
		this.verifySurveyTitleInputField();
		this.clickTypeSchedulersTitleField(schedulersTitle);
		Thread.sleep(1000);
		this.surveyDescriptionTextBox();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verifyBreadCrumbScheduler();
		this.verify_Orginal_Changes();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Schedulers_Back_To_Orginal_Staging -----------");
	}
	
	public void move_Schedulers_To_Another_Workroom() throws InterruptedException {
		this.click_Schedulers_5_Title();
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
		System.out.println("------- Completed --> move_Survey_To_Another_Workroom() -----------");
	}
	
	
	//--------------------------------
	
	By blue_Light_Bulb = By.xpath("//a[@class='right-tip-button-link']//i[@class='fa fa-lightbulb-o']");
	By pop_Over_Content = By.xpath("//div[contains(text(),'Click here to manage who can respond.')]");

	
	public void verify_Blue_Light_Bulb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(blue_Light_Bulb)));
	}
	
	public void verify_Pop_Over_Content() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pop_Over_Content)));
	}
	
	
	public void click_Blue_Light_Bulb() {
		DriverFactory.getInstance().getDriver().findElement(blue_Light_Bulb).click();
	}
	
	public void navigate_To_Light_Bulb_Help_Text_In_Scheduler() throws InterruptedException {
		this.verifySchedulersTitle();
		this.clickSchedulersTitle();
		Thread.sleep(1000);
		this.verify_Blue_Light_Bulb();
		System.out.println("------- Completed --> navigate_To_Help_Text_In_Scheduler() -----------");
	}
	
	public void verify_Help_Text_Shown() throws InterruptedException {
		this.click_Blue_Light_Bulb();
		Thread.sleep(1000);
		this.verify_Pop_Over_Content();
		this.clickBreadCrumbScheduler();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Help_Text_Shown() -----------");
	}
	
	//--------------------------------
	
	By expanded_View = By.xpath("//a[@class='btn btn-default default-view active'][@title='Expanded']");
	By expanded_default_View = By.xpath("//a[@class='btn btn-default default-view']");
	By tile_View = By.xpath("//a[contains(@class,'btn btn-default tile-view')]");
	By list_View = By.xpath("//a[contains(@class,'btn btn-default list-view')]");
	By tab_List_View = By.xpath("//ul[@class='nav nav-tabs']");

	public void click_Expanded_Default_View() {
		DriverFactory.getInstance().getDriver().findElement(expanded_default_View).click();
	}
	
	public void click_Tile_View() {
		DriverFactory.getInstance().getDriver().findElement(tile_View).click();
	}
	
	public void click_List_View() {
		DriverFactory.getInstance().getDriver().findElement(list_View).click();
	}
	
	public void verify_Expanded_View_Schedulers() throws InterruptedException {
		Thread.sleep(2000);

		String scheduler1 = "//h3//a[normalize-space(text())='This is a Schedulers Title']";
		String scheduler2 = "//h3//a[normalize-space(text())='This is a Schedulers Title 2']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler2)).size() > 0);
	}
	
	public void verify_Tile_View_Schedulers() throws InterruptedException {
		Thread.sleep(2000);

		String tab_List_View = "//ul[@class='nav nav-tabs']";
		String scheduler1 = "(//*[@id='schedulers']//div//h3[ @class='card-title']/a[contains(text(),'This is a Schedulers T')])[1]";
		String scheduler2 = "(//*[@id='schedulers']//div//h3[ @class='card-title']/a[contains(text(),'This is a Schedulers T')])[2]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(tab_List_View)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler2)).size() > 0);
	}
	
	public void verify_List_View_Schedulers() throws InterruptedException {
		Thread.sleep(2000);

		String scheduler1 = "//tbody/tr//a[normalize-space(text())='This is a Schedulers Title']";
		String scheduler2 = "//tbody/tr//a[normalize-space(text())='This is a Schedulers Title 2']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(scheduler2)).size() > 0);

	}
	
	public void view_And_Verify_Schedulers_Expanded_View() throws InterruptedException {
		this.verifyNewSchedulers();
		this.click_Tile_View();
		Thread.sleep(1000);
		this.click_Expanded_Default_View();
		Thread.sleep(1000);
		this.verify_Expanded_View_Schedulers();
		//DriverFactory.getInstance().getDriver().navigate().refresh();
		//Thread.sleep(1000);
		System.out.println("------- Completed --> select_Schedulers_Expanded_View() -----------");
	}
	
	public void view_And_Verify_Schedulers_Tile_View() throws InterruptedException {
		this.verifyNewSchedulers();
		this.click_Tile_View();
		Thread.sleep(1000);
		this.verify_Tile_View_Schedulers();
		//DriverFactory.getInstance().getDriver().navigate().refresh();
		//Thread.sleep(1000);
		System.out.println("------- Completed --> view_And_Verify_Schedulers_Tile_View() -----------");
	}
	
	public void view_And_Verify_Schedulers_List_View() throws InterruptedException {
		this.verifyNewSchedulers();
		this.click_List_View();
		Thread.sleep(1000);
		this.verify_List_View_Schedulers();
		//DriverFactory.getInstance().getDriver().navigate().refresh();
		//Thread.sleep(1000);
		this.click_Expanded_Default_View();
		Thread.sleep(1000);
		System.out.println("------- Completed --> select_Schedulers_List_View() -----------");
	}
	
	//----------------------------------
	
	
	public void verify_Copied_Scheduler_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'This is a Schedulers Title  - Copy')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Scheduler_1_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Schedulers 1')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Scheduler_2_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Schedulers 2')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Schedulers_3_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Schedulers 3')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Schedulers_5_Deleted() throws InterruptedException {
		String element = "(//a[contains(text(),'Schedulers 5')]/following::div[@class='dropdown header-actions'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void delete_Schedulers_1() throws InterruptedException {
		this.click_Schedulers_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_1_Delete_Option();
		this.click_Schedulers_1_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Schedulers_1() -----------");
	}
	
	public void delete_Archived_Schedulers_2() throws InterruptedException {
		this.verify_Schedulers_2_Dropdown();
		this.click_Schedulers_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_2_Delete_Option();
		this.click_Schedulers_2_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Archived_Schedulers_2() -----------");
	}
	
	public void delete_Schedulers_3() throws InterruptedException {
		this.verify_Schedulers_3_Dropdown();
		this.click_Schedulers_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_3_Delete_Option();
		this.click_Schedulers_3_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Schedulers_3() -----------");
	}
	
	public void delete_Schedulers_5() throws InterruptedException {
		this.verify_Schedulers_5_Dropdown();
		this.click_Schedulers_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_5_Delete_Option();
		this.click_Schedulers_5_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Schedulers_3() -----------");
	}
	
	public void delete_Schedulers_6() throws InterruptedException {
		this.verify_Schedulers_6_Dropdown();
		this.click_Schedulers_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_6_Delete_Option();
		this.click_Schedulers_6_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Schedulers_3() -----------");
	}
	
	public void delete_Copied_Scheduler() throws InterruptedException {
		this.verify_Schedulers_Title_Copy_DropDown();
		this.click_Schedulers_Title_Copy_Dropdown();
		Thread.sleep(1000);
		this.verify_Schedulers_Title_Copy_Delete_Option();
		this.click_Schedulers_Title_Copy_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Copied_Scheduler() -----------");
	}
		
	public void delete_Schedulers_4_Edited() throws InterruptedException {
		this.verify_Schedulers_4_Edited_DropDown();
		this.click_Schedulers_4_Edited_Dropdown();
		Thread.sleep(1000);
		this.verify_Edited_Schedulers_4_Delete_Option();
		this.click_Schedulers_4_Edited_Delete_Option();
		Thread.sleep(1000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Schedulers_4_Edited() -----------");
		
	}

}
