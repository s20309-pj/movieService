package pl.edu.pjwstk.matyliano.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pjwstk.matyliano.enums.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    private Long id;
    private String title;
    private Category category;
}
