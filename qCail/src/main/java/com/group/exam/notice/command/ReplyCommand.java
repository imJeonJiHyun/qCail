package com.group.exam.notice.command;

public class ReplyCommand {
	private Integer replySeq;
	private Integer boardSeq;
	private Integer memberSeq;
	private String replyContent;
	
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
}
