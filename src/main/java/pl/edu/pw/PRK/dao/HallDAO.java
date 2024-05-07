package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Hall;
import java.util.List;

public interface HallDAO extends JpaRepository<Hall,Integer> {

    List<Hall> findAllByOrderByNumberAsc();

    Hall findByNumber(int number);
}
