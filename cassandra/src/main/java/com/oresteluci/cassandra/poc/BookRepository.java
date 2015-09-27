package com.oresteluci.cassandra.poc;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Oreste Luci
 */
public interface BookRepository extends CrudRepository<Book, String> {

    @Query("SELECT * FROM book WHERE author=?0")
    public Book findByAuthor(String author);


}
