package com.group.exam.reply.vo;

import java.sql.Date;

public class ReplyVO {
	private Integer replySeq;
	private Integer boardSeq;
	private Integer memberSeq;
	private String replyContent;
	private String memberNickname;
	private Date replyRegDay;
	
	public Integer getReplySeq() {
		return replySeq;
	}
	public void setReplySeq(Integer replySeq) {
		this.replySeq = replySeq;
	}
	public Integer getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(Integer boardSeq) {
		this.boardSeq = boardSeq;
	}
	public Integer getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public Date getReplyRegDay() {
		return replyRegDay;
	}
	public void setReplyRegDay(Date replyRegDay) {
		this.replyRegDay = replyRegDay;
	}
}