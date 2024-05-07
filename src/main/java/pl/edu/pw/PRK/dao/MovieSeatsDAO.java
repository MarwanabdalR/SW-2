package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.util.List;

public interface MovieSeatsDAO extends JpaRepository<MovieSeats,Integer>{

    @Query("SELECT s FROM MovieSeats s WHERE s.scheduleOfMovieId = ?1")
    List<MovieSeats> findSeatAssignedToScheduledMovie(ScheduleOfMovie ScheduledMovieId);

    @Query("SELECT s FROM MovieSeats s WHERE s.isOccupied = false AND s.scheduleOfMovieId=?1")
    List<MovieSeats> findNotOccupiedSeats(ScheduleOfMovie ScheduledMovieId);
}
