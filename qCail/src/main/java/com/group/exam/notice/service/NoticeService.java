package com.group.exam.notice.service;

import java.util.List;

import com.group.exam.notice.command.ReplyCommand;
import com.group.exam.notice.command.WriteCommand;
import com.group.exam.notice.vo.NoticeVO;
import com.group.exam.reply.vo.ReplyVO;

public interface NoticeService {
	public List<NoticeVO> showList();
	public NoticeVO showDetail(Integer boardSeq);
	public void insertWrite(WriteCommand writeCommand);
	public void wite(WriteCommand writeCommand);
	//댓글
	public List<ReplyVO> replySelect(Integer boardSeq);
	public void replyInsert(ReplyCommand replyCommand);
	public void replyUpdate(ReplyCommand replyCommand);
	public void replyDelete(Integer replySeq);
}