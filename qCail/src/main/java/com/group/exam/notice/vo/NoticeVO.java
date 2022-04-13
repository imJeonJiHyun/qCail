package com.group.exam.notice.vo;

import java.sql.Date;

public class NoticeVO {
	private Long noticeSeq;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegDay;
	private static Long adminSeq;
	private static String adminNickname;
	//db랑 이름 맞춰주기
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
	public static Long getAdminSeq() {
		return adminSeq;
	}
	public void setAdminSeq(Long adminSeq) {
		this.adminSeq = adminSeq;
	}
	public static String getAdminNickname() {
		return adminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}
}