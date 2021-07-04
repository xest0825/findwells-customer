package kr.co.fw.common.excel;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.fw.common.util.CommUtil;
import kr.co.fw.config.Constants;
import kr.co.fw.config.Constants.UPLOADS;


public class excelHandler2 implements ResultHandler {

	private static final Logger logger = LoggerFactory.getLogger(excelHandler.class);
	
	
	private String EXCEL_FILENAME = "";
	private String EXCEL_PATH = "";;
	private ArrayList<String> TITLE = null;
	private ArrayList<String> FIELDS = null;
	
	private Workbook wb = null;
	private XSSFWorkbook temp_wb = null;
	private Sheet dataSheet = null;
	private int rowindex = 0;
	
	private int hidden = 0;
	private int BLANK_ROW = 0;
	private String TILTE_YN  = "Y";
	
	private DataFormat dataFormat = null;
	private CellStyle numStyle = null;
	
    public int getRowindex() {
		return rowindex;
	}


	/**
     * 
     * Description  : 엑셀 핸들러 
     * 최초 생성일  : 2014. 5. 20. : 오전 10:16:20
     * file         : FileService.java 
     * 페키지       : genexon.comm.excel;
     * RETURN       : excelHandler 
     * @param excelfilename
     * @throws Exception

     */
	public excelHandler2(String excelfilename) throws Exception {

		EXCEL_FILENAME = excelfilename;
		EXCEL_PATH = Constants.getPATH(UPLOADS.TEMPLATE) +  EXCEL_FILENAME;
		
		try 
		{	
			temp_wb = new XSSFWorkbook(new FileInputStream(EXCEL_PATH));
			wb =  new SXSSFWorkbook(temp_wb, 1000); 
			wb.removeSheetAt(wb.getSheetIndex("Data"));
			
			dataSheet = wb.createSheet("Data");
			
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	public excelHandler2(String excelfilename , int  blankrow , String titleyn) throws Exception {

		EXCEL_FILENAME = excelfilename;
		EXCEL_PATH = Constants.getPATH(UPLOADS.TEMPLATE) +  EXCEL_FILENAME;
		BLANK_ROW = blankrow;	
		TILTE_YN = titleyn;
		
		try 
		{	
			temp_wb = new XSSFWorkbook(new FileInputStream(EXCEL_PATH));
			wb =  temp_wb; 
			wb.removeSheetAt(wb.getSheetIndex("Data"));
			dataSheet = wb.createSheet("Data");
			
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	

	/**
     * @return the dataSheet
     */
    public Sheet getDataSheet() {
        return dataSheet;
    }


    /**
     * 
     * Description  : 엑셀 핸들러 맵형태
     * 최초 생성일  : 2014. 5. 20. : 오전 10:16:20
     * file         : FileService.java 
     * 페키지       : genexon.comm.excel;
     * RETURN       : excelHandler 
     * @param excelfilename , titles
     * @throws Exception

     */
	
	public excelHandler2(String excelfilename, ArrayList<String> titles) throws Exception {

		EXCEL_FILENAME = excelfilename;
		EXCEL_PATH = Constants.getPATH(UPLOADS.TEMPLATE) +  EXCEL_FILENAME;
		TITLE =titles;
		TILTE_YN = "Y";
		
		try 
		{	
			temp_wb = new XSSFWorkbook(new FileInputStream(EXCEL_PATH));
			
			wb =  temp_wb; 
			wb.removeSheetAt(wb.getSheetIndex("Data"));
			
			dataSheet = wb.createSheet("Data");
			
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	
	public excelHandler2(String excelfilename, ArrayList<String> titles, ArrayList<String> fields) throws Exception {

		EXCEL_FILENAME = excelfilename;
		EXCEL_PATH = Constants.getPATH(UPLOADS.TEMPLATE) +  EXCEL_FILENAME;
		TITLE =titles;
		FIELDS = fields;
		TILTE_YN = "Y";
		
		try 
		{	
			temp_wb = new XSSFWorkbook(new FileInputStream(EXCEL_PATH));
			
			wb =  temp_wb; 
			wb.removeSheetAt(wb.getSheetIndex("Data"));
			
			dataSheet = wb.createSheet("Data");
			
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/* (non-Javadoc)
	 * @see org.apache.ibatis.session.ResultHandler#handleResult(org.apache.ibatis.session.ResultContext)
	 */
    @Override
	public void handleResult(ResultContext context)
	{
       Sheet sh = dataSheet;
		
       try {
		    
			Object obj = context.getResultObject();
			
			
			//맵형태(mybatis alias > lhmap, hmap)
			if(obj instanceof java.util.LinkedHashMap || obj instanceof java.util.HashMap) {
				
				hidden = 1;
				  
				@SuppressWarnings("unchecked")
				Map<String, Object> resultMap = (Map<String, Object>) obj;
				
				Iterator<String> itvalue = resultMap.keySet().iterator();
				Iterator<String> itvaluevalue = resultMap.keySet().iterator();
				
				Object keyvalue = null;
				Row headerRow = sh.createRow(rowindex);
				
				if (rowindex == 0) {
					//빈로우 생성
				    for(int j =0  ; j < BLANK_ROW; j++){
				        rowindex++;
						headerRow = sh.createRow(rowindex);
				    }
				    
				    //타이틀 작성여부
				    if(TILTE_YN.equals("Y")){
				       
				        Font monthFont = wb.createFont();
				        monthFont.setFontHeightInPoints((short)12);
				        monthFont.setColor(IndexedColors.WHITE.getIndex());
						CellStyle  style = wb.createCellStyle();
				        style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				        style.setFont(monthFont);
				        
				        //타이틀 파라메터가 있는경우
				        if(TITLE != null){
				        
				        	for(int  i= 0 ; i < this.TITLE.size(); i++ ){
		
								  Cell cell = headerRow.createCell(i);
								  cell.setCellValue(TITLE.get(i));
								  cell.setCellStyle(style);
								  
							}
				        //타이틀 파라메터가 없는경우map keyvlaue 를 타이틀로 	
				        }else{
				        	int i = 0;
							while(itvalue.hasNext())
							{	
							  keyvalue = itvalue.next();
							  String keystr = keyvalue.toString();
							  
							  Cell cell = headerRow.createCell(i);
							  cell.setCellValue(keystr);
							  cell.setCellStyle(style);
							  
							  i++;
							}
				        }
				        rowindex++;
						headerRow = sh.createRow(rowindex);
				    }
				}
				
				//FIELDS 값 정의 했을 때 > FIELDS에 정의해 놓은 결과값 필드명으로 맵에있는 데이터 가져와서 셀 데이터 생성
				if(FIELDS != null) {
					String cellValue = "";
					
					for(int i=0; i < FIELDS.size(); i++) {
						Cell cell = headerRow.createCell(i);
						
						cellValue = String.valueOf(resultMap.get(FIELDS.get(i)));

						if("PSCD".equals(FIELDS.get(i)) || "SCD".equals(FIELDS.get(i)) || "INSPOL_NO".equals(FIELDS.get(i)) ){
							
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cell.setCellValue(cellValue.replace("null", ""));
						}else{
							if(CommUtil.isStringDouble(cellValue)) {
								//금액, 성적 컬럼 셀은 #,### 형식으로 나오도록
								if(FIELDS.get(i).indexOf("AMT") > 0 || FIELDS.get(i).indexOf("MONEY") > 0 || FIELDS.get(i).indexOf("HWANSAN") > 0) {
									dataFormat = wb.createDataFormat();
									numStyle = wb.createCellStyle();
									numStyle.setDataFormat(dataFormat.getFormat("#,##0"));
									
									cell.setCellType(Cell.CELL_TYPE_NUMERIC);
									cell.setCellStyle(numStyle);
								}
								
								cell.setCellValue(Double.parseDouble(cellValue.replace("null", "")));
			                }else {
			                    cell.setCellValue(cellValue.replace("null", ""));
			                }
						}
					}
				}else {	//FIELDS 값 정의 안했을 때 > 맵의 데이터 순차적으로 insert
					int i = 0;
					
					while(itvaluevalue.hasNext()) {
						keyvalue = itvaluevalue.next();
						String keystr = keyvalue.toString();
						String value = String.valueOf(resultMap.get(keystr));
						
						Cell cell = headerRow.createCell(i);
						  
						  if (resultMap.get(keystr) instanceof String) {
							  cell.setCellValue( value.replace("null", ""));
						  } else {
							  if(CommUtil.isStringDouble(value)){
								  cell.setCellValue(Double.parseDouble(value.replace("null", "")));
							  }else{
								  cell.setCellValue( value.replace("null", ""));
							  }
						  }
					 
					  
					  i++;
					}
				}

				rowindex++;
			
			//VO 형태	
			}
			else
			{
				Field[] fields = obj.getClass().getDeclaredFields();
				
				if (TITLE != null && FIELDS !=null ) {

					hidden = 1;
					Row headerRow = sh.createRow(rowindex);
					
					if (rowindex == 0) 
					{
						Font monthFont = wb.createFont();
				        monthFont.setFontHeightInPoints((short)12);
				        monthFont.setColor(IndexedColors.WHITE.getIndex());
						CellStyle  style = wb.createCellStyle();
				        style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				        style.setFont(monthFont);
				        
				        //타이틀 파라메터가 있는경우
				        
			        	for(int  i= 0 ; i < TITLE.size(); i++ ){
			        		  Cell cell = headerRow.createCell(i);
			        		  
			        		  if(i==0) {
			        			  cell.setCellValue("serialVersionUID");
			        		  }
							  cell.setCellValue(TITLE.get(i));				        		  					 
							  cell.setCellStyle(style);
							  
						}
				        
				        rowindex++;
						headerRow = sh.createRow(rowindex);
					}
					
					Map<String, Object> map = new LinkedHashMap<String, Object>();
						
					for (int i = 0; i <= fields.length - 1; i++)
					{
						
						if(fields[i] != null )
						{
							fields[i].setAccessible(true);
							map.put(fields[i].getName().toString(), String.valueOf(fields[i].get(obj)));
						}								                
					}
					
					if(map != null) {
						for (int i = 0; i < FIELDS.size(); i++)
						{                                                                            
							
							Cell cell = headerRow.createCell(i);
							String cellvalue = "";
							
							if(i==0) {
								cellvalue = String.valueOf(map.get("serialVersionUID")); 
							}
							
							if(FIELDS.get(i) != null )
							{
								cellvalue = String.valueOf(map.get(FIELDS.get(i))); 
							}
							
			                if(CommUtil.isStringDouble(cellvalue))
			                {
			                    cell.setCellValue(Double.parseDouble(cellvalue.replace("null", "")));
			                }
			                else
			                {
			                    cell.setCellValue(cellvalue.replace("null", ""));
			                }
			                
						}
					}
					
					
				} else {
//					Field[] fields = obj.getClass().getDeclaredFields();
					hidden = 0;
					Row headerRow = sh.createRow(rowindex);
					
					if (rowindex == 0) 
					{
						
						for (int i = 0; i <= fields.length - 1; i++)
						{
							fields[i].setAccessible(true);
							Cell cell = headerRow.createCell(i);
							cell.setCellValue(fields[i].getName().toString());
						}
						rowindex++;
						headerRow = sh.createRow(rowindex);
						
					}
	
					for (int i = 0; i <= fields.length - 1; i++)
					{
						
						Cell cell = headerRow.createCell(i);
						String cellvalue = "";
						
						if(fields[i] != null )
						{
							fields[i].setAccessible(true);
							cellvalue = String.valueOf(fields[i].get(obj));
						}
						
		                if(CommUtil.isStringDouble(cellvalue))
		                {
		                    cell.setCellValue(Double.parseDouble(cellvalue.replace("null", "")));
		                }
		                else
		                {
		                    cell.setCellValue(cellvalue.replace("null", ""));
		                }
		                
					}
				}
				rowindex++;
			}
			
		}
		catch (Exception e)
        {
			logger.error(e.getMessage());
        }
	}

	/**
	 * 
	 * Description  : 생성된 엑셀 파일 전송 
	 * 최초 생성일  : 2014. 5. 20. : 오전 10:18:54
	 * file         : excelHandler.java 
	 * 페키지       : genexon.comm.excel
	 * RETURN       : void 
	 * @param response
	 * @param filename
	 * @throws Exception

	 */
	public void sendResponse(HttpServletResponse response, String filename)
			throws Exception {

		OutputStream out = response.getOutputStream();

		try {
		    
		    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ";");
		    response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setDateHeader("Last-Modified", new Date().getTime());
	
			
			if(hidden == 0){
				wb.setSheetOrder("Data", 1);
				wb.setSheetHidden(1, true);
	
			}else{
				wb.setSheetOrder("Data", 0);
				wb.setSheetHidden(0, false);
			}
			
		    
			wb.write(out);
			
			

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServletException(e);
		} finally {
			if(out != null) out.close();
		}
	}

	
	/**
	 * 
	 * Description  : 파일삭제 
	 * 최초 생성일  : 2014. 5. 20. : 오전 10:30:55
	 * file         : excelHandler.java 
	 * 페키지       : genexon.comm.excel
	 * RETURN       : void 
	 * @throws Exception

	 */
	public void closeExcel()throws Exception {
		try {
			
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Description  : 워크북 리턴  
	 *
	 * 최초 생성일  : 2014. 5. 20. : 오전 10:30:58
	 * file         : excelHandler.java 
	 * 페키지       : genexon.comm.excel
	 * RETURN       : XSSFWorkbook 
	 * @return

	 */
	public Workbook getWb() {
		
		
	    if (wb instanceof SXSSFWorkbook)
	    {
	       	return (SXSSFWorkbook)wb;
	    }
	    else if (wb instanceof XSSFWorkbook ){
	    	return (XSSFWorkbook)wb;
	    }
	    else
	    {
	    	return wb;
	    }
		
	}	
}
