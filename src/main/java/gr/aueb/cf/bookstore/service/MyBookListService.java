package gr.aueb.cf.bookstore.service;

import gr.aueb.cf.bookstore.entity.MyBookList;
import gr.aueb.cf.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBook;
    public void saveMyBooks(MyBookList book) {
        myBook.save(book);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBook.findAll();
    }

    public void deleteById(int id) {
        myBook.deleteById(id);
    }
}
