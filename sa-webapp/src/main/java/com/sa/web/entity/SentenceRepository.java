package com.sa.web.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long>{

    @Query("select s from Sentence s where s.sentence = :sentence")
    Sentence findBySentence(@Param("sentence") String sentence);
}
