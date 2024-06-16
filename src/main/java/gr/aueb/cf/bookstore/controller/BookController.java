package gr.aueb.cf.bookstore.controller;

import gr.aueb.cf.bookstore.entity.Book;
import gr.aueb.cf.bookstore.entity.MyBookList;
import gr.aueb.cf.bookstore.service.BookService;
import gr.aueb.cf.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "book_register";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book>bookList=service.getAllBook();

        return new ModelAndView("bookList","bookList",bookList);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b, Model model) {
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
       List<MyBookList>list=myBookListService.getAllMyBooks();
       model.addAttribute("book",list);
        return "my_books";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBooks(mb); // den eimai sigouros
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book  b= service.getBookById(id);
        model.addAttribute("book",b);
        return "editBook";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")  int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }
}
