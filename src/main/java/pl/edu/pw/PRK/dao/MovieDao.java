package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Movie;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

	List<Movie> findAllByOrderByNameAsc();
	
}
