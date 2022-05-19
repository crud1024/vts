package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Person;

public interface PersonService {
	public Integer insertPerson(Person person);
	public Integer updatePerson(Person person);
	public Integer delectPerson(Person person);
	/*
	 * ������Ϣ��ѯ
	 */
	public Person findOfAPerson(int p_id);
	/*
	 * ������Ա��Ϣ��ѯ
	 */
	public List<Person> findOfGroupOfPerson(int g_id);
	/*
	 * ������Ա��Ϣ��ѯ
	 */
	public List<Person> findOfAllPerson();
}
