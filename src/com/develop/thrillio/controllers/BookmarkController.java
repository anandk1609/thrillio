package com.develop.thrillio.controllers;

import com.develop.thrillio.entities.Book;
import com.develop.thrillio.entities.Bookmark;
import com.develop.thrillio.entities.User;
import com.develop.thrillio.entities.WebLink;
import com.develop.thrillio.service.BookmarkService;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkService.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkService.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		
		System.out.println("Data to be shared: ");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
		}
	}
}
