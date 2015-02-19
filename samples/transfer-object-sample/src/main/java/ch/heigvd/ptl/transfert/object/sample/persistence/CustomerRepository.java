package ch.heigvd.ptl.transfert.object.sample.persistence;

import ch.heigvd.ptl.transfert.object.sample.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
