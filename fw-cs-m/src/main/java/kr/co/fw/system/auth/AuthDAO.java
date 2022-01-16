package kr.co.fw.system.auth;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

/**
 * @desc : 시스템관리 DAO
 * @author : chys
 */
@Repository(value = "AuthDAO")
public class AuthDAO extends BaseDAO {

	private static final String SQL_PREFIX = "Auth.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @desc 인증 이력 조회 
	 * @param AuthVO
	 * @return ArrayList<SystemVO>
	 * @throws Exception
	 */
	public List<HashMap<String, Object>> selectAuthLogList(AuthVO paramvo) throws Exception {
		return sqlSession.selectList(SQL_PREFIX + "selectAuthLogList", paramvo);
	}
	
	/**
	 * @desc 인증 이력 입력
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int insertAuthLog(AuthVO paramvo) throws Exception {
		return sqlSession.insert(SQL_PREFIX + "insertAuthLog", paramvo);
	}
	
	/**
	 * @desc 인증 이력 수정
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int updateAuthLog(AuthVO paramvo) throws Exception {
		return sqlSession.update(SQL_PREFIX + "updateAuthLog", paramvo);
	}
	
	/**
	 * @desc 인증 이력 삭제
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteAuthLog(AuthVO paramvo) throws Exception {
		return sqlSession.delete(SQL_PREFIX + "deleteAuthLog", paramvo);
	}

}
