package com.group.exam.notice.dao;

import java.util.List;

import com.group.exam.notice.vo.NoticeVO;
import com.group.exam.reply.vo.ReplyVO;

public interface NoticeDAO {
	public List<NoticeVO> selectAll();
	public NoticeVO selectDetail(Integer boardSeq);
	public int count();
	public void insert(NoticeVO noticeVO);
	public void update(NoticeVO noticeVO);
	public void delete(Integer boardSeq);
	//댓글
	public List<ReplyVO> replySelect(Integer boardSeq);
	public int replyCount();
	public void replyInsert(ReplyVO replyVO);
	public void replyUpdate(ReplyVO replyVO);
	public void replyDelete(Integer replySeq);
}