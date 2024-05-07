package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="sold_tickets")
public class SoldTicket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="movie_seat_id")
	private MovieSeats movieSeat;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ticket_id")
	private Ticket ticket;


	// define constructors

	public SoldTicket() {

	}

	public SoldTicket(User user, MovieSeats movieSeat, Ticket ticket) {
		this.user = user;
		this.movieSeat = movieSeat;
		this.ticket = ticket;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MovieSeats getMovieSeat() {
		return movieSeat;
	}

	public void setMovieSeat(MovieSeats movieSeatId) {
		this.movieSeat = movieSeatId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}











