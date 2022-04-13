package com.group.exam.notice.command;

import java.sql.Date;

public class ListCommand {
	private Long noticeSeq;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegDay;
	private Long adminSeq;
	
	public Long getNoticeSeq() {
		return noticeSeq;
	}
	public void setNoticeSeq(Long noticeSeq) {
		this.noticeSeq = noticeSeq;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeRegDay() {
		return noticeRegDay;
	}
	public void setNoticeRegDay(Date noticeRegDay) {
		this.noticeRegDay = noticeRegDay;
	}
	public Long getAdminSeq() {
		return adminSeq;
	}
	public void setAdminSeq(Long adminSeq) {
		this.adminSeq = adminSeq;
	}
}
