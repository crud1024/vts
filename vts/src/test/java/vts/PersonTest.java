package vts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.crud1024.controller.GroupController;
import xyz.crud1024.controller.PersonController;
import xyz.crud1024.controller.ScoreController;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Person;


public class PersonTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	PersonController personController = null;
	@Before
	public void before() {
		personController = (PersonController) ac.getBean("personController");
	}
	/*
	 * ÃÌº”∂”‘±≤‚ ‘
	 */
	@Test
	public void insertGroup() {
		Integer insertGroup = personController.insertPerson(new Person(17, "test", "test", 3));
		System.out.println(insertGroup);
	}
}
