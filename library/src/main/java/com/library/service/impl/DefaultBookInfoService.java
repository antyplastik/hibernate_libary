package com.library.service.impl;

import com.library.model.BookInfo;
import com.library.service.BookInfoService;
import org.hibernate.Session;

public class DefaultBookInfoService implements BookInfoService {
    @Override
    public boolean addNewBookCopy(BookInfo... book) {
        return false;
    }

    @Override
    public boolean updateBookInfo(BookInfo book) {
        return false;
    }

    @Override
    public BookInfo findBookByTitle(String title) {
        return null;
    }

    @Override
    public BookInfo findBookByISBN(String isbn) {
        return null;
    }

    @Override
    public BookInfo findBookByTheAuthor(String name, String lastName) {
        return null;
    }
}
