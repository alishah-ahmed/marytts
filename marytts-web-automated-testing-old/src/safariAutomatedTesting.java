import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class safariAutomatedTesting {

	private static WebDriver safariDriver = null;
	
	public static void main(String[] args) throws InterruptedException {
		if (isSupportedPlatform()) {
			createDriver();
			
			safariDriver.get("http://localhost:59125/");
			
			WebElement languageSelect = safariDriver.findElement(By.id("VOICE_SELECTIONS"));
		    List<WebElement> options = languageSelect.findElements(By.tagName("option"));
		    for (WebElement option : options) {
//		        String languageName = option.getText();
		    	option.click();		//selecting language
		        
		        //for load testing, put a for loop for the next six lines
		        executeTestsForType("TEXT");		//input type: TEXT
				executeTestsForType("SSML");		//input type: SSML
				executeTestsForType("EMOTIONML");	//input type: EMOTIONML
				executeTestsForType("RAWMARYXML");	//input type: RAWMARYXML
				
				Thread.sleep(2000);
		    }
			
			//safariDriver.quit();
		}
	}
	
	private static boolean isSupportedPlatform() {
	    Platform current = Platform.getCurrent();
	    return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
	}

	public static void createDriver() {
	    assumeTrue(isSupportedPlatform());
	    safariDriver = new SafariDriver();
	}

	public void quitDriver() {
	    safariDriver.quit();
	}

	public static void shouldBeAbleToPerformAGoogleSearch() {
	    safariDriver.get("http://www.google.com");
	    safariDriver.findElement(By.name("q")).sendKeys("webdriver");
	    safariDriver.findElement(By.name("btnG")).click();
	    new WebDriverWait(safariDriver, 3)
	        .until(ExpectedConditions.titleIs("webdriver - Google Search"));
	}
	
	public static void executeTestsForType(String type) throws InterruptedException {
		Thread.sleep(2000);
		Select inputType = new Select(safariDriver.findElement(By.id("INPUT_TYPE")));
		inputType.selectByVisibleText(type);
		testAllOutputTypes();
	}
	
	public static void testAllOutputTypes() throws InterruptedException {
		testAudio();
		testRawMaryXML();
		testTokens();
		testPartsOfSpeech();
		testTextToPhonems();
		testIntonation();
		testAllophones();
		testAcoustParams();
		testRealisedAcoustParams();
		testRealisedDurations();
		testPraatTextGrid();
		testTargetFeatures();
		testHalfPhoneTargetFeatures();
	}
	
	//output: audio
	public static void testAudio() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("AUDIO");
		WebElement speakButton = safariDriver.findElement(By.id("SPEAK"));
		speakButton.click();
		Thread.sleep(15000);
	}
	
	//output: RawMaryXML
	public static void testRawMaryXML() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("RAWMARYXML");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: tokens
	public static void testTokens() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TOKENS");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: PartsOfSpeech
	public static void testPartsOfSpeech() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PARTSOFSPEECH");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: phonemes
	public static void testTextToPhonems() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PHONEMES");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: intonation
	public static void testIntonation() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("INTONATION");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: allophones
	public static void testAllophones() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ALLOPHONES");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: acoustparams
	public static void testAcoustParams() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ACOUSTPARAMS");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: Realised_AcoustParams
	public static void testRealisedAcoustParams() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_ACOUSTPARAMS");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: Realised_Durations
	public static void testRealisedDurations() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_DURATIONS");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: Praat_TextGrid
	public static void testPraatTextGrid() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PRAAT_TEXTGRID");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: TargetFeatures
	public static void testTargetFeatures() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TARGETFEATURES");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
	
	//output: HalfPhone_TargetFeatures
	public static void testHalfPhoneTargetFeatures() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("HALFPHONE_TARGETFEATURES");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(1000);
	}
}
