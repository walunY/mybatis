package xyz.walun.domain;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
	private Integer id;
	private Integer uid;
	private Double money;
	private User user;

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", uid=" + uid +
				", money=" + money +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public User getUser() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}
}
