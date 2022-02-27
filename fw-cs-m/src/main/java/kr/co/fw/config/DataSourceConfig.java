package kr.co.fw.config;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages="kr.co.fw.sqlmap.mapper.**", sqlSessionFactoryRef="sqlSessionFactory")
public class DataSourceConfig {

	
	@Bean(name="dataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public DataSource DataSource() {
		return new HikariDataSource();
	}
	
	@Bean(name="dataSourceSms")
	@ConfigurationProperties(prefix="spring.datasource2")
	public DataSource DataSourceSms() {
		return new HikariDataSource();
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory (@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("sqlmap/mapper/**/*.xml"));
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:sqlmap/mybatis-config.xml"));
		
		return sqlSessionFactory.getObject();
	}
	
	@Bean(name="sqlSessionFactorySms")
	public SqlSessionFactory sqlSessionFactorySms (@Qualifier("dataSourceSms") DataSource dataSourceSms, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSourceSms);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("sqlmap/mapper/sms/sms-mapper.xml"));
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:sqlmap/mybatis-config.xml"));
		
		return sqlSessionFactory.getObject();
	}
	
	
	@Bean(name="sqlSession")
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean(name="sqlSessionSms")
	public SqlSessionTemplate sqlSessionSms(SqlSessionFactory sqlSessionFactorySms) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactorySms);
	}
	
}
