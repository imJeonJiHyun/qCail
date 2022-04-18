package com.group.exam.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.reply.command.WriteCommand;
import com.group.exam.reply.dao.ReplyDAO;
import com.group.exam.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public List<ReplyVO> replySelect() {
		return replyDAO.replySelect();
	}

	@Override
	public void replyInsert(WriteCommand writeCommand) {
		ReplyVO replyInsert = new ReplyVO();
		//replyInsert.setReplySeq(writeCommand.getReplySeq());
		replyInsert.setBoardSeq(writeCommand.getBoardSeq());
		replyInsert.setMemberSeq(writeCommand.getMemberSeq());
		replyInsert.setReplyContent(writeCommand.getReplyContent());
		
		System.out.println("댓글 서비스 클래스 insert \n" + replyInsert);
		replyDAO.replyInsert(replyInsert);
	}

	@Override
	public void replyUpdate(WriteCommand writeCommand) {
		ReplyVO replyUpdate = new ReplyVO();
		//replyUpdate.setReplySeq(writeCommand.getReplySeq());
		//replyUpdate.setBoardSeq(writeCommand.getBoardSeq());
		//replyUpdate.setMemberSeq(writeCommand.getMemberSeq());
		replyUpdate.setReplyContent(writeCommand.getReplyContent());
		
		System.out.println("댓글 서비스 클래스 update \n" + replyUpdate);
		replyDAO.replyUpdate(replyUpdate);
	}

	@Override
	public void replyDelete(Long replySeq) {
		//ReplyVO replyDelete = new ReplyVO();
		//replyDelete.setReplySeq(replyDelete.getReplySeq());
		//replyDelete.setBoardSeq(writeCommand.getBoardSeq());
		//replyDelete.setMemberSeq(writeCommand.getMemberSeq());
		//replyDelete.setReplyContent(writeCommand.getReplyContent());
		
		//System.out.println("댓글 서비스 클래스 update \n" + replyDelete);
		replyDAO.replyDelete(replySeq);
	}
}