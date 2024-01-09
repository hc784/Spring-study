package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		c2 a = ctx.getBean("c",c2.class);
		a.hi2();
		
		ctx.close();
	}
}
