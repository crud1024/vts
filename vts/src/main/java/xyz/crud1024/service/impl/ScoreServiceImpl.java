package xyz.crud1024.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.crud1024.dao.ScoreMapper;
import xyz.crud1024.pojo.Score;
import xyz.crud1024.service.ScoreService;
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	@Resource
	private ScoreMapper scoreMapper;
	@Override
	public Integer insertScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.insertScore(score);
	}

	@Override
	public Integer updateScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.updateScore(score);
	}

	@Override
	public Integer delectScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.delectScore(score);
	}

	@Override
	public List<Score> findOfAScore(int s_pid) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfAScore(s_pid);
	}

	@Override
	public List<Score> findOfGroupOfScore(int s_gid) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfGroupOfScore(s_gid);
	}

	@Override
	public List<Score> findOfAllScore() {
		// TODO Auto-generated method stub
		return scoreMapper.findOfAllScore();
	}

	@Override
	public List<Score> findOfGroupAndNumOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfGroupAndNumOfScore(score);
	}

	@Override
	public List<Score> findOfPersonAndNumOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfPersonAndNumOfScore(score);
	}

	@Override
	public List<Score> findOfAllNum(int s_gid) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfAllNum(s_gid);
	}

	@Override
	public List<Score> findOfGroupAndNumAndPersonOfScore(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.findOfGroupAndNumAndPersonOfScore(score);
	}

}
