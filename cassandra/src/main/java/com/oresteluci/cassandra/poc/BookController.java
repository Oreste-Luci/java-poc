package com.oresteluci.cassandra.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            value = "/add",
            method= RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @RequestMapping(
            value = "/books",
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
}
