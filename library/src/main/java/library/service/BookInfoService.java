package library.service;

import library.model.BookInfo;
import org.hibernate.Session;

public interface BookInfoService {

    boolean addNewBookToTheLibrary(Session session, BookInfo book);

    boolean updateBookInfo(Session session, BookInfo ... book);

    BookInfo findBookByTitle(Session session, String title);

    BookInfo findBookByTheAuthor(Session session, String name, String lastName);
}
