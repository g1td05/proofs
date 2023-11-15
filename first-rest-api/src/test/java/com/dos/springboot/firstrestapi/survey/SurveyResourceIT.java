package com.dos.springboot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
public class SurveyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTIONS_URL	= "/surveys/Survey1/questions";

	@Autowired
	TestRestTemplate template;

	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity< String > responseEntity = template.getForEntity( SPECIFIC_QUESTION_URL, String.class );
		
		String expectedResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform","options":["AWS","Azure","GCP"],"correctAnswer":"AWS"}
				""";
		
		assertTrue( responseEntity.getStatusCode().is2xxSuccessful() );
		assertEquals( "application/json", responseEntity.getHeaders().get( "Content-Type" ).get( 0 ) );
		
		JSONAssert.assertEquals( expectedResponse, responseEntity.getBody(), false );
		
	}
	
	@Test
	void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
		ResponseEntity< String > responseEntity = template.getForEntity( GENERIC_QUESTIONS_URL, String.class );
		String expectedResponse = 
				"""
					[
					    {
					        "id": "Question1"
					    },
					    {
					        "id": "Question2"
					    },
					    {
					        "id": "Question3"
					    }
					]
				
				""";
		assertTrue( responseEntity.getStatusCode().is2xxSuccessful() );
		assertEquals( "application/json", responseEntity.getHeaders().get( "Content-Type" ).get( 0 ) );
		
		JSONAssert.assertEquals( expectedResponse, responseEntity.getBody(), false );
	}
	
	@Test
	void addNewSurveyQuestion_basicScenario() {
		String requestBody = """
				
				{
					"description":"Not so Most Popular DevOps Tool",
					"options":[
						"Kubernetes",
						"Docker",
						"Terraform"
					],
					"correctAnswer":"No one"
				}
				
				""";
		
		HttpHeaders headers = new HttpHeaders();

		headers.add( "Content-Type", "application/json" );
		
		HttpEntity< String > httpEntity = new HttpEntity< String >( requestBody, headers );
		
		ResponseEntity<String> responseEntity = template.exchange( GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class );
		
		System.out.println( "Response: " + responseEntity.getStatusCode() + "<<<<<<<<<<<" );
		
		assertTrue( responseEntity.getStatusCode().is2xxSuccessful() );
		String locationHeader = responseEntity.getHeaders().get( "Location" ).get( 0 );
		System.out.println( locationHeader + "<<<<<<<<<<<<<" );
		assertTrue( locationHeader.contains( "/surveys/Survey1/questions/" ) );
		
		template.delete( locationHeader );
	}
	
}
