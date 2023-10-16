package ManagedBeans;

public class Product {
	private long upc;
	private String name;
	private String type;
	private String description;
	private double price;
	public Product() {
		upc = 0;
		name = "";
		type = "";
		description = "";
		price = 0.0;
	}
	public Product(long upc, String name, String type, String description, double price) {
		this.upc = upc;
		this.name = name;
		this.type = type;
		this.description = description;
		this.price = price;
	}
	public long getUpc() {
		return upc;
	}
	public void setUpc(long upc) {
		this.upc = upc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
