package com.group.exam.reply.service;

import java.util.List;

import com.group.exam.reply.command.WriteCommand;
import com.group.exam.reply.vo.ReplyVO;



public interface ReplyService {
	public List<ReplyVO> showReply();
	public void inserWrite(WriteCommand writeCommand);
}