package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="movie_seats")
public class MovieSeats {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "is_occupied")
	private boolean isOccupied;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schedule_of_movie_id")
	private ScheduleOfMovie scheduleOfMovieId;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="seat_id")
	private Seat seatId;


	// define constructors

	public MovieSeats() {
		this.isOccupied=false;
	}

	public MovieSeats(ScheduleOfMovie scheduleOfMovieId, Seat seatId) {
		this.scheduleOfMovieId = scheduleOfMovieId;
		this.seatId = seatId;
		this.isOccupied=false;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScheduleOfMovie getScheduleOfMovieId() {
		return scheduleOfMovieId;
	}

	public void setScheduleOfMovieId(ScheduleOfMovie scheduleOfMovieId) {
		this.scheduleOfMovieId = scheduleOfMovieId;
	}

	public Seat getSeatId() {
		return seatId;
	}

	public void setSeatId(Seat seatId) {
		this.seatId = seatId;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}
}











