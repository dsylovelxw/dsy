package denglu.entity;

import java.util.List;

public class User<T> {
	private int code;//状态
	private String msg;//
private int count;// 行数
private List<T> data;//用户信息
 
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public List<T> getData() {
	return data;
}
public void setData(List<T> data) {
	this.data = data;
}
 

}
