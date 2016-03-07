package com.hyperiongray.nlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperiongray.nlp.service.SimilarityService;

@RestController
public class WordSimilarityController {

	@Autowired
	SimilarityService similarityService;
	
	@RequestMapping(value="/api/v1/similarity")
	public Double getWordSimilarity(String word1, String word2) {
		return similarityService.getWordSimilarity(word1, word2);
	}
	
}
