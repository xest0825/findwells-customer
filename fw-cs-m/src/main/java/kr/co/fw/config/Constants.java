package kr.co.fw.config;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 시스템 전역 상수
 */
public class Constants {

	public enum UPLOADS {
		ROOT, UPLOAD_ROOT, FILE, TEMP, TEMPLATE, IMAGE, EXCEL
	};

	public enum LOGGING {
		LOGGING, NOLOGGING
	};

	public static LOGGING QueryLogging = LOGGING.LOGGING;

	private static String WEB_ROOT_PATH = "";
	private static String UPLOAD_ROOT_PATH = "";

	private static String FILE_PATH = "";
	private static String TEMP_FILE_PATH = "";
	private static String TEMPLATE_FILE_PATH = "";
	private static String IMAGE_FILE_PATH = "";
	private static String EXCEL_FILE_PATH = "";

	private static final String UPLOAD_ROOT_URL = "/upload";
	private static final String FILE_URL = UPLOAD_ROOT_URL + "/files/";
	private static final String TEMP_FILE_URL = UPLOAD_ROOT_URL + "/tempFiles/";
	private static final String TEMPLATE_FILE_URL = UPLOAD_ROOT_URL + "/template/";
	private static final String IMAGE_FILE_URL = UPLOAD_ROOT_URL + "/files/img/";
	private static final String EXCEL_FILE_URL = UPLOAD_ROOT_URL + "/files/excel/";
	
	public static void setConstants(String WebRootPath) {
		Logger logger = LoggerFactory.getLogger(Constants.class);
		logger.debug("-----Set Constants...-----");

		Constants.WEB_ROOT_PATH = WebRootPath;

		Constants.UPLOAD_ROOT_PATH = WebRootPath + Constants.UPLOAD_ROOT_URL;

		/** FILE_PATH */
		Constants.FILE_PATH = Constants.WEB_ROOT_PATH + Constants.FILE_URL;

		/** TEMP_FILE_PATH */
		Constants.TEMP_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.TEMP_FILE_URL;
		Constants.TEMPLATE_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.TEMPLATE_FILE_URL;
		Constants.IMAGE_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.IMAGE_FILE_URL;
		Constants.EXCEL_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.EXCEL_FILE_URL;

		mkdir(Constants.UPLOAD_ROOT_PATH);
		logger.debug("-Constants.UPLOAD_ROOT_PATH={}-", Constants.UPLOAD_ROOT_PATH);

		mkdir(Constants.FILE_PATH);
		logger.debug("-Constants.FILE_PATH={}-", Constants.FILE_PATH);

		mkdir(Constants.TEMP_FILE_PATH);
		logger.debug("-Constants.TEMP_FILE_PATH={}-", Constants.TEMP_FILE_PATH);
		
		mkdir(Constants.TEMPLATE_FILE_PATH);
		logger.debug("-Constants.TEMPLATE_FILE_PATH={}-", Constants.TEMPLATE_FILE_PATH);
		
		mkdir(Constants.IMAGE_FILE_PATH);
		logger.debug("-Constants.IMAGE_FILE_PATH={}-", Constants.IMAGE_FILE_PATH);
		
		mkdir(Constants.EXCEL_FILE_PATH);
		logger.debug("-Constants.EXCEL_FILE_PATH={}-", Constants.EXCEL_FILE_PATH);
	}

	public static String getURL(UPLOADS u) {
		String rtnURL = "";
		switch (u) {
		case ROOT:
			rtnURL = "/";
			break;

		case UPLOAD_ROOT:
			rtnURL = Constants.UPLOAD_ROOT_URL;
			break;

		case FILE:
			rtnURL = Constants.FILE_URL;
			break;

		case TEMP:
			rtnURL = Constants.TEMP_FILE_URL;
			break;
			
		case TEMPLATE:
			rtnURL = Constants.TEMPLATE_FILE_URL;
			break;
			
		case IMAGE:
			rtnURL = Constants.IMAGE_FILE_URL;
			break;
			
		case EXCEL:
			rtnURL = Constants.EXCEL_FILE_URL;
			break;

		default:
			rtnURL = "/";
			break;
		}
		return rtnURL;
	}

	public static String getPATH(UPLOADS u) {
		String rtnPATH = "";
		switch (u) {
		case ROOT:
			rtnPATH = Constants.WEB_ROOT_PATH;
			break;

		case UPLOAD_ROOT:
			rtnPATH = Constants.UPLOAD_ROOT_PATH;
			break;

		case FILE:
			rtnPATH = Constants.FILE_PATH;
			break;

		case TEMP:
			rtnPATH = Constants.TEMP_FILE_PATH;
			break;
			
		case TEMPLATE:
			rtnPATH = Constants.TEMPLATE_FILE_PATH;
			break;
			
		case IMAGE:
			rtnPATH = Constants.IMAGE_FILE_PATH;
			break;
			
		case EXCEL:
			rtnPATH = Constants.EXCEL_FILE_PATH;
			break;

		default:
			rtnPATH = Constants.WEB_ROOT_PATH;
			break;
		}
		return rtnPATH;
	}

	private static void mkdir(String path) {
		File upDir = new File(path);
		if (!upDir.exists()) { // 해당 디렉토리의 존재여부를 확인
			upDir.mkdirs(); // 없다면 생성
		}
	}

}///
