package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.SeatDAO2;
import pl.edu.pw.PRK.dao.SeatDao;
import pl.edu.pw.PRK.entity.Seat;
import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

	private final SeatDao seatDao;
	private final SeatDAO2 seatDAO2;

	@Autowired
	public SeatServiceImpl(SeatDao seatDao, SeatDAO2 seatDAO2) {
		this.seatDao = seatDao;
		this.seatDAO2 = seatDAO2;
	}
	
	@Override
	@Transactional
	public List<Seat> findAll() {
		return seatDao.findAll();
	}

	@Override
	@Transactional
	public List<Seat> findAllSortedByHallIdAsc() {
		return seatDao.findAllByOrderByHallIdAsc();
	}

	@Override
	@Transactional
	public Seat findById(int theId) {

		Optional<Seat> result = seatDao.findById(theId);

		Seat seat;
		
		if (result.isPresent()) {
			seat = result.get();

		}
		else {
			// we didn't find the seat
			throw new RuntimeException("Did not find seat id - " + theId);
		}
		
		return seat;
	}

	@Override
	@Transactional
	public void save(Seat seat) {
		seatDao.save(seat);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		seatDao.deleteById(theId);
	}

	@Override
	@Transactional
	public boolean checkIfSeatNumberAlreadyExists(int seatNumber, int rowNumber, int hallNumber) {
		return seatDao.findSeatByNumberAndRowAndHallId(seatNumber, rowNumber, hallNumber) != null;
	}

	@Override
	@Transactional
	public List<Seat> searchBy(String hallNumber) {
		return seatDAO2.searchBy(hallNumber);
	}
}






