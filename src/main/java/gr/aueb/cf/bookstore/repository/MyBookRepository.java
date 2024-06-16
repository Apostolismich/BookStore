package gr.aueb.cf.bookstore.repository;

import gr.aueb.cf.bookstore.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
