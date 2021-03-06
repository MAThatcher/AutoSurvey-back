package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID", updatable=false)
	private int id;
		
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	//TODO: Adjust column length
	@Column(length=1024, name="CONTENT")
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name = "RESPONSE_ID")
	@JsonBackReference
	private Response response;
	
	
	
	public Answer() {
		
	}

	public Answer(int id, Question question, String content) {
		super();
		this.id = id;
		this.question = question;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id +  ", question=" + question + ", content=" + content + "]";
	}

	
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
	
	
}
