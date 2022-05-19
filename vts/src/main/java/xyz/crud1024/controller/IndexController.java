package xyz.crud1024.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;
import xyz.crud1024.pojo.Columns;
import xyz.crud1024.pojo.DataTus;
import xyz.crud1024.pojo.Group;
import xyz.crud1024.pojo.Person;
import xyz.crud1024.pojo.PictureSettings;
import xyz.crud1024.pojo.Score;
import xyz.crud1024.service.GroupService;
import xyz.crud1024.service.PersonService;
import xyz.crud1024.service.ScoreService;
@Controller
@RequestMapping(value = "/jsp")
public class IndexController {
	
	@Resource
	private GroupService groupService;
	@Resource
	private PersonService personService;
	@Resource
	private ScoreService scoreService;
	
	/*
	 * 队伍列表
	 */
	@RequestMapping(value = "/grouplist")
	public ModelAndView grouplist(HttpServletRequest request) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("grouplist");
			return modelAndView;
	}
	/*
	 * 所有队伍信息
	 */
	@RequestMapping(value = "/grouplists")
	@ResponseBody
	public String grouplists() throws JsonProcessingException{
		List<Group> list = groupService.findOfAllGroup();
		//把查询到的结果封装到json中，以json字符串形式返回
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		return obj.toString();
	}
	/*
	 * 添加队员
	 */
	@RequestMapping(value = "/addperson")
	public String addperson(){
		return "addperson";
	}
	
	/*
	 * 队员列表
	 */
	@RequestMapping(value = "/personlist")
	public String personlist(){
		return "personlist";
	}
	/*
	 * 所有队员信息
	 */
	@RequestMapping(value = "/personlists")
	@ResponseBody
	public String personlists() throws JsonProcessingException{
		List<Person> list = personService.findOfAllPerson();
		//把查询到的结果封装到json中，以json字符串形式返回
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		System.out.println(obj.toString());
		return obj.toString();
	}
	/*
	 * 显示选择队伍
	 */
	@RequestMapping(value = "/choosegroup")
	public String choosegroup(){
		return "choosegroup";
	}
	/*
	 * 添加队伍
	 */
	@RequestMapping(value = "/addgroup")
	public String addgroup(){
		return "addgroup";
	}
	
	/*
	 * 得分列表
	 */
	@RequestMapping(value = "/scorelist")
	public String scorelist(){
		return "scorelist";
	}
	/*
	 * 所有队员信息
	 */
	@RequestMapping(value = "/scorelists")
	@ResponseBody
	public String scorelists() throws JsonProcessingException{
		List<Score> list = scoreService.findOfAllScore();
		//把查询到的结果封装到json中，以json字符串形式返回
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		System.out.println(obj.toString());
		return obj.toString();
	}
	/*
	 * 单只队伍得分
	 */
	@RequestMapping(value = "/group")
	public String group(HttpServletRequest request) throws JsonProcessingException{
		int	gid=Integer.valueOf(request.getParameter("g_id"));
		int	cid=Integer.valueOf(request.getParameter("cid"));
		List<Columns> columns =new ArrayList<Columns>();//显示类型
		List<Person> psersonList = personService.findOfGroupOfPerson(gid);//小组所有队员
		System.out.println(psersonList.size());
		for (Iterator iterator = psersonList.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println(person.getPname()+person.getPid());
			List<Score> findOfAScore = scoreService.findOfPersonAndNumOfScore(new Score(person.getPid(), cid));//查询出个人的所有加分记录size为总得分
//			List<Score> findOfAScore = scoreService.findOfAScore(person.getPid());//查询出个人的所有加分记录size为总得分
			columns.add(new Columns(person.getPname(), findOfAScore.size(), new PictureSettings("layui/crud1024.png")));
			System.out.println(findOfAScore.size());
			
		}
		ObjectMapper jsonMapper = new ObjectMapper();
		String ujson;
		ujson = jsonMapper.writeValueAsString(columns);
		request.setAttribute("columns", ujson.replace("\"", "'"));
//		request.setAttribute("columns", "[{name:'胖虎',steps:5,pictureSettings:{src:'test'}},{name:'小志',steps:5,pictureSettings:{src:'test'}},{name:'静香',steps:5,pictureSettings:{src:'test'}},{name:'乔治',steps:4,pictureSettings:{src:'test'}},{name:'肖恩',steps:3,pictureSettings:{src:'test'}},{name:'小猪佩奇',steps:4,pictureSettings:{src:'test'}}]");
		System.out.println(ujson.replace("\"", "'"));
		return "forward:group.jsp";
	}
	/*
	 * 单只队伍单场得分
	 */
	@RequestMapping(value = "/groups")
	public String groups(HttpServletRequest request) throws JsonProcessingException{
		int	gid=Integer.valueOf(request.getParameter("g_id"));
		//列表数据
		List<DataTus> dataTus = new ArrayList<DataTus>();
		List<Score> scores = scoreService.findOfAllNum(gid);
		for (Score score : scores) {
			DataTus dataTus2 = new DataTus();//一场比赛一个new一个json数据对象
			dataTus2.setRound("第"+score.getS_cid()+"轮");//设置轮数
			System.out.println(dataTus2.getRound());
			Score score2 = new Score();
			score2.setS_cid(score.getS_cid());
			score2.setS_gid(gid);
			List<Score> scorelist = scoreService.findOfGroupAndNumAndPersonOfScore(score2);
			dataTus2.setPerson1(scorelist.get(0).getSnum());
			dataTus2.setPerson2(scorelist.get(1).getSnum());
			dataTus2.setPerson3(scorelist.get(2).getSnum());
			dataTus2.setPerson4(scorelist.get(3).getSnum());
			dataTus2.setPerson5(scorelist.get(4).getSnum());
			dataTus2.setPerson6(scorelist.get(5).getSnum());
			dataTus.add(dataTus2);
		}
		List<Person> persons = personService.findOfGroupOfPerson(1);//传入队伍id查出所有成员
		int i = 1;
		for (Person person : persons) {
			request.setAttribute("person"+i, person.getPname());//将成员传给页面标签数据
			i++;
		}
		
		ObjectMapper jsonMapper = new ObjectMapper();
		String ujson;
		ujson = jsonMapper.writeValueAsString(dataTus);
		request.setAttribute("groups", ujson);
		System.out.println(ujson);
		//标签提示数据
		
		return "forward:groups.jsp";
	}
	/*
	 * 计分选择轮次页面
	 */
	@RequestMapping(value = "/choosenum")
	public String choosenum(){
		return "choosenum";
	}
	/*
	 * 单场得分选择队伍和轮次页面
	 */
	@RequestMapping(value = "/choosegroupandnum")
	public String choosegroupandnum(){
		return "choosegroupandnum";
	}
	/*
	 * 计分页面
	 */
	@RequestMapping(value = "/vts")
	public String vts(HttpServletRequest request){
		request.setAttribute("cid", request.getParameter("cid"));
		return "vts";
	}
	
	
	
}
