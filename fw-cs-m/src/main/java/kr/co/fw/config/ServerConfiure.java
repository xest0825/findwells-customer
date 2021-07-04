package kr.co.fw.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.fw.system.interceptor.InterceptorAdapter;

@Configuration
public class ServerConfiure implements WebMvcConfigurer {

	private static final List<String> URL_PTTERNS = Arrays.asList("/**");

	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptorAdapter(sqlSession)).addPathPatterns(URL_PTTERNS);
	}
	
	@Bean
	public GracefulShutdown gracefulShutdown() {
	    return new GracefulShutdown();
	}

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory(final GracefulShutdown gracefulShutdown) {
	    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	    factory.addConnectorCustomizers(gracefulShutdown);
	    return factory;
	}

}
