package bookstore.rest.model;

import lombok.*;

import java.time.OffsetDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class BookResponse extends Book {

    private Integer Id;
    private OffsetDateTime lastUpdated;

}
