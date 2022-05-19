package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Group;

public interface GroupService {
	public Integer insertGroup(Group group);
	public Integer updateGroup(Group group);
	public Integer delectGroup(Group group);
	/*
	 * 个人队伍信息查询
	 */
	public Group findOfAGroup(int gid);
	/*
	 * 所有队伍信息查询
	 */
	public List<Group> findOfAllGroup();
}
