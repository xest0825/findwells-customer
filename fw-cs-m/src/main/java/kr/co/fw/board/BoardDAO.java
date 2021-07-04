package kr.co.fw.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAO extends BaseDAO {

	public List<HashMap<String, Object>> getItemList(BoardVO paramvo) {
		log.info("BoardDAO.getItemList");
		return getSqlSession().selectList(getBoardMapper() + "getItemList", paramvo);
	}
}
