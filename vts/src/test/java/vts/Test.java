package vts;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xyz.crud1024.dao.GroupMapper;
import xyz.crud1024.dao.PersonMapper;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Person;
import xyz.crud1024.util.GetOfSqlSession;

public class Test {
	

	/*
	 * 添加组信息测试
	 */
	@org.junit.Test
	public void insertGroup() {
		// 1.通过工具类获取sqlsession对象
		SqlSession session = new GetOfSqlSession().getSqlSession();
		GroupMapper mapper = session.getMapper(GroupMapper.class);
		Integer len = mapper.insertGroup(new Group(11, "日本", "c:///sd"));
		System.out.println(len);
	}
	@org.junit.Test
	public void findOfAllPerson() {
		// 1.通过工具类获取sqlsession对象
		SqlSession session = new GetOfSqlSession().getSqlSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> findOfAllPerson = mapper.findOfAllPerson();
		for (Person person : findOfAllPerson) {
			System.out.println(person.toString());
		}
	}
	@org.junit.Test
	public void insertPerson() {
		// 1.通过工具类获取sqlsession对象
		SqlSession session = new GetOfSqlSession().getSqlSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Integer insertPerson = mapper.insertPerson(new Person(14, "何一峰", "df", 2));
		System.out.println(insertPerson);
	}
}
