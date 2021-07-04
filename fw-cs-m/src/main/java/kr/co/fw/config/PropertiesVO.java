package kr.co.fw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("kr.co.gnx")
public class PropertiesVO {

	private String uploadPath;
	
}
