package kr.co.fw.common.insco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.fw.common.excel.excelHandler2;
import kr.co.fw.config.Constants.UPLOADS;
import kr.co.fw.common.file.FileService;
import kr.co.fw.common.file.FileVO;

/**
 * 원수사 관리 service
 */
@Service(value = "InscoService")
public class InscoService {

	private static final Logger logger = LoggerFactory.getLogger(InscoService.class);

	@Autowired
	private InscoDAO inscoDAO;
	
	@Autowired
	private FileService fileService;

	/**
	 * @Description  : 원수사 등록/수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : String
	 * @throws       : Exception
	 */
	public void insertOrUpdateInsco(MultipartHttpServletRequest mRequest ,InscoVO paramvo) throws Exception {
		try {
			int result = 0;
			FileVO filevo = new FileVO();
			MultipartFile mpf = mRequest.getFile("FILE_NM");
					
			if(mpf != null) {
//				filevo = fileService.imageSave(mpf, UPLOADS.IMAGE, paramvo.getMb_id());
				
				// 파일 경로 저장
				paramvo.setCI_URL(filevo.getFile_url());
			}
			
			result = inscoDAO.selectInscoCnt(paramvo);
			if(result > 0){
				inscoDAO.updateInsco(paramvo);				
			} else {
				inscoDAO.insertInsco(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @Description  : 원수사관리 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : excelHandler2
	 * @throws       : Exception
	 */
	public excelHandler2 selectInscoListExcel(InscoVO vo) throws Exception {
		excelHandler2 eh = null;
		String[] tiltestemp = {"보험구분", "원수사코드", "원수사명", "가입설계 URL", "홈페이지 URL", "대표번호", "헬프데스크", "IT데스크", "로고(이미지)", "제휴시작일","제휴종료일","사용유무", "정렬순서", "수정자", "수정일자"};
		
		String[] fieldstemp = {"INSCO_TYPE_NM", "INSCO_CD", "INSCO_NM", "PLAN_URL", "HOME_URL", "PRENO", "HELPNO", "ITNO", "CI_URL", "PRTN_START_YMD", "PRTN_END_YMD", "USE_YN", "SORT_NO", "UP_EMP_CD", "UP_DTM"};
		try {
			ArrayList<String> titleList = new ArrayList<String>();
			ArrayList<String> fieldsList = new ArrayList<String>();
			
			Collections.addAll(titleList, tiltestemp);
			Collections.addAll(fieldsList,fieldstemp);
			
			eh = new excelHandler2(vo.getExcel_path() ,titleList, fieldsList);
			inscoDAO.selectInscoListExcel(vo, eh);

			//컬럼 사이즈 설정
			if(eh.getRowindex() != 0) {
				for(int i=0; i<tiltestemp.length; i++) {
					eh.getDataSheet().setColumnWidth(i, (eh.getDataSheet().getColumnWidth(i)) + (int)2048); //(int)1 : 약 0.03픽셀
				}
			}
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return eh;
	}
	
	/**
	 * @brief 원수사 조회
	 * @param InscoVO
	 * @return List<InscoVO>
	 * @throws Exception
	 */
	public List<InscoVO> selectInscoList(InscoVO paramvo) throws Exception {

		try {
			return inscoDAO.selectInscoList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	/**
	 * @brief 원수사 입력
	 * @param List<InscoVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertInsco(ArrayList<InscoVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				InscoVO paramvo = models.get(i);

				result += inscoDAO.insertInsco(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 원수사 수정
	 * @param List<InscoVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateInsco(ArrayList<InscoVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				InscoVO paramvo = models.get(i);

				result += inscoDAO.updateInsco(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 원수사 삭제
	 * @param List<InscoVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteInsco(ArrayList<InscoVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				InscoVO paramvo = models.get(i);

				result += inscoDAO.deleteInsco(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/**
	 * ddcode INSCO_CD(원수사코드) 리스트 조회
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param InscoVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectInscoCdList(InscoVO inscoVO) throws Exception {
		try {
			return inscoDAO.selectInscoCdList(inscoVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

}
