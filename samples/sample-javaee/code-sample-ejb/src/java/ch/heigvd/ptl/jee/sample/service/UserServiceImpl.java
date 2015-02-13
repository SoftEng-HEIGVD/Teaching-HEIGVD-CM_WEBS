package ch.heigvd.ptl.jee.sample.service;

import ch.heigvd.ptl.jee.sample.model.User;
import ch.heigvd.ptl.jee.sample.to.UserTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserServiceImpl implements UserService {
	@PersistenceContext(name = "PU")
	private EntityManager em;
	
	@EJB
	private UtilityService utilityService;
	
	@Override
	public User registerUser(UserTO userTO) {
		User user = new User();
		
		user.setUsername(utilityService.trimString(userTO.getUsername()));
		user.setRole(User.Role.MEMBER);
		
		em.persist(user);
		
		return user;
	}
}
