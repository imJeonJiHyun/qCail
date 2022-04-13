package com.group.exam.notice.service;

import java.util.List;

import com.group.exam.notice.command.WriteCommand;
import com.group.exam.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> showList();
	public NoticeVO showDetail(Long noticeSeq);
	public void insertWrite(WriteCommand writeCommand);
	public void wite(WriteCommand writeCommand);
}