package kr.co.fw.system.login;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;
import kr.co.fw.system.security.model.User;

@Service
public class LoginService extends BaseService {

	public User getUser(User paramvo) {
		return getLoginDAO().getUser(paramvo);
	}
	
	public HashMap<String, Object> getUserMap(User paramvo) {
		return getLoginDAO().getUserMap(paramvo);
	}

	public List<String> getRoleList(User paramvo) {
		return getLoginDAO().getRoleList(paramvo);
	}

}
