package com.votingapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chart")
public class Chart {
	@Id
	@Column(name="id")
	private int id;

	@Column(name="question")
	private String question;
	
	@Column(name="option")
	private String option;
	
	@Column(name="value")
	private int value;
	
	@Column(name="creator")
	private String creator;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Chart(String question, String option, String creator) {
		this.question = question;
		this.option = option;
		this.value = value;
		this.creator = creator;
	}

	public Chart() {
		
	}

}
