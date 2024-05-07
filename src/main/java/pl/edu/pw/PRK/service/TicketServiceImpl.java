package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.TicketDAO2;
import pl.edu.pw.PRK.dao.TicketDao;
import pl.edu.pw.PRK.entity.Ticket;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketDao ticketDao;
	private final TicketDAO2 ticketDAO2;

	@Autowired
	public TicketServiceImpl(TicketDao ticketDao, TicketDAO2 ticketDAO2) {
		this.ticketDao = ticketDao;
		this.ticketDAO2 = ticketDAO2;
	}
	
	@Override
	@Transactional
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	@Transactional
	public List<Ticket> findAllSortedByPriceDesc() {
		return ticketDao.findAllByOrderByPriceDesc();
	}

	@Override
	@Transactional
	public Ticket findById(int theId) {

		Optional<Ticket> result = ticketDao.findById(theId);

		Ticket Ticket;
		
		if (result.isPresent()) {
			Ticket = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Ticket id - " + theId);
		}
		
		return Ticket;
	}

	@Override
	@Transactional
	public void save(Ticket Ticket) {
		ticketDao.save(Ticket);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ticketDao.deleteById(theId);
	}

	@Override
	@Transactional
	public List <Ticket> searchBy(String theName) {
		return ticketDAO2.searchBy(theName);
	}
}






