package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DefaultAuthorInfoServiceTest {

    AuthorInfoService authorInfoService;
    Session session;

    @BeforeMethod
    public void setUp() {
        authorInfoService = new DefaultAuthorInfoService();
    }

    @Test
    public void testAddNewAuthor() {
        boolean newRecord = authorInfoService.addNewAuthor(setDefaultAuthor());

        Assert.assertEquals(newRecord, true);
    }

    @Test
    public void testUpdateAuthor() {
        boolean oldRecord = authorInfoService.addNewAuthor(setDefaultAuthor());

        boolean updated = authorInfoService.updateAuthor(new AuthorInfo((long) 1, "Andrzej", "Sapkowski", null));

        Assert.assertTrue(oldRecord);
        Assert.assertTrue(updated);
    }

    @Test
    public void testDeleteAuthor() {
        boolean oldRecord = authorInfoService.addNewAuthor(setDefaultAuthor());
        boolean newRecord = authorInfoService.addNewAuthor(new AuthorInfo((long) 1, "Andrzej", "Sapkowski", null));

        boolean deleted = authorInfoService.deleteAuthor(authorInfoService.findAuthor(new AuthorInfo((long) 1, "Henryk", "Sienkiewicz", null)));

        Assert.assertTrue(oldRecord);
        Assert.assertTrue(newRecord);
        Assert.assertTrue(deleted);
    }

    @Test
    public void testFindAuthor() {
        boolean newRecord = authorInfoService.addNewAuthor(setDefaultAuthor());

        AuthorInfo result = authorInfoService.findAuthor(new AuthorInfo((long) 1, "Henryk", "Sienkiewicz", null));

        Assert.assertTrue(newRecord);
        Assert.assertNotNull(result);
    }

    private AuthorInfo setDefaultAuthor() {
        AuthorInfo newAuthor = new AuthorInfo();
        newAuthor.setName("Henryk");
        newAuthor.setLastName("Sienkiewicz");
        return newAuthor;
    }

}