package bookstore.Model;

import bookstore.Service.Emailable;
import bookstore.Service.Salable;

public class EBook extends Book implements Salable, Emailable
{
    private int quantity;
    private String fileType;

    public EBook(String isbn, String title, int publishYear, double price, String author, String fileType)
    {
        super(isbn, title, publishYear, price, author);
        this.fileType = fileType;
        this.quantity =1;
    }

    public String getFileType() {return fileType;}
    public void setFileType(String fileType) {this.fileType = fileType;}

        @Override
        public String getEmailContent()
        {
            return "Download your eBook \"" + getTitle() + "\" in format: " + fileType;
        }

        @Override
        public int getQuantity() {return quantity;}

        @Override
        public void setQuantity(int quantity) {this.quantity = quantity;}
    }
