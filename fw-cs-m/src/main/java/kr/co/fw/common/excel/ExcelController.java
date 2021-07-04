package kr.co.fw.common.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 엑셀 컨트롤러
 *
 */
@Controller(value = "ExcelController")
public class ExcelController {

	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

	@Autowired
	private ExcelService excelService;
	
	/********** 엑셀마스터 **********/
	/**
	 * @brief 엑셀마스터(입수엑셀설정) 화면이동
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/excel/excelMst.go")
	public String selectIfDtUploadConf(HttpServletRequest request, HttpServletResponse response) {
		return "/excel/excelMst";
	}
	
	/**
	 * @brief 엑셀마스터 목록 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelMstList.ajax")
	public ModelAndView selectExcelMstList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ExcelVO") ExcelVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", excelService.selectExcelMstList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 엑셀마스터 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertExcelMst.ajax")
	public ModelAndView insertExcelMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.insertExcelMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 엑셀마스터 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateExcelMst.ajax")
	public ModelAndView updateExcelMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateExcelMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 엑셀마스터 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteExcelMst.ajax")
	public ModelAndView deleteExcelMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteExcelMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	/********** 월별엑셀raw데이터 **********/
	
	/**
	 * @brief 월별엑셀raw데이터 목록 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelDataMonthList.ajax")
	public ModelAndView selectExcelDataMonthList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ExcelVO") ExcelVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", excelService.selectExcelDataMonthList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별엑셀raw데이터 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertExcelDataMonth.ajax")
	public ModelAndView insertExcelDataMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.insertExcelDataMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별엑셀raw데이터 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateExcelDataMonth.ajax")
	public ModelAndView updateExcelDataMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateExcelDataMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별엑셀raw데이터 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteExcelDataMonth.ajax")
	public ModelAndView deleteExcelDataMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteExcelDataMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/********** 매핑마스터 **********/
	/**
	 * @brief 맵핑마스터 관리 화면 이동
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/excelMapMstMng.pop")
	public ModelAndView excelMapMstMng(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("/excel/excelMapMstMng");
		
		ExcelVO paramVO = new ExcelVO();
		
		Gson gson = new Gson();
		
		paramVO = gson.fromJson(excelVO.getJson_string(), ExcelVO.class);
		
		try {
			mv.addObject("ExcelVO", paramVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * @brief 매핑마스터 목록 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelDataMapMstList.ajax")
	public ModelAndView selectExcelDataMapMstList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ExcelVO") ExcelVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", excelService.selectExcelDataMapMstList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 매핑마스터 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertExcelDataMapMst.ajax")
	public ModelAndView insertExcelDataMapMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.insertExcelDataMapMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 매핑마스터 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateExcelDataMapMst.ajax")
	public ModelAndView updateExcelDataMapMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateExcelDataMapMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 매핑마스터 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteExcelDataMapMst.ajax")
	public ModelAndView deleteExcelDataMapMst(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteExcelDataMapMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/********** 월별매핑 **********/
	
