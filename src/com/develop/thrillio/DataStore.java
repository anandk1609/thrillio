package com.develop.thrillio;

import com.develop.thrillio.constants.Gender;
import com.develop.thrillio.constants.UserType;
import com.develop.thrillio.entities.Bookmark;
import com.develop.thrillio.entities.User;
import com.develop.thrillio.entities.UserBookmark;
import com.develop.thrillio.service.BookmarkService;
import com.develop.thrillio.service.UserService;

public class DataStore {
	private static final int USER_BOOKMARK_LIMIT = 5;
	private static final int BOOKMARK_COUNT_PER_TYPE = 5;
	private static final int BOOKMARK_TYPES_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	
	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	
	public static void loadData() {
		loadUsers();
		loadWeblinks();
	}

	public static void loadUsers() {
		users[0] = UserService.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE, UserType.USER);
		users[1] = UserService.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "Altman", Gender.MALE, UserType.USER);
		users[2] = UserService.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "Sol", Gender.FEMALE, UserType.EDITOR);
		users[3] = UserService.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "Elise", Gender.FEMALE, UserType.EDITOR);
		users[4] = UserService.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Pravin", "Yadav", Gender.MALE, UserType.CHIEF_EDITOR);
	}
	
	public static void loadWeblinks() {
		bookmarks[0][1] = BookmarkService.getInstance().createWebLink(BOOKMARK_COUNT_PER_TYPE, null, null, null);
	}
}