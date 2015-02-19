package ch.heigvd.ptl.transfert.object.sample.rest;

import ch.heigvd.ptl.transfert.object.sample.model.Address;
import ch.heigvd.ptl.transfert.object.sample.model.Customer;
import ch.heigvd.ptl.transfert.object.sample.model.ItemOrder;
import ch.heigvd.ptl.transfert.object.sample.model.Order;
import ch.heigvd.ptl.transfert.object.sample.persistence.CustomerRepository;
import ch.heigvd.ptl.transfert.object.sample.persistence.OrderRepository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/data")
public class DataResource {
	private final Random rand = new Random(Calendar.getInstance().getTimeInMillis());
	
	private static final String[] DESCRIPTIONS = new String[] {
		"Morbi a odio cursus, finibus lorem ut, pellentesque elit.",
		"Nunc sollicitudin lorem at dolor placerat, eget ornare erat fringilla.",
		"Sed eget ipsum sit amet lacus dictum porttitor at facilisis velit.",
		"Integer at metus vitae erat porta pellentesque.",
		"Pellentesque iaculis ante vestibulum dolor finibus hendrerit.",
		"Mauris tempus orci quis orci lacinia cursus.",
		"Nam semper ligula quis nisl egestas, at pellentesque nunc tincidunt.",
		"Integer venenatis justo ac urna accumsan, eget hendrerit ligula eleifend.",
		"Ut sagittis ipsum sed nisl ultrices rutrum.",
		"Proin pretium lacus nec lectus congue, a finibus elit consequat.",
		"Sed id ligula semper, auctor metus et, mattis tortor.",
		"Aenean non massa quis urna pellentesque pellentesque in nec ex.",
		"Vestibulum non erat venenatis, finibus lorem ac, eleifend eros.",
		"Proin ac mi et turpis volutpat facilisis id eget est.",
		"Pellentesque mattis quam tincidunt sem rhoncus finibus."
	};
	
	private static final String[] STREETS_AND_CITIES = new String[] {
		"Proin", "Orci", "Egestas", "Lobortis", "Quam", "Non", "Posuere", "Lorem", "Etiam"
	};
	
	private static final String[] FIRSTNAMES = new String[] {
		"Alfred", "Henri", "Romain", "Benoit", "Alain", "Alex"
	};
	
	private static final String[] LASTNAMES = new String[] {
		"Dupont", "Dutoit", "Ducroc", "Desportes", "Terieur" 
	};
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	private final List<Customer> customers = new ArrayList<>();
	private final List<Order> orders = new ArrayList();
	
	private float random (float low, float high) {
    return rand.nextFloat() * (high - low) + low;
	}

	private int randomInt (int low, int high) {
		return (int) Math.floor(rand.nextFloat() * (high - low) + low);
	}

	private Date randomDate(Date start, Date end) {
    return new Date(start.getTime() + (int) (rand.nextFloat() * (end.getTime() - start.getTime())));
	}

	private Address generateAddress() {
		Address address = new Address();
		
		address.setStreet(STREETS_AND_CITIES[randomInt(0, STREETS_AND_CITIES.length)]);
		address.setCity(STREETS_AND_CITIES[randomInt(0, STREETS_AND_CITIES.length)]);

		return address;
	}
	
	private ItemOrder generateItemOrder() {
		ItemOrder itemOrder = new ItemOrder();
		
		itemOrder.setDescription(DESCRIPTIONS[randomInt(0, DESCRIPTIONS.length)]);
		
		itemOrder.setQuantity(randomInt(1, 100));
		itemOrder.setUnitPrice(random(1.0f, 100.0f));
		
		return itemOrder;
	}
	
	private void populateCustomers() {
		for (int i = 0; i < 25; i++) {
			Customer customer = new Customer();
			
			customer.setFirstname(FIRSTNAMES[randomInt(0, FIRSTNAMES.length)]);
			customer.setLastname(LASTNAMES[randomInt(0, LASTNAMES.length)]);
			
			customer.setBillingAddress(generateAddress());
			customer.setShippingAddress(generateAddress());
			
			customers.add(customerRepository.save(customer));
		}
	}
	
	private void populateOrders() throws ParseException {
		for (int i = 0; i < 100; i++) {
			Order order = new Order();
			
			order.setCustomer(customers.get(randomInt(0, customers.size())));
			
			List<ItemOrder> items = new ArrayList<>();
			for (int j = 0; i < 25; i++) {
				items.add(generateItemOrder());
			}
			order.setItems(items);
			
			orders.add(orderRepository.save(order));
		}
	}
	
	@Path("/populate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response populate() throws ParseException {
		customerRepository.deleteAll();
		orderRepository.deleteAll();

		populateCustomers();
		populateOrders();
		
		return Response.ok().build();
	}
}
