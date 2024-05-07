package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cinema_halls")
public class Hall {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="number")
	private int number;

	@Column(name="capacity")
	private int capacity;

	// define constructors

	public Hall() {

	}

	public Hall(int id, int number, int capacity) {
		this.id = id;
		this.number = number;
		this.capacity = capacity;
	}


	public Hall(int number, int capacity) {
		this.number = number;
		this.capacity = capacity;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Hall [id=" + id + ", number=" + number + ", capacity=" + capacity+"]";
	}
		
}











