package com.group.exam.reply.command;

public class WriteCommand {
	private Long boardSeq;
	private Long memberSeq;
	private String replyContent;
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
}