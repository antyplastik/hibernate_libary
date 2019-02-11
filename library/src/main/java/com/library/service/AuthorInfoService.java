package com.library.service;

import com.library.model.AuthorInfo;
import com.library.model.Customer;
import org.hibernate.Session;

public interface AuthorInfoService {

    boolean addNewAuthor(Session session, AuthorInfo newAuthor);

    boolean updateAuthor(Session session, AuthorInfo newAuthor);

    boolean deleteAuthor(Session session, AuthorInfo newAuthor);

    AuthorInfo findAuthor(Session session, AuthorInfo newAuthor);

}
