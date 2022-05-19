package xyz.crud1024.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.crud1024.dao.GroupMapper;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.service.GroupService;
import xyz.crud1024.util.Algorithm;
import xyz.crud1024.util.GetOfSqlSession;
@Controller
public class GroupController {
	@Resource
	private GroupService groupService;
	
	public Integer insertGroup(Group group) {
		// TODO Auto-generated method stub
		return groupService.insertGroup(group);
	}
	
	public Integer updateGroup(Group group) {
		// TODO Auto-generated method stub
		return groupService.updateGroup(group);
	}

	public Integer delectGroup(Group group) {
		// TODO Auto-generated method stub
		return groupService.delectGroup(group);
	}

	public Group findOfAGroup(int gid) {
		// TODO Auto-generated method stub
		return groupService.findOfAGroup(gid);
	}

	public List<Group> findOfAllGroup() {
		// TODO Auto-generated method stub
		return groupService.findOfAllGroup();
	}
	@RequestMapping(value = "getGroups")
	@ResponseBody
	public List<Group> getGroups() {
		ArrayList<Group> groups = (ArrayList<Group>) groupService.findOfAllGroup();
		
		return groups;
	}
	@RequestMapping(value = "insertgroup")
	public String insertgroup(HttpServletRequest request) {
//		groupService.insertGroup(new Group(Integer.valueOf(request.getParameter("gid")), request.getParameter("gname"), request.getParameter("gurl")));
		int num = groupService.findOfAllGroup().size()+1;
		groupService.insertGroup(new Group(num, request.getParameter("gname"), request.getParameter("gurl")));
		return "redirect:/jsp/addgroup";
	}
	
}
