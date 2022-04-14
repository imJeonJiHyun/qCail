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
	public List<ReplyVO> showReply() {
		return replyDAO.replySelect();
	}

	@Override
	public void insertWrite(WriteCommand writeCommand) {
		ReplyVO newReply = new ReplyVO();
		//newReply.setReplySeq(writeCommand.getReplySeq());
		newReply.setBoardSeq(writeCommand.getBoardSeq());
		newReply.setMemberSeq(writeCommand.getMemberSeq());
		newReply.setReplyContent(writeCommand.getReplyContent());
		
		System.out.println("댓글 서비스 클래스 insert \n" + newReply);
		replyDAO.replyInsert(newReply);
	}
}