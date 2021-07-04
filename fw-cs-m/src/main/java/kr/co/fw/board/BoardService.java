package kr.co.fw.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService extends BaseService {

	public List<HashMap<String, Object>> getItemList(BoardVO paramvo) {
		log.info("BoardService.getItemList");
		return getBoardDAO().getItemList(paramvo);
	}

}
