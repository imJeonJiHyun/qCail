package com.group.exam.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.reply.command.WriteCommand;
import com.group.exam.reply.service.ReplyService;
import com.group.exam.reply.vo.ReplyVO;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/notice/read/{boardSeq}", method=RequestMethod.GET)
	public String replySelect(@ModelAttribute("writeForm") WriteCommand writeCommand, Model model) {
		List<ReplyVO> replySelect = replyService.replySelect();
		model.addAttribute("replySelect", replySelect);
		return "reply_list_form";
	}
	
	@RequestMapping(value="/notice/read/{boardSeq}", method=RequestMethod.POST)
	public String replyInsert(@ModelAttribute("writeForm") WriteCommand writeCommand) {
		replyService.replyInsert(writeCommand);
		return "redirect:/notice/read/{boardSeq}";
	}
	
	@RequestMapping(value = "/reqly/update", method = RequestMethod.POST)
	public Map<String, Object> replyUpdate(@RequestBody WriteCommand writeCommand) {
		Map<String, Object> result = new HashMap<>();
		try {
			replyService.replyUpdate(writeCommand);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	
//	@RequestMapping(value="/reply/update", method=RequestMethod.GET)
//	public String replyUpdate(WriteCommand writeCommand, Model model) {
//		model.addAttribute("replyUpdate", re)
//		return "reply_update_form";
//	} 수정 컨트롤러
}