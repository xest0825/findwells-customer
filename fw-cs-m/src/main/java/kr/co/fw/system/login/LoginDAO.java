package kr.co.fw.system.login;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LoginDAO extends BaseDAO {

	public List<User> getUserList(User paramvo) {
		log.info("LoginDAO.getUserList");
		return getSqlSession().selectList(getUserMapper() + "getUserList", paramvo);
	}

	public User getUser(User paramvo) {
		log.info("LoginDAO.getUser");
		return getSqlSession().selectOne(getUserMapper() + "getUser", paramvo);
	}

	public List<String> getRoleList(User paramvo) {
		log.info("LoginDAO.getRoleList");
		return getSqlSession().selectList(getRoleMapper() + "getRoleList", paramvo);
	}
}
