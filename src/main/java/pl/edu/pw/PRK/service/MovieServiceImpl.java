package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.MovieDAO2;
import pl.edu.pw.PRK.dao.MovieDao;
import pl.edu.pw.PRK.entity.Movie;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieDao movieDao;
	private final MovieDAO2 movieDAO2;
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao, MovieDAO2 movieDAO2) {
		this.movieDao = movieDao;
		this.movieDAO2 = movieDAO2;
	}
	
	@Override
	@Transactional
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	@Override
	@Transactional
	public List<Movie> findAllSortedByNameAsc() {
		return movieDao.findAllByOrderByNameAsc();
	}

	@Override
	@Transactional
	public Movie findById(int theId) {

		Optional<Movie> result = movieDao.findById(theId);

		Movie movie;
		
		if (result.isPresent()) {
			movie = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find movie id - " + theId);
		}
		
		return movie;
	}

	@Override
	@Transactional
	public void save(Movie theEmployee) {
		movieDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		movieDao.deleteById(theId);
	}

	@Override
	@Transactional
	public List <Movie> searchBy(String theName) {
		return movieDAO2.searchBy(theName);
	}
}