	/**
	 * @brief 월별매핑 목록 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelDataMapMonthList.ajax")
	public ModelAndView selectExcelDataMapMonthList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ExcelVO") ExcelVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", excelService.selectExcelDataMapMonthList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별매핑 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertExcelDataMapMonth.ajax")
	public ModelAndView insertExcelDataMapMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {		
			//월별 맵핑 저장
			excelService.insertExcelDataMapMonth(models);
			
			//필수맵핑확인
			String reqCols = excelService.confirmReqColsMap(excelVO);
			
			if(reqCols != null) {
				throw new Exception(reqCols + "은(는) 필수 맵핑 데이터입니다.");
			}
			
			//엑셀 업로드
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별매핑 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateExcelDataMapMonth.ajax")
	public ModelAndView updateExcelDataMapMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateExcelDataMapMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 월별매핑 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteExcelDataMapMonth.ajax")
	public ModelAndView deleteExcelDataMapMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteExcelDataMapMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/********** 업로드상태 **********/	
	/**
	 * @brief 업로드상태 목록 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelStatusMonthList.ajax")
	public ModelAndView selectExcelStatusMonthList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ExcelVO") ExcelVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", excelService.selectExcelStatusMonthList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 업로드상태 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertExcelStatusMonth.ajax")
	public ModelAndView insertExcelStatusMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.insertExcelStatusMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 업로드상태 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateExcelStatusMonth.ajax")
	public ModelAndView updateExcelStatusMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateExcelStatusMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 업로드상태 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteExcelStatusMonth.ajax")
	public ModelAndView deleteExcelStatusMonth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteExcelStatusMonth(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}		

	/********** 월별 엑셀업로드 관리 **********/
	/**
	 * @brief 엑셀업로드 화면 이동
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value="/excel/excelUploadMonth.go")
	public ModelAndView excelUploadMonth(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/excel/excelUploadMonth");
		
		try {
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 엑셀업로드 리스트 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value = "/excel/excelUploadMonthList.ajax")
	public ModelAndView excelUploadMonthList(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", excelService.excelUploadMonthList(excelVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 엑셀파일 업로드 팝업 화면 이동
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value = "/excel/excelFileUploadPop.pop")
	public ModelAndView excelFileUploadPop(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("/excel/excelFileUploadPop");
		
		Gson gson = new Gson();
		
		
		try {
			//월별 업로드에서 이동시 전달된 파라미터
			Map<String, Object> paramVO = gson.fromJson(excelVO.getJson_string(), Map.class);
			mv.addObject("ExcelVO", paramVO);
			
			//월별 맵핑 저장 데이터 얻어오기
			ExcelVO excelvo2 = gson.fromJson(excelVO.getJson_string(), ExcelVO.class);
			List<Map<String, Object>> excelMap = excelService.getExcelDataMapMonth(excelvo2);	
		    mv.addObject("ExcelMap", excelMap);
		    
		    //ROWSTART_SEQ 세팅
		    if(excelMap.size() > 0) {
		    	mv.addObject("ROWSTART_SEQ", excelMap.get(0).get("ROWSTART_SEQ"));
		    }else {
		    	mv.addObject("ROWSTART_SEQ", "1");
		    }
		    
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 엑셀파일 업로드 TEMP 테이블 저장
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @param MultipartFile
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value = "/excel/insertMonthExcel.ajax")
	public ModelAndView insertExcelFile(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO, MultipartFile excelfiles) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			//엑셀파일 업로드
			excelService.insertMonthExcel(excelVO, excelfiles);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
     * 엑셀파일/데이터 삭제
     * @param HttpServletRequest
     * @param HttpServletResponse
     * @param ExcelVO
     * @return void
     */
	@RequestMapping(value = "/excel/deleteMonthExcel.ajax")
	public void deleteMonthExcel(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		try {
			excelService.deleteMonthExcel(excelVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/******************* 업로드테이블관리 ******************/
	/**
	 * 업로드 테이블 관리
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value = "/excel/uploadTableMst.go")
	public ModelAndView uploadTableMst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/excel/uploadTableMst");
		
		try {
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 관리 리스트 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value = "/excel/selectUploadTableMst.ajax")
	public ModelAndView selectUploadTableMst(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", excelService.selectUploadTableMst(excelVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 입력
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertUploadTableMst.ajax")
	public ModelAndView insertUploadTableMst(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);

		try {
			mv.addObject("results", excelService.insertUploadTableMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 수정
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateUploadTableMst.ajax")
	public ModelAndView updateUploadTableMst(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);

		try {
			mv.addObject("results", excelService.updateUploadTableMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 삭제
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteUploadTableMst.ajax")
	public ModelAndView deleteUploadTableMst(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);

		try {
			mv.addObject("results", excelService.deleteUploadTableMst(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 맵핑 컬럼 관리
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/uploadTabColMngPop.pop")
	public ModelAndView tableColumnMngPop(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) {
		ModelAndView mv = new ModelAndView("/excel/uploadTabColMngPop");
		
		Gson gson = new Gson();
		
		try {
			Map<String, Object> paramVO = gson.fromJson(excelVO.getJson_string(), Map.class);
			
			mv.addObject("ExcelVO", paramVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 업로드 테이블 맵핑 컬럼 리스트 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/uploadTabColMngList.ajax")
	public ModelAndView uploadTabColMngList(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", excelService.uploadTabColMngList(excelVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 엑셀업로드 테이블 맵핑 컬럼 추가
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/insertOrUpdateUploadTabCol.ajax")
	public ModelAndView insertOrUpdateUploadTabCol(HttpServletRequest request, HttpServletResponse response
				, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);
		
		try {
			mv.addObject("results", excelService.insertOrUpdateUploadTabCol(models));			
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * 엑셀업로드 테이블 컬럼 수정
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/updateUploadTabCol.ajax")
	public ModelAndView updateUploadTabCol(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);
		
		try {
			mv.addObject("results", excelService.updateUploadTabCol(models));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	
	/**
	 * 엑셀업로드 테이블 컬럼 사용안함처리
	 * @param request
	 * @param response
	 * @param JSONObject
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excel/deleteUploadTabCol.ajax")
	public ModelAndView deleteUploadTabCol(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ArrayList<ExcelVO> models = (ArrayList<ExcelVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ExcelVO.class);
		
		try {
			mv.addObject("results", excelService.deleteUploadTabCol(models));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * DDCODE(UPLOAD_TABLE_COLUMN) 코드 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectTableColumn.ajax")
	public ModelAndView selectTableColumn(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", excelService.selectTableColumn(excelVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * DDCODE(UPLOAD_TABLE) 코드 조회
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectUploadTable.ajax")
	public ModelAndView selectUploadTable(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", excelService.selectUploadTable(excelVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}
	
	/**
	 * DDCODE(EXCEL_INSCO_CD) 코드 조회
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/selectExcelInscoList.ajax")
	public ModelAndView selectExcelInscoList(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.addObject("results", excelService.selectExcelInscoList(excelVO));
		
		return mv;
	}
	
	/**
	 * 맵핑데이터 조회 데이터 팝업
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/confirmMappingDataPop.pop")
	public ModelAndView confirmMappingDataPop(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("/excel/confirmMappingDataPop");
		
		Gson gson = new Gson();
		excelVO = gson.fromJson(excelVO.getJson_string(), ExcelVO.class);
		
		//맵핑 저장 데이터 얻어오기
		List<Map<String, Object>> excelMap = excelService.getExcelDataMapMonth(excelVO);
	    mv.addObject("ExcelMap", excelMap);
	    mv.addObject("ExcelVO", excelVO);
		
		return mv;
	}
	
	/**
	 * 맵핑 데이터 테이블에 저장
	 * @param request
	 * @param response
	 * @param ExcelVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/excel/call_PRC_EXCEL_UPLOAD.ajax")
	public ModelAndView call_PRC_EXCEL_UPLOAD(HttpServletRequest request, HttpServletResponse response, ExcelVO excelVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		//프로시저 호출
		excelService.call_PRC_EXCEL_UPLOAD(excelVO);

		return mv;
	}
}
