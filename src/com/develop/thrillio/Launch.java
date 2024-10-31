package com.develop.thrillio;

import com.develop.thrillio.entities.Bookmark;
import com.develop.thrillio.entities.User;
import com.develop.thrillio.service.BookmarkService;
import com.develop.thrillio.service.UserService;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading Data....");
		DataStore.loadData();
		
		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmarks();
		
//		System.out.println("2. Printing Data....");
//		printUserData();
//		printBookmarkData();
	}
	
	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
	}
	
	private static void printBookmarkData() {
		for(Bookmark[] bookmarkList: bookmarks) {
			for(Bookmark bookmark: bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void startBookmarking() {
		System.out.println("\n2. Bookmarking...");
		for(User user: users) {
			View.bookmark(user, bookmarks);
		}
	}
	
	private static void startBrowsing() {
		//System.out.println("\n2. Browsing...");
		for(User user: users) {
			View.browse(user, bookmarks);
		}
	}
	public static void main(String[] args) {
		loadData();
		//startBookmarking();
		startBrowsing();
	}

}
