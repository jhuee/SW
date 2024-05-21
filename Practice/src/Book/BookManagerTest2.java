package Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest2 {
    private BookManager bookManager;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        book1 = new Book("1", "Java Basics", "John Doe", 2020);
        book2 = new Book("2", "Advanced Java", "Jane Smith", 2021);
        book3 = new Book("3", "Java Patterns", "Robert Martin", 2019);
    }

    @Test
    public void testAddBook() {
        assertTrue(bookManager.addBook(book1));
        assertFalse(bookManager.addBook(book1)); // Duplicate ID

        List<Book> books = bookManager.searchBook("Java Basics");
        assertEquals(1, books.size());
        assertEquals(book1, books.get(0));
    }

    @Test
    public void testSearchBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        List<Book> books = bookManager.searchBook("Java");
        assertEquals(3, books.size());

        books = bookManager.searchBook("Advanced");
        assertEquals(1, books.size());
        assertEquals(book2, books.get(0));

        books = bookManager.searchBook("Python");
        assertTrue(books.isEmpty());
    }

    @Test
    public void testRemoveBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);

        assertTrue(bookManager.removeBook("1"));
        assertFalse(bookManager.removeBook("1")); // Already removed

        List<Book> books = bookManager.searchBook("Java Basics");
        assertTrue(books.isEmpty());
    }
}
