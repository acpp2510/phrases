package com.example.phrase.controllers;

import com.example.phrase.models.Phrase;
import com.example.phrase.repositories.PhraseRepository;
import com.example.phrase.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public ResponseEntity<List<Phrase>> getAllPhrase(){
        List<Phrase> phrasesList = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(phrasesList,HttpStatus.OK);
    }
}
