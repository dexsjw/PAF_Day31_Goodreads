package ibf2021.paf.day31.repository;

public class SQL {

    public static final String SQL_GET_ALL_BOOKS = "select * from book2018";
    public static final String SQL_GET_ALL_BOOKS_LIMIT_OFFSET = "select * from book2018 limit ? offset ?";
    public static final String SQL_GET_BOOK_BY_TITLE = "select * book2018 where title like ?";
    public static final String SQL_GET_BOOK_FORMAT = "select distinct(format) from book2018 where format not like ''";
    public static final String SQL_GET_BOOK_FORMAT_COUNT = "select count(*) as format_count from book2018 where format=?";
    
}
