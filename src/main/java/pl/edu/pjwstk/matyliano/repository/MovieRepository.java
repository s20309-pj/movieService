package pl.edu.pjwstk.matyliano.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.matyliano.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();

    Movie save(Movie movie);

    Optional<Movie> findById(Long aLong);

    void deleteById(Long id);
}
