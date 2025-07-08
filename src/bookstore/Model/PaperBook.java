package bookstore.Model;


public class PaperBook extends Book
{
    private int stock;

    public PaperBook(String isbn, String title, int publishYear, double price, String author, int stock)
    {
        super(isbn, title, publishYear, price, author);
        this.stock = stock;
    }

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
}