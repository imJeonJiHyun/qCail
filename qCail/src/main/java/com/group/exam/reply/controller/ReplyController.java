package com.group.exam.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.reply.command.WriteCommand;
import com.group.exam.reply.service.ReplyService;
import com.group.exam.reply.vo.ReplyVO;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/reply", method=RequestMethod.GET)
	public String replySelect(WriteCommand writeCommand, Model model) {
		List<ReplyVO> replySelect = replyService.replySelect();
		model.addAttribute("replySelect", replySelect);
		return "reply_list_form";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String replyInsert(@ModelAttribute("writeForm") WriteCommand writeCommand) {
		replyService.replyInsert(writeCommand);
		return "redirect:/reply";
	}
	
//	@RequestMapping(value="/reply/update", method=RequestMethod.GET)
//	public String replyUpdate(WriteCommand writeCommand, Model model) {
//		model.addAttribute("replyUpdate", re)
//		return "reply_update_form";
//	} 수정 컨트롤러
}