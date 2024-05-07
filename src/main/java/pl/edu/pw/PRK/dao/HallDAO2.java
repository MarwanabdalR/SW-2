package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.Hall;
import java.util.List;

public interface HallDAO2 {

    List <Hall> searchBy (String number);
}
