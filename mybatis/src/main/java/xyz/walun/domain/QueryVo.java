package xyz.walun.domain;

import xyz.walun.domain.User;

import java.util.List;

public class QueryVo {
	private User user;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
