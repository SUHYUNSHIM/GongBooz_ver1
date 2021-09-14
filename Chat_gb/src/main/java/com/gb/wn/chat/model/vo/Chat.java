package com.gb.wn.chat.model.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@ToString
public class Chat implements Serializable{
	private int no;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getVaildYN() {
		return vaildYN;
	}

	public void setVaildYN(String vaildYN) {
		this.vaildYN = vaildYN;
	}

	private String memberId;
	private int srNo;
	private String chatContent;
	private Date sendDate;
	
	private String vaildYN;
}
