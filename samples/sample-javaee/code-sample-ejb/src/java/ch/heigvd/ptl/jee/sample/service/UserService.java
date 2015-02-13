package ch.heigvd.ptl.jee.sample.service;

import ch.heigvd.ptl.jee.sample.model.User;
import ch.heigvd.ptl.jee.sample.to.UserTO;
import javax.ejb.Local;

@Local
public interface UserService {
	User registerUser(UserTO userTO);
}
