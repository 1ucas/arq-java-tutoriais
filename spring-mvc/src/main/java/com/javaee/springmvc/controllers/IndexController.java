package com.javaee.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee.springmvc.services.BookService;

@Controller
public class IndexController {

	private final BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.getBooks());

        return "index";
    }
}
