package com.library.service.impl;

import com.library.model.BookInfo;
import com.library.model.Customer;
import com.library.service.RentService;
import org.hibernate.Session;

import java.math.BigDecimal;

public class DefaultRentService implements RentService {
    @Override
    public boolean rentBookCopy(Session session, Customer customer, BookInfo book) {
        return false;
    }

    @Override
    public BigDecimal returnBookCopy(Session session, Customer customer, BookInfo bookInfo) {
        return null;
    }
}
