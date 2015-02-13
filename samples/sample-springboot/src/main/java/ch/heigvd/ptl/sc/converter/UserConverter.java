package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.to.UserTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
	@Autowired
	private AddressConverter addressConverter;
	
	public final List<UserTO> convertSourceToTarget(List<User> sources) {
		List<UserTO> results = new ArrayList<>();
		
		for (User source : sources) {
			results.add(convertSourceToTarget(source));
		}
		
		return results;
	}

	public final UserTO convertSourceToTarget(User source) {
		UserTO target = new UserTO();
		fillTargetFromSource(target, source);
		return target;
	}
	
	public final List<User> convertTargetToSource(List<UserTO> targets) {
		List<User> results = new ArrayList<>();
		
		for (UserTO target : targets) {
			results.add(convertTargetToSource(target));
		}
		
		return results;
	}

	public final User convertTargetToSource(UserTO target) {
		User source = new User();
		fillSourceFromTarget(source, target);
		return source;
	}

	public void fillTargetFromSource(UserTO target, User source) {
		target.setAddress(addressConverter.convertSourceToTarget(source.getAddress()));
		target.setUsername(source.getUsername());
		target.setRole(source.getRole().name());
	}

	public void fillSourceFromTarget(User source, UserTO target) {
		source.setAddress(addressConverter.convertTargetToSource(target.getAddress()));
		source.setUsername(target.getUsername());
	}
}
