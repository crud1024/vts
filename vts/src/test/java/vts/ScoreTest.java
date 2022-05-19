package vts;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.crud1024.controller.GroupController;
import xyz.crud1024.controller.ScoreController;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Score;


public class ScoreTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	ScoreController scoreController = null;
	@Before
	public void before() {
		scoreController = (ScoreController) ac.getBean("scoreController");
	}
	/*
	 * ��ӵ÷ּ�¼����
	 */
	@Test
	public void insertScore() {
		Integer insertScore = scoreController.insertScore(new Score(3, 1, 2, 3));
		System.out.println(insertScore);
	}
	/*
	 * ��ѯ���м�¼�ִβ���
	 */
	@Test
	public void findOfAllNum() {
		List<Score> insertScore = scoreController.findOfAllNum(1);
		System.out.println(insertScore.size());
	}
	/*
	 * ��ӵ÷ּ�¼����
	 */
	@Test
	public void findOfGroupAndNumOfScore() {
		Score score = new Score();
		score.setS_gid(1);
		score.setS_cid(1);
		List<Score> findOfGroupAndNumOfScore = scoreController.findOfGroupAndNumOfScore(score);
		for (Score score2 : findOfGroupAndNumOfScore) {
			System.out.println(score2);
		}
	}
	/*
	 * ��ѯ�������˵÷����ݲ���
	 */
	@Test
	public void findOfGroupAndNumAndPersonOfScore() {
		Score score = new Score();
		score.setS_gid(1);
		score.setS_cid(1);
		List<Score> scores2 = scoreController.findOfGroupAndNumAndPersonOfScore(score);
		for (Score score2 : scores2) {
			System.out.println(score2);
		}
	}
}
