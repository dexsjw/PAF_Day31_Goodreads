package ibf2021.paf.day31.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.paf.day31.Day31Application;
import ibf2021.paf.day31.model.Book;
import ibf2021.paf.day31.repository.GoodreadRepo;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping(path="/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodreadController {

    Logger logger = Logger.getLogger(Day31Application.class.toString());

    @Autowired
    private GoodreadRepo grr;

    @GetMapping
    public ResponseEntity<String> getAllbooks(
        @RequestParam(defaultValue="10") int limit,
        @RequestParam(defaultValue="0") int offset) {

        logger.info(">>>>>>limit: %d, offset: %d".formatted(limit, offset));
        List<Book> result = grr.getAllBooks(limit, offset);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        result.stream().forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping(path="/format")
    public ResponseEntity<String> getBookFormat() {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        grr.getBookFormat().stream().forEach(arrBuilder::add);
        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    // GET /api/books/count/<format>
    // { <format>: <count> }
    // GET /api/books/count/ebook -> { "ebook": 20 }

    @GetMapping(path="/count/{format}")
    public ResponseEntity<String> getBookFormatCount(@PathVariable(required=true) String format) {
        final int formatCount = grr.getBookFormatCount(format);
        JsonObjectBuilder objBuilder = Json.createObjectBuilder();
        objBuilder.add(format, formatCount);
        return ResponseEntity.ok(objBuilder.build().toString());
    }
    
}
