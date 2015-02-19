package ch.heigvd.ptl.transfert.object.sample.persistence;

import ch.heigvd.ptl.transfert.object.sample.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
