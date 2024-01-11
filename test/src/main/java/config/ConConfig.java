package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConConfig {
	
	@Bean
	public HelloCon helloCon() {
		return new HelloCon();
	}
}
