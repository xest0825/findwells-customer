package kr.co.fw.common.msg;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * 원수사 관리 service
 */
@Slf4j
@Service(value = "MessageService")
public class MessageService extends BaseService{

	/**
	 * message 로그 이력 조회
	 */
	public List<HashMap<String, Object>> getMessageLogList(MessageVO paramvo) {
		try {
			return getMessageDAO().getMessageLogList(paramvo);
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
			return getMessageDAO().insertMessageLog(paramvo);
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
			return getMessageDAO().updateMessageLog(paramvo);
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
			return getMessageDAO().deleteMessageLog(paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	

}
