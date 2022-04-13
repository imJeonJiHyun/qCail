package com.group.exam.reply.dao;

import java.util.List;

import com.group.exam.reply.vo.ReplyVO;


public interface ReplyDAO {
	public List<ReplyVO> replySelect();
	public int replyCount();
	public void replyInsert(ReplyVO replyVO);
	public void replyUpdate(ReplyVO replyVO);
	public void replyDelete(Long replySeq);
}