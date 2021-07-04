package kr.co.fw.contract.byenHwanMng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fw.common.excel.excelHandler2;

@Service(value = "ByenHwanService")
public class ByenHwanService {

	private static final Logger logger = LoggerFactory.getLogger(ByenHwanService.class);

	@Autowired
	private ByenHwanDAO byenHwanDAO;

	/**
	 * @Description  : 변환율관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenHwanList(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> resultList = new ArrayList<ByenHwanVO>();
		try {
			resultList = byenHwanDAO.selectByenHwanList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return resultList;
	}

	/**
	 * @Description  : 상품구분2 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenhwanProdKind2(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> resultList = new ArrayList<ByenHwanVO>();
		try {
			resultList = byenHwanDAO.selectByenhwanProdKind2(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return resultList;
	}

	/**
	 * @Description  : 변환율관리 마감월 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenhwanComYm(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> resultList = new ArrayList<ByenHwanVO>();
		try {
			resultList = byenHwanDAO.selectByenhwanComYm(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return resultList;
	}

	/**
	 * @Description  : 변환율 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectByenHwan(ByenHwanVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = byenHwanDAO.selectByenHwan(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}

	/**
	 * @Description  : 변환율 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void insertByenHwan(ByenHwanVO paramrvo) throws Exception {
		try {
			byenHwanDAO.insertByenHwan(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateByenHwan(ByenHwanVO paramrvo) throws Exception {
		try {
			byenHwanDAO.updateByenHwan(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void deleteByenHwan(ArrayList<ByenHwanVO> models) throws Exception {
		try {
			for (int i = 0; i < models.size(); i++) {
				ByenHwanVO paramvo = models.get(i);

				byenHwanDAO.deleteByenHwan(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 11
	 * @return       : excelHandler2
	 * @throws       : Exception
	 */
	public excelHandler2 selectByenHwanListExcel(ByenHwanVO vo) throws Exception {
		excelHandler2 eh = null;
		String[] tiltestemp = {"마감월", "원수사코드", "원수사명", "상품구분2", "변환율", "환산회차", "사용유무"};
		
		String[] fieldstemp = {"COM_YM", "INSCO_CD", "INSCO_NM", "PROD_KIND2", "BYENHWAN_RATE", "HWANSAN_COUNT", "USE_YN"};

		try {
			ArrayList<String> titleList = new ArrayList<String>();
			ArrayList<String> fieldsList = new ArrayList<String>();
			
			Collections.addAll(titleList, tiltestemp);
			Collections.addAll(fieldsList,fieldstemp);
			
			eh = new excelHandler2(vo.getExcel_path() ,titleList, fieldsList);
			byenHwanDAO.selectByenHwanListExcel(vo, eh);

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
	 * @Description  : 상품등록 -> 상품군2 change 이벤트 발생시 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectProductByenHwan(ByenHwanVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = byenHwanDAO.selectProductByenHwan(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}
	
}
