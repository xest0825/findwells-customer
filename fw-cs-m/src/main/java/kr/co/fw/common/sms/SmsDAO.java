package kr.co.fw.common.sms;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class SmsDAO extends BaseDAO {
	
	/**
	 * 장문 SMS전송 (nPro 아이하트)
	 * 
	 * @since 2021-02-15
	 * @param SmsVO
	 * @return void
	 */
	public void insertSendLongSmsInfo(SmsVO paramvo) {

		/*
		 * 주의사항 MSG_DATA 테이블에는 정상적으로 등록 되었으나 MMS_CONTENTS_INFO 테이블에서는 MMS File Error
		 * MMS_KEY[0] 조인할 수 있는 데이터가 존재 하지 않아 문자발송이 되지 않을 경우가 존재한다. 데이터에 등록 시
		 * MMS_CONTENTS_INFO 테이블에 먼저 등록되도록 해야한다. 테이블 등록 순서 => MMS_CONTENTS_INFO_HIST >
		 * MMS_CONTENTS_INFO > MSG_DATA
		 */
		getSqlSessionSms().insert(getSmsMapper() + "insertMmsContensInfoHist", paramvo); // 단문,장문 공통으로 들어가는 MMS_CONTENTS_INFO_HIST
																				// 등록 시 시퀸스를 먼저 생성 후 넣어줌
		// logger.debug("CONT_SEQ = " + paraVO.getCont_seq());
		getSqlSessionSms().insert(getSmsMapper() + "insertMmsContensInfo", paramvo);
		getSqlSessionSms().insert(getSmsMapper() + "insertMsgData", paramvo);
	}

}
