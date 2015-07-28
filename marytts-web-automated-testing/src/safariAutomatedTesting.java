import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

@RunWith(JUnit4.class)
public class safariAutomatedTesting {

	private static WebDriver safariDriver = null;
	private static Select outputType = null;
	private static String phonemesInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><t g2p_method=\"lexicon\" ph=\"' w E l - k @ m\" pos=\"VB\">Welcome</t><t g2p_method=\"lexicon\" ph=\"' t u\" pos=\"TO\">to</t><t g2p_method=\"lexicon\" ph=\"D @\" pos=\"DT\">the</t><t g2p_method=\"lexicon\" ph=\"' w r= l d\" pos=\"NN\">world</t><t g2p_method=\"lexicon\" ph=\"' V v\" pos=\"IN\">of</t><t g2p_method=\"lexicon\" ph=\"s - ' p i tS\" pos=\"NN\">speech</t><t g2p_method=\"lexicon\" ph=\"' s I n - T @ - s @ s\" pos=\"NN\">synthesis</t><t pos=\".\">!</t></s></voice></p></maryxml>";
	private static String allophonesInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><phrase><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' w E l - k @ m\" pos=\"VB\">Welcome<syllable accent=\"H*\" ph=\"w E l\" stress=\"1\"><ph p=\"w\"/><ph p=\"E\"/><ph p=\"l\"/></syllable><syllable ph=\"k @ m\"><ph p=\"k\"/><ph p=\"@\"/><ph p=\"m\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"' t u\" pos=\"TO\">to<syllable ph=\"t u\" stress=\"1\"><ph p=\"t\"/><ph p=\"u\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"D @\" pos=\"DT\">the<syllable ph=\"D @\"><ph p=\"D\"/><ph p=\"@\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' w r= l d\" pos=\"NN\">world<syllable accent=\"H*\" ph=\"w r= l d\" stress=\"1\"><ph p=\"w\"/><ph p=\"r=\"/><ph p=\"l\"/><ph p=\"d\"/></syllable></t><t g2p_method=\"lexicon\" ph=\"' V v\" pos=\"IN\">of<syllable ph=\"V v\" stress=\"1\"><ph p=\"V\"/><ph p=\"v\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"s - ' p i tS\" pos=\"NN\">speech<syllable ph=\"s\"><ph p=\"s\"/></syllable><syllable accent=\"H*\" ph=\"p i tS\" stress=\"1\"><ph p=\"p\"/><ph p=\"i\"/><ph p=\"tS\"/></syllable></t><t accent=\"H*\" g2p_method=\"lexicon\" ph=\"' s I n - T @ - s @ s\" pos=\"NN\">synthesis<syllable accent=\"H*\" ph=\"s I n\" stress=\"1\"><ph p=\"s\"/><ph p=\"I\"/><ph p=\"n\"/></syllable><syllable ph=\"T @\"><ph p=\"T\"/><ph p=\"@\"/></syllable><syllable ph=\"s @ s\"><ph p=\"s\"/><ph p=\"@\"/><ph p=\"s\"/></syllable></t><t pos=\".\">!</t><boundary breakindex=\"5\" tone=\"L-L%\"/></phrase></s></voice></p></maryxml>";
	private static String partsOfSpeechInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><maryxml xmlns=\"http://mary.dfki.de/2002/MaryXML\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"0.5\" xml:lang=\"en-US\"><p><voice name=\"cmu-slt-hsmm\"><s><t pos=\"VB\">Welcome</t><t pos=\"TO\">to</t><t pos=\"DT\">the</t><t pos=\"NN\">world</t><t pos=\"IN\">of</t><t pos=\"NN\">speech</t><t pos=\"NN\">synthesis</t><t pos=\".\">!</t></s></voice></p></maryxml>";

