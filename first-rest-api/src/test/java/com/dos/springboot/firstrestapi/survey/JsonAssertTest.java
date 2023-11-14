package com.dos.springboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	@Test
	void jsonAssert_learningBasics() throws JSONException {
		String expectedResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform","options":["AWS","Azure","GCP"],"correctAnswer":"AWS"}
				""";
		String actualResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform","options":["AWS","Azure","GCP"],"correctAnswer":"AWS"}
				""";
		
		JSONAssert.assertEquals( expectedResponse, actualResponse, true );
	}

}
