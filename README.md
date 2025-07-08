# 📚 Quantum Bookstore

Quantum Bookstore is a Java-based application for managing and selling various types of books, including paper books, eBooks, and demo versions. It simulates core bookstore functionalities like inventory control, book purchases, email delivery, and shipping.
The system is designed to be easily extensible, so that we don’t need to modify it if we’ve added a new type of products
---

## Features

- Add, retrieve, and remove books from inventory
- Search for books using ISBN
- Remove outdated books by publish year
- Buy paper books and eBooks
- Email delivery of eBooks
- Shipping support for paper books
- Prevent purchase of demo (non-salable) books

---

## Technologies Used

- **Java 17**
- **Maven**
- **JUnit 5** for unit testing

---

## 📂 Project Structure

Quantum-Bookstore/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── bookstore/
│ │ ├── Model/ # Book types (PaperBook, EBook, DemoBook)
│ │ └── Service/ # Services (BuyService, InventoryService, etc.)
│ └── test/
│ └── java/
│ └── BookStoreTests.java # JUnit tests
└── README.md

---

## Book Types

### PaperBook
- Implements `Salable` and `Shippable`
- Has quantity and can be shipped

### EBook
- Implements `Salable` and `Emailable`
- Delivered via email in formats like PDF/Word

### DemoBook
- Free demo version
- Not salable, not shippable

---

## Unit Tests (JUnit 5)

Tests included in `BookStoreTests.java`:
- `testAddBook()` - Add and verify book exists
- `testRemoveOutdatedBooks()` - Remove old books
- `testBuyPaperBookSuccess()` - Buy paper book with quantity check
- `testBuyEBookSuccess()` - Buy and email an eBook
- `testBuyDemoBookThrowsException()` - Buying demo book throws exception
- `testBuyBookWithInsufficientStock()` - Handle out-of-stock scenario

Run tests using:
```
mvn test
```
How to Run
Clone the repo:
```
git clone https://github.com/Afnan-Sayed/Quantum-Bookstore.git
cd Quantum-Bookstore
```
Compile and test:
```
mvn clean install
```
