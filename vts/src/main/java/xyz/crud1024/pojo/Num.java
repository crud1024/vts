package xyz.crud1024.pojo;
/**
 * 场次类-表示对局的场次
 * @author 王智锋
 *
 */
public class Num {
	private int nid;//场次id
	private int n_gid;//队伍id
	private String nnum;//场次
	private String ntf;//是否获胜0-1；1为获胜
	public Num() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Num(int n_gid, String nnum, String ntf) {
		super();
		this.n_gid = n_gid;
		this.nnum = nnum;
		this.ntf = ntf;
	}

	public Num(int nid, int n_gid, String nnum, String ntf) {
		super();
		this.nid = nid;
		this.n_gid = n_gid;
		this.nnum = nnum;
		this.ntf = ntf;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getN_gid() {
		return n_gid;
	}
	public void setN_gid(int n_gid) {
		this.n_gid = n_gid;
	}
	public String getNnum() {
		return nnum;
	}
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	public String getNtf() {
		return ntf;
	}
	public void setNtf(String ntf) {
		this.ntf = ntf;
	}
	@Override
	public String toString() {
		return "Num [nid=" + nid + ", n_gid=" + n_gid + ", nnum=" + nnum + ", ntf=" + ntf + "]";
	}
	
}
