package kr.co.fw.system.interceptor.copy;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.fw.system.security.model.User;

@SuppressWarnings("deprecation")
public class InterceptorAdapter extends HandlerInterceptorAdapter {

	private SqlSessionTemplate sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(InterceptorAdapter.class);

	public InterceptorAdapter(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// session검사
		String url = request.getRequestURI();
		logger.debug("url : " + url);

		if (!url.contains("resources/") && 
				!url.contains("META-INF/") && 
				!url.contains("index.go") &&
				!url.contains("/js/") &&
				!url.contains("/css/") &&
				!url.contains("/img/") &&
				!url.contains("favicon.ico") 
			) {

			Enumeration<String> paramsss = request.getParameterNames();
			logger.info("---------- requests @ interceptor ----------");
			String params = "";
			while (paramsss.hasMoreElements()) {
				String name = (String) paramsss.nextElement();
				params += (name + "=" + request.getParameter(name) + "&");
			}
			logger.info(params);
			logger.info("--------------------------------------------");

			// 인덱스에서 메뉴조회, 세션유지, index.go 이동, ddcode 공통코드 조회를 제외한 나머지 액션
//	    	HttpSession session = request.getSession();
//    		SessionVO sessionVO = SessionUtil.getSessionVO(session);
			User user = new User();
//    		if (sessionVO != null) {
//    			user = SessionUtil.getSessionVO(session).getUser();
//    		}
			HashMap<String, String> map = new HashMap<String, String>();

			String user_id = "";

			if (user != null) {
				user_id = user.getUser_id();
				logger.debug("session Exists user_id = " + user_id);
			}

			HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();
			String ip = req.getHeader("X-FORWARDED-FOR");

			if (ip == null)
				ip = req.getRemoteAddr();
			String ua = request.getHeader("User-Agent");

			map.put("action_url", url);
			map.put("user_id", user_id);
			map.put("user_ip", ip);
			map.put("conn_env", ua);
			map.put("param", params);

			sqlSession.insert("Log." + "insertActionLog", map);
		}

		return true;
	}
}
