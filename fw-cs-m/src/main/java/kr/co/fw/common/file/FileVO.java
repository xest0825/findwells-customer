package kr.co.fw.common.file;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileVO extends BaseVO {
	
	/* 파일 정보 */
	private String file_id; 		/* VARCHAR(256) PK  '파일 ID' */
	private String orgn_file_nm; 	/* VARCHAR(256) 	'원래 파일 명' */
	private String phys_file_nm; 	/* VARCHAR(256) 	'물리 파일 명' */
	private String file_path;		/* VARCHAR(500) 	'파일 경로' */
	private String file_url; 		/* VARCHAR(500) 	'파일 URL' */
	private String file_mime; 		/* VARCHAR(500) 	'파일 MIME' */
	private String file_size; 		/* INT(11) 			'파일 크기' */
	private String file_ext; 		/* VARCHAR(10) 		'확장자' */
	private String memo; 			/* VARCHAR(100) 	'메모' */
	
	/* 파일 사용 정보 */
	private String usg_seq; 		/* BIGINT PK AI '파일 사용 일련번호 */	
	private String usg_cd; 			/* VARCHAR(10)	'사용 코드' */
	private String ref_id; 			/* VARCHAR(20)	'사용 참조 ID'*/
	
	/* RPA 연동 */
	private String work_id;
	
	private String attach_gbn;
	
	@JsonIgnore
	private MultipartFile file;
	
}
