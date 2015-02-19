package ch.heigvd.ptl.transfert.object.sample.to;

import java.util.List;

public class OrderTO {
	private AddressTO billingAddress;
	private AddressTO shippingAddress;
	
	private int totalQuantity = 0;
	private float totalPrice = 0;
	
	private List<ItemOrderTO> items;

	public AddressTO getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressTO billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressTO getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressTO shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemOrderTO> getItems() {
		return items;
	}

	public void setItems(List<ItemOrderTO> items) {
		this.items = items;
	}
}
