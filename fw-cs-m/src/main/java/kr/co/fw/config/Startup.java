package kr.co.fw.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import kr.co.fw.config.Constants.LOGGING;
import lombok.extern.slf4j.Slf4j;

/**
 * 시스템 초기화 클래스, 서버 실행시 로깅/업로드경로 설정 등의 초기화 작업을 처리
 */
@Slf4j
public class Startup {

	@Value("${Globals.LoggerYN}")
	private String LoggerYN;

	@Value("${Globals.DBGubun}")
	private String DBGubun;

	private static String OS = System.getProperty("os.name").toLowerCase();

	@PostConstruct
	public void init() {
		log.info("######################################");
		log.info("-kr.co.gnx SAMPLE System Starting -");
		log.info("######################################");
		log.info("-LOGGING = {}-", LoggerYN); // globals.properties에서 읽어옴.
		LoadInit();
		log.info("######################################");
		log.info("-kr.co.gnx SAMPLE System Started -");
		log.info("######################################");
	}

	private void LoadInit() {
		try {
			log.info("-----LoadInitData...-----");

			String[] wrPathArr = this.getClass().getResource("/").getPath().split("/");
			String wrPath = org.apache.commons.lang.StringUtils.join(wrPathArr, "/", 0, wrPathArr.length - 2);
//			String homePath = "";
			if ("dev".equals(DBGubun)) {

			}

			log.info("Web Root Path = {}", wrPath);
			Constants.setConstants(wrPath);
			if (LoggerYN.equals("N")) {
				Constants.QueryLogging = LOGGING.NOLOGGING;
			} else {
				Constants.QueryLogging = LOGGING.LOGGING;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("######################################");
			log.warn("-kr.co.gnx SAMPLE System Start Fail -");
			log.warn("######################################");
		}
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}

}
