package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.Hall;
import java.util.List;

public interface HallService {

	List<Hall> findAll();

	List<Hall> findAllSortedByNumberAsc();

	Hall findById(int theId);
	
	void save(Hall hall);
	
	void deleteById(int theId);

	boolean checkIsNumberAlreadyExist(int number);

	List <Hall> searchBy (String number);
}
