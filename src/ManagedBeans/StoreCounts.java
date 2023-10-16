package ManagedBeans;

public class StoreCounts {
	private int count;
	private int store;
	private String address;
	private long phone;
	public StoreCounts() {
		this.count = 0;
		this.store = 0;
		this.address = "";
		this.phone = 0;
	}
	public StoreCounts(int count, int store, String address, long phone) {
		this.count = count;
		this.store = store;
		this.address = address;
		this.phone = phone;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String formatPhone() {
		String formatted = String.valueOf(phone);
		formatted = "(" + formatted.substring(0,3) + ")" + formatted.substring(3,6) + "-" + formatted.substring(6,10);
		return formatted;
	}
}
