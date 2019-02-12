package com.library.service;

import com.library.model.BookInfo;
import org.hibernate.Session;

public interface BookInfoService {

    boolean addNewBookCopy(BookInfo... book);

    boolean updateBookInfo(BookInfo book);

    BookInfo findBookByTitle(String title);

    BookInfo findBookByISBN(String isbn);

    BookInfo findBookByTheAuthor(String name, String lastName);
}
