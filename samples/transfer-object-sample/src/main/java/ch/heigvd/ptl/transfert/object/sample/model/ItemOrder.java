package ch.heigvd.ptl.transfert.object.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ItemOrder {
	private String description;
	private float unitPrice;
	private int quantity;

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
