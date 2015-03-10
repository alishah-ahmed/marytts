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
		
		testSpeak();
		testRawMaryXML();
		
		firefoxDriver.quit();
	}
	
	public static void testSpeak() throws InterruptedException {
		Thread.sleep(7000);
		WebElement speakButton = firefoxDriver.findElement(By.id("SPEAK"));
		speakButton.click();
		Thread.sleep(15000);
	}
	
	public static void testRawMaryXML() throws InterruptedException {
		Select outputType = new Select(firefoxDriver.findElement(By.id("OUTPUT_TYPE")));
		outputType.selectByVisibleText("RAWMARYXML");
		WebElement processButton = firefoxDriver.findElement(By.id("PROCESS"));
		processButton.click();
		Thread.sleep(10000);
	}

}
