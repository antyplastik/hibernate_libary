package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DefaultAuthorInfoService implements AuthorInfoService {
    @Override
    public boolean addNewAuthor(AuthorInfo newAuthor) {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            if (newAuthor != null) {
                session.save(newAuthor);
                tx.commit();
                return true;
            }
//            tx.rollback();
        }

        return false;
    }

    @Override
    public boolean updateAuthor(AuthorInfo newAuthor) {
        try (Session session = SessionUtil.getSession()) {

        }
        return false;
    }

    @Override
    public boolean deleteAuthor(AuthorInfo newAuthor) {
        try (Session session = SessionUtil.getSession()) {


        }
        return false;
    }

    @Override
    public List<AuthorInfo> findAuthor(String authorName, String authorLastName) {
        Query<AuthorInfo> query;
        List<AuthorInfo> resultList;
        try (Session session = SessionUtil.getSession()) {
            query = session.createQuery("FROM AuthorInfo ai WHERE ai.name=:name and ai.lastName=:lastName", AuthorInfo.class);
            query.setParameter("name", authorName);
            query.setParameter("lastName", authorLastName);

            resultList = query.list();

        }
        System.out.println("hello");
        return resultList;
    }
}
