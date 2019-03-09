package com.library.service;

import com.library.model.AuthorInfo;
import com.library.model.BookInfo;

import java.util.List;

public interface AuthorInfoService {

    boolean addNewAuthor(AuthorInfo newAuthor);

    boolean updateAuthor(AuthorInfo newAuthor);

    boolean deleteAuthor(AuthorInfo newAuthor);

    List<AuthorInfo> findAuthor(String name, String lastName);

    List<BookInfo> findBookByTheAuthor(String name, String lastName);

}
