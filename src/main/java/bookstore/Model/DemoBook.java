package bookstore.Model;

public class DemoBook extends Book
{
    public DemoBook(String isbn, String title, int publishYear, String author)
    {
        super(isbn, title, publishYear, 0.0, author); //demo books not for sale so i set price to 0.0
    }
}