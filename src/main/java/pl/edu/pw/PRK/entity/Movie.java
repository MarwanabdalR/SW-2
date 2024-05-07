package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="duration")
	private int duration;


	// define constructors

	public Movie() {

	}

	public Movie(int id, String name, String description, int duration) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
	}


	public Movie(String name, String description, int duration) {
		this.name = name;
		this.description = description;
		this.duration = duration;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration + "]";
	}
		
}











