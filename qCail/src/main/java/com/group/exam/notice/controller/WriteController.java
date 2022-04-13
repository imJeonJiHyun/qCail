package com.group.exam.notice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.notice.command.WriteCommand;
import com.group.exam.notice.service.NoticeService;
import com.group.exam.notice.vo.NoticeVO;

@Controller
public class WriteController {
	
	@Autowired
	private NoticeService writeService;
	
	public void setWriteService(NoticeService writeService) {
		this.writeService = writeService;
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String insertWrite(@ModelAttribute("writeForm") WriteCommand writeCommand, HttpSession session) {
		session.setAttribute("adminSeq", NoticeVO.getAdminSeq());
		session.setAttribute("adminNickname", NoticeVO.getAdminNickname());
		return "notice_write_form";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("writeForm") WriteCommand writeCommand, HttpSession session) {
		writeService.insertWrite(writeCommand);
		session.setAttribute("adminSeq", NoticeVO.getAdminSeq());
		session.setAttribute("adminNickname", NoticeVO.getAdminNickname());
		return "redirect:/notice/list";
	}
}