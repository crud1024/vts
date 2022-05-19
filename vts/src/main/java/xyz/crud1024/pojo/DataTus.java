package xyz.crud1024.pojo;

public class DataTus {
	private String round;
	private int person1;
	private int person2;
	private int person3;
	private int person4;
	private int person5;
	private int person6;
	public DataTus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataTus(String round, int person1, int person2, int person3, int person4, int person5, int person6) {
		super();
		this.round = round;
		this.person1 = person1;
		this.person2 = person2;
		this.person3 = person3;
		this.person4 = person4;
		this.person5 = person5;
		this.person6 = person6;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	public int getPerson1() {
		return person1;
	}
	public void setPerson1(int person1) {
		this.person1 = person1;
	}
	public int getPerson2() {
		return person2;
	}
	public void setPerson2(int person2) {
		this.person2 = person2;
	}
	public int getPerson3() {
		return person3;
	}
	public void setPerson3(int person3) {
		this.person3 = person3;
	}
	public int getPerson4() {
		return person4;
	}
	public void setPerson4(int person4) {
		this.person4 = person4;
	}
	public int getPerson5() {
		return person5;
	}
	public void setPerson5(int person5) {
		this.person5 = person5;
	}
	public int getPerson6() {
		return person6;
	}
	public void setPerson6(int person6) {
		this.person6 = person6;
	}
	@Override
	public String toString() {
		return "DataTus [round=" + round + ", person1=" + person1 + ", person2=" + person2 + ", person3=" + person3
				+ ", person4=" + person4 + ", person5=" + person5 + ", person6=" + person6 + "]";
	}
	
	
}
