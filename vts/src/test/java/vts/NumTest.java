package vts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.crud1024.controller.NumController;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Num;

public class NumTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	NumController numController = null;
	@Before
	public void before() {
		numController = (NumController) ac.getBean("numController");
	}
	/*
	 * ÃÌº”∂”ŒÈ≤‚ ‘
	 */
	@Test
	public void insertGroup() {
		Integer insertGroup = numController.insertNum(new Num(3, "1", "1"));
		System.out.println(insertGroup);
	}
}
