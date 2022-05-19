package xyz.crud1024.dao;

import java.util.List;


import xyz.crud1024.pojo.Score;

public interface ScoreMapper {
	public Integer insertScore(Score score);
	public Integer updateScore(Score score);
	public Integer delectScore(Score score);
	/*
	 * ���˵÷������ѯ
	 */
	public List<Score> findOfAScore(int s_pid);
	/*
	 * ͨ������id��ѯ���вμӾ�����ѯ�����ѯ
	 */
	public List<Score> findOfAllNum(int s_gid);
	/*
	 * ��ֻ����÷���Ϣ��ѯ
	 */
	public List<Score> findOfGroupOfScore(int s_gid);
	/*
	 * ��ֻ���鵥�����е÷���Ϣ��ѯ
	 */
	public List<Score> findOfGroupAndNumOfScore(Score score);
	/*
	 * ��ֻ���鵥�����ж�Ա������Ϣ��ѯ
	 */
	public List<Score> findOfGroupAndNumAndPersonOfScore(Score score);
	/*
	 * ����Ա���ֵ÷���Ϣ��ѯ
	 */
	public List<Score> findOfPersonAndNumOfScore(Score score);
	/*
	 * ���ж���÷���Ϣ��ѯ--��Ҫ������ʾ����ɼ�
	 */
	public List<Score> findOfAllScore();
}
