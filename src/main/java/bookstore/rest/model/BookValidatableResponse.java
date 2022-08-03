package bookstore.rest.model;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import java.awt.print.Book;

public class BookValidatableResponse {

    private BookResponse model;
    private Response response;


    public BookValidatableResponse(Response response) {
        this.response = response;
        model = response.as(BookResponse.class);
    }

    public BookValidatableResponse checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);

        return this;
    }

    public BookValidatableResponse checkIdNotNull() {
        response.then().body("id", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkLastUpdated() {
        response.then().body("lastUpdated", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkBook(Book expected) {
        Assert.assertEquals(new bookstore.rest.model.Book(model), expected);

        return this;
    }

    public BookValidatableResponse checkId(Integer id) {
        response.then().body("id", Matchers.equalTo(id));

        return this;
    }

    public Integer getId() {
        return response.jsonPath().getInt("id");
    }


}
