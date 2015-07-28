import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class lengthTesting {
	private static WebDriver safariDriver = null;
	private static Select outputType = null;

	private static int stringLength = 0;
	private static List<String> englishWordsList;

	public static void main(String[] args) throws InterruptedException {
		if (isSupportedPlatform()) { // check if windows or mac -> for safari
			Scanner s;
			try {
				s = new Scanner(new File("UK.dic"));
				englishWordsList = new ArrayList<String>();
				while (s.hasNext()) {
					englishWordsList.add(s.next());
				}
				s.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			createDriver();
			safariDriver.get("http://localhost:59125/");

			outputType = new Select(safariDriver.findElement(By
					.id("OUTPUT_TYPE")));

			WebElement languageSelect = safariDriver.findElement(By
					.id("VOICE_SELECTIONS"));
			List<WebElement> options = languageSelect.findElements(By
					.tagName("option"));
			
			//for all languages
			for (WebElement option : options) {
				option.click(); // selecting language
				stringLength = 0;

				for (int i = 0; i < 20; i++) {		// test till 20000 length
					if (safariDriver == null) {
						System.out.println("SESSION CLOSED!");
						break;
					}

					WebElement inputText = safariDriver.findElement(By
							.id("INPUT_TEXT"));

					try {
						stringLength += 1000;
						String inputString = pickRandomString(englishWordsList,
								stringLength);
						inputText.clear();
						inputText.sendKeys(inputString);

						WebElement speakButton = safariDriver.findElement(By
								.id("SPEAK"));
						speakButton.click();

						Thread.sleep(stringLength * 15);
					} catch (Exception e) {
						System.out.println("language: " + option.getText()
								+ "--- FAILED AT LENGTH: " + stringLength);
						break;
					}
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

	public static String pickRandomString(List<String> list, int length) {
		Collections.shuffle(list);

		String inputString = "";
		for (int i = 0; i < englishWordsList.size(); i++) {
			inputString += englishWordsList.get(i) + " ";

			if (inputString.length() >= length) {
				break;
			}
		}

		return inputString;
	}

}
