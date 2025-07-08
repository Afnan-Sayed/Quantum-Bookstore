package bookstore.Service;

import bookstore.Model.Book;

public class BuyService
{

    public double buyBook(String isbn, int quantity, String email, String address, InventoryService inventory)
            throws Exception
    {
        Book book = inventory.getBook(isbn);
        if (book ==null) throw new Exception("Book not found");

        if (!(book instanceof Salable))
        {
            throw new Exception("Book is not available for sale");
        }

        Salable salable = (Salable) book;
        int availableQty = salable.getQuantity();
        if (availableQty < quantity)
        {
            throw new Exception("Not enough quantity available");
        }

        //reduce quantity
        salable.setQuantity(availableQty-quantity);
        double totalPrice = book.getPrice() * quantity;

        //handle shipping
        if (book instanceof Shippable)
        {
            ShippingService.send((Shippable) book, address);
        }

        //handle emailing
        if (book instanceof Emailable)
        {
            MailService.send((Emailable) book, email);
        }

        System.out.println(quantity + "x \"" + book.getTitle() + "\" purchased.");
        return totalPrice;
    }
}

