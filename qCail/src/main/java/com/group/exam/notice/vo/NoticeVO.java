package com.group.exam.notice.vo;

import java.sql.Date;

public class NoticeVO {
	private Integer boardSeq;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegDay;
	private static Long adminSeq;
	private static String adminNickname;
	
	public Integer getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(Integer boardSeq) {
		this.boardSeq = boardSeq;
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
	public static void setAdminSeq(Long adminSeq) {
		NoticeVO.adminSeq = adminSeq;
	}
	public static String getAdminNickname() {
		return adminNickname;
	}
	public static void setAdminNickname(String adminNickname) {
		NoticeVO.adminNickname = adminNickname;
	}
	
}