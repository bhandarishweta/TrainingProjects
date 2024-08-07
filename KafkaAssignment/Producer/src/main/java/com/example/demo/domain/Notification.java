package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Notification {
	
	private Long id;
	
	private String message;
	
	private String recepient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + ", recepient=" + recepient + "]";
	}
	
	

}
