package pl.edu.pw.PRK.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pw.PRK.dao.RoleDao;
import pl.edu.pw.PRK.dao.UserDao;
import pl.edu.pw.PRK.entity.Role;
import pl.edu.pw.PRK.entity.User;
import pl.edu.pw.PRK.entity.WebUser;
// import scala.collection.immutable.List;



@Service
public class UserServiceImpl implements UserService {


	
	private final UserDao userDao;

	private final RoleDao roleDao;

	private final BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	@Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(WebUser webUser) {
		if(roleDao.findRoleByName("USER") == null){
			Role user_Role = new Role("USER");
			roleDao.saveRole(user_Role);
		}
		if(roleDao.findRoleByName("ADMIN") == null){
		    Role admin_Role = new Role("ADMIN");
		    roleDao.saveRole(admin_Role);
		}
		User user = new User();

		// assign user details to the user object
		user.setUserName(webUser.getUserName());
		user.setPassword(passwordEncoder.encode(webUser.getPassword()));
		user.setFirstName(webUser.getFirstName());
		user.setLastName(webUser.getLastName());
		user.setEmail(webUser.getEmail());
		user.setEnabled(webUser.getEnabled());

		// give user default role of "user"
		if(webUser.getEnabled()){
			user.setRoles(Collections.singletonList(roleDao.findRoleByName("ADMIN")));
		}
		else{user.setRoles(Collections.singletonList(roleDao.findRoleByName("USER")));}
		

		
		// save user in the database
		userDao.save(user);
	}

	@Override
    @Transactional
    public void updateData(User user) {
    // Always assign the "USER" role to every user
    Collection<Role> roles = Collections.singleton(roleDao.findRoleByName("USER"));

    // If the user is enabled, assign the "ADMIN" role
    if (user.isEnabled()) {
        roles.add(roleDao.findRoleByName("ADMIN"));
    }

    // Set the roles for the user
    user.setRoles(roles);

    // Check if the password needs to be encoded
    if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    // Save the updated user
    userDao.save(user);
}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);
	}

	private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role tempRole : roles) {
			SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
			authorities.add(tempAuthority);
		}

		return authorities;
	}
}
