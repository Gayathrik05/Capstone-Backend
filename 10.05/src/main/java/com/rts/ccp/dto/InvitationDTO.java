package com.rts.ccp.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rts.ccp.bean.User;

@Component
public class InvitationDTO {
	private Long invitationId;
	private String sender;
	private String recipientEmail;
	private String invitationCode;
	private LocalDateTime sentTime;
	private boolean accepted;
	private LocalDateTime acceptedTime;
	
	private List<User> users;
	
	
	
	public InvitationDTO(Long invitationId, String sender, String recipientEmail, String invitationCode,
			LocalDateTime sentTime, boolean accepted, LocalDateTime acceptedTime, List<User> users) {
		super();
		this.invitationId = invitationId;
		this.sender = sender;
		this.recipientEmail = recipientEmail;
		this.invitationCode = invitationCode;
		this.sentTime = sentTime;
		this.accepted = accepted;
		this.acceptedTime = acceptedTime;
		this.users = users;
	}
	public InvitationDTO() {
		super();
	}
	public Long getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public LocalDateTime getSentTime() {
		return sentTime;
	}
	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public LocalDateTime getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(LocalDateTime acceptedTime) {
		this.acceptedTime = acceptedTime;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}