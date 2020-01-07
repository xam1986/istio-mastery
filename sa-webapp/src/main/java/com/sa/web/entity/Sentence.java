package com.sa.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sentence {
	@Id
	@GeneratedValue
	private Long id;
	private String sentence;

	public Sentence() {
		super();
	}

	public Sentence(Long id, String sentence) {
		super();
		this.id = id;
		this.sentence = sentence;
	}

	public Sentence(String sentence) {
		super();
		this.sentence = sentence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {
		return String.format("Sentence [id=%s, sentence=%s]", id, sentence);
	}

}
