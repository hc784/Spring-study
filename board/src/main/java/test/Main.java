package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import board.BoardVO;
import config.MemberConfig;
import mapper.BoardMapper;

public class Main {
	

	public static void main(String[] args) {
		/*
		 * AnnotationConfigApplicationContext ac = new
		 * AnnotationConfigApplicationContext(MemberConfig.class); MockMvc mockMvc;
		 * AnnotationConfigWebApplicationContext ctx = new
		 * AnnotationConfigWebApplicationContext(); mockMvc =
		 * MockMvcBuilders.webAppContextSetup(ctx).build();
		 * mockMvc.perform(MockMvcRequestBuilders.get("/board/list").andReturn().
		 * getModelAndView());
		 */
	}
}
