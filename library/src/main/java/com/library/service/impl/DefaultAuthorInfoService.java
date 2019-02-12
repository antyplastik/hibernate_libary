package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;

public class DefaultAuthorInfoService implements AuthorInfoService {
    @Override
    public boolean addNewAuthor(AuthorInfo newAuthor) {
        try(Session session = SessionUtil.getSession()){

        }
        return false;
    }

    @Override
    public boolean updateAuthor(AuthorInfo newAuthor) {
        return false;
    }

    @Override
    public boolean deleteAuthor(AuthorInfo newAuthor) {
        return false;
    }

    @Override
    public AuthorInfo findAuthor(AuthorInfo newAuthor) {
        return null;
    }
}