	public static void main(String[] args) throws InterruptedException {
		if (isSupportedPlatform()) { // check if windows or mac -> for safari
			createDriver();
			safariDriver.get("http://localhost:59125/");

			outputType = new Select(safariDriver.findElement(By
					.id("OUTPUT_TYPE")));

			WebElement languageSelect = safariDriver.findElement(By
					.id("VOICE_SELECTIONS"));
			List<WebElement> options = languageSelect.findElements(By
					.tagName("option"));
			for (WebElement option : options) {
				// String languageName = option.getText();
				option.click(); // selecting language

				// for load testing, running the same code 20 times!
				for (int i = 0; i < 200; i++) {
					if (safariDriver == null) {
						System.out
								.println("SESSION CLOSED!");
						break;
					}
					executeTestsForType("TEXT"); // input type: TEXT
					executeTestsForType("SSML"); // input type: SSML
					executeTestsForType("EMOTIONML"); // input type: EMOTIONML
					executeTestsForType("PHONEMES"); // input type: PHONEMS
					executeTestsForType("ALLOPHONES"); // input type: ALLOPHONES
					executeTestsForType("RAWMARYXML"); // input type: RAWMARYXML
					executeTestsForType("TOKENS"); // input type: TOKENS
					executeTestsForType("WORDS"); // input type: WORDS
					executeTestsForType("INTONATION"); // input type: INTONATION
					executeTestsForType("PARTSOFSPEECH"); // input type:
															// PARTSOFSPEECH

					Thread.sleep(2000);
				}
			}

			safariDriver.quit();
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

	public static void executeTestsForType(String type)
			throws InterruptedException {
		Thread.sleep(1000);
		Select inputType = new Select(safariDriver.findElement(By
				.id("INPUT_TYPE")));
		inputType.selectByVisibleText(type);

		Thread.sleep(1000);

		WebElement inputText = safariDriver.findElement(By.id("INPUT_TEXT"));

		boolean isError = false;
		do {
			try {
				switch (type) {
				case "PHONEMES":
					inputText.sendKeys(phonemesInput);
					Thread.sleep(1000);
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
					Thread.sleep(1000);
					isError = false;
					break;
				case "ALLOPHONES":
					inputText.sendKeys(allophonesInput);
					Thread.sleep(1000);
					testAudio();
					testAllophones();
					testAcoustParams();
					testRealisedAcoustParams();
					testRealisedDurations();
					testPraatTextGrid();
					testTargetFeatures();
					testHalfPhoneTargetFeatures();
					isError = false;
					break;
				case "PARTSOFSPEECH":
					inputText.sendKeys(partsOfSpeechInput);
					Thread.sleep(1000);
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
					isError = false;
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
			} catch (Exception e) {
				isError = true;
			}
		} while (isError);

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

	// output: audio
	public static void testAudio() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By
				.id("OUTPUT_TYPE")));
		try {
			outputType.selectByVisibleText("AUDIO");
			Select audioOut = new Select(safariDriver.findElement(By
					.id("AUDIO_OUT")));
			audioOut.selectByVisibleText("WAVE_FILE");

			WebElement speakButton = safariDriver.findElement(By.id("SPEAK"));
			speakButton.click();
			Thread.sleep(6000);

			// audioOut.selectByVisibleText("AIFF_FILE");
			// speakButton.click();
			// Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println("output type AUDIO, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}
	}

	// output: RawMaryXML
	public static void testRawMaryXML() throws InterruptedException {
		// Select outputType = new
		// Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		try {
			outputType.selectByVisibleText("RAWMARYXML");
		} catch (Exception e) {
			System.out.println("output type RAWMARYXML, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: tokens
	public static void testTokens() throws InterruptedException {
		// Select outputType = new
		// Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		try {
			outputType.selectByVisibleText("TOKENS");
		} catch (Exception e) {
			System.out.println("output type TOKENS, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: PartsOfSpeech
	public static void testPartsOfSpeech() throws InterruptedException {
		// Select outputType = new
		// Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		try {
			outputType.selectByVisibleText("PARTSOFSPEECH");
		} catch (Exception e) {
			System.out.println("output type PARTSOFSPEECH, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: phonemes
	public static void testPhonemes() throws InterruptedException {
		try {
			outputType.selectByVisibleText("PHONEMES");
		} catch (Exception e) {
			System.out.println("output type PHONEMES, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: intonation
	public static void testIntonation() throws InterruptedException {
		// Select outputType = new
		// Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
		try {
			outputType.selectByVisibleText("INTONATION");
		} catch (Exception e) {
			System.out.println("output type INTONATION, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: allophones
	public static void testAllophones() throws InterruptedException {
		Select outputType = new Select(safariDriver.findElement(By
				.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ALLOPHONES");
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: acoustparams
	public static void testAcoustParams() throws InterruptedException {
		try {
			outputType.selectByVisibleText("ACOUSTPARAMS");
		} catch (Exception e) {
			System.out.println("output type ACOUSTPARAMS, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		// Thread.sleep(1000);
		Thread.sleep(700);
	}

	// output: Realised_AcoustParams
	public static void testRealisedAcoustParams() throws InterruptedException {
		try {
			outputType.selectByVisibleText("REALISED_ACOUSTPARAMS");
		} catch (Exception e) {
			System.out
					.println("output type REALISED_ACOUSTPARAMS, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: Realised_Durations
	public static void testRealisedDurations() throws InterruptedException {
		try {
			outputType.selectByVisibleText("REALISED_DURATIONS");
		} catch (Exception e) {
			System.out
					.println("output type REALISED_DURATIONS, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: Praat_TextGrid
	public static void testPraatTextGrid() throws InterruptedException {
		try {
			outputType.selectByVisibleText("PRAAT_TEXTGRID");
		} catch (Exception e) {
			System.out.println("output type PRAAT_TEXTGRID, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: TargetFeatures
	public static void testTargetFeatures() throws InterruptedException {
		try {
			outputType.selectByVisibleText("TARGETFEATURES");
		} catch (Exception e) {
			System.out.println("output type TARGETFEATURES, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}

		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}

	// output: HalfPhone_TargetFeatures
	public static void testHalfPhoneTargetFeatures()
			throws InterruptedException {
		try {
			outputType.selectByVisibleText("HALFPHONE_TARGETFEATURES");
		} catch (Exception e) {
			System.out
					.println("output type HALFPHONE_TARGETFEATURES, text not found!");
			System.out.println("error message: " + e.getLocalizedMessage()
					+ "\n");
		}
		WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(2000);
	}
}
