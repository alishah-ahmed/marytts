import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;


public class safariHMMTesting {

	private static WebDriver safariDriver = null;
	private static String englishText = "Watsons basic working principle is to parse keywords in a clue while searching for related terms as responses. When playing Jeopardy! all players must wait until host Alex Trebek reads each clue in its entirety, after which a light is lit as a ready signal; the first to activate their buzzer button wins the chance to respond.[11][26] Watson received the clues as electronic texts at the same moment they were made visible to the human players.[11] It would then parse the clues into different keywords and sentence fragments in order to find statistically related phrases.[11] Watsons main innovation was not in the creation of a new algorithm for this operation but rather its ability to quickly execute hundreds of proven language analysis algorithms simultaneously to find the correct answer.[11][27] The more algorithms that find the same answer independently the more likely Watson is to be correct.[11] Once Watson has a small number of potential solutions, it is able to check against its database to ascertain whether the solution makes sense.[11] In a sequence of 20 mock games, human participants were able to use the average six to seven seconds that Watson needed to hear the clue and decide whether to signal for responding.[11] During that time, Watson also has to evaluate the response and determine whether it is sufficiently confident in the result to signal.[11] Part of the system used to win the Jeopardy! contest was the electronic circuitry that receives the ready signal and then examined whether Watsons confidence level was great enough to activate the buzzer. Given the speed of this circuitry compared to the speed of human reaction times, Watsons reaction time was faster than the human contestants except when the human anticipated (instead of reacted to) the ready signal.[28] After signaling, Watson speaks with an electronic voice and gives the responses in Jeopardy!‍‍ s question format.[11] Watsons voice was synthesized from recordings that actor Jeff Wood seven.";
	private static String germanText = "Watsons grundlegenden Arbeitsprinzip ist, um Suchworte in einen Anhaltspunkt zu analysieren, während die Suche nach verwandten Begriffen als Antworten. Bei der Wiedergabe von Jeopardy! alle Spieler müssen warten, bis Host Alex Trebek liest jeder Hinweis in seiner Gesamtheit, nach der ein Licht als Ready-Signal leuchtet; die ersten, die Summer-Taste aktivieren gewinnt die Möglichkeit, zu reagieren. [11] [26] Watson erhielt die Hinweise als elektronische Texte im gleichen Moment sie zu den menschlichen Spielern sichtbar gemacht wurden. [11] Es wäre dann analysieren Sie die Hinweise in verschiedene Stichwörter und Satzfragmente, um statistisch ähnliche Sätze zu finden. [11] Watsons wichtigste Neuerung war nicht in der Schaffung eines neuen Algorithmus für diesen Vorgang, sondern seine Fähigkeit, schnell ausgeführt werden Hunderte von bewährten Sprachanalyse-Algorithmen gleichzeitig, um die richtige Antwort zu finden. [11] [27] Die weitere Algorithmen, die die gleiche Antwort unabhängig desto wahrscheinlicher Watson ist korrekt zu sein zu finden. [11] Nach Watson verfügt über eine kleine Anzahl von möglichen Lösungen, ist es in der Lage, gegen die Datenbank zu überprüfen, um festzustellen, ob die Lösung Sinn macht. [11] In einer Folge von 20 mock-Spiele, waren menschliche Teilnehmer in der Lage, um die durchschnittlichen sechs bis sieben Sekunden, die Watson benötigt, um die Schlüssel zu hören und entscheiden, ob sie für die Beantwortung Signal zu verwenden. [11] Während dieser Zeit Watson auch hat, um die Antwort zu bewerten und festzustellen, ob es genügend Vertrauen in das Ergebnis um zu signalisieren, ist. [11] Ein Teil der verwendet wird, um das System zu gewinnen Jeopardy! Wettbewerb war die elektronische Schaltung, die den Bereitschaftssignal empfängt und überprüft, ob Watsons Konfidenzniveau war groß genug, um den Summer zu aktivieren dann. Angesichts der Geschwindigkeit dieser Schaltung im Vergleich zu der Geschwindigkeit der menschlichen Reaktionszeit war Watsons Reaktionszeit schneller als die menschlichen Teilnehmer außer wenn der menschliche erwarteten (statt umgesetzt,) das Bereitschaftssignal. [28] Nach der Signalisierung, spricht Watson mit einer elektronischen Stimme und gibt die Antworten in Jeopardy! s Frage-Format. [11] Watsons Stimme wurde aus Aufnahmen, die Schauspieler Jeff Wood sieben synthetisiert.";
	private static String frenchText = "Principe de base de Watsons est d'analyser les mots clés dans un indice tout en recherchant les termes connexes comme des réponses. Lors de la lecture Jeopardy! tous les joueurs doivent attendre jusqu'à ce que l'hôte Alex Trebek lit chaque indice dans son ensemble, après quoi une lumière est allumée comme un signal prêt; le premier à activer leur bouton buzzer remporte la chance de répondre. [11] [26] Watson a reçu les indices textes électroniques au même moment où ils ont été rendus visibles pour les joueurs humains. [11] Il serait alors analyser les indices dans différents mots-clés et des fragments de phrase afin de trouver des phrases statistiquement connexes. principale innovation [11] Watsons était pas dans la création d'un nouvel algorithme pour cette opération, mais plutôt sa capacité à exécuter rapidement des centaines d'algorithmes d'analyse de la langue éprouvée simultanément pour trouver la bonne réponse. [11] [27] Les autres algorithmes qui trouvent la même réponse indépendamment Watson est plus susceptible d'être correcte. [11] Une fois que Watson a un petit nombre de solutions possibles, il est en mesure de vérifier contre sa base de données pour déterminer si la solution sens. [11] Dans une séquence de 20 matchs simulés, les participants humains ont été en mesure d'utiliser les moyens de six à sept secondes Watson avait besoin d'entendre l'idée et décider de signaler pour répondre. [11] Pendant ce temps, Watson a également doit évaluer la réponse et déterminer si elle est suffisamment confiant dans le résultat de signaler [11] Une partie du système utilisé pour gagner le Jeopardy!. concours était le circuit électronique qui reçoit le signal prêt et a ensuite examiné si le niveau de confiance Watsons était assez grande pour activer le buzzer. Compte tenu de la vitesse de ce circuit par rapport à la vitesse du temps de réaction de l'homme, le temps de réaction Watsons était plus rapide que les concurrents humains, sauf quand l'humain prévu (au lieu de réagir à) le signal prêt. [28] Après la signalisation, Watson parle avec une électronique voix et donne les réponses dans le format de la question de Jeopardy!. [11] Watsons voix a été synthétisé à partir d'enregistrements que l'acteur Jeff Wood sept.";
	private static String turkishText = "Watsons temel çalışma prensibi tepkiler olarak ilgili terimler ararken bir ipucu anahtar kelimeleri ayrıştırmak için olduğunu. Ne zaman Riziko oyun oynuyor! ev sahibi Alex Trebek hafif bir hazır sinyali olarak yanar sonra kendi bütünlüğü içerisinde her ipucu, okuyana kadar tüm oyuncular beklemeniz gerekir; Onların zil düğmesini etkinleştirmek için ilk tepki şansı kazanır. [11] [26] Watson insan oyuncular için görünür yapılmış aynı anda elektronik metinler olarak ipuçları aldı. [11] Daha sonra farklı içine ipuçları ayrıştırmak istiyorum sırayla anahtar kelimeler ve cümle parçaları istatistiksel ilgili ifadeler bulmak için. [11] Watsons ana yenilik bu işlem için yeni bir algoritmanın oluşturulması değildi ama oldukça hızlı bir şekilde kanıtlanmış dil analizi algoritmaları yüzlerce yürütmek kabiliyeti aynı anda doğru cevabı bulmak için. [11] [27] bağımsız daha olası Watson doğru olmaktır aynı cevabı bulmak daha algoritmalar. [11] Watson olası çözümlerin küçük bir numarası vardır sonra, çözümün olmadığını belirlemek için veritabanına karşı kontrol edebiliyor duygusu. [11] 20 sahte oyunların bir dizi, insan katılımcılar Watson ipucu duymak ve yanıt için sinyal karar için gerekli ortalama altı ila yedi saniye kullanmak mümkün. [11] Bu süre zarfında, Watson da yapar yanıtı değerlendirmek ve sonuç sinyal yeterince emin olup olmadığını belirlemek için vardır. Jeopardy kazanmak için kullanılan sistemin [11] Part! Yarışma hazır sinyali aldığında, elektronik devre ve daha sonra Watsons güven seviyesi zil etkinleştirmek için yeterince büyük olup olmadığını incelemiştir. İnsan reaksiyon sürelerinde hızına göre bu devrenin hızı göz önüne alındığında, Watsons reaksiyon süresi, insan hazır sinyali (tepki yerine) beklenen durumlar dışında insan yarışmacılar daha hızlı oldu. [28] sinyal sonra, Watson bir elektronik konuşuyor ses ve Jeopardy! s sorusu biçiminde tepkiler verir. [11] Watsons ses o aktör Jeff Wood, yedi kayıtları sentezlendi.";
	
