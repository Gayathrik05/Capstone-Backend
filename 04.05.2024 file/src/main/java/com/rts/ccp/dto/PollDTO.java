package com.rts.ccp.dto;

import java.sql.Date;
import java.util.List;

import com.rts.ccp.bean.Comment;
import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.Reaction;
import com.rts.ccp.bean.User;

public class PollDTO {
	private String pollQuestion;

	private List<Option> options;

	private Date timeStamp;

	private Date endDate;

	private boolean status;

	private List<Reaction> reaction;

	private List<Comment> comments;

	private User user;


	public PollDTO() {
		super();
	}

	public PollDTO(String pollQuestion, List<Option> options, Date timeStamp, Date endDate, boolean status,
			List<Reaction> reaction, List<Comment> comments, User user) {
		super();
		this.pollQuestion = pollQuestion;
		this.options = options;
		this.timeStamp = timeStamp;
		this.endDate = endDate;
		this.status = status;
		this.reaction = reaction;
		this.comments = comments;
		this.user = user;
	}

	public String getPollQuestion() {
		return pollQuestion;
	}

	public void setPollQuestion(String pollQuestion) {
		this.pollQuestion = pollQuestion;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Reaction> getReaction() {
		return reaction;
	}

	public void setReaction(List<Reaction> reaction) {
		this.reaction = reaction;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
