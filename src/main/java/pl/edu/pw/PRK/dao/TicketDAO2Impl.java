package pl.edu.pw.PRK.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pw.PRK.entity.Ticket;
import java.util.List;

@Repository
public class TicketDAO2Impl implements TicketDAO2 {

    private final EntityManager entityManager;

    @Autowired
    public TicketDAO2Impl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List <Ticket> searchBy(String theName) {

        Session currentSession = entityManager.unwrap(Session.class);

        org.hibernate.query.Query<Ticket> theQuery = currentSession.createQuery("from Ticket where name like :name", Ticket.class);

        theQuery.setParameter("name", "%" + theName + "%");

        return theQuery.getResultList();
    }
}
