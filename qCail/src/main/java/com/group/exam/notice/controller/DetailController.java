package com.group.exam.notice.controller;

import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.exam.notice.exception.DetailNotFoundException;
import com.group.exam.notice.service.NoticeService;
import com.group.exam.notice.vo.NoticeVO;
import com.group.exam.reply.vo.ReplyVO;

@Controller
public class DetailController {

	@Autowired
	private NoticeService detailService;
	
	
	@RequestMapping("/notice/read/{boardSeq}")
	public String noticeDetail(Model model, @PathVariable("boardSeq") Integer boardSeq) {
		NoticeVO noticeDetail = detailService.showDetail(boardSeq);
		List<ReplyVO> replySelect = detailService.replySelect(boardSeq);
		
		if(noticeDetail == null) {
			throw new DetailNotFoundException();
		}

		model.addAttribute("noticeDetail", noticeDetail);
		model.addAttribute("replySelect", replySelect);
		return "notice_detail_form";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String noticeNumberTypeMismatch() {
		return "exception/NTypeEx";
	}
	
	@ExceptionHandler(DetailNotFoundException.class)
	public String noDetail() {
		return "exception/nodetail";
	}
}
