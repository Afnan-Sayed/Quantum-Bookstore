package bookstore.Service;


public class MailService
{
    public static void send(Emailable book, String email)
    {
        System.out.println("The book is sent to " +  email);
    }
}
