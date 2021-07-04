package kr.co.fw.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController extends BaseController {

	@GetMapping
	public ResponseEntity<List<HashMap<String, Object>>> list() {
		log.info("list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		BoardVO boardvo = new BoardVO();
		list = getBoardService().getItemList(boardvo);

		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/{bd_no}")
	public ResponseEntity<BoardVO> read(@PathVariable String bd_no) {
		log.info("read / " + bd_no);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		BoardVO bd = new BoardVO();

		ResponseEntity<BoardVO> entity = new ResponseEntity<>(bd, HttpStatus.OK);
		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@RequestBody BoardVO board) {
		log.info("register");
		log.info(board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PutMapping
	public ResponseEntity<String> modify(@RequestBody BoardVO board) {
		log.info("modify");
		log.info(board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("", HttpStatus.OK);
		return entity;
	}

	@DeleteMapping("/{bd_no}")
	public ResponseEntity<String> remove(@PathVariable String bd_no) {
		log.info("remove / " + bd_no);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}

}
