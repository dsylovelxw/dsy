package denglu.entity;

public class Denglu {

	private  int id;
	private String mName;
	private int type;
	private int fatherid;
	private  String mben ;
	private String resUrl;
	private int ishide;
	private String js;
	
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public int getIshide() {
		return ishide;
	}
	public void setIshide(int ishide) {
		this.ishide = ishide;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	public String getMben() {
		return mben;
	}
	public void setMben(String mben) {
		this.mben = mben;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
