package vts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.crud1024.controller.GroupController;
import xyz.crud1024.pojo.Group;


public class GroupTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	GroupController groupController = null;
	@Before
	public void before() {
		groupController = (GroupController) ac.getBean("groupController");
	}
	/*
	 * 添加队伍测试
	 */
	@Test
	public void insertGroup() {
		Integer insertGroup = groupController.insertGroup(new Group(3, "日本", "c:///sd"));
		System.out.println(insertGroup);
	}
	/*
	 * 修改队伍测试
	 */
	@Test
	public void updateGroup() {
		Integer insertGroup = groupController.updateGroup(new Group(3, "鬼子", "c:///sd"));
		System.out.println(insertGroup);
	}
}
