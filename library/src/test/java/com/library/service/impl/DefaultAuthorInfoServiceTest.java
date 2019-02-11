package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.Assert.*;

import javax.validation.constraints.AssertTrue;

public class DefaultAuthorInfoServiceTest {

    AuthorInfoService authorInfoService;
    Session session;

    @BeforeMethod
    public void setUp() {
        authorInfoService = new DefaultAuthorInfoService();
    }

    @Test
    public void testAddNewAuthor() {
        boolean newRecord = authorInfoService.addNewAuthor(session = SessionUtil.getSession(), setDefaultAuthor());

        Assert.assertEquals(newRecord, true);
    }

    @Test
    public void testUpdateAuthor() {
        boolean oldRecord = authorInfoService.addNewAuthor(session = SessionUtil.getSession(), setDefaultAuthor());

        boolean updated = authorInfoService.updateAuthor(session = SessionUtil.getSession(), new AuthorInfo((long) 1, "Andrzej", "Sapkowski", null));

        Assert.assertTrue(oldRecord);
        Assert.assertTrue(updated);
    }

    @Test
    public void testDeleteAuthor() {
        boolean oldRecord = authorInfoService.addNewAuthor(session = SessionUtil.getSession(), setDefaultAuthor());
        boolean newRecord = authorInfoService.addNewAuthor(session, new AuthorInfo((long) 1, "Andrzej", "Sapkowski", null));

        boolean deleted = authorInfoService.deleteAuthor(session = SessionUtil.getSession(), authorInfoService.findAuthor(session, new AuthorInfo((long) 1, "Henryk", "Sienkiewicz", null)));

        Assert.assertTrue(oldRecord);
        Assert.assertTrue(newRecord);
        Assert.assertTrue(deleted);

    }

    @Test
    public void testFindAuthor() {
        boolean newRecord = authorInfoService.addNewAuthor(session = SessionUtil.getSession(), setDefaultAuthor());

        AuthorInfo result = authorInfoService.findAuthor(session, new AuthorInfo((long) 1, "Henryk", "Sienkiewicz", null));

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