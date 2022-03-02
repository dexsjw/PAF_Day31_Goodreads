package ibf2021.paf.day31.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Book {
    private String bookId;
    private String title;
    private String authors;
    private String description;
    private String edition;
    private String format;
    private int pages;
    private float rating;
    private int ratingCount;
    private int reviewCount;
    private String genres;
    private String imageUrl;

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("bookId", bookId)
            .add("title", title)
            .add("authors", authors)
            .add("description", description)
            .add("edition", edition)
            .add("format", format)
            .add("pages", pages)
            .add("rating", rating)
            .add("ratingCount", ratingCount)
            .add("reviewCount", reviewCount)
            .add("genres", genres)
            .add("imageUrl", imageUrl)
            .build();
    }

    public static Book populate(SqlRowSet rs) {
        final Book book = new Book();
        book.setBookId(rs.getString("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthors(rs.getString("authors"));
        book.setDescription(rs.getString("description"));
        book.setEdition(rs.getString("edition"));
        book.setFormat(rs.getString("format"));
        book.setPages(rs.getInt("pages"));
        book.setRating(rs.getFloat("rating"));
        book.setRatingCount(rs.getInt("rating_count"));
        book.setReviewCount(rs.getInt("review_count"));
        book.setGenres(rs.getString("genres"));
        book.setImageUrl(rs.getString("image_url"));
        return book;
    }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public int getRatingCount() { return ratingCount; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }

    public int getReviewCount() { return reviewCount; }
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount; }

    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
