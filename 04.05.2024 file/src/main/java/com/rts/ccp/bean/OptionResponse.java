package com.rts.ccp.bean;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_option_response")
@Component
public class OptionResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long optionResponseId;

//	@Column(name = "option_response")
//	private long optionResponse;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poll_id")
	private Poll pollId;

	@JsonDeserialize()
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "option_id")
	private Option optionId;
	
	public OptionResponse() {
		super();

	}



	public OptionResponse(long optionResponseId, User user, Poll pollId, Option optionId) {
		super();
		this.optionResponseId = optionResponseId;
//		this.optionResponse = optionResponse;
		this.user = user;
		this.pollId = pollId;
		this.optionId = optionId;
	}



	public long getOptionResponseId() {
		return optionResponseId;
	}

	public void setOptionResponseId(long optionResponseId) {
		this.optionResponseId = optionResponseId;
	}

//	public long getOptionResponse() {
//		return optionResponse;
//	}
//
//	public void setOptionResponse(long optionResponse) {
//		this.optionResponse = optionResponse;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Poll getPollId() {
		return pollId;
	}

	public void setPollId(Poll pollId) {
		this.pollId = pollId;
	}



	public Option getOptionId() {
		return optionId;
	}



	public void setOptionId(Option optionId) {
		this.optionId = optionId;
	}



	@Override
	public String toString() {
		return "OptionResponse [optionResponseId=" + optionResponseId + ", user=" + user + ", pollId=" + pollId
				+ ", optionId=" + optionId + "]";
	}

	

}
