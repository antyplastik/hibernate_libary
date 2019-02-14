package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

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
            tx.rollback();
        }

        return false;
    }

    @Override
    public boolean updateAuthor(AuthorInfo newAuthor) {
        boolean result = false;
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            List<AuthorInfo> findAuthor = findAuthor(newAuthor.getName(), newAuthor.getLastName());

            Integer listSize = findAuthor.size();

            if (listSize == 1) {
                session.save(newAuthor);
                result = true;
                tx.commit();

            } else if (listSize == null || listSize == 0) {
                tx.rollback();
                throw new IllegalArgumentException("[ERROR] No author in the database");

            } else {
                tx.rollback();
                throw new IllegalArgumentException("[ERROR] There is more than one such author in the database");
            }
        }
        return result;
    }

    @Override
    public boolean deleteAuthor(AuthorInfo newAuthor) {
        boolean result;
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            List<AuthorInfo> foundAuthor = findAuthor(newAuthor.getName(), newAuthor.getLastName());
            Integer listSize = foundAuthor.size();

            if (listSize == 1) {
                session.delete(newAuthor);
                result = true;
                tx.commit();

            } else if (listSize == null || listSize == 0) {
                tx.rollback();
                throw new IllegalArgumentException("[ERROR] No author in the database");

            } else {
                tx.rollback();
                throw new IllegalArgumentException("[ERROR] There is more than one such author in the database");
            }
        }
        return result;
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
