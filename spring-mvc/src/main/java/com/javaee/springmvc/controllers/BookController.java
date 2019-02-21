package com.javaee.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee.springmvc.domain.Book;
import com.javaee.springmvc.services.BookService;

@Controller
@RequestMapping(BookController.BASE_URL)
public class BookController {

	public static final String BASE_URL = "/book";

	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findById(id));

        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());

        return "book/bookform";
    }

    @GetMapping("/{id}/update")
    public String updateBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        
        return  "book/bookform";
    }

    @PostMapping("/")
    public String saveOrUpdate(@ModelAttribute Book book){
        Book savedBook = bookService.saveBook(book);

        return "redirect:/book/" + savedBook.getId();
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable String id){
        bookService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
