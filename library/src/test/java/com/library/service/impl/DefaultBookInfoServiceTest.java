package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.model.BookInfo;
import com.library.service.AuthorInfoService;
import com.library.service.BookInfoService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DefaultBookInfoServiceTest {

    BookInfoService bookInfoService;

    @BeforeMethod
    public void setUp() {
        bookInfoService = new DefaultBookInfoService();
    }

    @Test
    public void testAddNewBookCopy() {
        boolean addedBookToDB = bookInfoService.addNewBookInfo(new BookInfo(null,"Ogniem i Mieczem","Test description",
               null, null));

        Assert.assertTrue(addedBookToDB);
    }

    @Test
    public void testUpdateBookInfo() {
        BookInfo bookToUpdate = new BookInfo(null,"Ogniem i Mieczem","Test description",
                null, null);

        boolean addedBookToDB = bookInfoService.addNewBookInfo(bookToUpdate);

        AuthorInfo author = new AuthorInfo(null,"Henryk","Sienkiewicz",null);
        AuthorInfoService ais = new DefaultAuthorInfoService();
        boolean addNewAuthor = ais.addNewAuthor(author);
//        bookToUpdate.setDescription(null);
        bookToUpdate.setAuthor(author);

        boolean updateBookInfoService = bookInfoService.updateBookInfo(bookToUpdate);

        BookInfo updatedBook = bookInfoService.findBookInfo(bookToUpdate.getTitle());

        Assert.assertTrue(addedBookToDB);
        Assert.assertTrue(addNewAuthor);
        Assert.assertTrue(updateBookInfoService);
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