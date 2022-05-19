package xyz.crud1024.dao;

import java.util.List;


import xyz.crud1024.pojo.Score;

public interface ScoreMapper {
	public Integer insertScore(Score score);
	public Integer updateScore(Score score);
	public Integer delectScore(Score score);
	/*
	 * 单人得分情况查询
	 */
	public List<Score> findOfAScore(int s_pid);
	/*
	 * 通过队伍id查询所有参加局数查询情况查询
	 */
	public List<Score> findOfAllNum(int s_gid);
	/*
	 * 单只队伍得分信息查询
	 */
	public List<Score> findOfGroupOfScore(int s_gid);
	/*
	 * 单只队伍单轮所有得分信息查询
	 */
	public List<Score> findOfGroupAndNumOfScore(Score score);
	/*
	 * 单只队伍单轮所有队员个人信息查询
	 */
	public List<Score> findOfGroupAndNumAndPersonOfScore(Score score);
	/*
	 * 单队员单轮得分信息查询
	 */
	public List<Score> findOfPersonAndNumOfScore(Score score);
	/*
	 * 所有队伍得分信息查询--需要分组显示各组成绩
	 */
	public List<Score> findOfAllScore();
}
