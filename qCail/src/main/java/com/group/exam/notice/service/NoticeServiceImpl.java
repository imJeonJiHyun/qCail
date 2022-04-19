package com.group.exam.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.notice.command.ReplyCommand;
import com.group.exam.notice.command.WriteCommand;
import com.group.exam.notice.dao.NoticeDAO;
import com.group.exam.notice.vo.NoticeVO;
import com.group.exam.reply.vo.ReplyVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeVO> showList() {
		return noticeDAO.selectAll();
	}
	
	public NoticeVO showDetail(Integer boardSeq) {
		NoticeVO detail = noticeDAO.selectDetail(boardSeq);
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
	
	//댓글
	@Override
	public List<ReplyVO> replySelect(Integer boardSeq) {
		return noticeDAO.replySelect(boardSeq);
	}

	@Override
	public void replyInsert(ReplyCommand replyCommand) {
		ReplyVO replyInsert = new ReplyVO();
		//replyInsert.setReplySeq(replyCommand.getReplySeq());
		replyInsert.setBoardSeq(replyCommand.getBoardSeq());
		replyInsert.setMemberSeq(replyCommand.getMemberSeq());
		replyInsert.setReplyContent(replyCommand.getReplyContent());
		
		System.out.println("댓글 서비스 클래스 insert \n" + replyInsert);
		noticeDAO.replyInsert(replyInsert);
	}

	@Override
	public void replyUpdate(ReplyCommand replyCommand) {
		ReplyVO replyUpdate = new ReplyVO();
		//replyUpdate.setReplySeq(replyCommand.getReplySeq());
		//replyUpdate.setBoardSeq(replyCommand.getBoardSeq());
		//replyUpdate.setMemberSeq(replyCommand.getMemberSeq());
		replyUpdate.setReplyContent(replyCommand.getReplyContent());
		
		System.out.println("댓글 서비스 클래스 update \n" + replyUpdate);
		noticeDAO.replyUpdate(replyUpdate);
	}

	@Override
	public void replyDelete(Integer replySeq) {
		//ReplyVO replyDelete = new ReplyVO();
		//replyDelete.setReplySeq(replyDelete.getReplySeq());
		//replyDelete.setBoardSeq(replyCommand.getBoardSeq());
		//replyDelete.setMemberSeq(replyCommand.getMemberSeq());
		//replyDelete.setReplyContent(replyCommand.getReplyContent());
		
		//System.out.println("댓글 서비스 클래스 update \n" + replyDelete);
		noticeDAO.replyDelete(replySeq);
	}
}
