package pl.edu.pw.PRK.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;

@Repository
public class SeatDAO2Impl implements SeatDAO2 {

    private final EntityManager entityManager;

    @Autowired
    public SeatDAO2Impl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List <Seat> searchBy(String hallNumber) {

        Session currentSession = entityManager.unwrap(Session.class);

        org.hibernate.query.Query<Seat> theQuery = currentSession.createQuery("from Seat where hall.number = :hallNumber", Seat.class);

        theQuery.setParameter("hallNumber", hallNumber);

        return theQuery.getResultList();
    }

//    @Override
//    public Seat findByNumberByRowByHall(int seatNumber, int rowNumber, int hallNumber) {
//
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        org.hibernate.query.Query<Seat> theQuery = currentSession.createQuery("from Seat where number = :seatNumber and row = :rowNumber and hall.number = :hallNumber", Seat.class);
//
//        theQuery.setParameter("seatNumber", seatNumber);
//        theQuery.setParameter("rowNumber", rowNumber);
//        theQuery.setParameter("hallNumber", hallNumber);
//
//        return theQuery.getSingleResultOrNull();
//    }
}
