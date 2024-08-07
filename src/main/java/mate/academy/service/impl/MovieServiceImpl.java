package mate.academy.service.impl;

import java.util.List;
import mate.academy.dao.MovieDao;
import mate.academy.dao.impl.MovieDaoImpl;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao = new MovieDaoImpl();

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieDao.getByMoviesId(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Movie not found with id: " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
