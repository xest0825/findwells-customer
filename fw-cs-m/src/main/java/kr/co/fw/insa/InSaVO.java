package kr.co.fw.insa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.fw.base.BaseVO;
import kr.co.fw.common.file.FileVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 인사정보 VO TBIN_EMPMST
 */
@Getter
@Setter
@ToString
public class InSaVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 5552939733840697694L;
	
	private String MB_ID;
	private String COM_YM;
    private List<HashMap<String,String>> COM_YM_ARR = null;
	private String SEQ             ;  /* 일련번호(TBIN_EMPMST_FSB_SEQ)                NUMBER(22)     */
	private String EMP_CD          ;  /* 사원코드                                     VARCHAR2(20)   */
	private String EMP_NM          ;  /* 사원명                                       VARCHAR2(20)   */
	private String USER_ID         ;  /* 사원ID                                       VARCHAR2(20)   */
	private String SCD             ;  /* 조직코드                                     VARCHAR2(20)   */
	private String PERNO           ;  /* 주민등록번호                                 VARCHAR2(4000) */
	private String HPNO            ;  /* 핸드폰번호                                   VARCHAR2(20)   */
	private String JOIN_GBN        ;  /* 입사구분(GRP_CMM_CD = JOIN_GBN)              VARCHAR2(20)   */
	private String NOW_SCD   	   ;  /* 현소속                                  VARCHAR2(250)   */
	private String JIKGUB          ;  /* 직급코드(GRP_CMM_CD = JIKGUB)                VARCHAR2(20)   */
	private String JIKCHK          ;  /* 직책코드(GRP_CMM_CD = JIKCHK)                VARCHAR2(20)   */
	private String EMAIL           ;  /* 이메일                                       VARCHAR2(50)   */
	private String ZIPCD           ;  /* 우편번호                                     VARCHAR2(7)    */
	private String ADDR1           ;  /* 자택주소                                     VARCHAR2(200)  */
	private String ADDR2           ;  /* 자택주소상세                                 VARCHAR2(200)  */
	private String EMPSTA          ;  /* 재직여부(GRP_CMM_CD = EMPSTA)                VARCHAR2(20)   */
	private String PAY_GBN         ;  /* 급여구분(GRP_CMM_CD = PAY_GBN)               VARCHAR2(20)   */
	private String RE_EMP_CD       ;  /* 소개자 사원코드                              VARCHAR2(20)   */
	private String RE_EMP_NM       ;  /* 소개자 사원명                                VARCHAR2(20)   */
	private String MG_EMP_CD       ;  /* 관리자 사원코드                              VARCHAR2(20)   */
	private String MG_EMP_NM       ;  /* 관리자 사원명                                VARCHAR2(20)   */
	private String RCRT_TYPE       ;  /* 유치방식(GRP_CMM_CD = RCRT_TYPE)             VARCHAR2(1)    */
	private String LREG_YMD        ;  /* 생보등록일                                   VARCHAR2(10)   */
	private String NREG_YMD        ;  /* 손보등록일                                   VARCHAR2(10)   */
	private String VREG_YMD        ;  /* 변액등록일                                   VARCHAR2(10)   */
	private String ENT_YMD         ;  /* 입사일자                                     VARCHAR2(10)   */
	private String GENT_YMD        ;  /* 위촉일자                                     VARCHAR2(10)   */
	private String END_YMD         ;  /* 퇴사일자                                     VARCHAR2(10)   */
	private String OUT_YMD         ;  /* 해촉일자                                     VARCHAR2(10)   */
	private String BANK            ;  /* 은행코드(GRP_CMM_CD = BANK)                  VARCHAR2(20)   */
	private String BK_ID           ;  /* 계좌번호                                     VARCHAR2(66)   */
	private String OWNER           ;  /* 예금주                                       VARCHAR2(50)   */
	private String H_BANK;  /* 홍콩 은행코드(GRP_CMM_CD = H_BANK)                  VARCHAR2(20)   */
	private String H_BK_ID;  /* 홍콩 계좌번호                                     VARCHAR2(66)   */
	private String H_OWNER;  /* 홍콩 예금주                                       VARCHAR2(50)   */
	private String HBANK;  /* 홍콩 은행코드(GRP_CMM_CD = H_BANK)                  VARCHAR2(20)   */
	private String HBK_ID;  /* 홍콩 계좌번호                                     VARCHAR2(66)   */
	private String HOWNER;  /* 홍콩 예금주                                       VARCHAR2(50)   */
	private String OWNER_RELATION  ;  /* 예금주와의 관계(GRP_CMM_CD = OWNER_RELATION) VARCHAR2(20)   */
	private String MEMO            ;  /* 메모                                         VARCHAR2(1000) */
	private String FILE_NAME       ;  /* 첨부파일명                                   VARCHAR2(200)  */
	private String ROLE_ID         ;  /* 시스템 사용권한                              VARCHAR2(10)   */
	private String BOARD_ROLE_ID   ;  /* 게시판 시스템 사용권한                     VARCHAR2(10)   */
	private String BOARD_ROLE_NM   ;  /* 게시판 시스템 사용권한명                     VARCHAR2(10)   */
	private String PASSPORT_NUM	   ;  /* 여권번호                              VARCHAR2(15)   */
	private String ADDRE1	   	   ;  /* 영문주소                              VARCHAR2(250)   */
	private String ADDRE2	   	   ;  /* 영문상세주소                              VARCHAR2(250)   */
	private String EMP_NME	   	   ;  /* 영문이름               			 VARCHAR2(30)   */
    ArrayList<FileVO> fileList     ;  /* 첨부파일 목록 */
    ArrayList<FileVO> necessaryFileList     ;  /* 필수첨부파일 목록 */
	
    private String RE_EMP_SCD = ""; 	// 소개자조직코드
    private String RE_EMP_SNM = ""; 	// 소개자조직명
    private String RE_JIKGUB;			// 소개자 직급
    private String RCRT_TYPENM = "";	// 유치방식명
    private String SCDPATH = "";  		// 조직경로 (본사/~지사/~팀)
    private String SCDNMPATH = "";		// 조직경로 (본사/~지사/~팀)
    private String SCDNMPATH1 = "";		// 조직경로 (본사)
    private String SCDNMPATH2 = "";   	// 조직경로 (~지사)
    private String SCDNMPATH3 = "";  	// 조직경로 (~팀)
    private String SCDNMPATH4 = "";  	// 조직경로 (~팀)
    private String SCDNMPATH5 = "";  	// 조직경로 (~팀)
    private String SNM = "";     		// 조직명
    private String SNMPATH;				// 조직경로2
    private String PAY_GBNNM = ""; 		// 급여구분명
    private String JIKGUBNM = "";  		// 직급명 
    private String JIKCHKNM = "";  		// 직책명 
    private String EMPSTANM = ""; 	    // 재직구분명 
    private String JOIN_GBNNM = ""; 	// 입사구분명
    private String BANKNM;				// 은행코드명
    private String OWNER_RELATIONNM;	// 예금주와의 관계명
	private String ROLE_NM		   ;  /* 시스템 사용권한명 */ 
    
    private String EMPINFO = "";   // 사원정보(퀵서치 데이터 받아올 때 사용)
    private String DATA_DCD;

	private String SRCH_SCD;
	private String SRCH_SNM;
	private String SRCH_EMP;
	private String SRCH_EMP_VALUE;
	private String SRCH_JIKCHK;
	private String SRCH_JIKGUB;
	private String SRCH_ROLE_ID;		// 조회권한
	private String SRCH_EMPSTA;
	private String SRCH_TERM; 			// 조회 - 기간 - 조회조건들
	private String SRCH_TERM_START_VALUE;
	private String SRCH_TERM_END_VALUE;
	
	private String SRCH_EMP_DETAIL;		/* 인사 상세정보 : 6개월 전까지 보여지도록 */
	
	private String queryStr; //조직경로를 동적으로 만들기위해
	private String SRCH_BOARD_AUTH; //게시판권한 조회
	
	private String CNT;
	private String HPREM_AMT;
	private String UPERM_AMT;
	private String CREDIT;
	
	private String SEARCH_WORD;
	
}
