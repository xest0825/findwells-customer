package kr.co.fw.common.excel;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

/**
 * 엑셀 DAO
 */
@Repository(value = "ExcelDAO")
public class ExcelDAO extends BaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelDAO.class);
	
	private static final String SQL_PREFIX = "Excel.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/********** 엑셀마스터 **********/
	
	/**
	 * @brief 엑셀마스터 목록 조회
	 * @param ExcelVO
	 * @return ArrayList<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelMstList(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectExcelMstList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 엑셀마스터 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertExcelMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/**
	 * @brief 엑셀마스터 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "updateExcelMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @brief 엑셀마스터 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "deleteExcelMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/********** 월별엑셀raw데이터 **********/
	
	/**
	 * @brief 월별엑셀raw데이터 목록 조회
	 * @param ExcelVO
	 * @return ArrayList<ExcelVO>
	 * @throws Exception
	 */
	public List<Map> selectExcelDataMonthList(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectExcelDataMonthList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 월별엑셀raw데이터 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertExcelDataMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/**
	 * @brief 월별엑셀raw데이터 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "updateExcelDataMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @brief 월별엑셀raw데이터 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "deleteExcelDataMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/********** 매핑마스터 **********/
	
	/**
	 * @brief 매핑마스터 목록 조회
	 * @param ExcelVO
	 * @return ArrayList<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelDataMapMstList(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectExcelDataMapMstList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 매핑마스터 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMapMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertExcelDataMapMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/**
	 * @brief 매핑마스터 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMapMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "updateExcelDataMapMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @brief 매핑마스터 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMapMst(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "deleteExcelDataMapMst", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/********** 월별매핑 **********/
	
	/**
	 * @brief 월별매핑 목록 조회
	 * @param ExcelVO
	 * @return ArrayList<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelDataMapMonthList(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectExcelDataMapMonthList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public int getCheckDataMapMonth(ExcelVO paramvo) throws Exception {
		return sqlSession.selectOne(SQL_PREFIX + "getCheckDataMapMonth", paramvo);
	}

	/**
	 * @brief 월별매핑 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMapMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertExcelDataMapMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/**
	 * @brief 월별매핑 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMapMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "updateExcelDataMapMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @brief 월별매핑 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMapMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "deleteExcelDataMapMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/********** 월별업로드상태 **********/
	
	/**
	 * @brief 월별업로드상태 목록 조회
	 * @param ExcelVO
	 * @return ArrayList<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelStatusMonthList(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectExcelStatusMonthList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 월별업로드상태 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelStatusMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertExcelStatusMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	
	/**
	 * @brief 월별업로드상태 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelStatusMonth(ExcelVO paramvo) throws Exception {
		System.out.println(sqlSession.getExecutorType());
		
		try {
			return sqlSession.update(SQL_PREFIX + "updateExcelStatusMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 월별업로드상태 입력 or 수정
	 * @param ExcelVO
	 */
	public void mergeExcelStatusMonth(ExcelVO excelVO) throws Exception {
		try {
			sqlSession.update(SQL_PREFIX + "mergeDataStatusMonth", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @brief 월별업로드상태 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelStatusMonth(ExcelVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "deleteExcelStatusMonth", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	/**
	 * 맵핑마스터 관리 > 리스트 조회
	 * @param ExcelVO
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMapMstMngList(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "selectMapMstMngList", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 엑셀업로드 리스트 조회
	 * @param ExcelVO
	 * @return List
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public List excelUploadMonthList(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "excelUploadMonthList", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 업로드 테이블 관리 리스트 조회
	 * @param ExcelVO
	 * @return List<Map>
	 * @throws Exception 
	 */
	
	@SuppressWarnings("rawtypes")
	public List selectUploadTableMst(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "selectUploadTableMst", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 업로드 테이블 입력
	 * @param ExcelVO
	 * @return int
	 * @throws Exception 
	 */
	public int insertUploadTableMst(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.insert(SQL_PREFIX + "insertUploadTableMst", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 업로드 테이블 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception 
	 */
	public int updateUploadTableMst(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.update(SQL_PREFIX + "updateUploadTableMst", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 업로드 테이블 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception 
	 */
	public int deleteUploadTableMst(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.delete(SQL_PREFIX + "deleteUploadTableMst", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 업로드 테이블 맵핑 컬럼 리스트 조회
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List uploadTabColMngList(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "uploadTabColMngList", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 추가
	 * @param ArrayList<ExcelVO>
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int insertOrUpdateUploadTabCol(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.update(SQL_PREFIX + "insertOrUpdateUploadTabCol", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 추가 시 맵핑마스터(가이드)도 등록
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	public int insertOrUpdateMapMst(ExcelVO excelVO) throws Exception {
		return sqlSession.update(SQL_PREFIX + "insertOrUpdateMapMst", excelVO);
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 추가(18.05.31 일괄처리로 변경하면서 안 씀.. 확정되면 지우자)
	 * @param ArrayList<ExcelVO>
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int updateUploadTabCol(ExcelVO excelVO) {
		try {
			return sqlSession.update(SQL_PREFIX + "updateUploadTabCol", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 사용안함처리(18.05.31 일괄처리로 변경하면서 안 씀.. 확정되면 지우자)
	 * @param ArrayList<ExcelVO>
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int deleteUploadTabCol(ExcelVO excelVO) {
		try {
			return sqlSession.update(SQL_PREFIX + "deleteUploadTabCol", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * DDCODE(UPLOAD_TABLE_COLUMN) 코드 조회
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectTableColumn(ExcelVO excelVO) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "selectTableColumn", excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * DDCODE(UPLOAD_TABLE) 코드 조회
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectUploadTable(ExcelVO excelVO) {
		return sqlSession.selectList(SQL_PREFIX + "selectUploadTable", excelVO);
	}
	
	/**
	 * DDCODE(EXCEL_INSCO_CD) 코드 조회
	 * @return List
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectExcelInscoList(ExcelVO excelVO) throws Exception {
		return sqlSession.selectList(SQL_PREFIX + "selectExcelInscoList", excelVO);
	}

	/**
	 * 월별 엑셀 TEMP 데이터 입력
	 * @param ExcelVO
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertExcelDataMonth(List<Map> dataList, ExcelVO excelVO) throws Exception {
		try {
			for(int i=0; i < dataList.size(); i++) {
				dataList.get(i).put("COM_YM", excelVO.getCOM_YM());
				dataList.get(i).put("MB_ID", excelVO.getMb_id());
				dataList.get(i).put("EXCEL_CD", excelVO.getEXCEL_CD());
				dataList.get(i).put("INSCO_CD", excelVO.getINSCO_CD());
				dataList.get(i).put("SEQ", (i+1));
				dataList.get(i).put("IN_EMP_CD", excelVO.getReg_id());
				
				sqlSession.insert(SQL_PREFIX + "insertExcelDataMonth", dataList.get(i));
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 월별 맵핑 저장 데이터 얻어오기
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	public List<Map<String, Object>> getExcelDataMapMonth(ExcelVO excelvo2) throws Exception {
		return sqlSession.selectList(SQL_PREFIX + "getExcelDataMapMonth", excelvo2);
	}

	/**
	 * 필수 맵핑 확인
	 * @param excelVO
	 * @return String
	 */
	public String confirmReqColsMap(ExcelVO excelVO) throws Exception {
		return sqlSession.selectOne(SQL_PREFIX + "confirmReqColsMap", excelVO);
	}

	/**
	 * 엑셀 업로드 프로시저 호출
	 * @param excelVO
	 */
	public void call_PRC_EXCEL_UPLOAD(ExcelVO excelVO) throws Exception {
		sqlSession.insert(SQL_PREFIX + "call_PRC_EXCEL_UPLOAD", excelVO);
	}

}
