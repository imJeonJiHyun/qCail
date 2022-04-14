package com.group.exam.reply.vo;

import java.sql.Date;

public class ReplyVO {
	private Long replySeq;
	private Long boardSeq;
	private Long memberSeq;
	private String replyContent;
	private String memberNickname;
	private Date replyRegDay;
	
	public Long getReplySeq() {
		return replySeq;
	}
	public void setReplySeq(Long replySeq) {
		this.replySeq = replySeq;
	}
	public Long getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(Long boardSeq) {
		this.boardSeq = boardSeq;
	}
	public Long getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(Long memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyRegDay() {
		return replyRegDay;
	}
	public void setReplyRegDay(Date replyRegDay) {
		this.replyRegDay = replyRegDay;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "ReplyVO [replySeq=" + replySeq + ", boardSeq=" + boardSeq + ", memberSeq=" + memberSeq
				+ ", replyContent=" + replyContent + ", memberNickname=" + memberNickname + ", replyRegDay="
				+ replyRegDay + "]";
	}
	
	
	
	
	
}