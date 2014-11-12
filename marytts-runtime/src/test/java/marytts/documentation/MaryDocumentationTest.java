package marytts.documentation;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import marytts.LocalMaryInterface;
import marytts.htsengine.HMMVoice;
import marytts.modules.synthesis.HMMSynthesizer;
import marytts.modules.synthesis.Voice;
import marytts.server.http.InfoRequestHandler;

import org.junit.Before;
import org.junit.Test;

public class MaryDocumentationTest {
	String voiceName = "cmu-slt-hsmm";
	
	@Before
	public void setUp() throws Exception {
		LocalMaryInterface mary = new LocalMaryInterface();
		HMMSynthesizer hmmSynth = new HMMSynthesizer();
		HMMVoice v = new HMMVoice(voiceName, hmmSynth);
        Voice.registerVoice(v);
	}
	
	@Test
	public void testAllVoices() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(null, null);
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocale() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=de: []
		String expectedOutput = "[]";
		queryVariables.put("locale", "de");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-gb: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-gb");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithName() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, name=cmu-slt-hsmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("name", "cmu-slt-hsmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=dummy-name: []
		expectedOutput = "[]";
		queryVariables.put("name", "dummy-name");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithGender() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, gender=female: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("gender", "female");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithType() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, type=hmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("type", "hmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleAndName() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, name=cmu-slt-hsmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=cmu-slt-hsmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "cmu-slt-hsmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, name=dummy-name: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "dummy-name");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleAndGender() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, gender=female: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("gender", "female");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, gender=female: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("gender", "female");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleAndType() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, type=hmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("type", "hmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("type", "hmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithNameAndGender() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, name=cmu-slt-hsmm, gender=female: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "female");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=cmu-slt-hsmm, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=dummy-name, gender=female: []
		expectedOutput = "[]";
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "female");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=dummy-name, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithNameAndType() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, name=cmu-slt-hsmm, type=hmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("type", "hmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=cmu-slt-hsmm, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=dummy-name, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("name", "dummy-name");
		queryVariables.put("type", "hmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, name=dummy-name, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("name", "dummy-name");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleNameAndGender() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, gender=female: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "female");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, gender=female: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "female");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, gender=male: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "male");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleNameAndType() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, type=hmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("type", "hmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("type", "hmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testVoicesWithLocaleNameGenderAndType() {
		InfoRequestHandler requestHandler = new InfoRequestHandler();
		Map<String, String> queryVariables = new HashMap<String, String> ();
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, gender=female, type=hmm: [{"name":"cmu-slt-hsmm","locale":"en_US","gender":"female","type":"hmm"}]
		String expectedOutput = "[{\"name\":\"cmu-slt-hsmm\",\"locale\":\"en_US\",\"gender\":\"female\",\"type\":\"hmm\"}]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "female");
		queryVariables.put("type", "hmm");
		String actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=en-us, name=cmu-slt-hsmm, gender=female, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("locale", "en-us");
		queryVariables.put("name", "cmu-slt-hsmm");
		queryVariables.put("gender", "female");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, gender=female, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "female");
		queryVariables.put("type", "hmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, gender=male, type=hmm: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "male");
		queryVariables.put("type", "hmm");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
		
		//expected output, locale=de, name=dummy-name, gender=male, type=unit: []
		expectedOutput = "[]";
		queryVariables.put("locale", "de");
		queryVariables.put("name", "dummy-name");
		queryVariables.put("gender", "male");
		queryVariables.put("type", "unit");
		actualOutput = requestHandler.methodsMapping.get("voices").callCorrectMethod(queryVariables, null);
		assertEquals(expectedOutput, actualOutput);
	}
}
