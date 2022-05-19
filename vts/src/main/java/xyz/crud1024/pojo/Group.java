package xyz.crud1024.pojo;
/**
 * ∂”ŒÈ¿‡
 * @author Õı÷«∑Ê
 *
 */
public class Group {
	private int gid;
	private String gname;
	private String gurl;
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int gid, String gname, String gurl) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gurl = gurl;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGurl() {
		return gurl;
	}
	public void setGurl(String gurl) {
		this.gurl = gurl;
	}
	@Override
	public String toString() {
		return "Group [gid=" + gid + ", gname=" + gname + ", gurl=" + gurl + "]";
	}
	
}
