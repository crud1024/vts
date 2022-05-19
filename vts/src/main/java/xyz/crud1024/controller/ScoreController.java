package xyz.crud1024.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.crud1024.pojo.Person;
import xyz.crud1024.pojo.Score;
import xyz.crud1024.service.ScoreService;
@Controller
public class ScoreController {
	@Resource
	private ScoreService scoreService;
	
	public Integer insertScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.insertScore(score);
	}

	public Integer updateScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.updateScore(score);
	}

	public Integer delectScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.delectScore(score);
	}

	public List<Score> findOfAllNum(int s_gid) {
		// TODO Auto-generated method stub
		return scoreService.findOfAllNum(s_gid);
	}
	
	public List<Score> findOfAScore(int s_pid) {
		// TODO Auto-generated method stub
		return scoreService.findOfAScore(s_pid);
	}

	public List<Score> findOfGroupOfScore(int s_gid) {
		// TODO Auto-generated method stub
		return scoreService.findOfGroupOfScore(s_gid);
	}

	public List<Score> findOfAllScore() {
		// TODO Auto-generated method stub
		return scoreService.findOfAllScore();
	}
	
	public List<Score> findOfGroupAndNumOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.findOfGroupAndNumOfScore(score);
	}
	
	public List<Score> findOfGroupAndNumAndPersonOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.findOfGroupAndNumAndPersonOfScore(score);
	}
	
	public List<Score> findOfPersonAndNumOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreService.findOfPersonAndNumOfScore(score);
	}
	
	//为得分表中添加得分记录
		@RequestMapping(value = "/getScore")
		public void getScore(@RequestBody Score score) {
			int s_pid = score.getS_pid();
			int s_gid = score.getS_gid();
			int s_cid = score.getS_cid();
			int denum = 1;
			//添加记录操作
			scoreService.insertScore(new Score(denum, s_gid, s_pid, s_cid));
			System.out.println("成功添加得分记录");
			
		}
		//通过队员id获取队伍总分数据
		@RequestMapping(value = "/getPersonScore")
		@ResponseBody
		public	List<Score> getPersonScore(HttpServletRequest request) {
			//更新队伍得分到页面
			//查询记录数据得分情况-记录数等于得分数
			Score score = new Score();
			score.setS_cid(Integer.valueOf(request.getParameter("cid")));
			score.setS_gid(Integer.valueOf(request.getParameter("pid")));
			List<Score> personscore = scoreService.findOfGroupAndNumOfScore(score);
			System.out.println(personscore.size());
//			List<Score> groupscore = scoreService.findOfGroupOfScore(Integer.valueOf(request.getParameter("p_gid")));
			return personscore;
		}
	//通过组id获取队伍总分数据
	@RequestMapping(value = "/getGroupScore")
	@ResponseBody
	public	List<Score> getGroupScore(HttpServletRequest request) {
			//更新队伍得分到页面
			//查询记录数据得分情况-记录数等于得分数
			Score score = new Score();
			score.setS_cid(Integer.valueOf(request.getParameter("cid")));
			score.setS_gid(Integer.valueOf(request.getParameter("p_gid")));
			List<Score> groupscore = scoreService.findOfGroupAndNumOfScore(score);
			System.out.println(groupscore.size());
//			List<Score> groupscore = scoreService.findOfGroupOfScore(Integer.valueOf(request.getParameter("p_gid")));
			return groupscore;
	}
}
