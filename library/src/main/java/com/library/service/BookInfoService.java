package com.library.service;

import com.library.model.BookInfo;
import org.hibernate.Session;

public interface BookInfoService {

    boolean addNewBookCopy(Session session, BookInfo... book);

    boolean updateBookInfo(Session session, BookInfo book);

    BookInfo findBookByTitle(Session session, String title);

    BookInfo findBookByISBN(Session session, String isbn);

    BookInfo findBookByTheAuthor(Session session, String name, String lastName);
}
