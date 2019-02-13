package com.library.service.impl;

import com.library.model.Customer;
import com.library.service.CustomerService;
import org.hibernate.Session;

public class DefaultCustomerService implements CustomerService {

    @Override
    public boolean addNewUser(Customer newUser) {
        return false;
    }

    @Override
    public boolean updateUser(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteUser(Customer customer) {
        return false;
    }

    @Override
    public Customer findUser(Customer user) {
        return null;
    }
}
