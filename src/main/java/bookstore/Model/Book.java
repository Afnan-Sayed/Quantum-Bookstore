package bookstore.Model;


public abstract class Book
{
    protected String ISBN;
    protected String title;
    protected int publishYear;
    protected double price;
    protected String author;

    public Book(String isbn, String title, int publishYear, double price, String author) {
        this.ISBN = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { return ISBN; }
    public String getTitle() { return title; }
    public int getPublishYear() { return publishYear; }
    public double getPrice() { return price; }
    public String getAuthor() { return author; }

    public void setPrice(double price) { this.price = price; }
    public void setISBN(String ISBN) {this.ISBN =ISBN;}
    public void setTitle(String title) {this.title=title;}
    public void setPublishYear(int publishYear) {this.publishYear = publishYear;}
    public void setAuthor(String author) {this.author = author;}
}