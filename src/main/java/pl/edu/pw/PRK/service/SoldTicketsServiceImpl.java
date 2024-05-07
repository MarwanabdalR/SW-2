package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.SoldTicketsDAO;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.SoldTicket;
import pl.edu.pw.PRK.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class SoldTicketsServiceImpl implements SoldTicketsService {

	private final SoldTicketsDAO soldTicketsDAO;

	@Autowired
	public SoldTicketsServiceImpl(SoldTicketsDAO soldTicketsDAO) {
		this.soldTicketsDAO = soldTicketsDAO;
	}
	
	@Override
	@Transactional
	public List<SoldTicket> findAll() {
		return soldTicketsDAO.findAll();
	}

	@Override
	@Transactional
	public SoldTicket findById(int theId) {

		Optional<SoldTicket> result = soldTicketsDAO.findById(theId);

		SoldTicket soldTicket;
		
		if (result.isPresent()) {
			soldTicket = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find sold ticket id - " + theId);
		}
		
		return soldTicket;
	}

	@Override
	@Transactional
	public void save(SoldTicket soldTicket) {
		soldTicketsDAO.save(soldTicket);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		soldTicketsDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public List <SoldTicket> findTicketListForTheUser(User user) {
		return soldTicketsDAO.findTicketListForTheUser(user);
	}

	@Override
	public boolean checkIfTicketIsSold(MovieSeats movieSeats) {
		return soldTicketsDAO.checkIfTicketIsSold(movieSeats) != null;
	}
}






