package bookstore.Model;


import bookstore.Service.Salable;
import bookstore.Service.Shippable;

public class PaperBook extends Book implements Salable, Shippable
{
    private int stock;
    private int quantity;


    public PaperBook(String isbn, String title, int publishYear, double price, String author, int quantity)
    {
        super(isbn, title, publishYear, price, author);
        this.quantity = quantity; 
    }


    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    @Override
    public int getQuantity() {return quantity;}

    @Override
    public void setQuantity(int quantity) {this.quantity = quantity;}


    @Override
    public String getShippingLabel()
    {
        return "shipping PaperBook: " + getTitle() + " by " + getAuthor();
    }
}