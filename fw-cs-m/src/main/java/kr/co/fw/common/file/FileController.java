package kr.co.fw.common.file;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.fw.base.BaseController;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.config.Constants.UPLOADS;
import kr.co.fw.config.PropertiesVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/files")
public class FileController extends BaseController {

	private final PropertiesVO propertiesVO;

	@GetMapping
	public ResponseEntity<?> getFileInfoList(@RequestBody FileVO filevo) {
		log.info("list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = getFileService().getFileInfoList(filevo);
		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/{file_id}")
	public ResponseEntity<?> getFileInfo(@PathVariable String file_id) {
		log.info("read / " + file_id);
		FileVO filevo = new FileVO();
		HashMap<String, Object> file = new HashMap<String, Object>();
		filevo.setFile_id(file_id);
		file = getFileService().getFileInfo(filevo);
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(file, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/download")
	public void filedownload(HttpServletResponse response, HttpServletRequest request) throws Exception {

		URL url = null;
		InputStream in = null;
		OutputStream out = null;

		String fileUrl = request.getParameter("file_url");
		log.info("fileUrl : " + fileUrl);

		try {
			String[] fileUrlArr = fileUrl.split("/");

			String fileName = fileUrlArr[fileUrlArr.length - 1];
			String header = request.getHeader("User-Agent");

			if (header.contains("MSIE") || header.contains("Trident")) {
				fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
				response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			}

			response.setHeader("Pragma", "no-cache;");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Transfer-Encoding", "binary");

			out = response.getOutputStream();

			String httpsResult = "";

			url = new URL(fileUrl);
			// 만약 프로토콜이 https 라면 https SSL을 무시하는 로직을 수행해주어야 한다.('https 인증서 무시' 라는 키워드로 구글에 검색하면 많이 나옵니다.)

			in = url.openStream();

			while (true) {
				//파일을 읽어온다.
				int data = in.read();
				if (data == -1) {
					break;
				}
				//파일을 쓴다.
				out.write(data);
			}

			in.close();
			out.close();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
		}
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<?> register(@RequestPart("fileInfo") String fileInfo,
			@RequestPart("file") MultipartFile mFile, FileVO filevo) throws Exception {
		log.info("register");
		log.info("fileInfo :: " + fileInfo.toString());
		log.info("filevo :: " + filevo.toString());
		filevo = new ObjectMapper().readValue(fileInfo, FileVO.class);
		String work_id = filevo.getWork_id();
		log.info(work_id);

		filevo.setFile(mFile);

		if (mFile != null) {
			log.info(mFile.getOriginalFilename());
		} else {
			log.info("MultipartFile is null");
		}

		HashMap<String, Object> file = new HashMap<String, Object>();
		filevo = getFileService().saveFile(mFile, UPLOADS.FILE, filevo);
		filevo.setFile(null);
		file = (HashMap<String, Object>) CommUtil.ConverObjectToMap(filevo);
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(file, HttpStatus.OK);
		return entity;
	}

	@PutMapping("/{file_id}")
	public ResponseEntity<?> updateFileInfo(@PathVariable String file_id, FileVO filevo) {
		log.info("modify files/" + file_id);
		log.info(filevo.toString());
		HashMap<String, Object> file = new HashMap<String, Object>();
		int result = getFileService().updateFileInfo(filevo);
		if (result > 0) {
			file.put("msg", "OK");
		} else {
			file.put("msg", "FAIL");
		}
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(file, HttpStatus.OK);
		return entity;
	}

	@DeleteMapping("/{file_id}")
	public ResponseEntity<?> deleteFile(@PathVariable String file_id) {
		log.info("remove files/ " + file_id);
		FileVO paramvo = new FileVO();
		paramvo.setFile_id(file_id);
		int result = getFileService().deleteFileAndInfo(paramvo);
		String msg = "";
		if (result > 0) {
			msg = "OK";
		} else {
			msg = "FAIL";
		}
		ResponseEntity<String> entity = new ResponseEntity<>(msg, HttpStatus.OK);
		return entity;
	}
}
