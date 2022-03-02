package ibf2021.paf.day31.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2021.paf.day31.model.Book;
import static ibf2021.paf.day31.repository.SQL.*;

@Repository
public class GoodreadRepo {
    
    @Autowired
    private JdbcTemplate template;

    // not used in this practice
    public List<Book> getAllBooks() {
        
        final List<Book> books = new LinkedList<>();
        
        // Return all books
        final SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_BOOKS);
        // Loop through row set
        while (rs.next()) {
            // Process a row
            final Book book = Book.populate(rs);
            books.add(book);
        }
        return books;
    }

    // not used in this practice
    public List<Book> getAllBooks(int limit) {
        return getAllBooks(limit, 0);
    }

    public List<Book> getAllBooks(int limit, int offset) {
        
        final List<Book> books = new LinkedList<>();
        
        final SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_BOOKS_LIMIT_OFFSET, limit, offset);
        while (rs.next()) {
            final Book book = Book.populate(rs);
            books.add(book);
        }
        return books;
    }
    
    // not used in this practice
    public List<Book> getBooksByTitle(String phrase) {

        final List<Book> books = new LinkedList<>();

        final String search = "%" + phrase + "%";
        final SqlRowSet rs = template.queryForRowSet(
            SQL_GET_BOOK_BY_TITLE, // prepared statement
            search // parameters
        );
        while (rs.next()) {
            final Book book = Book.populate(rs);
            books.add(book);
        }
        return books;
    }

    public List<String> getBookFormat() {
        final List<String> formats = new LinkedList<>();
        final SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOK_FORMAT);
        while(rs.next()) {
            formats.add(rs.getString("format").toLowerCase());
        }
        return formats;
    }

    public int getBookFormatCount(String format) {
        final SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOK_FORMAT_COUNT, format);
        final int formatCount = rs.getInt("format_count");
        return formatCount;
    }
}
