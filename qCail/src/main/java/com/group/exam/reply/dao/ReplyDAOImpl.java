package com.group.exam.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.exam.reply.vo.ReplyVO;

public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ReplyDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<ReplyVO> replySelect() {
		return sqlSessionTemplate.selectList("select");
	}
	
	@Override
	public int replyCount() {
		return sqlSessionTemplate.selectOne("count");
	}

	@Override
	public void replyInsert(ReplyVO replyVO) {
		sqlSessionTemplate.insert("insert", replyVO);	
	}

	@Override
	public void replyUpdate(ReplyVO replyVO) {
		sqlSessionTemplate.update("update", replyVO);
	}

	@Override
	public void replyDelete(Long replySeq) {
		sqlSessionTemplate.delete("delete", replySeq);
	}
}