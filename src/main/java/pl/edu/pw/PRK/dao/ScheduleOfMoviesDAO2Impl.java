package pl.edu.pw.PRK.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.util.List;

@Repository
public class ScheduleOfMoviesDAO2Impl implements ScheduleOfMoviesDAO2 {

    private final EntityManager entityManager;

    @Autowired
    public ScheduleOfMoviesDAO2Impl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List <ScheduleOfMovie> searchBy(String theName) {

        Session currentSession = entityManager.unwrap(Session.class);

        org.hibernate.query.Query<ScheduleOfMovie> theQuery = currentSession.createQuery("from ScheduleOfMovie where movie.name like :name", ScheduleOfMovie.class);

        theQuery.setParameter("name", "%" + theName + "%");

        return theQuery.getResultList();
    }
}
