package pl.edu.pjwstk.matyliano.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pjwstk.matyliano.exception.ResourceNotFoundException;
import pl.edu.pjwstk.matyliano.model.Movie;
import pl.edu.pjwstk.matyliano.repository.MovieRepository;

import static pl.edu.pjwstk.matyliano.cons.EntityNotFound.NOT_FOUND;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Movie updateMovie(Long id, Movie movie) {
        var movieToUpdate = getMovieById(id);
        if (movie.getTitle() != null) {
            movieToUpdate.setTitle((movie.getTitle()));
        }
        if (movie.getCategory() != null) {
            movieToUpdate.setCategory(movie.getCategory());
        }

        return addMovie(movieToUpdate);
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, NOT_FOUND
            );
        }
        movieRepository.deleteById(id);
    }

    public void isAvailable(Long id) {
        var movie = getMovieById(id);
        movie.setAvailable(true);
        addMovie(movie);
    }
}
