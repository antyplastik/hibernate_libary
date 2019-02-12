package com.library.service;

import com.library.model.Customer;
import org.hibernate.Session;

public interface CustomerService {

    boolean addNewUser(Customer newUser);

    boolean updateUser(Customer customer);

    boolean deleteUser(Customer customer);

    Customer findUser(Customer user);
}
