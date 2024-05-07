package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="schedule_of_movies")
public class ScheduleOfMovie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="date")
	private Date date;

	@Column(name="time")
	private Time time;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="movie_id")
	private Movie movie;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hall_ID")
	private Hall hall;


	// define constructors

	public ScheduleOfMovie() {

	}

	public ScheduleOfMovie(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public String getMovieName(){
		return movie.getName();
	}

	public int getHallNumber(){
		return hall.getNumber();
	}
	public void setMovie(Movie movie_id) {
		this.movie = movie_id;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall_id) {
		this.hall = hall_id;
	}
		
}











