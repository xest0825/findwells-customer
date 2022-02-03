package kr.co.fw.common.msg;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import lombok.extern.slf4j.Slf4j;

/**
 * 원수사 DAO
 */
@Slf4j
@Repository(value = "MessageDAO")
public class MessageDAO extends BaseDAO {

	/**
	 * message 로그 이력 조회
	 */
	public List<HashMap<String, Object>> getMessageLogList(MessageVO paramvo) {
		try {
			return getSqlSession().selectList(getMessageMapper() + "getMessageLogList", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * message 이력 입력
	 */
	public int insertMessageLog(MessageVO paramvo) {
		try {
			return getSqlSession().insert(getMessageMapper() + "insertMessageLog", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * message 이력 수정
	 */
	public int updateMessageLog(MessageVO paramvo) {
		try {
			return getSqlSession().update(getMessageMapper() + "updateMessageLog", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * message 이력 삭제
	 */
	public int deleteMessageLog(MessageVO paramvo) {
		try {
			return getSqlSession().delete(getMessageMapper() + "deleteMessageLog", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
}
