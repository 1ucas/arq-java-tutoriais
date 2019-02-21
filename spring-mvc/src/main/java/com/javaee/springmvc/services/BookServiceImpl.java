package com.javaee.springmvc.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.javaee.springmvc.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	private Set<Book> booksSaved = new HashSet<>();
	private Long actualId = 0L;

	@Override
    public Set<Book> getBooks() {
        return booksSaved;
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = booksSaved.stream().filter(book -> book.getId().equals(id)).findFirst();
        return bookOptional.orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
    	if(book.getId() != null) {
    		this.deleteById(book.getId());
    	} else {
    		actualId++;
    		book.setId(actualId);
    	}
    	this.booksSaved.add(book);
        return book;
    }

    @Override
    public void deleteById(Long idToDelete) {
    	this.booksSaved.removeIf(book -> book.getId().equals(idToDelete));
    }
}
