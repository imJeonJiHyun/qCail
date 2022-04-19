package com.group.exam.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.notice.vo.NoticeVO;
import com.group.exam.reply.vo.ReplyVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public NoticeDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<NoticeVO> selectAll() {
		return sqlSessionTemplate.selectList("selectAll");
	}
	
	@Override
	public NoticeVO selectDetail(Integer boardSeq) {
		return sqlSessionTemplate.selectOne("selectDetail", boardSeq);
	}

	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("count");
	}

	@Override
	public void insert(NoticeVO noticeVO) {
		sqlSessionTemplate.insert("insert", noticeVO);
	}

	@Override
	public void update(NoticeVO noticeVO) {
		sqlSessionTemplate.update("update", noticeVO);
	}

	@Override
	public void delete(Integer boardSeq) {
		sqlSessionTemplate.delete("delete", boardSeq);
	}

	//댓글
	@Override
	public List<ReplyVO> replySelect(Integer boardSeq) {
		return sqlSessionTemplate.selectList("replySelect", boardSeq);
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
	public void replyDelete(Integer replySeq) {
		sqlSessionTemplate.delete("replyDelete", replySeq);
	}
}