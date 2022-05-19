package xyz.crud1024.pojo;
/**
 * 用户类
 * @author 王智锋
 *
 */
public class Root {
	private int uid;
	private String uname;
	private String upassword;
	public Root() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Root(int uid, String uname, String upassword) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "Root [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + "]";
	}
	
}
