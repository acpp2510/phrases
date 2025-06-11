package com.example.phrase.controllers;

import com.example.phrase.models.Phrase;
import com.example.phrase.repositories.PhraseRepository;
import com.example.phrase.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/phrases")
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping
    public ResponseEntity<List<Phrase>> getAllPhrase(){
        List<Phrase> phrasesList = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(phrasesList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Phrase getForId(@PathVariable Long id){
        return phraseService.getPhraseById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Phrase don´t found with ID: "+ id
        ));
    }

}
