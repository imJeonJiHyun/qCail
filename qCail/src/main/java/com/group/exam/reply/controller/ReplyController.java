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
	public String showReply(WriteCommand writeCommand, Model model) {
		List<ReplyVO> replyList = replyService.showReply();
		model.addAttribute("replyList", replyList);
		return "reply_list_form";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String insertWrite(@ModelAttribute("writeForm") WriteCommand writeCommand) {
		replyService.insertWrite(writeCommand);
		return "redirect:/reply";
	}
}