package xyz.crud1024.pojo;

import java.util.List;

public class Columns {
	private String name;
	private int steps;
	private PictureSettings pictureSettings;
	public Columns() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Columns(String name, int steps, PictureSettings pictureSettings) {
		super();
		this.name = name;
		this.steps = steps;
		this.pictureSettings = pictureSettings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public PictureSettings getPictureSettings() {
		return pictureSettings;
	}
	public void setPictureSettings(PictureSettings pictureSettings) {
		this.pictureSettings = pictureSettings;
	}
	@Override
	public String toString() {
		return "Columns [name=" + name + ", steps=" + steps + ", pictureSettings=" + pictureSettings + "]";
	}
	
}
