package pl.edu.pjwstk.matyliano.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pjwstk.matyliano.enums.Category;
import pl.edu.pjwstk.matyliano.model.Movie;

import static pl.edu.pjwstk.matyliano.cons.EntityNotFound.NOT_FOUND;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie(1L, "Going Postal", Category.FANTASY));
        movies.add(new Movie(2L, "John Wick", Category.THRILLER));
        movies.add(new Movie(3L, "Requiem for a Dream", Category.DRAMA));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst();
        if (movie.isPresent()) {
            return movie;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, NOT_FOUND
        );
    }

    public Optional<Movie> updateMovie(Long id, Movie movie) {
        Optional<Movie> result = movies.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (result.isPresent()) {
            result.get().setCategory(movie.getCategory());
            result.get().setTitle(movie.getTitle());
            return result;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, NOT_FOUND
        );
    }

    public void deleteMovieById(Long id) {
        if (!movies.removeIf(movie -> movie.getId().equals(id))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, NOT_FOUND
            );
        }
    }

}
