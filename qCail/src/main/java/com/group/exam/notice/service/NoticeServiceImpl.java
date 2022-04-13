package com.group.exam.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.notice.command.WriteCommand;
import com.group.exam.notice.dao.NoticeDAO;
import com.group.exam.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeVO> showList() {
		return noticeDAO.selectAll();
	}
	
	public NoticeVO showDetail(Long noticeSeq) {
		NoticeVO detail = noticeDAO.selectDetail(noticeSeq);
		return detail;
	}
	
	public void insertWrite(WriteCommand writeCommand) {
		
		NoticeVO newNotice = new NoticeVO();
		
		//newNotice.setNoticeSeq(writeCommand.getNoticeSeq());
		newNotice.setNoticeTitle(writeCommand.getNoticeTitle());
		newNotice.setNoticeContent(writeCommand.getNoticeContent());
		//newNotice.setNoticeRegDay(writeCommand.getNoticeRegDay());
		newNotice.setAdminSeq(writeCommand.getAdminSeq());

		noticeDAO.insert(newNotice);
	}

	public void wite(WriteCommand writeCommand) {
		//글쓰는 사람의 시퀀스를 추출해야함

		NoticeVO newNotice = new NoticeVO();
		
		//newNotice.setNoticeSeq(writeCommand.getNoticeSeq());
		newNotice.setNoticeTitle(writeCommand.getNoticeTitle());
		newNotice.setNoticeContent(writeCommand.getNoticeContent());
		//newNotice.setNoticeRegDay(writeCommand.getNoticeRegDay());
		newNotice.setAdminSeq(writeCommand.getAdminSeq());
	
		noticeDAO.insert(newNotice);

	}
}
