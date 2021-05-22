package pl.edu.pjwstk.matyliano.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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

    public Optional<Movie> getMovieById(Long id) {
      return movieRepository.findById(id);
    }

    public Optional<Movie> updateMovie(Long id, Movie movieToUpdate) {
        Optional<Movie> movie = movieRepository.findAll().stream().filter(m -> m.getId().equals(id)).findFirst();
        if (movie.isPresent()) {
            movie.get().setCategory(movieToUpdate.getCategory());
            movie.get().setTitle(movieToUpdate.getTitle());
            return movie;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, NOT_FOUND
        );
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, NOT_FOUND
            );
        }
        movieRepository.deleteById(id);
    }
}
