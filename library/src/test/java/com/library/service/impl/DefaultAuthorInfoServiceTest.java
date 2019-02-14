package com.library.service.impl;

import com.library.model.AuthorInfo;
import com.library.service.AuthorInfoService;
import com.library.util.SessionUtil;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


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
        boolean oldRecordUpdate = authorInfoService.updateAuthor(setDefaultAuthor());

        boolean updated;
        try {
            updated = authorInfoService.updateAuthor(new AuthorInfo((long) 1, "Andrzej", "Sapkowski", null));
        } catch (IllegalArgumentException e){
            updated = false;
        }

        Assert.assertTrue(oldRecord, "[ERROR] Problems with add to db");
        Assert.assertTrue(oldRecordUpdate, "[ERROR] Can't update old author");
        Assert.assertFalse(updated, "[ERROR] Can't update new author");
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