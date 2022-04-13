package com.group.exam.notice.dao;

import java.util.List;

import com.group.exam.notice.vo.NoticeVO;

public interface NoticeDAO {
	public List<NoticeVO> selectAll();
	public NoticeVO selectDetail(Long noticeSeq);
	public int count();
	public void insert(NoticeVO noticeVO);
	public void update(NoticeVO noticeVO);
	public void delete(Long noticeSeq);
}