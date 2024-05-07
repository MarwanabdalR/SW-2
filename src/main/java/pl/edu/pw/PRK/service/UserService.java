package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.User;
import pl.edu.pw.PRK.entity.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(WebUser webUser);

	void updateData(User user);
}
