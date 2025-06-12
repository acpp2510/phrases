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
    public ResponseEntity<Phrase> getForId(@PathVariable Long id){
        Phrase phrase = phraseService.getPhraseById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Phrase don´t found with ID: "+ id));
        return new ResponseEntity<>(phrase, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Phrase> addPhrase (@RequestBody Phrase newPhrase){
        Phrase createdPhrase = phraseService.savePhrase(newPhrase);
        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phrase> updatePhrase (@PathVariable Long id, @RequestBody Phrase phraseDetails){
        Phrase existingPhrase = phraseService.getPhraseById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Phrase not found with ID: " + id));
        Phrase updatedPhrase = phraseService.updatePhrase(existingPhrase, phraseDetails);
        return new ResponseEntity<Phrase>(updatedPhrase,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhrase(@PathVariable Long id) {
        Phrase existingPhrase = phraseService.getPhraseById(id).orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Phrase not found with ID: " + id));
        phraseService.deletePhrase(existingPhrase);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
