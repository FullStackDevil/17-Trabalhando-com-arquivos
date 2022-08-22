package entities;

public class Product {

	private String item;
	private Double unitPrice;
	private Integer quantity;

	public Product() {
	}

	public Product(String item, Double unitPrice, Integer quantity) {
		super();
		this.item = item;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double totalValue() {
		return unitPrice * quantity;
	}

}
