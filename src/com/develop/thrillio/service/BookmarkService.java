package com.develop.thrillio.service;

import com.develop.thrillio.dao.BookmarkDao;
import com.develop.thrillio.entities.Book;
import com.develop.thrillio.entities.Bookmark;
import com.develop.thrillio.entities.Movie;
import com.develop.thrillio.entities.User;
import com.develop.thrillio.entities.UserBookmark;
import com.develop.thrillio.entities.WebLink;

public class BookmarkService {
	private static BookmarkService instance = new BookmarkService();
	private static BookmarkDao dao = new BookmarkDao();
	
	private BookmarkService() {};

	public static BookmarkService getInstance() {
		return instance;
	}
	
	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		return weblink;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setReleaseYear(releaseYear);
		return movie;
	}
	
	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		book.setId(publicationYear);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}
	
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", Marked by: " + user.getEmail() + " , " +bookmark);
	}
}