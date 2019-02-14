package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.model.BookInfo;
import com.library.service.BookInfoService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DefaultBookInfoServiceTest {

    BookInfoService bookInfoService;

    @BeforeMethod
    public void setUp() {
        bookInfoService = new DefaultBookInfoService();
    }

    @Test
    public void testAddNewBookCopy() {
        boolean addedBookToDB = bookInfoService.addNewBookInfo(new BookInfo(null,"Ogniem i Mieczem","Test description",
                new AuthorInfo(null,"Henryk", "Sienkiewicz",null), null));

        Assert.assertTrue(addedBookToDB);
    }

    @Test
    public void testUpdateBookInfo() {
    }

    @Test
    public void testFindBookByTitle() {

//        List<BookInfo> foundBook = bookInfoService.findBookByTheAuthor();
    }

    @Test
    public void testFindBookByISBN() {
    }

    @Test
    public void testFindBookByTheAuthor() {
    }
}