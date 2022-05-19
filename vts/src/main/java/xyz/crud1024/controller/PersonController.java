package xyz.crud1024.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.crud1024.pojo.Person;
import xyz.crud1024.service.PersonService;
@Controller
public class PersonController {
	@Resource
	private PersonService personService;
	
	public Integer insertPerson(Person person) {
		// TODO Auto-generated method stub
		return personService.insertPerson(person);
	}

	public Integer updatePerson(Person person) {
		// TODO Auto-generated method stub
		return personService.updatePerson(person);
	}

	public Integer delectPerson(Person person) {
		// TODO Auto-generated method stub
		return personService.delectPerson(person);
	}

	public Person findOfAPerson(int p_id) {
		// TODO Auto-generated method stub
		return personService.findOfAPerson(p_id);
	}

	public List<Person> findOfGroupOfPerson(int g_id) {
		// TODO Auto-generated method stub
		return personService.findOfGroupOfPerson(g_id);
	}

	public List<Person> findOfAllPerson() {
		// TODO Auto-generated method stub
		return personService.findOfAllPerson();
	}
	@RequestMapping(value = "getPersons")
	@ResponseBody
	public List<Person> getPersons(HttpServletRequest request) {
		System.out.println(request.getParameter("g_id"));
		String parameter = request.getParameter("g_id");
		ArrayList<Person> persons = (ArrayList<Person>) personService.findOfGroupOfPerson(Integer.valueOf(parameter));
		return persons;
	}
	@RequestMapping(value = "insertperson")
	public String insertperson(HttpServletRequest request) {
		int num = personService.findOfAllPerson().size()+1;
		personService.insertPerson(new Person(num, request.getParameter("pname"), request.getParameter("purl"), Integer.valueOf(request.getParameter("p_gid"))));
		request.setAttribute("sss", 1);
		return "redirect:/jsp/addperson";
	}
	
}
