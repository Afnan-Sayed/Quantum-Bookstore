package bookstore.Service;

public class ShippingService
{
    public static void send(Shippable book, String address)
    {
        System.out.println("The book is shipped to " +  address);
    }
}
