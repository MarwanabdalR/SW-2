package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.Movie;
import java.util.List;

public interface MovieDAO2 {

    List <Movie> searchBy (String theName);
}
