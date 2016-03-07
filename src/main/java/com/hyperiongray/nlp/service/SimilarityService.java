package com.hyperiongray.nlp.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimilarityService {

	private static final Logger logger = LoggerFactory.getLogger(SimilarityService.class);
	
	@Value("${model.word2vec.trained.location}")
	private String trainedModelLocation;

	private Word2Vec model;
	
	@PostConstruct
	public void createService() throws IOException {
		logger.info("Loading Google model in memory from file " + trainedModelLocation);
		File gModel = new File("/Users/alex/Documents/Word2Vec/GoogleNews-vectors-negative300.bin.gz");
		model = (Word2Vec) WordVectorSerializer.loadGoogleModel(gModel, true);
		logger.info("Google model loaded");
	}
	
	public Double getWordSimilarity(String word1, String word2) {
		return model.similarity(word1, word2);
	}
	
}
