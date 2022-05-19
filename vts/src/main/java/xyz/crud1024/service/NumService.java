package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Num;

public interface NumService {
	public Integer insertNum(Num num);
	public Integer updateNum(Num num);
	public Integer delectNum(Num num);
	/*
	 * �����Ծ���Ϣ��ѯ
	 */
	public Num findOfANum(int nnum);
	/*
	 * ����Ծ���Ϣ��ѯ
	 */
	public Num findOfAGroupNum(int gid);
	/*
	 * ���жԾ���Ϣ��ѯ
	 */
	public List<Num> findOfAllNum();
}
