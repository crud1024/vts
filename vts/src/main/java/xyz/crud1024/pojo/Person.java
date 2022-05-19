package xyz.crud1024.pojo;
/**
 * 队员类
 * @author 王智锋
 *
 */
public class Person {
	private int pid;
	private String pname;
	private String purl;
	private int p_gid;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int pid, String pname, String purl, int p_gid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.purl = purl;
		this.p_gid = p_gid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public int getP_gid() {
		return p_gid;
	}
	public void setP_gid(int p_gid) {
		this.p_gid = p_gid;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", purl=" + purl + ", p_gid=" + p_gid + "]";
	}
	
}
