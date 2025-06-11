package com.example.phrase.services;

import com.example.phrase.models.Phrase;
import com.example.phrase.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases(){
        return phraseRepository.findAll();
    }
}
