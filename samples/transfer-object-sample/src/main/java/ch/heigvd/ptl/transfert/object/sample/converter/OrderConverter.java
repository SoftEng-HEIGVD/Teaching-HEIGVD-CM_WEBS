package ch.heigvd.ptl.transfert.object.sample.converter;

import ch.heigvd.ptl.transfert.object.sample.model.Address;
import ch.heigvd.ptl.transfert.object.sample.model.Customer;
import ch.heigvd.ptl.transfert.object.sample.model.ItemOrder;
import ch.heigvd.ptl.transfert.object.sample.model.Order;
import ch.heigvd.ptl.transfert.object.sample.to.AddressTO;
import ch.heigvd.ptl.transfert.object.sample.to.ItemOrderTO;
import ch.heigvd.ptl.transfert.object.sample.to.OrderTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {
	public List<OrderTO> convertModelToTransferObject(List<Order> orders) {
		List<OrderTO> ordersConverted = new ArrayList<>();
		
		for (Order order : orders) {
			ordersConverted.add(convertModelToTransferObject(order));
		}
		
		return ordersConverted;
	}

	public OrderTO convertModelToTransferObject(Order order) {
		OrderTO orderConverted = new OrderTO();
		
		Customer customer = order.getCustomer();
		
		orderConverted.setBillingAddress(
			convertAddressToAddressTO(customer, customer.getBillingAddress())
		);
		orderConverted.setShippingAddress(
			convertAddressToAddressTO(customer, customer.getShippingAddress())
		);

		int totalQuantity = 0;
		float totalPrice = 0;
		List<ItemOrderTO> itemsConverted = new ArrayList<>();
		for (ItemOrder io : order.getItems()) {
			ItemOrderTO itemOrderConverted = convertItemOrderToItemOrderTO(io);
			
			// We keep track of the total quantity and total price for the whole order.
			totalQuantity += itemOrderConverted.getQuantity();
			totalPrice += itemOrderConverted.getTotalPrice();
			
			itemsConverted.add(itemOrderConverted);
		}
		
		orderConverted.setItems(itemsConverted);
		
		// We have also a difference between the DB model and the TO. We enrich the TO with the total price and quantity.
		orderConverted.setTotalQuantity(totalQuantity);
		orderConverted.setTotalPrice(totalPrice);
		
		return orderConverted;
	}
	
	private AddressTO convertAddressToAddressTO(Customer customer, Address address) {
		AddressTO addressConverted = new AddressTO();
		
		addressConverted.setStreet(address.getStreet());
		addressConverted.setCity(address.getCity());
		
		// Difference between the DB model and the TO representation. We concatenate the first and last name.
		addressConverted.setName(customer.getFirstname() + " " + customer.getLastname());
		
		return addressConverted;
	}
	
	private ItemOrderTO convertItemOrderToItemOrderTO(ItemOrder itemOrder) {
		ItemOrderTO itemOrderConverted = new ItemOrderTO();
		
		itemOrderConverted.setDescription(itemOrder.getDescription());
		itemOrderConverted.setQuantity(itemOrder.getQuantity());
		itemOrderConverted.setUnitPrice(itemOrder.getUnitPrice());
		
		// Difference with the DB model. We provide a calculation of the total price for the item.
		itemOrderConverted.setTotalPrice(itemOrder.getQuantity() * itemOrder.getUnitPrice());
		
		return itemOrderConverted;
	}
}
