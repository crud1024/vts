package xyz.crud1024.pojo;
/**
 * 得分类
 * @author 王智锋
 *
 */
public class Score {
	private int sid;
	private int snum;
	private int s_gid;
	private int s_pid;
	private int s_cid;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Score(int s_pid, int s_cid) {
		super();
		this.s_pid = s_pid;
		this.s_cid = s_cid;
	}

	public Score(int sid, int snum, int s_gid, int s_pid, int s_cid) {
		super();
		this.sid = sid;
		this.snum = snum;
		this.s_gid = s_gid;
		this.s_pid = s_pid;
		this.s_cid = s_cid;
	}
	public Score(int snum, int s_gid, int s_pid, int s_cid) {
		super();
		this.snum = snum;
		this.s_gid = s_gid;
		this.s_pid = s_pid;
		this.s_cid = s_cid;
	}
	public Score(int snum, int s_gid, int s_pid) {
		super();
		this.snum = snum;
		this.s_gid = s_gid;
		this.s_pid = s_pid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getS_gid() {
		return s_gid;
	}
	public void setS_gid(int s_gid) {
		this.s_gid = s_gid;
	}
	public int getS_pid() {
		return s_pid;
	}
	public void setS_pid(int s_pid) {
		this.s_pid = s_pid;
	}
	public int getS_cid() {
		return s_cid;
	}
	public void setS_cid(int s_cid) {
		this.s_cid = s_cid;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", snum=" + snum + ", s_gid=" + s_gid + ", s_pid=" + s_pid + ", s_cid=" + s_cid
				+ "]";
	}
	
	
	
}
