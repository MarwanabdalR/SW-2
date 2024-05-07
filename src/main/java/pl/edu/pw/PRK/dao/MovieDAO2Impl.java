package pl.edu.pw.PRK.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pw.PRK.entity.Movie;
import java.util.List;

@Repository
public class MovieDAO2Impl implements MovieDAO2 {

    private final EntityManager entityManager;

    @Autowired
    public MovieDAO2Impl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List <Movie> searchBy(String theName) {

        Session currentSession = entityManager.unwrap(Session.class);

        org.hibernate.query.Query<Movie> theQuery = currentSession.createQuery("from Movie where name like :name", Movie.class);

        theQuery.setParameter("name", "%" + theName + "%");

        return theQuery.getResultList();
    }
}
