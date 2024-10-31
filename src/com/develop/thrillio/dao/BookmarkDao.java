package com.develop.thrillio.dao;

import com.develop.thrillio.DataStore;
import com.develop.thrillio.entities.Bookmark;
import com.develop.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
