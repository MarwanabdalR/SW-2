package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.Ticket;
import java.util.List;

public interface TicketService {

	List<Ticket> findAll();

	List<Ticket> findAllSortedByPriceDesc();

	Ticket findById(int theId);
	
	void save(Ticket ticket);
	
	void deleteById(int theId);

	List <Ticket> searchBy (String theName);
}
