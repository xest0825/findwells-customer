package kr.co.fw.common.excel;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc 엑셀 샘플 데이터 생성 - 임의로 생성하는 샘플데이터 부분(createSampleData)과 DB에서 불러와서 뿌려주는 부분(createCodeData)로 나누어짐
 * @desc 샘플과 코드 데이터가 똑같이 첫번째 시트에 있음
 * @author KIMDONGUK
 * @since 2018-11-11
 */
public class SampleExcelCreate {
	private static final Logger logger = LoggerFactory.getLogger(SampleExcelCreate.class);
	
	private SXSSFWorkbook workbook = null;
	private Sheet dataSheet1 = null;
	
	private DataFormat dataFormat = null;
	private CellStyle cellStyle = null;		//전체 셀 스타일
	private CellStyle numStyle = null;		//숫자유형 셀 스타일
	private CellStyle headerStyle = null;	//필수를 제외한 헤더 부분 셀 스타일
	private CellStyle reqStyle = null;		//필수값 헤더 부분 셀 스타일
	
	private Font reqFont = null;			//필수 데이터 헤더 폰트
	
	private int cellIdx = 0;
	
	public SampleExcelCreate(String createSheetName) {
		if(workbook == null) {
			workbook = new SXSSFWorkbook(1000);
		}
		
		if(dataSheet1 == null) {
			dataSheet1 = workbook.createSheet(createSheetName);
		}
		
		//숫자를 제외한 value부분 cell 스타일
		cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		//숫자형 데이터 스타일
		dataFormat = workbook.createDataFormat();
		numStyle = workbook.createCellStyle();
		numStyle.setDataFormat(dataFormat.getFormat("#,##0"));
		numStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		numStyle.setBorderTop(CellStyle.BORDER_THIN);
		numStyle.setBorderBottom(CellStyle.BORDER_THIN);
		numStyle.setBorderLeft(CellStyle.BORDER_THIN);
		numStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		//필수값을 제외한 헤더부분 스타일
		headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		//필수 값 헤더 스타일
		reqFont = workbook.createFont();
		reqFont.setColor(IndexedColors.RED.getIndex());
		
		reqStyle = workbook.createCellStyle();
		reqStyle.setAlignment(CellStyle.ALIGN_CENTER);
		reqStyle.setBorderTop(CellStyle.BORDER_THIN);
		reqStyle.setBorderBottom(CellStyle.BORDER_THIN);
		reqStyle.setBorderLeft(CellStyle.BORDER_THIN);
		reqStyle.setBorderRight(CellStyle.BORDER_THIN);
		reqStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		reqStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		reqStyle.setFont(reqFont);
		
	}
	
	//DB에서 불러오지 않고 임의로 생성한 데이터
	public void createSampleData(ArrayList<String[]> titleList, ArrayList<Object[]> fieldList, String[] reqYN) throws Exception {
		int rowIdx = 0;
		
		//헤더부분
		for(int i = 0; i < titleList.size(); i++) {
			String[] titles = titleList.get(i);
			
			Row row = dataSheet1.createRow(i);
			
			//헤더는 값유형에 상관없이 무조건 중앙, 문자형
			for(int j = 0; j < titles.length; j++) {
				Cell cell = row.createCell(j);
				
				cell.setCellValue(titles[j]);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				
				//필수값이면 필수 셀 스타일 적용
				if(reqYN[j].equals("Y")) {
					cell.setCellStyle(reqStyle);
				}else {
					cell.setCellStyle(headerStyle);
				}
			}
			
			rowIdx = row.getRowNum() + 1;
		}
		
		//샘플 데이터 부분
		for(int i = 0; i < fieldList.size(); i++) {
			Object[] fields = fieldList.get(i);
			
			Row row = dataSheet1.createRow(i + rowIdx);
			
			for(int j=0; j < fields.length; j++) {
				Cell cell = row.createCell(j);
				
				if(fields[j] instanceof Integer) {
					cell.setCellValue((Integer)fields[j]);
					cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					cell.setCellStyle(numStyle);
				}else {
					cell.setCellValue((String)fields[j]);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellStyle(cellStyle);
				}
			}
		}
		
		//마지막 셀 인덱스는 첫번째 로우의 마지막 셀의 위치로 잡아냄
		cellIdx = dataSheet1.getRow(0).getLastCellNum();
	}
	
