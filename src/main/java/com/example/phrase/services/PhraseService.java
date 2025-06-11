package com.example.phrase.services;

import com.example.phrase.models.Phrase;
import com.example.phrase.repositories.PhraseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases(){
        return phraseRepository.findAll();
    }

    public Optional<Phrase> getPhraseById (Long id){
        return phraseRepository.findById(id);
    }

    public Phrase savePhrase (Phrase newPhrase){
        return phraseRepository.save(newPhrase);
    }

    public Phrase updatePhrase (Phrase phrase, Phrase newDetails){
        phrase.setText(newDetails.getText());
        phrase.setAuthor(newDetails.getAuthor());
        return phraseRepository.save(phrase);
    }

    public void deletePhrase(Phrase phrase) {
        phraseRepository.delete(phrase);
    }
}
