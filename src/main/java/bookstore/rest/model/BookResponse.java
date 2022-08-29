package bookstore.rest.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class BookResponse extends Book {

    private Integer Id;
    private OffsetDateTime lastUpdated;

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

    public static BookResponse createError400() {
        return new BookResponse().setStatus(400)
            .setError("Bad Request")
            .setPath("/rest-api/books");
    }

}
