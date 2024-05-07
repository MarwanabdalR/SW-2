package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.Seat;
import java.util.List;

public interface SeatDAO2 {

    List <Seat> searchBy (String hallNumber);

//    Seat findByNumberByRowByHall(int seatNumber, int rowNumber, int hallNumber);
}
