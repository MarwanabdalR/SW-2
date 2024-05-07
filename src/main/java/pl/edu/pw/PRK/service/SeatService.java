package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.Seat;

import java.util.List;

public interface SeatService {

	List<Seat> findAll();

	List<Seat> findAllSortedByHallIdAsc();

	Seat findById(int theId);
	
	void save(Seat seat);
	
	void deleteById(int theId);

	boolean checkIfSeatNumberAlreadyExists(int seatNumber, int rowNumber, int hallNumber);

	List <Seat> searchBy (String hallNumber);
}
