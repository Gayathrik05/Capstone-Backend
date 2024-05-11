package com.rts.ccp.dto;

public class OptionResponseDTO {

	private long pollId;
	 
	private long optionId;
 
	private long userid;

	public long getPollId() {
		return pollId;
	}

	public void setPollId(long pollId) {
		this.pollId = pollId;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public OptionResponseDTO(long pollId, long optionId, long userid) {
		super();
		this.pollId = pollId;
		this.optionId = optionId;
		this.userid = userid;
	}

	public OptionResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OptionResponseDTO [pollId=" + pollId + ", optionId=" + optionId + ", userid=" + userid + "]";
	}
 	
	
}
