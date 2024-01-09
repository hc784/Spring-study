//package spring;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//
//@Aspect
//public class TestAspect {
//	
//	@Around("execution(public * spring..*(..))")
//	void hi(ProceedingJoinPoint joinpoint) throws Throwable
//	{
//		System.out.print("aspectbefore");
//		joinpoint.proceed();
//		System.out.print("aspectAfter");
//	}
//}
