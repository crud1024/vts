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
	 * �������Ϣ����
	 */
	@org.junit.Test
	public void insertGroup() {
		// 1.ͨ���������ȡsqlsession����
		SqlSession session = new GetOfSqlSession().getSqlSession();
		GroupMapper mapper = session.getMapper(GroupMapper.class);
		Integer len = mapper.insertGroup(new Group(11, "�ձ�", "c:///sd"));
		System.out.println(len);
	}
	@org.junit.Test
	public void findOfAllPerson() {
		// 1.ͨ���������ȡsqlsession����
		SqlSession session = new GetOfSqlSession().getSqlSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> findOfAllPerson = mapper.findOfAllPerson();
		for (Person person : findOfAllPerson) {
			System.out.println(person.toString());
		}
	}
	@org.junit.Test
	public void insertPerson() {
		// 1.ͨ���������ȡsqlsession����
		SqlSession session = new GetOfSqlSession().getSqlSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Integer insertPerson = mapper.insertPerson(new Person(14, "��һ��", "df", 2));
		System.out.println(insertPerson);
	}
}
