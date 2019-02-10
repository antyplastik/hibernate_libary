package com.library.service.impl;

import com.library.model.BookInfo;
import com.library.service.BookInfoService;
import org.hibernate.Session;

public class DefaultBookInfoService implements BookInfoService {
    @Override
    public boolean addNewBookCopy(Session session, BookInfo... book) {
        return false;
    }

    @Override
    public boolean updateBookInfo(Session session, BookInfo book) {
        return false;
    }

    @Override
    public BookInfo findBookByTitle(Session session, String title) {
        return null;
    }

    @Override
    public BookInfo findBookByISBN(Session session, String isbn) {
        return null;
    }

    @Override
    public BookInfo findBookByTheAuthor(Session session, String name, String lastName) {
        return null;
    }
}
