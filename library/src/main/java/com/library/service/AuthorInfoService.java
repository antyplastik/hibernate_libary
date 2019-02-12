package com.library.service;

import com.library.model.AuthorInfo;
import com.library.model.Customer;
import org.hibernate.Session;

public interface AuthorInfoService {

    boolean addNewAuthor(AuthorInfo newAuthor);

    boolean updateAuthor(AuthorInfo newAuthor);

    boolean deleteAuthor(AuthorInfo newAuthor);

    AuthorInfo findAuthor(AuthorInfo newAuthor);

}
