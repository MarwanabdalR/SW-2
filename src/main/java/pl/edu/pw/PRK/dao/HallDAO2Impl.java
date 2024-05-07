package pl.edu.pw.PRK.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pw.PRK.entity.Hall;
import java.util.List;

@Repository
public class HallDAO2Impl implements HallDAO2 {

    private final EntityManager entityManager;

    @Autowired
    public HallDAO2Impl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List <Hall> searchBy(String number) {

        Session currentSession = entityManager.unwrap(Session.class);

        org.hibernate.query.Query<Hall> theQuery = currentSession.createQuery("from Hall where number = :number", Hall.class);

        theQuery.setParameter("number", number);

        return theQuery.getResultList();
    }
}
