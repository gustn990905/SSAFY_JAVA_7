package com.ssafy.ws.step5;

public class UserManagerImpl implements IUserManager {

	private static final int MAX_USER_SIZE = 100;
	private User[] users = new User[MAX_USER_SIZE];
	private int userSize = 0;
	private User loginUser;

	private static IUserManager instance = new UserManagerImpl();

	private UserManagerImpl() {
	}

	public static IUserManager getInstance() {
		return instance;
	}

	@Override
	public void signup(User user) {
		users[userSize++] = user;
	}

	@Override
	public User login(String id, String password) {
		for (int i = 0; i < userSize; i++) {
			if (users[i].getUserId().equals(id) && users[i].getPassword().equals(password)) {
				loginUser = users[i];
				return loginUser;
			}
		}
		return null;
	}

	@Override
	public void logout() {
		loginUser = null;
	}

	@Override
	public User getLoginUser() {
		return loginUser;
	}

	@Override
	public User getUser(int userSeq) {
		for (int i = 0; i < userSize; i++)
			if (users[i].getUserSeq() == userSeq)
				return users[i];
		return null;
	}

	@Override
	public User getUser(String nickName) {
		for (int i = 0; i < userSize; i++)
			if (users[i].getNickName().equals(nickName))
				return users[i];
		return null;
	}
}