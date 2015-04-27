import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class firefoxAutomatedTesting {

	static WebDriver firefoxDriver;
	
	public static void main(String[] args) throws InterruptedException {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://localhost:59125/");
		
		executeTestsForType("TEXT");		//input type: TEXT
		executeTestsForType("SSML");		//input type: SSML
		executeTestsForType("EMOTIONML");	//input type: EMOTIONML
		executeTestsForType("RAWMARYXML");	//input type: RAWMARYXML
		
		Thread.sleep(7000);
		firefoxDriver.quit();
	}
	
	public static void executeTestsForType(String type) throws InterruptedException {
		Thread.sleep(5000);
		Select inputType = new Select(firefoxDriver.findElement(By.id("INPUT_TYPE")));
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
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("AUDIO");
		WebElement speakButton = firefoxDriver.findElement(By.id("SPEAK"));
		speakButton.click();
		Thread.sleep(25000);
	}
	
	//output: RawMaryXML
	public static void testRawMaryXML() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("RAWMARYXML");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: tokens
	public static void testTokens() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TOKENS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: PartsOfSpeech
	public static void testPartsOfSpeech() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PARTSOFSPEECH");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: phonemes
	public static void testTextToPhonems() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PHONEMES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: intonation
	public static void testIntonation() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("INTONATION");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: allophones
	public static void testAllophones() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ALLOPHONES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: acoustparams
	public static void testAcoustParams() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ACOUSTPARAMS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: Realised_AcoustParams
	public static void testRealisedAcoustParams() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_ACOUSTPARAMS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: Realised_Durations
	public static void testRealisedDurations() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_DURATIONS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: Praat_TextGrid
	public static void testPraatTextGrid() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PRAAT_TEXTGRID");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: TargetFeatures
	public static void testTargetFeatures() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TARGETFEATURES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//output: HalfPhone_TargetFeatures
	public static void testHalfPhoneTargetFeatures() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("HALFPHONE_TARGETFEATURES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
}
