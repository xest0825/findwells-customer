package kr.co.fw.contract.productGroup;

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

@Service(value = "ProductGroupService")
public class ProductGroupService {

	private static final Logger logger = LoggerFactory.getLogger(ProductGroupService.class);

	@Autowired
	private ProductGroupDAO productGroupDAO;

	/**
	 * @Description  : 상품군관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ProductGroupVO>
	 * @throws       : Exception
	 */
	public List<ProductGroupVO> selectProductGroupList(ProductGroupVO paramvo) throws Exception {
		List<ProductGroupVO> resultList = new ArrayList<ProductGroupVO>();
		try {
			resultList = productGroupDAO.selectProductGroupList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return resultList;
	}

	/**
	 * @Description  : 상품군 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectProductGroup(ProductGroupVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = productGroupDAO.selectProductGroup(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}

	/**
	 * @Description  : 상품군 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void insertProductGroup(ProductGroupVO paramrvo) throws Exception {
		try {
			productGroupDAO.insertProductGroup(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateProductGroup(ProductGroupVO paramrvo) throws Exception {
		try {
			productGroupDAO.updateProductGroup(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void deleteProductGroup(ArrayList<ProductGroupVO> models) throws Exception {
		try {
			for (int i = 0; i < models.size(); i++) {
				ProductGroupVO paramvo = models.get(i);

				productGroupDAO.deleteProductGroup(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : excelHandler2
	 * @throws       : Exception
	 */
	public excelHandler2 selectProductGroupListExcel(ProductGroupVO vo) throws Exception {
		excelHandler2 eh = null;
		String[] tiltestemp = {"상품구분1", "상품구분2", "사용유무"};
		
		String[] fieldstemp = {"PROD_KIND1", "PROD_KIND2", "USE_YN"};

		try {
			ArrayList<String> titleList = new ArrayList<String>();
			ArrayList<String> fieldsList = new ArrayList<String>();
			
			Collections.addAll(titleList, tiltestemp);
			Collections.addAll(fieldsList,fieldstemp);
			
			eh = new excelHandler2(vo.getExcel_path() ,titleList, fieldsList);
			productGroupDAO.selectProductGroupListExcel(vo, eh);

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
	
	
}
