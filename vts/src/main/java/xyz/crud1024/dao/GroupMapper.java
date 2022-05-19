package xyz.crud1024.dao;

import java.util.List;


import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Person;
public interface GroupMapper {
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
