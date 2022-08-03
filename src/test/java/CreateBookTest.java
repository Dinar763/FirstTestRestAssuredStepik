import bookstore.rest.client.TestClient;
import bookstore.rest.enums.Category;
import bookstore.rest.model.Book;
import bookstore.rest.model.BookValidatableResponse;
import org.testng.annotations.Test;

public class CreateBookTest {

    @Test
    public void testCreateBook() {

        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);

        TestClient testClient = new TestClient();

        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);

        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);
    }


}
