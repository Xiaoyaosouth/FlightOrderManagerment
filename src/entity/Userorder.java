package entity;

import java.sql.Timestamp;

/**
 * 用户订单实体类
 */
public class Userorder {
	int id; // 订单号
	String phone; // 手机号
	String name; // 用户名
	String userId; // 证件号
	String statu; // 订单状态
	Timestamp startTime; // 订单提交时间
	Timestamp updateTime; // 订单更新时间
	String totalPrice; // 订单总价
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String uid) {
		this.userId = uid;
	}
	public String getStatu() {
		return this.statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Timestamp getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Timestamp ts) {
		this.startTime = ts;
	}
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(Timestamp ts) {
		this.updateTime = ts;
	}
	public String getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(String tp) {
		this.totalPrice = tp;
	}
}