package com.group.exam.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.notice.vo.NoticeVO;

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
	public NoticeVO selectDetail(Long noticeSeq) {
		return sqlSessionTemplate.selectOne("selectDetail", noticeSeq);
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
	public void delete(Long noticeSeq) {
		sqlSessionTemplate.delete("delete", noticeSeq);
	}
}