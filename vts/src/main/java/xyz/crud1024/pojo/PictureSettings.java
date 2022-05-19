package xyz.crud1024.pojo;

/**
 * @author Õı÷«∑Ê
 *
 */
public class PictureSettings {
	private String src;

	public PictureSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PictureSettings(String src) {
		super();
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "PictureSettings [src=" + src + "]";
	}
	
}
