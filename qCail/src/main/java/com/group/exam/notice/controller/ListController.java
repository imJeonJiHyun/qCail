package com.group.exam.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String showList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Long admin = (long) 1; //db에서 값을 가져오지 않고 임의로 값을 넣어서 테스트 중이였음
		String adminNick = "오가은";  //근데 실패함, 글쓰기 버튼은 뜨는데 닉네임이 뜨지 않음
		session.setAttribute("adminSeq", admin);
		session.setAttribute("adminNickname", adminNick);
		
		List<NoticeVO> noticeList = noticeService.showList();
		model.addAttribute("noticeList", noticeList);
		return "notice_list_form";
	}
}