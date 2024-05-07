package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
