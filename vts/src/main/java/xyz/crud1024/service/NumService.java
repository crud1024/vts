package xyz.crud1024.service;

import java.util.List;

import xyz.crud1024.pojo.Num;

public interface NumService {
	public Integer insertNum(Num num);
	public Integer updateNum(Num num);
	public Integer delectNum(Num num);
	/*
	 * 单场对局信息查询
	 */
	public Num findOfANum(int nnum);
	/*
	 * 队伍对局信息查询
	 */
	public Num findOfAGroupNum(int gid);
	/*
	 * 所有对局信息查询
	 */
	public List<Num> findOfAllNum();
}
