package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Ticket;

import java.util.List;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	List<Ticket> findAllByOrderByPriceDesc();
	
}
