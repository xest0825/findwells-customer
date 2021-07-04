package kr.co.fw.common.excel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;

@SuppressWarnings("all")
public class Sheet2ListHandler implements SheetContentsHandler {

	private List rows;
	private Map<String, String> row;
	private int columnCnt;
	private int currColNum = 0;
	private String key = "";
	private int SEQ = 1;
	
	public Sheet2ListHandler(List rows, int columnsCnt) {
		this.rows = rows;
		this.columnCnt = columnsCnt;
	}
	
	@Override
	public void startRow(int rowNum) {
		/**
		 * 엑셀 파싱 중 로우가 시작할 때 실행되는 부분 
		 */
		
		this.row = new HashMap<String, String>();
		
		//맵의 기본 key, value Set 만들어줌
		for(int i = 1; i <= columnCnt; i++) {
			key = i < 10 ? "C00"+(i+1) : "C0"+i;
			
			row.put(key, "");
		}
		
		currColNum = 1;
	}

	@Override
	public void endRow() {
		/**
		 * 엑셀 파싱 중 로우가 끝날 때 실행되는 부분
		 */
		
		rows.add(row);
	}

	@Override
	public void cell(String cellReference, String formattedValue) {
		//cellReference = 셀 주소
		//formattedValue = 값
		
		//비어있는 셀이 있을경우 값 자체를 가져오기 않기 때문에 셀 위치?를 가져와 현재 컬럼 위치와 비교하여 앞의 빈 값은 ""로 채워줌
		//엑셀에서 가져 온 현재 컬럼 위치 
		int thisCol = (new CellReference(cellReference)).getCol() + 1;		//Map의 key값이 C000이 아니라 C001부터 시작하기 때문에 +1
		
		//비어있는 셀 개수
		int missedCols = thisCol - currColNum;
		
		//비어있는 셀 만큼 값을 빈값으로 채워줌
		for(int i=0; i < missedCols; i++) {
			key = currColNum < 10 ? "C00"+currColNum : "C0" + currColNum;
			row.put(key, "");
			currColNum++;
		}
		
		currColNum = thisCol;
		
		key = currColNum < 10 ? "C00"+currColNum : "C0" + currColNum;
		row.put(key, formattedValue == null ? "" : formattedValue);
		
		currColNum++;
	}

	@Override
	public void headerFooter(String text, boolean isHeader, String tagName) {
		
	}
}
