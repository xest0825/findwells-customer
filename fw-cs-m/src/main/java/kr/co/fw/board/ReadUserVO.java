package kr.co.fw.board;

import kr.co.fw.base.BaseVO;

public class ReadUserVO extends BaseVO {
	
	private String BD_NO;  		// 게시판번호  NUMBER(15)
	private String ITEM_NO;   	// 게시글 번호 NUMBER(15)
	private String EMP_CD;     	// 사원번호    VARCHAR2(10)
	private String READ_EMP_CD;
	private String SEQ_NO;    	// 일련번호    NUMBER(15)
	private String READ_DTM;  	// 읽은시간    DATE
	private String EMP_NM;     	// 사원명
	private String READ_EMP_NM;
	private String SCD;       	// 조직명
	private String SNM;     	// 조직이름
	private String SNMPATH; 	// 조직이름경로
	private String JIKGUB;    	// 직급
	private String JIKCHK;    	// 직책
	private String JIKGUB_NM;  	// 직급명
	private String JIKCHK_NM;  	// 직책명
	
	private String [] DESIG_SCD_ARR;   // 지정사업부
	private String [] DESIG_GROUP_ARR; // 지정그룹
	
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bD_NO) {
		BD_NO = bD_NO;
	}
	public String getITEM_NO() {
		return ITEM_NO;
	}
	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}
	public String getEMP_CD() {
		return EMP_CD;
	}
	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	public String getEMP_NM() {
		return EMP_NM;
	}
	public String getREAD_EMP_CD() {
		return READ_EMP_CD;
	}
	public void setREAD_EMP_CD(String rEAD_EMP_CD) {
		READ_EMP_CD = rEAD_EMP_CD;
	}
	public String getREAD_EMP_NM() {
		return READ_EMP_NM;
	}
	public void setREAD_EMP_NM(String rEAD_EMP_NM) {
		READ_EMP_NM = rEAD_EMP_NM;
	}
	public void setEMP_NM(String eMP_NM) {
		EMP_NM = eMP_NM;
	}
	public String getSNM() {
		return SNM;
	}
	public void setSNM(String sNM) {
		SNM = sNM;
	}
	public String getSNMPATH() {
		return SNMPATH;
	}
	public void setSNMPATH(String sNMPATH) {
		SNMPATH = sNMPATH;
	}
	public String getJIKGUB_NM() {
		return JIKGUB_NM;
	}
	public void setJIKGUB_NM(String jIKGUB_NM) {
		JIKGUB_NM = jIKGUB_NM;
	}
	public String getJIKCHK_NM() {
		return JIKCHK_NM;
	}
	public void setJIKCHK_NM(String jIKCHK_NM) {
		JIKCHK_NM = jIKCHK_NM;
	}
	public String getSEQ_NO() {
		return SEQ_NO;
	}
	public void setSEQ_NO(String sEQ_NO) {
		SEQ_NO = sEQ_NO;
	}
	public String getREAD_DTM() {
		return READ_DTM;
	}
	public void setREAD_DTM(String rEAD_DTM) {
		READ_DTM = rEAD_DTM;
	}

	public String getSCD() {
		return SCD;
	}
	public void setSCD(String sCD) {
		SCD = sCD;
	}

	public String getJIKGUB() {
		return JIKGUB;
	}
	public void setJIKGUB(String jIKGUB) {
		JIKGUB = jIKGUB;
	}
	public String getJIKCHK() {
		return JIKCHK;
	}
	public void setJIKCHK(String jIKCHK) {
		JIKCHK = jIKCHK;
	}

	public String[] getDESIG_SCD_ARR() {
		return DESIG_SCD_ARR;
	}
	public void setDESIG_SCD_ARR(String[] dESIG_SCD_ARR) {
		DESIG_SCD_ARR = dESIG_SCD_ARR;
	}
	public String[] getDESIG_GROUP_ARR() {
		return DESIG_GROUP_ARR;
	}
	public void setDESIG_GROUP_ARR(String[] dESIG_GROUP_ARR) {
		DESIG_GROUP_ARR = dESIG_GROUP_ARR;
	}
	
	
}
