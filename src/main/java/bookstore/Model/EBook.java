package bookstore.Model;

public class EBook extends Book
{
    private String fileType;

    public EBook(String isbn, String title, int publishYear, double price, String author, String fileType)
    {
        super(isbn, title, publishYear, price, author);
        this.fileType = fileType;
    }

    public String getFileType() {return fileType;}
    public void setFileType(String fileType) {this.fileType = fileType;}
}
