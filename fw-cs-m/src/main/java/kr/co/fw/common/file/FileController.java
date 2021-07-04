package kr.co.fw.common.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.fw.base.BaseController;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.config.Constants.UPLOADS;
import kr.co.fw.config.PropertiesVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
