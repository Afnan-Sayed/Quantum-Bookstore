import bookstore.Model.Book;
import bookstore.Model.DemoBook;
import bookstore.Model.EBook;
import bookstore.Model.PaperBook;
import bookstore.Service.BuyService;
import bookstore.Service.InventoryService;
import bookstore.Service.Salable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTests
{

    InventoryService inventory;
    BuyService buyService;

    @BeforeEach
    public void setup()
    {
        inventory = new InventoryService();
        buyService = new BuyService();
    }

    @Test
    public void testAddBook()
    {
        Book book = new PaperBook("123", "Book1", 2004, 300, "Afnan", 10);
        inventory.addBook(book);
        assertTrue(inventory.exists("123"));
        assertEquals("Book1", inventory.getBook("123").getTitle());
    }

    @Test
    public void testRemoveOutdatedBooks()
    {
        Book oldBook = new PaperBook("111", "Book2", 2000, 200, "Hamza", 5);
        Book newBook = new EBook("222", "Book3", 2021, 150, "Sayed", "PDF");

        inventory.addBook(oldBook);
        inventory.addBook(newBook);
        List<Book> removed = inventory.removeOutdatedBooks(15);

        assertEquals(1, removed.size());
        assertEquals("Book2", removed.get(0).getTitle());
        assertFalse(inventory.exists("111"));
    }

    @Test
    public void testBuyPaperBookSuccess() throws Exception
    {
        Book paperBook = new PaperBook("301", "Book4", 2010, 250, "Mahmoud", 5);
        inventory.addBook(paperBook);

        double total = buyService.buyBook("301", 2, "mahmoud@gmail.com", "giza, Egypt", inventory);

        assertEquals(500, total);
        assertEquals(3, ((Salable) paperBook).getQuantity());
    }

    @Test
    public void testBuyEBookSuccess() throws Exception
    {
        Book ebook = new EBook("302", "Book5", 2020, 180, "afnan", "word");
        inventory.addBook(ebook);

        double total = buyService.buyBook("302", 1, "afnan@gmail.com", "", inventory);

        assertEquals(180, total);
        assertEquals(0, ((Salable) ebook).getQuantity());
    }

    @Test
    public void testBuyDemoBookThrowsException() //demo books are not salable
    {
        Book demoBook = new DemoBook("404", "Book6", 2022, "afnan");

        inventory.addBook(demoBook);

        Exception exception = assertThrows(Exception.class, () ->buyService.buyBook
                ("404", 1, "afnan@gmail.com", "", inventory)
        );
        assertEquals("Book is not available for sale", exception.getMessage());
    }

    @Test
    public void testBuyBookWithInsufficientStock()
    {
        Book paperBook = new PaperBook("500", "Book7", 2025, 100, "sayed", 1);
        inventory.addBook(paperBook);

        Exception exception = assertThrows(Exception.class, () ->buyService.buyBook
                ("500", 3, "sayed@gmail.com", "cairo", inventory)
        );
        assertEquals("Not enough quantity available", exception.getMessage());
    }
}