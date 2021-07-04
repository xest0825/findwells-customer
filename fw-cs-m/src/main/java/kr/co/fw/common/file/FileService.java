package kr.co.fw.common.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.co.fw.base.BaseService;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.config.Constants.UPLOADS;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService extends BaseService {

	/**
	 * 파일 정보 목록 조회
	 * 
	 * @param FileVO
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getFileInfoList(FileVO paramvo) {
		return getFileDAO().getFileInfoList(paramvo);
	}
	
	/**
	 * 파일 정보 조회
	 * 
	 * @param FileVO
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> getFileInfo(FileVO paramvo) {
		HashMap<String, Object> file = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = getFileDAO().getFileInfoList(paramvo);
		if (!CommUtil.isEmpty(list)) {
			file = list.get(0);
		}
		return file; 
	}

	/**
	 * 파일 정보 입력
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public HashMap<String, Object> insertFileInfo(FileVO paramvo) {
		HashMap<String, Object> file = new HashMap<String, Object>();
		String fileId = CommUtil.getUUIDExceptDash();
		paramvo.setFile_id(fileId);
		int result = 0;
		result = getFileDAO().insertFileInfo(paramvo);
		if (result > 0) {
			file = getFileInfo(paramvo);
		} else {
			file = null;
		}
		return file;
	}
	
	/**
	 * 파일 업로드및 DB 저장
	 *
	 * @param multipartFile
	 * @return FileVO
	 * @throws Exception
	 */
	public FileVO saveFile(MultipartFile multipartFile, UPLOADS u, FileVO filevo) throws Exception {

		String fileName = multipartFile.getOriginalFilename(); // 원본파일명
		String fileId = CommUtil.getUUID(); // 저장파일명
		String fileFormat = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자
		String retunfilename = fileId + "." + fileFormat; // 저장파일명.확장자

		String filePath = kr.co.fw.config.Constants.getPATH(u); // upload폴더
		String fileUrl = kr.co.fw.config.Constants.getURL(u) + retunfilename; // upload폴더/저장파일명.확장자

		String fileSize = Long.toString(multipartFile.getSize()); // 파일 사이즈
		String mine = multipartFile.getContentType();
		String fullPath = filePath + retunfilename; // upload폴더명/저장파일명.확장자

		log.info("#####################################");
		log.info("UUID 파일명: " + fileId);
		log.info("원본 파일명: " + fileName);
		log.info("확장자: " + fileFormat);
		log.info("파일 PATH : " + fileUrl);
		log.info("파일 REAL PATH : " + fullPath);
		log.info("파일 사이즈 : " + fileSize);
		log.info("파일 mime : " + mine);
		log.info("#####################################");
		log.info("");
		log.info("");

		filevo.setFile_id(fileId); // FILE_NO
		filevo.setOrgn_file_nm(fileName); // FILE_NM
		filevo.setPhys_file_nm(retunfilename);
		filevo.setFile_ext(fileFormat); // FILE_FORMAT
		filevo.setFile_path(fullPath); // 절대경로
		filevo.setFile_url(fileUrl); // 저장경로
		filevo.setFile_size(Long.toString(multipartFile.getSize())); // 파일사이즈
		filevo.setFile_mime(mine); // MIME
		// TODO : filevo.setReg_id();

		/* 파일정보 저장 */
		try {
			getFileDAO().insertFileInfo(filevo);

		} catch (Exception e1) {
			log.error(e1.getMessage());
			throw e1;
		}

		File dir = new File(filePath);
		File file = new File(fullPath);

		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			log.debug(file.getPath());
//			multipartFile.transferTo(file);
			FileCopyUtils.copy(multipartFile.getBytes(), file);
		} catch (IOException e) {
			log.error(e.getMessage());
			throw e;
		}

		return filevo;
	}


	/**
	 * 파일 정보 수정
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int updateFileInfo(FileVO paramvo) {
		return getFileDAO().updateFileInfo(paramvo);
	}

	/**
	 * 파일 정보와 물리 파일 삭제
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int deleteFileAndInfo(FileVO paramvo) {
		HashMap<String, Object> fileMap = new HashMap<String, Object>();
		fileMap = getFileInfo(paramvo);
		int ret = 0;
		if (CommUtil.isNotEmpty(fileMap) && CommUtil.isNotEmpty((String)fileMap.get("file_path"))) {
			log.debug("파일삭제:{}", (String)fileMap.get("file_path"));
			File file = new File((String)fileMap.get("file_path"));

			file.delete();
			ret = getFileDAO().deleteFileInfo(paramvo);
		}
		return ret;
	}
	/**
	 * 파일 정보 삭제
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int deleteFileInfo(FileVO paramvo) {
		return getFileDAO().deleteFileInfo(paramvo);
	}

	/**
	 * 파일 사용 정보 목록 조회
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public List<HashMap<String, Object>> getFileUsageList(FileVO paramvo) {
		return getFileDAO().getFileUsageList(paramvo);
	}

	/**
	 * 파일 사용 정보 입력
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int insertFileUsage(FileVO paramvo) {
		return getFileDAO().insertFileUsage(paramvo);
	}

	/**
	 * 파일 사용 정보 수정
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int updateFileUsage(FileVO paramvo) {
		return getFileDAO().updateFileUsage(paramvo);
	}

	/**
	 * 파일 사용 정보 삭제
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int deleteFileUsage(FileVO paramvo) {
		return getFileDAO().deleteFileUsage(paramvo);
	}
}
