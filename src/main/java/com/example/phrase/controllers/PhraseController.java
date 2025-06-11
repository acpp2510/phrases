package com.example.phrase.controllers;

import com.example.phrase.models.Phrase;
import com.example.phrase.repositories.PhraseRepository;
import com.example.phrase.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/create")
    public ResponseEntity addPhrase (@RequestBody Phrase newPhrase){
        Phrase createdPhrase = phraseService.savePhrase(newPhrase);
        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);
    }

}
