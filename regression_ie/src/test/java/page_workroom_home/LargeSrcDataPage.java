package page_workroom_home;

import static org.testng.Assert.assertTrue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class LargeSrcDataPage {
	WebDriver driver;

	public LargeSrcDataPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// -------------- user_navigates and click edit icon()------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By pencil = By.xpath("//span[@class='glyphicon glyphicon-pencil']");

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Edit_Icon() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pencil)));
	}

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}

	public void click_Edit_Icon() {
		driver.findElement(pencil).click();
	}

	// -----------------Function Being Called--------------------------
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Edit_Icon();
		this.click_Edit_Icon();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Clicks_On_Edit_Icon() -----------");
	}
	
	// ----------- user switches to message window Iframe()----------------------
	By saveBtn = By.xpath("//button[@name='button']");
	By horizontal_Line = By.xpath("//a[@id='cke_60']");
	By source = By.xpath("//a[@id='cke_16']");
	By textarea = By.xpath("//textarea[@class='cke_source cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']");

	public void verify_SaveBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saveBtn)));
	}

	public void switch_2_Iframe_Clear_Text() {
		// ---------------------switching to iframe-----------------
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and clearning text
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		// ---switch back to default content
		driver.switchTo().defaultContent();
	}

	public void click_source_Btn() {
		driver.findElement(source).click();
	}

	public void copy_To_Clipboard_Paste_And_Save() throws IOException {
		// --http://www.avajava.com/tutorials/lessons/how-do-i-copy-a-string-to-the-clipboard.html
		// https://stackoverflow.com/questions/6710350/copying-text-to-the-clipboard-using-java
		String content = FileUtils.readFileToString(new File("C:\\git\\BoardEffectUIAutomation_New\\regression_chrome\\uploadedFiles\\Images.txt"),
				"UTF-8");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection contentSel = new StringSelection(content);
		clipboard.setContents(contentSel, null);
		driver.findElement(textarea).click();
		driver.findElement(textarea).sendKeys(Keys.CONTROL + "v");
	}

	public void user_Copy_Past_Text_and_Save() throws InterruptedException, IOException {
		for (int i = 0; i < 1; i++) {
			this.verify_SaveBtn();
			this.click_source_Btn();
			Thread.sleep(1000);
			this.copy_To_Clipboard_Paste_And_Save();
			Thread.sleep(500);
		}
		driver.findElement(saveBtn).click();
	}

	// ---------------------Function Being called----------------------
	public void switch_To_Iframe_Copy_Paste_Content() throws InterruptedException, IOException {
		this.switch_2_Iframe_Clear_Text();
		this.user_Copy_Past_Text_and_Save();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Iframe_Insert_Line_Breaks() -----------");
	}
	
	// --------------------verify_workroom_message()--------------------
	By saved_Message = By.xpath("//div[@class='col-md-8 full main-content']//p[contains(text(),'AutoBE welcome message has been saved.')]");
	By video_Title = By.xpath("//strong[contains(text(),'Welcome to My Test Workroom')]");

	public void verify_Saved_Message_And_Content() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saved_Message),
				ExpectedConditions.visibilityOfElementLocated(video_Title)));
	}
	
	// ------------------Function Being Called---------------------------
	public void verify_Content_Appears() throws InterruptedException {
		this.verify_Saved_Message_And_Content();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Content_Appears() -----------");
	}

	// -----------------------delete insert previous message---------------
	public void switch_2_Iframe_SendKeys_Agian() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		String content = "Customize this area to greet your users with organizational information, photos, links and more!\n"
				+ "If you have questions, please contact your BoardEffect Administrator or the BoardEffect Support Team:\n" + "Name\n" + "Phone\n"
				+ "Email\n" + "BoardEffect Support 1-866-672-2666, option 1";
		// ---switch to iframe-----
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(content);
		driver.switchTo().defaultContent();
	}

	public void click_Save_Btn() throws InterruptedException {
		driver.findElement(saveBtn).click();
	}
	
	// --------------Function Being Called------------------------------
	public void delete_Insert_Previous_Message() throws InterruptedException {
		this.click_Edit_Icon();
		Thread.sleep(1000);
		this.verify_SaveBtn();
		Thread.sleep(1000);
		this.switch_2_Iframe_SendKeys_Agian();
		Thread.sleep(1000);
		this.click_Save_Btn();
		System.out.println("------- Completed --> delete_Insert_Previous_Message() -----------");
	}
	
	// ------------------------verify previous message---------------------
	By message_Content_2 = By.xpath("//p[contains(text(),'Customize this area to greet your users with organ')]");

	public void verify_Saved_Message_And_Content_Again() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saved_Message),
				ExpectedConditions.visibilityOfElementLocated(message_Content_2)));
	}

	// -----------------------Function Being Called-------------------------
	public void verify_Previous_Message() throws InterruptedException {
		this.verify_Saved_Message_And_Content_Again();
		System.out.println("------- Completed --> verify_Previous_Message() -----------");
		Thread.sleep(4000);
	}
}
