package com.sa.web;

import com.sa.web.dto.SentenceDto;
import com.sa.web.dto.SentimentDto;
import com.sa.web.entity.Sentence;
import com.sa.web.entity.SentenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class SentimentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${sa.logic.api.url}")
    private String saLogicApiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    SentenceRepository repository;

    public SentimentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/sentiment")
    public SentimentDto sentimentAnalysis(@RequestBody SentenceDto sentenceDto) {

        logger.info("sentimentAnalysis {}", sentenceDto);
        if (repository.findBySentence(sentenceDto.getSentence()) != null)
            repository.save(new Sentence(sentenceDto.getSentence()));

        return restTemplate.postForEntity(saLogicApiUrl + "/analyse/sentiment",
                sentenceDto, SentimentDto.class)
                .getBody();
    }
}


