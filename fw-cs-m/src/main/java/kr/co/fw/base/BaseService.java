package kr.co.fw.base;

import org.springframework.beans.factory.annotation.Autowired;


import kr.co.fw.board.BoardDAO;
import kr.co.fw.common.code.CodeDAO;
import kr.co.fw.common.file.FileDAO;
import kr.co.fw.common.sms.SmsDAO;
import kr.co.fw.consultant.ConsultantDAO;
import kr.co.fw.customer.CustomerDAO;
import kr.co.fw.product.ProductDAO;
import kr.co.fw.system.auth.AuthDAO;
import kr.co.fw.system.log.LogDAO;
import kr.co.fw.system.login.LoginDAO;
import kr.co.fw.system.user.UserDAO;
import lombok.Getter;

@Getter
public class BaseService {
	
	/* SYSTEM/Common 영역 */
	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private LogDAO logDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private CodeDAO codeDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private SmsDAO smsDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthDAO authDAO;
	
	
	/* Biz 영역 */
	@Autowired
	private ConsultantDAO consultantDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
}
