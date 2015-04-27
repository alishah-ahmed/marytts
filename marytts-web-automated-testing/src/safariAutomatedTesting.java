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
	private static String phonemsInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><t g2p_method=\"lexicon\" ph=\"' w E l - k @ m\" pos=\"VB\">Welcome</t><t g2p_method=\"lexicon\" ph=\"' t u\" pos=\"TO\">to</t><t g2p_method=\"lexicon\" ph=\"D @\" pos=\"DT\">the</t><t g2p_method=\"lexicon\" ph=\"' w r= l d\" pos=\"NN\">world</t><t g2p_method=\"lexicon\" ph=\"' V v\" pos=\"IN\">of</t><t g2p_method=\"lexicon\" ph=\"s - ' p i tS\" pos=\"NN\">speech</t><t g2p_method=\"lexicon\" ph=\"' s I n - T @ - s @ s\" pos=\"NN\">synthesis</t><t pos=\".\">!</t></s></voice></p></maryxml>";
	private static String allophonesInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><phrase><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' w E l - k @ m\" pos=\"VB\">Welcome<syllable accent=\"H*\" ph=\"w E l\" stress=\"1\"><ph p=\"w\"/><ph p=\"E\"/><ph p=\"l\"/></syllable><syllable ph=\"k @ m\"><ph p=\"k\"/><ph p=\"@\"/><ph p=\"m\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"' t u\" pos=\"TO\">to<syllable ph=\"t u\" stress=\"1\"><ph p=\"t\"/><ph p=\"u\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"D @\" pos=\"DT\">the<syllable ph=\"D @\"><ph p=\"D\"/><ph p=\"@\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' w r= l d\" pos=\"NN\">world<syllable accent=\"H*\" ph=\"w r= l d\" stress=\"1\"><ph p=\"w\"/><ph p=\"r=\"/><ph p=\"l\"/><ph p=\"d\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"' V v\" pos=\"IN\">of<syllable ph=\"V v\" stress=\"1\"><ph p=\"V\"/><ph p=\"v\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"s - ' p i tS\" pos=\"NN\">speech<syllable ph=\"s\"><ph p=\"s\"/></syllable><syllable accent=\"H*\" ph=\"p i tS\" stress=\"1\"><ph p=\"p\"/><ph p=\"i\"/><ph p=\"tS\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' s I n - T @ - s @ s\" pos=\"NN\">synthesis<syllable accent=\"H*\" ph=\"s I n\" stress=\"1\"><ph p=\"s\"/><ph p=\"I\"/><ph p=\"n\"/></syllable><syllable ph=\"T @\"><ph p=\"T\"/><ph p=\"@\"/></syllable><syllable ph=\"s @ s\"><ph p=\"s\"/><ph p=\"@\"/><ph p=\"s\"/></syllable></t><t pos=\".\">!</t><boundary breakindex=\"5\" tone=\"L-L%\"/></phrase></s></voice></p></maryxml>";
	private static String partsOfSpeechInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><t pos=\"VB\">Welcome</t><t pos=\"TO\">to</t><t pos=\"DT\">the</t><t pos=\"NN\">world</t><t pos=\"IN\">of</t><t pos=\"NN\">speech</t><t pos=\"NN\">synthesis</t><t pos=\".\">!</t></s></voice></p></maryxml>";
	
	public static void main(String[] args) throws InterruptedException {
		if (isSupportedPlatform()) {
			createDriver();
			
			safariDriver.get("http://localhost:59125/");
			
			WebElement languageSelect = safariDriver.findElement(By.id("VOICE_SELECTIONS"));
		    List<WebElement> options = languageSelect.findElements(By.tagName("option"));
		    for (WebElement option : options) {
//		        String languageName = option.getText();
		    	option.click();		//selecting language
		        
		        //for load testing, running the same code 20 times!
		    	//for (int i=0; i<20; i++) {
			        executeTestsForType("TEXT");		//input type: TEXT
					executeTestsForType("SSML");		//input type: SSML
					executeTestsForType("EMOTIONML");	//input type: EMOTIONML
					executeTestsForType("PHONEMES");		//input type: PHONEMS
					executeTestsForType("ALLOPHONES");	//input type: ALLOPHONES
					executeTestsForType("RAWMARYXML");	//input type: RAWMARYXML
					executeTestsForType("TOKENS");		//input type: TOKENS
					executeTestsForType("WORDS");		//input type: WORDS
					executeTestsForType("INTONATION");	//input type: INTONATION
					executeTestsForType("PARTSOFSPEECH");	//input type: PARTSOFSPEECH
					
					Thread.sleep(2000);
		    	//}
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
		
		WebElement inputText = safariDriver
				.findElement(By.id("INPUT_TEXT"));
		switch (type) {
		case "PHONEMES":
			inputText.sendKeys(phonemsInput);
			testAudio();
			testPhonemes();
			testIntonation();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		case "ALLOPHONES":
			inputText.sendKeys(allophonesInput);
			testAudio();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		case "PARTSOFSPEECH":
			inputText.sendKeys(partsOfSpeechInput);
			testAudio();
			testPartsOfSpeech();
			testPhonemes();
			testIntonation();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		case "TOKENS":
			testAudio();
			testTokens();
			testPartsOfSpeech();
			testPhonemes();
			testIntonation();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		case "WORDS":
			testAudio();
			testPartsOfSpeech();
			testPhonemes();
			testIntonation();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		case "INTONATION":
			testAudio();
			testIntonation();
			testAllophones();
			testAcoustParams();
			testRealisedAcoustParams();
			testRealisedDurations();
			testPraatTextGrid();
			testTargetFeatures();
			testHalfPhoneTargetFeatures();
			break;
		default:
			testAllOutputTypes();
		}
	}
	
	public static void testAllOutputTypes() throws InterruptedException {
		testAudio();
		testRawMaryXML();
		testTokens();
		testPartsOfSpeech();
		testPhonemes();
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
		
		Select audioOut = new Select(safariDriver.findElement(By.id("AUDIO_OUT")));
		audioOut.selectByVisibleText("WAVE_FILE");
		
		WebElement speakButton = safariDriver.findElement(By.id("SPEAK"));
		speakButton.click();
		Thread.sleep(10000);
		
		audioOut.selectByVisibleText("AIFF_FILE");
		speakButton.click();
		Thread.sleep(14000);
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
	public static void testPhonemes() throws InterruptedException {
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
