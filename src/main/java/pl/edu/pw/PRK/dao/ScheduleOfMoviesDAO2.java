package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.ScheduleOfMovie;
import java.util.List;

public interface ScheduleOfMoviesDAO2 {

    List <ScheduleOfMovie> searchBy (String theName);
}
