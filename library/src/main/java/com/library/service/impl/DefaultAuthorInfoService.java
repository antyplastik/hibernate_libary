package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import org.hibernate.Session;

public class DefaultAuthorInfoService implements AuthorInfoService {
    @Override
    public boolean addNewAuthor(Session session, AuthorInfo newAuthor) {
        return false;
    }

    @Override
    public boolean updateAuthor(Session session, AuthorInfo newAuthor) {
        return false;
    }

    @Override
    public boolean deleteAuthor(Session session, AuthorInfo newAuthor) {
        return false;
    }

    @Override
    public AuthorInfo findAuthor(Session session, AuthorInfo newAuthor) {
        return null;
    }
}