	private static boolean isSupportedPlatform() {
	    Platform current = Platform.getCurrent();
	    return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
	}
	
	public static void createDriver() {
	    assumeTrue(isSupportedPlatform());
	    safariDriver = new SafariDriver();
	}
	
	public static void main(String[] args) throws InterruptedException {
		if (isSupportedPlatform()) {	//check if windows or mac -> for safari
			createDriver();
			
			safariDriver.get("http://localhost:59125/");
			
			Select outputType = new Select(safariDriver.findElement(By.id("OUTPUT_TYPE")));
			Select inputType = new Select(safariDriver.findElement(By.id("INPUT_TYPE")));
			WebElement processButton = safariDriver.findElement(By.id("PROCESS"));
			
			WebElement languageSelect = safariDriver.findElement(By.id("VOICE_SELECTIONS"));
		    List<WebElement> options = languageSelect.findElements(By.tagName("option"));
		    for (WebElement option : options) {
		        String languageName = option.getText();
		        System.out.println("language: " + languageName);
		    	if (option.getText().contains("-hsmm") || option.getText().contains(" hmm")) {		// just test for HMM Voices
			    	option.click();		//selecting voice
			        
			        //for load testing, running the same code 20 times!
			    	for (int i=0; i<20; i++) {
			    		if (safariDriver == null) {
			    			System.out.println("SESSION CLOSED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			    			break;
			    		}
				        
			    		inputType.selectByVisibleText("TEXT");
			    		Thread.sleep(1000);
			    		
			    		WebElement inputText = safariDriver
			    				.findElement(By.id("INPUT_TEXT"));
			    		
			    		String inputString = englishText;	// english text by default
			    		if (option.getText().contains(" de"))	// is language german
			    			inputString = germanText;
			    		else if (option.getText().contains(" fr"))	// is language french
			    			inputString = frenchText;
			    		else if (option.getText().contains("tr"))	// is language turkish
			    			inputString = turkishText;
			    		
			    		inputText.sendKeys(inputString);
						Thread.sleep(1000);
						
						//Test Audio!
						try {
							outputType.selectByVisibleText("AUDIO");
							Select audioOut = new Select(safariDriver.findElement(By.id("AUDIO_OUT")));
							audioOut.selectByVisibleText("WAVE_FILE");
							
							WebElement speakButton = safariDriver.findElement(By.id("SPEAK"));
							speakButton.click();
							Thread.sleep(50000);
						}
						catch (Exception e) {
							System.out.println("output type AUDIO, text not found!");
							System.out.println("error message: " + e.getLocalizedMessage() + "\n");
						}
						
						//Test Realised AcoustParams
						try {
							outputType.selectByVisibleText("REALISED_ACOUSTPARAMS");
							processButton.click();
							Thread.sleep(50000);
						}
						catch (Exception e) {
							System.out.println("ooutput type REALISED_ACOUSTPARAMS, text not found!");
							System.out.println("error message: " + e.getLocalizedMessage() + "\n");
						}
						
						//Test Realised Durations
						try {
							outputType.selectByVisibleText("REALISED_DURATIONS");
							processButton.click();
							Thread.sleep(50000);
						}
						catch (Exception e) {
							System.out.println("ooutput type REALISED_DURATIONS, text not found!");
							System.out.println("error message: " + e.getLocalizedMessage() + "\n");
						}
						
						//Test Praat TextGrid
						try {
							outputType.selectByVisibleText("PRAAT_TEXTGRID");
							processButton.click();
							Thread.sleep(50000);
						}
						catch (Exception e) {
							System.out.println("ooutput type PRAAT_TEXTGRID, text not found!");
							System.out.println("error message: " + e.getLocalizedMessage() + "\n");
						}
			    	}
		    	}
		    }
			
			safariDriver.quit();
		}
	}

}
