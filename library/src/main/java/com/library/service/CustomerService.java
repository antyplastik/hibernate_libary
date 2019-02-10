package com.library.service;

import com.library.model.Customer;
import org.hibernate.Session;

public interface CustomerService {

    boolean addNewUser(Session session, Customer newUser);

    boolean updateUser(Session session, Customer customer);

    boolean deleteUser(Session session, Customer customer);

    Customer findUser(Session session, Customer user);
}
