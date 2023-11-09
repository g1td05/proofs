package com.dos.springboot.firstrestapi.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyResource {

	@Autowired
	private SurveyService surveyService;
	
	public SurveyResource() {}

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	
	@RequestMapping( "/surveys" )
	public List< Survey > retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}

	
}
