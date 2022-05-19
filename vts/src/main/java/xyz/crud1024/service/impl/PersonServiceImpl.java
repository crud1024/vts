package xyz.crud1024.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.crud1024.dao.PersonMapper;
import xyz.crud1024.pojo.Person;
import xyz.crud1024.service.PersonService;
@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Resource
	private PersonMapper personMapper;
	@Override
	public Integer insertPerson(Person person) {
		// TODO Auto-generated method stub
		return personMapper.insertPerson(person);
	}

	@Override
	public Integer updatePerson(Person person) {
		// TODO Auto-generated method stub
		return personMapper.updatePerson(person);
	}

	@Override
	public Integer delectPerson(Person person) {
		// TODO Auto-generated method stub
		return personMapper.delectPerson(person);
	}

	@Override
	public Person findOfAPerson(int p_id) {
		// TODO Auto-generated method stub
		return personMapper.findOfAPerson(p_id);
	}

	@Override
	public List<Person> findOfGroupOfPerson(int g_id) {
		// TODO Auto-generated method stub
		return personMapper.findOfGroupOfPerson(g_id);
	}

	@Override
	public List<Person> findOfAllPerson() {
		// TODO Auto-generated method stub
		return personMapper.findOfAllPerson();
	}

}
