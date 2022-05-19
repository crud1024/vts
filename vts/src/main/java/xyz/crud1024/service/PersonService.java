package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Person;

public interface PersonService {
	public Integer insertPerson(Person person);
	public Integer updatePerson(Person person);
	public Integer delectPerson(Person person);
	/*
	 * 单人信息查询
	 */
	public Person findOfAPerson(int p_id);
	/*
	 * 整队人员信息查询
	 */
	public List<Person> findOfGroupOfPerson(int g_id);
	/*
	 * 所有人员信息查询
	 */
	public List<Person> findOfAllPerson();
}
