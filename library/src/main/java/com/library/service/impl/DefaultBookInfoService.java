package com.library.service.impl;

import com.library.model.BookInfo;
import com.library.service.BookInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DefaultBookInfoService implements BookInfoService {
    @Override
    public boolean addNewBookInfo(BookInfo newBookInfo) {

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            BookInfo foundBookInfo = findBookInfo(newBookInfo.getTitle());

            if (newBookInfo.getTitle() != null || !newBookInfo.getTitle().equals("")) {
                if (newBookInfo.equals(foundBookInfo)) {
                    tx.rollback();
                    throw new IllegalArgumentException("[ERROR] Book found in database");
                }
                if (!newBookInfo.equals(foundBookInfo)) {
                    session.save(newBookInfo);
                    tx.commit();
                    return true;
                }
            } else {
                tx.rollback();
                throw new IllegalArgumentException("[ERROR] Book not found in the database");
            }
        }
        return false;
    }

    @Override
    public boolean updateBookInfo(BookInfo book) {



        return false;
    }

    @Override
    public BookInfo findBookInfo(String title) {
        BookInfo foundBook;
        try (Session session = SessionUtil.getSession()) {
            Query<BookInfo> bookInfoQuery = session.createQuery("FROM BookInfo bi WHERE bi.title=:title", BookInfo.class);
            bookInfoQuery.setParameter("title", title);

            foundBook = bookInfoQuery.uniqueResult();
        }
        return foundBook;
    }

    @Override
    public List<BookInfo> findBookByTitle(String title) {
        return null;
    }

    @Override
    public BookInfo findBookByISBN(String isbn) {
        return null;
    }

    @Override
    public List<BookInfo> findBookByTheAuthor(String name, String lastName) {
        return null;
    }
}
