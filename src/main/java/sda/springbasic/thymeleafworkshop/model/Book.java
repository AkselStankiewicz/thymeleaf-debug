package sda.springbasic.thymeleafworkshop.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotEmpty(message = "Pole nie może być puste")
    private String title;
    @NotEmpty(message = "Pole nie może być puste")
    private String author;
}
