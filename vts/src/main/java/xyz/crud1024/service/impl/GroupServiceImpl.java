package xyz.crud1024.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.crud1024.dao.GroupMapper;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.service.GroupService;
@Service("groupService")
public class GroupServiceImpl implements GroupService{
	@Resource
	private GroupMapper groupMapper;
	@Override
	public Integer insertGroup(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.insertGroup(group);
	}

	@Override
	public Integer updateGroup(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.updateGroup(group);
	}

	@Override
	public Integer delectGroup(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.delectGroup(group);
	}

	@Override
	public Group findOfAGroup(int gid) {
		// TODO Auto-generated method stub
		return groupMapper.findOfAGroup(gid);
	}

	@Override
	public List<Group> findOfAllGroup() {
		// TODO Auto-generated method stub
		return groupMapper.findOfAllGroup();
	}

}
