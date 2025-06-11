package com.example.phrase.repositories;

import com.example.phrase.models.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long>  {

}
