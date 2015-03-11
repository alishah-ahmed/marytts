package test;

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
		
		Thread.sleep(7000);
		testSpeak();
		testRawMaryXML();
		testTokens();
		testPartsOfSpeech();
		testPhonems();
		testIntonation();
		testAllophones();
		testAcoustParams();
		testRealisedAcoustParams();
		testRealisedDurations();
		testPraatTextGrid();
		testTargetFeatures();
		testHalfPhoneTargetFeatures();
		
		firefoxDriver.quit();
	}
	
	//input: text, output: audio
	public static void testSpeak() throws InterruptedException {
		WebElement speakButton = firefoxDriver.findElement(By.id("SPEAK"));
		speakButton.click();
		Thread.sleep(20000);
	}
	
	//input: text, output: RawMaryXML
	public static void testRawMaryXML() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("RAWMARYXML");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: tokens
	public static void testTokens() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TOKENS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: PartsOfSpeech
	public static void testPartsOfSpeech() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PARTSOFSPEECH");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: phonemes
	public static void testPhonems() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PHONEMES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: intonation
	public static void testIntonation() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("INTONATION");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: allophones
	public static void testAllophones() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ALLOPHONES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: acoustparams
	public static void testAcoustParams() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("ACOUSTPARAMS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: Realised_AcoustParams
	public static void testRealisedAcoustParams() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_ACOUSTPARAMS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: Realised_Durations
	public static void testRealisedDurations() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("REALISED_DURATIONS");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: Praat_TextGrid
	public static void testPraatTextGrid() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("PRAAT_TEXTGRID");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: TargetFeatures
	public static void testTargetFeatures() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("TARGETFEATURES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
	
	//input: text, output: HalfPhone_TargetFeatures
	public static void testHalfPhoneTargetFeatures() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("HALFPHONE_TARGETFEATURES");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(7000);
	}
}
