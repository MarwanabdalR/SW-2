package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO2;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleOfMoviesServiceImpl implements ScheduleOfMoviesService {

	private final ScheduleOfMoviesDAO scheduleOfMoviesDAO;
	private final ScheduleOfMoviesDAO2 scheduleOfMoviesDAO2;

	@Autowired
	public ScheduleOfMoviesServiceImpl(ScheduleOfMoviesDAO scheduleOfMoviesDAO, ScheduleOfMoviesDAO2 scheduleOfMoviesDAO2) {
		this.scheduleOfMoviesDAO = scheduleOfMoviesDAO;
		this.scheduleOfMoviesDAO2 = scheduleOfMoviesDAO2;
	}

	@Override
	@Transactional
	public List<ScheduleOfMovie> findAll() {
		return scheduleOfMoviesDAO.findAll();
	}

	@Override
	@Transactional
	public List<ScheduleOfMovie> findAllSortedByDateAndTime() {
		return scheduleOfMoviesDAO.findAllByOrderByDateAscTimeAsc();
	}

	@Override
	@Transactional
	public ScheduleOfMovie findById(int theId) {

		Optional<ScheduleOfMovie> result = scheduleOfMoviesDAO.findById(theId);

		ScheduleOfMovie scheduleOfMovie;

		if (result.isPresent()) {
			scheduleOfMovie = result.get();

		}
		else {
			// we didn't find the
			throw new RuntimeException("Did not find movie id - " + theId);
		}

		return scheduleOfMovie;
	}

	@Override
	@Transactional
	public void save(ScheduleOfMovie scheduleOfMovie) {
		scheduleOfMoviesDAO.save(scheduleOfMovie);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		scheduleOfMoviesDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public List <ScheduleOfMovie> searchBy(String theName) {
		return scheduleOfMoviesDAO2.searchBy(theName);
	}

	@Override
	@Transactional
	public boolean checkIfScheduleOfMovieExists(Time time, Date date, int hallId) {
		return scheduleOfMoviesDAO.findScheduleOfMovieByTimeAndDateAndHallId(time, date, hallId) != null;
	}
}






