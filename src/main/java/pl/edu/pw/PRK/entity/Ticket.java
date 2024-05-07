package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	@NotNull
	private String name;

	@Column(name="price")
	@NotNull
	private float price;

	// define constructors

	public Ticket() {

	}

	public Ticket(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Ticket(String name, float price) {
		this.name = name;
		this.price = price;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", price=" + price +"]";
	}
		
}











