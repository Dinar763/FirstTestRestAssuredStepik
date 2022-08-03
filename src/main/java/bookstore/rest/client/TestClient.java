package bookstore.rest.client;
import bookstore.props.TestConfig;
import bookstore.rest.model.BookValidatableResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import java.awt.print.Book;
import static io.restassured.RestAssured.given;


@AllArgsConstructor
public class TestClient {

    private String baseUri;
    private String basePath;

    public TestClient() {
        this(TestConfig.Uri.value, TestConfig.Path.value);
    }

    public RequestSpecification getRequestSpec() {
        return given().baseUri(baseUri).
                basePath(basePath).
                contentType(ContentType.JSON).
                log().all();
    }

    public RequestSpecification getRequestSpec(Object book) {
        return getRequestSpec().
                body(book);
    }


    public BookValidatableResponse create(Book book) {
        Response response = getRequestSpec(book).when().
                post("/books");

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse read(Integer id) {
        Response response = getRequestSpec().when().
                get("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }
}
