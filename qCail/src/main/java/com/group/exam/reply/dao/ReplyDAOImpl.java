package com.group.exam.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.reply.vo.ReplyVO;
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ReplyDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<ReplyVO> replySelect() {
		return sqlSessionTemplate.selectList("replySelect");
	}
	
	@Override
	public int replyCount() {
		return sqlSessionTemplate.selectOne("replyCount");
	}

	@Override
	public void replyInsert(ReplyVO replyVO) {
		sqlSessionTemplate.insert("replyInsert", replyVO);	
	}

	@Override
	public void replyUpdate(ReplyVO replyVO) {
		sqlSessionTemplate.update("replyUpdate", replyVO);
	}

	@Override
	public void replyDelete(Long replySeq) {
		sqlSessionTemplate.delete("replyDelete", replySeq);
	}
}