package kr.co.fw.base;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

//import kr.co.fw.common.util.PageVO;
//import kr.co.fw.common.util.PropertiesVO;


@Getter
@Setter
public class BaseVO {

	/**
	 * (non-javadoc) BaseVO 멤버 변수 추가 금지
	 */
	private String user_id; // 사용자 ID (UUID)
	private String user_nm; // 사용자 명

	private String role_id; // 권한 ID

	private String mb_id; // 고객사 ID
	private String mb_nm; // 고객사 명

	private String emp_no; // 사원 번호

	private String login_id; // 로그인 ID
	private String login_pw; // 로그인 비밀번호
	private String session_id; // 세션 ID
	private String devc_id; // 기기 ID

	private String reg_id; // 등록자 ID
	private String reg_dtm; // 등록 일시
	private String mod_id; // 수정자 ID
	private String mod_dtm; // 수정 일시

	private String sort_no; // 정렬 번호
	private String use_yn; // 사용 여부

	private String org_id; // 조직 ID
	private String org_nm; // 조직 명
	private String org_id_path; // 조직 ID 경로
	private String org_nm_path; // 조직 명 경로

//	private PropertiesVO propertiesVO; // 프로퍼티 VO

	private String srch_word; // 검색어

	private int total = 0; // 총 개수
//	private PageVO pageVO; // 페이지 VO
	
	public String AuthUserID = null;
	private String row_num = ""; /*열번호*/
	private String search_type = "";
	private String search_start_date = "";
	private String search_end_date = "";
    private String parent = "";
    private String cnt = ""; 
    private String excel_path = "";
	private String excel_yn;
	private String system_gubun;
	private String text;
	private String value;
	private String user_role_ids;
	private List<String> user_role_list;
	private String json_string;
	private String page;
    private String page_size;
    private boolean isPagination;
	
	
	
	

}
