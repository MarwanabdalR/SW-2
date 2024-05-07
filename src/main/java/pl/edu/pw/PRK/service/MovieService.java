package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.Movie;

import java.util.List;

public interface MovieService {

	List<Movie> findAll();

	List<Movie> findAllSortedByNameAsc();

	Movie findById(int theId);
	
	void save(Movie movie);
	
	void deleteById(int theId);

	List <Movie> searchBy (String theName);
}
