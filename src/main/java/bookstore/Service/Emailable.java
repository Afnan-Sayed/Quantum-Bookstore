package bookstore.Service;

/*
this class represents an interface for all book products that may be sent via email
like EBook or any other future products
*/

public interface Emailable
{
    String getEmailContent();
}

