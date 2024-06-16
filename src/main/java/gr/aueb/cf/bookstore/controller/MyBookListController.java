package gr.aueb.cf.bookstore.controller;

import gr.aueb.cf.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService service;

    @RequestMapping("deleteMylist/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/my_books";
    }
}
