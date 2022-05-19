package xyz.crud1024.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.crud1024.dao.NumMapper;
import xyz.crud1024.pojo.Num;
import xyz.crud1024.service.NumService;
@Service("numService")
public class NumServiceImpl implements NumService{
	@Resource
	private NumMapper numMapper;
	@Override
	public Integer insertNum(Num num) {
		// TODO Auto-generated method stub
		return numMapper.insertNum(num);
	}

	@Override
	public Integer updateNum(Num num) {
		// TODO Auto-generated method stub
		return numMapper.updateNum(num);
	}

	@Override
	public Integer delectNum(Num num) {
		// TODO Auto-generated method stub
		return numMapper.delectNum(num);
	}

	@Override
	public Num findOfANum(int nnum) {
		// TODO Auto-generated method stub
		return numMapper.findOfANum(nnum);
	}

	@Override
	public Num findOfAGroupNum(int gid) {
		// TODO Auto-generated method stub
		return numMapper.findOfAGroupNum(gid);
	}

	@Override
	public List<Num> findOfAllNum() {
		// TODO Auto-generated method stub
		return numMapper.findOfAllNum();
	}
	
}
