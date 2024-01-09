package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppContext {
	@Bean
	public TestAspect testAspect() {
		return new TestAspect();
	}
	
	@Bean
	public c2 c()
	{
		return new c2();
	}
	
	
}
