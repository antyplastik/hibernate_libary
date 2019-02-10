package com.library.service.impl;

import com.library.model.Customer;
import com.library.service.CustomerService;
import org.hibernate.Session;

public class DefaultCustomerService implements CustomerService {
    @Override
    public boolean addNewUser(Session session, Customer newUser) {
        return false;
    }

    @Override
    public boolean updateUser(Session session, Customer customer) {
        return false;
    }

    @Override
    public boolean deleteUser(Session session, Customer customer) {
        return false;
    }

    @Override
    public Customer findUser(Session session, Customer user) {
        return null;
    }
}
