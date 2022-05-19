package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Group;

public interface GroupService {
	public Integer insertGroup(Group group);
	public Integer updateGroup(Group group);
	public Integer delectGroup(Group group);
	/*
	 * ���˶�����Ϣ��ѯ
	 */
	public Group findOfAGroup(int gid);
	/*
	 * ���ж�����Ϣ��ѯ
	 */
	public List<Group> findOfAllGroup();
}
