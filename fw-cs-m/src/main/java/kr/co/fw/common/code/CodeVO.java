package kr.co.fw.common.code;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodeVO extends BaseVO {
	
	private String grp_cd; 			
	private String grp_cd_nm;
	private String grp_cd_desc;
	private String cd;
	private String cd_nm;
	private String cd_desc;

}
