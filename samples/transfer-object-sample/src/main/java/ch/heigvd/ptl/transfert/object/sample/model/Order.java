package ch.heigvd.ptl.transfert.object.sample.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String id;
	
	@DBRef
	private Customer customer;
	
	private List<ItemOrder> items;

	public Customer getCustomer() {
		return customer;
	}

	public String getId() {
		return id;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}
}
