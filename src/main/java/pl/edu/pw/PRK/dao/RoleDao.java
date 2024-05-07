package pl.edu.pw.PRK.dao;

import pl.edu.pw.PRK.entity.Role;

public interface RoleDao {

	Role findRoleByName(String theRoleName);
	
}
