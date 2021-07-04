package kr.co.fw.common.excel;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.StylesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import kr.co.fw.common.util.CommUtil;
import kr.co.fw.config.Constants.LOGGING;
import kr.co.fw.config.Constants.UPLOADS;
import kr.co.fw.common.file.FileService;
import kr.co.fw.common.file.FileVO;

/**
 * 엑셀 service
 */
@Service(value = "ExcelService")
public class ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

	@Autowired
	private ExcelDAO excelDAO;
	
	@Autowired
	private FileService fileService;

	
	/********** 엑셀마스터 **********/
	
	/**
	 * @brief 엑셀마스터 목록 조회
	 * @param ExcelVO
	 * @return List<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelMstList(ExcelVO paramvo) throws Exception {

		try {
			return excelDAO.selectExcelMstList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	
	/**
	 * @brief 엑셀마스터 입력
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.insertExcelMst(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 엑셀마스터 수정
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.updateExcelMst(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 엑셀마스터 삭제
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.deleteExcelMst(paramvo);
				result += excelDAO.deleteExcelDataMapMst(paramvo);		/* 엑셀마스터가 삭제되면 해당 맵핑 마스터도 삭제되도록 */
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/********** 월별엑셀raw데이터 **********/
	
	/**
	 * @brief 월별엑셀raw데이터 목록 조회
	 * @param ExcelVO
	 * @return List<ExcelVO>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> selectExcelDataMonthList(ExcelVO paramvo) throws Exception {

		try {
			return excelDAO.selectExcelDataMonthList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	
	/**
	 * @brief 월별엑셀raw데이터 입력
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.insertExcelDataMonth(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 월별엑셀raw데이터 수정
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.updateExcelDataMonth(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 월별엑셀raw데이터 삭제
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.deleteExcelDataMonth(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/********** 매핑마스터 **********/
	
	/**
	 * @brief 매핑마스터 목록 조회
	 * @param ExcelVO
	 * @return List<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelDataMapMstList(ExcelVO paramvo) throws Exception {

		try {
			return excelDAO.selectExcelDataMapMstList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	
	/**
	 * @brief 매핑마스터 입력
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMapMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.insertExcelDataMapMst(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 매핑마스터 수정
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMapMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.updateExcelDataMapMst(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 매핑마스터 삭제
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMapMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.deleteExcelDataMapMst(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/********** 월별매핑 **********/
	
	/**
	 * @brief 월별매핑 목록 조회
	 * @param ExcelVO
	 * @return List<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelDataMapMonthList(ExcelVO paramvo) throws Exception {

		try {
			return excelDAO.selectExcelDataMapMonthList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	
	/**
	 * @brief 월별매핑 입력
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelDataMapMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		ExcelVO paramvo = null;
		
		try {
			for (int i = 0; i < models.size(); i++) {
				paramvo = models.get(i);

				//기존 데이터 삭제
				if(i==0) {
					excelDAO.deleteExcelDataMapMonth(paramvo);
				}
				
				//맵핑 입력
				paramvo.setSort_no(""+i+"");
				result += excelDAO.insertExcelDataMapMonth(paramvo);
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 월별매핑 수정
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelDataMapMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.updateExcelDataMapMonth(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 월별매핑 삭제
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelDataMapMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.deleteExcelDataMapMonth(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/********** 업로드상태 **********/
	
	/**
	 * @brief 업로드상태 목록 조회
	 * @param ExcelVO
	 * @return List<ExcelVO>
	 * @throws Exception
	 */
	public List<ExcelVO> selectExcelStatusMonthList(ExcelVO paramvo) throws Exception {

		try {
			return excelDAO.selectExcelStatusMonthList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	
	/**
	 * @brief 업로드상태 입력
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertExcelStatusMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.insertExcelStatusMonth(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 업로드상태 수정
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateExcelStatusMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.updateExcelStatusMonth(paramvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 업로드상태 삭제
	 * @param List<ExcelVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteExcelStatusMonth(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ExcelVO paramvo = models.get(i);

				result += excelDAO.deleteExcelStatusMonth(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/**
	 * 맵핑마스터 관리 > 리스트 조회
	 * @param ExcelVO
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMapMstMngList(ExcelVO excelVO) throws Exception {
		try {
			return excelDAO.selectMapMstMngList(excelVO);
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
			return excelDAO.excelUploadMonthList(excelVO);
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
	@SuppressWarnings({ "rawtypes" })
	public List selectUploadTableMst(ExcelVO excelVO) throws Exception {
		try {
			return excelDAO.selectUploadTableMst(excelVO);
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
	public int insertUploadTableMst(ArrayList<ExcelVO> models) throws Exception {
		int result = 0;
		
		try {
			for(int i=0; i<models.size(); i++) {
				ExcelVO paramvo = models.get(i);
				
				result += excelDAO.insertUploadTableMst(paramvo);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 업로드 테이블 수정
	 * @param ExcelVO
	 * @return int
	 * @throws Exception 
	 */
	public int updateUploadTableMst(ArrayList<ExcelVO> models) throws Exception {
		ExcelVO paramvo = null;
		
		int result = 0;
		
		try {
			for(int i=0; i<models.size(); i++) {
				paramvo = models.get(i);
				
				result += excelDAO.updateUploadTableMst(paramvo);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 업로드 테이블 삭제
	 * @param ExcelVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteUploadTableMst(ArrayList<ExcelVO> models) throws Exception {
		ExcelVO paramvo = null;
		
		int result = 0;
		
		try {
			for(int i=0; i<models.size(); i++) {
				paramvo = models.get(i);
				
				result += excelDAO.deleteUploadTableMst(paramvo);
				
				paramvo = null;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
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
			return excelDAO.uploadTabColMngList(excelVO);
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
	public int insertOrUpdateUploadTabCol(ArrayList<ExcelVO> models) throws Exception {
		ExcelVO excelVO = null;
		
		int result = 0;
		
		try {
			//insert 속도를 위해 쿼리 로깅OFF(데이터가 그렇게 많지는 않지만....)
			logger.info("ExcelService - insertOrUpdateUploadTabCol() : 맵핑 컬럼 입력 ");
			kr.co.fw.config.Constants.QueryLogging = LOGGING.NOLOGGING;

			for(int i=0; i < models.size(); i++) {
				excelVO = models.get(i);
				
				//월별 맵핑 저장
				result += excelDAO.insertOrUpdateUploadTabCol(excelVO);
				
				//맵핑 가이드 저장(맵핑마스터 저장)
				result += excelDAO.insertOrUpdateMapMst(excelVO);
			}
			
			//쿼리 로깅ON
	    	kr.co.fw.config.Constants.QueryLogging = LOGGING.LOGGING;
	    	logger.info("ExcelService - insertOrUpdateUploadTabCol() : 맵핑 컬럼 종료 ");
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 수정
	 * @param ArrayList<ExcelVO>
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int updateUploadTabCol(ArrayList<ExcelVO> models) {
		ExcelVO excelVO = null;
		
		int result = 0;
		
		try {
			for(int i=0; i<models.size(); i++) {
				excelVO = models.get(i);
				
				result += excelDAO.updateUploadTabCol(excelVO);
				
				excelVO = null;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 사용안함처리
	 * @param ArrayList<ExcelVO>
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int deleteUploadTabCol(ArrayList<ExcelVO> models) {
		ExcelVO excelVO = null;
		
		int result = 0;
		
		try {
			for(int i=0; i<models.size(); i++) {
				excelVO = models.get(i);
				
				result += excelDAO.deleteUploadTabCol(excelVO);
				
				excelVO = null;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 엑셀파일 업로드 TEMP 테이블 저장
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public void insertMonthExcel(ExcelVO excelVO, MultipartFile excelfiles) throws Exception {
		/****************************************
	     * STEP1. 기존에 저장된 TEMP 데이터 삭제/ 신규파일저장
	     ****************************************/
		//입력전 데이터삭제
        ExcelVO delExcelVO = new ExcelVO();
        
        delExcelVO.setCOM_YM(excelVO.getCOM_YM());    
        delExcelVO.setEXCEL_CD(excelVO.getEXCEL_CD());
        
        excelDAO.deleteExcelDataMonth(delExcelVO);
        
	    FileVO filevo = new FileVO();
	    filevo.setAttach_gbn(excelVO.getDATA_CTG());
        fileService.saveFile(excelfiles , UPLOADS.EXCEL, filevo);
		
        /**********************************
         * STEP2. 엑셀오픈 
         **********************************/
        File file = new File(filevo.getFile_path());
        
        OPCPackage pkg = OPCPackage.open(file);
        XSSFReader xssfReader = new XSSFReader(pkg);
		XSSFReader.SheetIterator itr = (XSSFReader.SheetIterator)xssfReader.getSheetsData();		
		StylesTable styles = xssfReader.getStylesTable();
		
		ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
		
		//엑셀 파일 읽어서 저장할 List
		List<Map> dataList = new ArrayList<Map>();
		int i=0;
		
		while(itr.hasNext()) {
			if(i > 0) break;	//첫번째 시트만 저장하기 위해
			
			InputStream sheetStream = itr.next();
			InputSource sheetSource = new InputSource(sheetStream);
			
			//Sheet2ListHandler는 엑셀 data를 가져와 SheetContentHandler를 재정의 하여 만든 클래스...
			//Map의 데이터 수를 몇개까지 할지 정함(100개 => C001 ~ C100까지 저장)
			Sheet2ListHandler sheet2ListHandler = new Sheet2ListHandler(dataList, 100);
			ContentHandler handler = new XSSFSheetXMLHandler(styles, strings, sheet2ListHandler, true);
			
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxFactory.newSAXParser();
			
			//sax parser 방식의 xmlReader생성
			XMLReader sheetParser = saxParser.getXMLReader();
			
			//xmlReader에 row와 cell 이벤트를 생성하는 핸들러 설정
			sheetParser.setContentHandler(handler);
			
			//위에서 Sheet 별로 생성한 inputSource를 파싱
			//이 과정에서 handler가 row와 cell 이벤트를 생성하고 생성된 이벤트는 sheet2ListHandler가 받아서 처리
			sheetParser.parse(sheetSource);
			
			sheetStream.close();
			
			i++;
		}
		
		pkg.close();
		
		//insert 속도를 위해 쿼리 로깅OFF
		kr.co.fw.config.Constants.QueryLogging = LOGGING.NOLOGGING;
		
		logger.debug("엑셀데이터 INSERT 시작!!!!!");
		
		excelDAO.insertExcelDataMonth(dataList, excelVO);
		
		logger.debug("엑셀데이터 INSERT 종료!!!!!");
		
		kr.co.fw.config.Constants.QueryLogging = LOGGING.LOGGING;
		
		// 파일정보 업데이트
    	excelVO.setSTATUS("NA");
    	excelVO.setIN_CNT(String.valueOf(dataList.size()));
    	excelVO.setSAVE_CNT("0");
    	excelVO.setERR_CNT("0");
    	excelVO.setEXCEL_FILE_NO(filevo.getFile_id());
    	excelVO.setNO_FILE_YN("N");
    	
    	//상태 업데이트(업데이트 결과가 0이면 입력)
    	excelDAO.mergeExcelStatusMonth(excelVO);
    	
    	/* sqlMapConfig.xml에서 defaultExecutorType = 'SIMPLE'이면 insert, update 시 결과 입력/수정 시 row수를 받아오나 BATCH이면 이상한 값을 가져온다. 왜일까.. */
    	/*int success = excelDAO.updateExcelStatusMonth(excelVO);
    	
    	if(success == 0) {
    		excelDAO.insertExcelStatusMonth(excelVO);
    	}*/
	}
	
	/**
     * 엑셀파일/데이터 삭제
     * @param ExcelVO
     * @return void
     */
	public void deleteMonthExcel(ExcelVO excelVO) throws Exception {
		logger.debug("deleteMonthExcel START");
		/*****************************
         * STEP1. 실제파일/데이터 삭제
         *****************************/
		logger.debug("STEP1. 실제파일/데이터 삭제");
		FileVO fileVO = new FileVO();
		
		if(CommUtil.isNotEmpty(excelVO.getEXCEL_FILE_NO())) {
			fileVO.setFile_id(excelVO.getEXCEL_FILE_NO());
			
			fileService.deleteFileAndInfo(fileVO);
		}
		
		/***************************************
         * STEP2. 업로드 엑셀데이터 삭제
         ***************************************/
		excelDAO.deleteExcelDataMonth(excelVO);
		
		/***************************************
         * STEP3. 업로드 상태 업데이트
         ***************************************/
		excelVO.setIN_CNT("0");
		excelVO.setSAVE_CNT("0");
		excelVO.setERR_CNT("0");
		excelVO.setEXCEL_FILE_NO("");
		excelDAO.updateExcelStatusMonth(excelVO);
		
		logger.debug("deleteMonthExcel END");
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
			return excelDAO.selectTableColumn(excelVO);
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
	public List selectUploadTable(ExcelVO excelVO) throws Exception {
		return excelDAO.selectUploadTable(excelVO);
	}
	
	/**
	 * DDCODE(EXCEL_INSCO_CD) 코드 조회
	 * @return List
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectExcelInscoList(ExcelVO excelVO) throws Exception {
		return excelDAO.selectExcelInscoList(excelVO);
	}

	/**
	 * 월별 맵핑 저장 데이터 얻어오기
	 * @param ExcelVO
	 * @return List
	 * @throws Exception
	 */
	public List<Map<String, Object>> getExcelDataMapMonth(ExcelVO excelvo2) throws Exception {
		return excelDAO.getExcelDataMapMonth(excelvo2);
	}

	/**
	 * 필수 맵핑 확인
	 * @param excelVO
	 * @return String
	 */
	public String confirmReqColsMap(ExcelVO excelVO) throws Exception {
		return excelDAO.confirmReqColsMap(excelVO);
	}

	/**
	 * 엑셀업로드 프로시저 호출
	 * @param ExcelVO
	 * @return void
	 */
	public void call_PRC_EXCEL_UPLOAD(ExcelVO excelVO) throws Exception {
		excelDAO.call_PRC_EXCEL_UPLOAD(excelVO);
	}
}
