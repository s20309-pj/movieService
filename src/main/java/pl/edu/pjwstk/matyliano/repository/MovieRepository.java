package pl.edu.pjwstk.matyliano.repository;

import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.matyliano.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
