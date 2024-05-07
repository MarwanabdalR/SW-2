package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.MovieSeatsDAO;
import pl.edu.pw.PRK.dao.SeatDao;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeatsServiceImpl implements MovieSeatsService {

	private final MovieSeatsDAO movieSeatsDAO;
	private final SeatDao seatDao;

	@Autowired
	public MovieSeatsServiceImpl(MovieSeatsDAO movieSeatsDAO, SeatDao seatDao) {
		this.movieSeatsDAO = movieSeatsDAO;
		this.seatDao=seatDao;
	}

	@Override
	@Transactional
	public List<MovieSeats> findAll() {
		return movieSeatsDAO.findAll();
	}

	@Override
	@Transactional
	public MovieSeats findById(int theId) {
		Optional<MovieSeats> result = movieSeatsDAO.findById(theId);

		MovieSeats movieSeats;

		if (result.isPresent()) {
			movieSeats = result.get();

		}
		else {
			// we didn't find
			throw new RuntimeException("Did not find movie seat id - " + theId);
		}

		return movieSeats;
	}

	@Override
	@Transactional
	public void save(MovieSeats movieSeats) {
		movieSeatsDAO.save(movieSeats);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		movieSeatsDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public void createBunchOfSeatsForNewMovie(ScheduleOfMovie scheduleOfMovie, Hall hall) {

		deleteBunchOfSeatsForNewMovie(scheduleOfMovie);

		List<Seat> seatList = seatDao.findSeatAssignedToHall(hall);
		for (Seat seat : seatList) {
			MovieSeats movieSeats = new MovieSeats(scheduleOfMovie, seat);
			movieSeatsDAO.save(movieSeats);
		}
	}

	@Override
	@Transactional
	public void deleteBunchOfSeatsForNewMovie(ScheduleOfMovie scheduleOfMovie) {
		List<MovieSeats> movieSeatsList = movieSeatsDAO.findSeatAssignedToScheduledMovie(scheduleOfMovie);
		for (MovieSeats movieSeats : movieSeatsList) {
			movieSeatsDAO.deleteById(movieSeats.getId());
		}
	}

	@Override
	@Transactional
	public List<MovieSeats> findNotOccupiedSeats(ScheduleOfMovie scheduleOfMovie) {
		return movieSeatsDAO.findNotOccupiedSeats(scheduleOfMovie);
	}


}






