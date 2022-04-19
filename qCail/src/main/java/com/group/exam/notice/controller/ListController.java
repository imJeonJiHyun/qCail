package com.group.exam.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.notice.service.NoticeService;
import com.group.exam.notice.vo.NoticeVO;

@Controller
public class ListController {
	
	@Autowired
	private NoticeService noticeService;
	

	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public String showList(Model model) {
		List<NoticeVO> noticeList = noticeService.showList();
		model.addAttribute("noticeList", noticeList);
		return "notice_list_form";
	}
}