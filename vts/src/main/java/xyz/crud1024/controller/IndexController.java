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
	 * �����б�
	 */
	@RequestMapping(value = "/grouplist")
	public ModelAndView grouplist(HttpServletRequest request) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("grouplist");
			return modelAndView;
	}
	/*
	 * ���ж�����Ϣ
	 */
	@RequestMapping(value = "/grouplists")
	@ResponseBody
	public String grouplists() throws JsonProcessingException{
		List<Group> list = groupService.findOfAllGroup();
		//�Ѳ�ѯ���Ľ����װ��json�У���json�ַ�����ʽ����
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		return obj.toString();
	}
	/*
	 * ��Ӷ�Ա
	 */
	@RequestMapping(value = "/addperson")
	public String addperson(){
		return "addperson";
	}
	
	/*
	 * ��Ա�б�
	 */
	@RequestMapping(value = "/personlist")
	public String personlist(){
		return "personlist";
	}
	/*
	 * ���ж�Ա��Ϣ
	 */
	@RequestMapping(value = "/personlists")
	@ResponseBody
	public String personlists() throws JsonProcessingException{
		List<Person> list = personService.findOfAllPerson();
		//�Ѳ�ѯ���Ľ����װ��json�У���json�ַ�����ʽ����
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		System.out.println(obj.toString());
		return obj.toString();
	}
	/*
	 * ��ʾѡ�����
	 */
	@RequestMapping(value = "/choosegroup")
	public String choosegroup(){
		return "choosegroup";
	}
	/*
	 * ��Ӷ���
	 */
	@RequestMapping(value = "/addgroup")
	public String addgroup(){
		return "addgroup";
	}
	
	/*
	 * �÷��б�
	 */
	@RequestMapping(value = "/scorelist")
	public String scorelist(){
		return "scorelist";
	}
	/*
	 * ���ж�Ա��Ϣ
	 */
	@RequestMapping(value = "/scorelists")
	@ResponseBody
	public String scorelists() throws JsonProcessingException{
		List<Score> list = scoreService.findOfAllScore();
		//�Ѳ�ѯ���Ľ����װ��json�У���json�ַ�����ʽ����
		JSONObject obj=new JSONObject();
		obj.put("code",0);
		obj.put("msg","");
		obj.put("count",list.size());
		obj.put("data",list);
		System.out.println(obj.toString());
		return obj.toString();
	}
	/*
	 * ��ֻ����÷�
	 */
	@RequestMapping(value = "/group")
	public String group(HttpServletRequest request) throws JsonProcessingException{
		int	gid=Integer.valueOf(request.getParameter("g_id"));
		int	cid=Integer.valueOf(request.getParameter("cid"));
		List<Columns> columns =new ArrayList<Columns>();//��ʾ����
		List<Person> psersonList = personService.findOfGroupOfPerson(gid);//С�����ж�Ա
		System.out.println(psersonList.size());
		for (Iterator iterator = psersonList.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println(person.getPname()+person.getPid());
			List<Score> findOfAScore = scoreService.findOfPersonAndNumOfScore(new Score(person.getPid(), cid));//��ѯ�����˵����мӷּ�¼sizeΪ�ܵ÷�
//			List<Score> findOfAScore = scoreService.findOfAScore(person.getPid());//��ѯ�����˵����мӷּ�¼sizeΪ�ܵ÷�
			columns.add(new Columns(person.getPname(), findOfAScore.size(), new PictureSettings("layui/crud1024.png")));
			System.out.println(findOfAScore.size());
			
		}
		ObjectMapper jsonMapper = new ObjectMapper();
		String ujson;
		ujson = jsonMapper.writeValueAsString(columns);
		request.setAttribute("columns", ujson.replace("\"", "'"));
//		request.setAttribute("columns", "[{name:'�ֻ�',steps:5,pictureSettings:{src:'test'}},{name:'С־',steps:5,pictureSettings:{src:'test'}},{name:'����',steps:5,pictureSettings:{src:'test'}},{name:'����',steps:4,pictureSettings:{src:'test'}},{name:'Ф��',steps:3,pictureSettings:{src:'test'}},{name:'С������',steps:4,pictureSettings:{src:'test'}}]");
		System.out.println(ujson.replace("\"", "'"));
		return "forward:group.jsp";
	}
	/*
	 * ��ֻ���鵥���÷�
	 */
	@RequestMapping(value = "/groups")
	public String groups(HttpServletRequest request) throws JsonProcessingException{
		int	gid=Integer.valueOf(request.getParameter("g_id"));
		//�б�����
		List<DataTus> dataTus = new ArrayList<DataTus>();
		List<Score> scores = scoreService.findOfAllNum(gid);
		for (Score score : scores) {
			DataTus dataTus2 = new DataTus();//һ������һ��newһ��json���ݶ���
			dataTus2.setRound("��"+score.getS_cid()+"��");//��������
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
		List<Person> persons = personService.findOfGroupOfPerson(1);//�������id������г�Ա
		int i = 1;
		for (Person person : persons) {
			request.setAttribute("person"+i, person.getPname());//����Ա����ҳ���ǩ����
			i++;
		}
		
		ObjectMapper jsonMapper = new ObjectMapper();
		String ujson;
		ujson = jsonMapper.writeValueAsString(dataTus);
		request.setAttribute("groups", ujson);
		System.out.println(ujson);
		//��ǩ��ʾ����
		
		return "forward:groups.jsp";
	}
	/*
	 * �Ʒ�ѡ���ִ�ҳ��
	 */
	@RequestMapping(value = "/choosenum")
	public String choosenum(){
		return "choosenum";
	}
	/*
	 * �����÷�ѡ�������ִ�ҳ��
	 */
	@RequestMapping(value = "/choosegroupandnum")
	public String choosegroupandnum(){
		return "choosegroupandnum";
	}
	/*
	 * �Ʒ�ҳ��
	 */
	@RequestMapping(value = "/vts")
	public String vts(HttpServletRequest request){
		request.setAttribute("cid", request.getParameter("cid"));
		return "vts";
	}
	
	
	
}
