package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.PRK.dao.HallDAO;
import pl.edu.pw.PRK.dao.HallDAO2;
import pl.edu.pw.PRK.entity.Hall;
import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {

	private final HallDAO hallDao;
	private final HallDAO2 hallDAO2;

	@Autowired
	public HallServiceImpl(HallDAO hallDao, HallDAO2 hallDAO2) {
		this.hallDao = hallDao;
		this.hallDAO2 = hallDAO2;
	}
	
	@Override
	@Transactional
	public List<Hall> findAll() {
		return hallDao.findAll();
	}

	@Override
	@Transactional
	public List<Hall> findAllSortedByNumberAsc() {
		return hallDao.findAllByOrderByNumberAsc();
	}

	@Override
	@Transactional
	public Hall findById(int theId) {
		Optional<Hall> result = hallDao.findById(theId);

		Hall hall;
		
		if (result.isPresent()) {
			hall = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find hall id - " + theId);
		}
		
		return hall;
	}

	@Override
	@Transactional
	public void save(Hall hall) {
		hallDao.save(hall);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		hallDao.deleteById(theId);
	}

	@Override
	@Transactional
	public boolean checkIsNumberAlreadyExist(int number) {
		return hallDao.findByNumber(number) != null;
	}

	@Override
	@Transactional
	public List<Hall> searchBy(String number) {
		return hallDAO2.searchBy(number);
	}

}






