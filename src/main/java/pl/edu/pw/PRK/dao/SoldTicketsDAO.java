package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.SoldTicket;
import pl.edu.pw.PRK.entity.User;
import java.util.List;

public interface SoldTicketsDAO extends JpaRepository<SoldTicket, Integer> {

    @Query("SELECT s FROM SoldTicket s WHERE s.user = ?1")
    List<SoldTicket> findTicketListForTheUser(User user);

    @Query("SELECT s FROM SoldTicket s WHERE s.movieSeat = ?1")
    SoldTicket checkIfTicketIsSold(MovieSeats movieSeats);
}
