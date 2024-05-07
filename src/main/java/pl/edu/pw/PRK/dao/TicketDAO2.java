package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.Ticket;
import java.util.List;

public interface TicketDAO2 {

    List <Ticket> searchBy (String theName);
}
