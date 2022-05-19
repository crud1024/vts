package xyz.crud1024.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Num;
import xyz.crud1024.service.NumService;

@Controller
public class NumController {
	@Resource
	private NumService numService;
	
	public Integer insertNum(Num num) {
		// TODO Auto-generated method stub
		return numService.insertNum(num);
	}

	
	public Integer updateNum(Num num) {
		// TODO Auto-generated method stub
		return numService.updateNum(num);
	}

	
	public Integer delectNum(Num num) {
		// TODO Auto-generated method stub
		return numService.delectNum(num);
	}

	
	public Num findOfANum(int nnum) {
		// TODO Auto-generated method stub
		return numService.findOfANum(nnum);
	}

	
	public Num findOfAGroupNum(int gid) {
		// TODO Auto-generated method stub
		return numService.findOfAGroupNum(gid);
	}

	
	public List<Num> findOfAllNum() {
		// TODO Auto-generated method stub
		return numService.findOfAllNum();
	}
	
	@RequestMapping(value = "getNums")
	@ResponseBody
	public List<Num> getNums() {
		List<Num> nums = numService.findOfAllNum();
		
		return nums;
	}
}
