package kr.co.fw.base;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.fw.board.BoardService;
import kr.co.fw.common.code.CodeService;
import kr.co.fw.common.file.FileService;
import kr.co.fw.consultant.ConsultantService;
import kr.co.fw.customer.CustomerService;
import kr.co.fw.product.ProductService;
import kr.co.fw.system.log.LogService;
import kr.co.fw.system.user.UserService;
import lombok.Getter;

@Getter
public class BaseController {
	
	@Autowired
	LogService logService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	UserService userService;
	
	
	/* Biz 영역 */
	@Autowired
	ConsultantService consultantService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
}