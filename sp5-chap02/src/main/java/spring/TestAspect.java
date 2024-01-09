package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class TestAspect {
	@Autowired
	c2 inner;
	void hi()
	{
		System.out.print("c1hi");
	}
}
