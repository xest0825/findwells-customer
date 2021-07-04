package kr.co.fw.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;

@Getter
public class BaseDAO {
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	@Qualifier("sqlSessionSms")
	private SqlSessionTemplate sqlSessionSms;
	
	/* SYSTEM/Common 영역 */
	@Getter
	private static final String LogMapper 	 	= "Log.";
	@Getter
	private static final String CodeMapper   	= "Code.";
	@Getter
	private static final String UserMapper 	 	= "User.";
	@Getter
	private static final String RoleMapper 	 	= "Role.";
	@Getter
	private static final String JwtMapper 	 	= "Jwt.";  //jwt-mapper.xml jwt 발급 관련
	@Getter
	private static final String MenuMapper 	 	= "Menu.";
	@Getter
	private static final String BoardMapper	 	= "Board.";
	@Getter
	private static final String InscoMapper  	= "Insco.";
	@Getter
	private static final String FileMapper 	 	= "File.";
	@Getter
	private static final String CommonMapper 	= "Common.";
	@Getter
	private static final String MemberMapper 	= "Member.";
	@Getter
	private static final String SmsMapper    	= "Sms.";
	
	/* Biz 영역 */
	@Getter
	private static final String ConsultantMapper	= "Consultant.";
	
	@Getter
	private static final String PlanMapper			= "Plan.";
	
	@Getter
	private static final String CustomerMapper		= "Customer.";
	
	@Getter
	private static final String ProcessMapper		= "Process.";
	
	@Getter
	private static final String ProductMapper		= "Product.";
	
	@Getter
	private static final String AdvertisementMapper = "Advertisement.";
	
	
}
