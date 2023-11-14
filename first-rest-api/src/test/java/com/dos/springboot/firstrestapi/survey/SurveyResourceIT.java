package com.dos.springboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
public class SurveyResourceIT {

	String str = """
			
			{
				"id": "Question",
				"description": "Most Popular Platform",
				"options": [
					"AWS",
					"Azure",
					"GCP"
				],
				"correctAnswer": "AWS"
			}
			
			""";

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	
	@Autowired
	TestRestTemplate template;
	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity< String > responseEntity = template.getForEntity( SPECIFIC_QUESTION_URL, String.class );
		
		String expectedResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform","options":["AWS","Azure","GCP"],"correctAnswer":"AWS"}
				""";
		
		JSONAssert.assertEquals( expectedResponse, responseEntity.getBody(), false );
		
//		assertEquals( expectedResponse.trim(), responseEntity.getBody() );
		
//		System.out.println( responseEntity.getBody() );
//		System.out.println( responseEntity.getHeaders() );
	}
}
