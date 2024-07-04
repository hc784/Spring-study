package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import login.MemberDao;
import login.MemberRegisterService;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"login", "board.service"})
@MapperScan(basePackages = {"mapper"})
public class MemberConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		//ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		ds.setUrl("jdbc:log4jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");

		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2); 
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	

	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao(dataSource());
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean se= new SqlSessionFactoryBean();
		se.setDataSource(dataSource());
		return (SqlSessionFactory)se.getObject();
	}
	
}
