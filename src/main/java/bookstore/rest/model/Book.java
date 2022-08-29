package bookstore.rest.model;
import bookstore.rest.enums.Category;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book extends java.awt.print.Book {

    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;
    private Category category;

    public Book(Book book) {
        this.title = book.title;
        this.description = book.description;
        this.author = book.author;
        this.price = book.price;
        this.count = book.count;
        this.category = book.category;
    }

    public static Book defaultOf() {
        return new Book("The Adventures of Tom Sawyer",
            "The story about Tom Sawyer.",
            "Mark Twain", 350, 10, Category.Adventures);
    }
}
