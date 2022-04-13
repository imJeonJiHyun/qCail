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
	public void inserWrite(WriteCommand writeCommand) {
		ReplyVO newReply = new ReplyVO();
		newReply.setReplyContent(writeCommand.getReplyContent());
		replyDAO.replyInsert(newReply);	
	}
}