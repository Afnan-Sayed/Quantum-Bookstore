package bookstore.Service;

import bookstore.Model.Book;

import java.time.Year;
import java.util.*;

public class InventoryService
{
    private final Map<String,Book> inventory = new HashMap<>();

    //add book
    public void addBook(Book book)
    {
        inventory.put(book.getIsbn(), book); //we need a unique key in the map, so i assumed isbn is pk
        System.out.println("Book " + book.getTitle() + " added successfully");
    }

    //get book by its isbn
    public Book getBook(String isbn)
    {
        return inventory.get(isbn);
    }


    //remove book by its isbn
    public void removeBook(String isbn)
    {
        inventory.remove(isbn);
        System.out.println( "Book with ISBN: " + isbn + " removed" );
    }

    //remove outdated books by entering a specific number of years
    public List<Book> removeOutdatedBooks(int years)
    {
        List<Book> outdated = new ArrayList<>();
        int currentYear = Year.now().getValue();

        for (Book book: new ArrayList<>(inventory.values()))
        {
            if ((currentYear-book.getPublishYear()) >years)
            {
                outdated.add(book);
                inventory.remove(book.getIsbn());
            }
        }
        return outdated;
    }


    //if book exits search by isbn
    public boolean exists(String isbn)
    {
        return inventory.containsKey(isbn);}


    //get all books in the inventory now
    public Collection<Book> getAllBooks()
    {
        return inventory.values();
    }
}