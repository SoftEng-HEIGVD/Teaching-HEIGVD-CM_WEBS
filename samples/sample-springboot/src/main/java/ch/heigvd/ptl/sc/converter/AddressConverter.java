package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.Address;
import ch.heigvd.ptl.sc.to.AddressTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {
	public final List<AddressTO> convertSourceToTarget(List<Address> sources) {
		List<AddressTO> results = new ArrayList<>();
		
		for (Address source : sources) {
			results.add(convertSourceToTarget(source));
		}
		
		return results;
	}

	public final AddressTO convertSourceToTarget(Address source) {
		AddressTO target = new AddressTO();
		fillTargetFromSource(target, source);
		return target;
	}
	
	public final List<Address> convertTargetToSource(List<AddressTO> targets) {
		List<Address> results = new ArrayList<>();
		
		for (AddressTO target : targets) {
			results.add(convertTargetToSource(target));
		}
		
		return results;
	}

	public final Address convertTargetToSource(AddressTO target) {
		Address source = new Address();
		fillSourceFromTarget(source, target);
		return source;
	}

	public void fillTargetFromSource(AddressTO target, Address source) {
		target.setPostalCode(source.getPostalCode());
		target.setCity(source.getCity());
		target.setStreet(source.getStreet());
	}

	public void fillSourceFromTarget(Address source, AddressTO target) {
		source.setStreet(target.getStreet());
		source.setCity(target.getCity());
		source.setPostalCode(target.getPostalCode());
	}
}
