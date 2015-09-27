package com.oresteluci.cassandra.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreste Luci
 */
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(
            value = "/",
            method= RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void add(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @RequestMapping(
            value = "/",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Book> getAll() {

        Iterable<Book> books = bookRepository.findAll();
        List<Book> response = new ArrayList<Book>();

        for (Book book : books) {
            response.add(book);
        }

        return response;
    }

    @RequestMapping(
            value = "/{isbn}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void delete(@PathVariable String isbn) {
        bookRepository.delete(isbn);
    }

    @RequestMapping(
            value = "/{isbn}",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Book get(@PathVariable String isbn) {
        return bookRepository.findOne(isbn);
    }

}
