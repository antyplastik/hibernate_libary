package com.library.service;

import com.library.model.BookInfo;

import java.util.List;

public interface BookInfoService {

    boolean addNewBookInfo(BookInfo bookInfo);

    boolean updateBookInfo(BookInfo book);

    BookInfo findBookInfo (String title);

    List<BookInfo> findBookByTitle(String title);

    BookInfo findBookByISBN(String isbn);

    List<BookInfo> findBookByTheAuthor(String name, String lastName);
}
