package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seats")
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="column_nr")
	private int number;

	@Column(name="row_nr")
	private int row;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hall_id")
	private Hall hall;

	// define constructors

	public Seat() {
	}

	public Seat(int number, int row, Hall hall) {
		this.number = number;
		this.row = row;
		this.hall = hall;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@Override
	public String toString() {
		return "Rząd: " + row + ", Miejsce: " + number;
	}
}