	//DB에서 불러온 코드 데이터(원수사, 조직 등..)
	public void createCodeData(ArrayList<String[]> titleList, String[] fieldKey, List<?> dataList) throws Exception {
		int rowIdx = 0;
		
		//셀이 시작하는 위치는 앞서 생성된 데이터보다 1칸 띄어서 생성
		cellIdx += 1;
		
		//헤더는 값유형에 상관없이 무조건 중앙, 문자형
		for(int i = 0; i < titleList.size(); i++) {
			String[] titles = titleList.get(i);
			
			Row row = dataSheet1.getRow(i);
			
			if(row == null) {
				row = dataSheet1.createRow(i);
			}
			
			for(int j = 0; j < titles.length; j++) {
				Cell cell = row.createCell(j + cellIdx);
				
				cell.setCellValue(titles[j]);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellStyle(headerStyle);
			}
			
			rowIdx = row.getRowNum() + 1;
		}
		
		//값부분
		for(int i=0; i < dataList.size(); i++) {
			Row row = dataSheet1.getRow(i + rowIdx);
			
			if(row == null) {
				row = dataSheet1.createRow(i + rowIdx);
			}
			
			Object obj = dataList.get(i);
			String[] fieldsKey = fieldKey;
			
			if(obj instanceof java.util.LinkedHashMap || obj instanceof java.util.HashMap) {
				//맵형태 일때
				@SuppressWarnings("unchecked")
				Map<String, Object> resultMap = (Map<String, Object>) obj;
				
				for(int j=0; j < fieldsKey.length; j++) {
					Cell cell = row.createCell(j + cellIdx);
					
					Object cellValue = resultMap.get(fieldsKey[j]);
					
					if(cellValue instanceof BigDecimal) {
						cell.setCellValue((Integer)cellValue);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellStyle(numStyle);
					}else {
						cell.setCellValue((String)cellValue);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cell.setCellStyle(cellStyle);
					}
				}
			}else {
				//맵형태가 아닐때(VO 형태)
				//VO에 선언된 파라미터들의 명을 INSERT
				Field[] fields = obj.getClass().getDeclaredFields();
				
				//key, value 형식으로 데이터가 담길 맵 선언
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				
				//VO에 담긴 데이터를 map으로 복사(파라미터 명 : key, 파라미터의 담긴 값 : value)
				for(int k=0; k < fields.length; k++) {
					fields[k].setAccessible(true);
					map.put(fields[k].getName().toString(), String.valueOf(fields[k].get(obj)));
				}
				
				//엑셀 데이터 INSERT(Service에서 넘긴 key 값으로 데이터 get)
				for (int j = 0; j < fieldsKey.length; j++) {
					Cell cell = row.createCell(j + cellIdx);
					Object cellValue = map.get(fieldsKey[j]);
					
					if(cellValue instanceof BigDecimal) {
						cell.setCellValue((Integer)cellValue);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellStyle(numStyle);
					}else {
						cell.setCellValue((String)cellValue);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cell.setCellStyle(cellStyle);
					}
				}
			}
		}
		
		cellIdx = dataSheet1.getRow(0).getLastCellNum();
	}
	
	/**
	 * 생성한 엑셀 다운로드
	 */
	public void sendResponse(HttpServletResponse response, String filename) throws Exception {

		OutputStream out = response.getOutputStream();

		try {
		    
		    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ";");
		    response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setDateHeader("Last-Modified", new Date().getTime());
			
		    
			workbook.write(out);
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			workbook.dispose();
			out.close();
		}
	}
		
	public Sheet getDataSheet() {
        return dataSheet1;
    }
}
