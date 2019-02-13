package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.transaction.Transactional;
import java.util.List;


public class DefaultAuthorInfoServiceTest {

    AuthorInfoService authorInfoService;
    Session session;

    @BeforeMethod
    public void setUp() {
        authorInfoService = new DefaultAuthorInfoService();
        try(Session session = SessionUtil.getSession()){
            session.createSQLQuery("TRUNCATE TABLE author");
        }
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

//    @Ignore
    @Test
    public void testDeleteAuthor() {
        boolean oldRecord = authorInfoService.addNewAuthor(setDefaultAuthor());
        boolean newRecord = authorInfoService.addNewAuthor(new AuthorInfo(null, "Andrzej", "Sapkowski", null));

        boolean deleted = false;

        List<AuthorInfo> listOfAuthor = authorInfoService.findAuthor("Henryk", "Sienkiewicz");
        if (listOfAuthor.size() == 1)
            deleted = authorInfoService.deleteAuthor(listOfAuthor.get(0));

        Assert.assertTrue(oldRecord);
        Assert.assertTrue(newRecord);
        Assert.assertTrue(deleted);
    }

    @Test
    public void testFindAuthor() {
        AuthorInfo result = null;
        boolean newRecord = authorInfoService.addNewAuthor(setDefaultAuthor());

        List<AuthorInfo> authorInfoList = authorInfoService.findAuthor("Henryk", "Sienkiewicz");
        if (authorInfoList.size() == 1)
            result = authorInfoList.get(0);

        Assert.assertTrue(newRecord);
        Assert.assertNotNull(result);
    }

    private AuthorInfo setDefaultAuthor() {
        AuthorInfo newAuthor = new AuthorInfo();
//        newAuthor.setId((long)1);
        newAuthor.setName("Henryk");
        newAuthor.setLastName("Sienkiewicz");
        return newAuthor;
    }

}