package create;

import bookstore.rest.client.TestClient;
import bookstore.rest.enums.Category;
import bookstore.rest.model.Book;
import bookstore.rest.model.BookValidatableResponse;
import bookstore.testBase.BookStoreTestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "createBooks")
    public void testCreateBook(Book book) {

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

    @DataProvider
    public Object[][] createBooks() {
        return new Object[][] {
            {Book.defaultOf()},
            {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
            {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},
            {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
            {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},
            {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
            {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},
            {Book.defaultOf().setPrice(0)},
            {Book.defaultOf().setCount(0)},
            {Book.defaultOf().setCategory(Category.Detective)},
            {Book.defaultOf().setCategory(Category.Horror)},
            {Book.defaultOf().setCategory(Category.Thriller)},

        };
    }


}
