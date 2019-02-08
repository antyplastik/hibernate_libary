package library.service;

import library.model.BookInfo;
import library.model.Customer;
import org.hibernate.Session;

import java.math.BigDecimal;

public interface RentService {

    boolean rentBookCopy(Session session, Customer customer, BookInfo book);

    BigDecimal returnBookCopy(Session session, Customer customer, BookInfo bookInfo);

}
