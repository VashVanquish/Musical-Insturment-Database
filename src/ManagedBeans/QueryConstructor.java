/*
Programmer: Mason Lanham
ID: 1629795
Date: 04/24/2023
Course: Database Management Systems
Assignment: Project Frontend
*/
package ManagedBeans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

@ManagedBean
@SessionScoped
public class QueryConstructor {
	private HashMap<String, String> Logins;
	private String table, username, password;
	private String[] tables;
	private long upc;
	private String name;
	private String type;
	private double price;
	private double minPrice;
	private byte upcQueryType; //0 = none, 1 = exactly, 2 = contains, 3 = greater than, 4 = less than
	private byte nameQueryType; //0 = none, 1 = exactly, 2 = contains
	private byte typeQueryType; //0 = none, 1 = exactly, 2 = contains
	private byte priceQueryType; //0 = none, 1 = exactly, 2 = contains, 3 = greater than, 4 = less than, 5 = greater than and less than
	private DatabaseConnectivity dc;
	private List<Product> products;
	private String[] itemTables;
	private long itemUpc;
	private String itemName;
	private String itemDescription;
	private String itemPrice;
	private String itemType;
	private long SerialNumber;
	private long SKU;
	private long[] SKUs;
	private int LID;
	private String Warranty;
	private List<StoreCounts> storeCounts;
	private String productDetails;
	
	public QueryConstructor() throws NamingException {
		this.tables = new String[6];
		this.upc = 0;
		this.name = "none";
		this.type = "none";
		this.price = 0.00;
		this.minPrice = 0.00;
		this.upcQueryType = 0;
		this.nameQueryType = 0;
		this.typeQueryType = 0;
		this.priceQueryType = 0;
		this.Logins = null;
		this.table = "Person";
		this.username = "";
		this.password = "";
		this.itemTables = new String[6];
		this.itemUpc = 0;
		this.itemName = "";
		this.itemType = "";
		this.itemPrice = "";
		this.itemType = "";
		this.SerialNumber = 0;
		this.SKU = 0;
		this.SKUs = new long[10];
		this.LID = 0;
		this.Warranty = "";
		this.productDetails = "";
		this.dc = DatabaseConnectivity.getInstance();
		this.products = new ArrayList<Product>();
		this.storeCounts = new ArrayList<StoreCounts>();
	}
	public QueryConstructor(String[] newTables, long newUPC, String newName, String newType, double newPrice, double newMinPrice, int upcQryType, int nameQryType, int typeQryType, int priceQryType) throws NamingException {
		this.tables = newTables;
		this.upc = newUPC;
		this.name = newName;
		this.type = newType;
		this.price = newPrice;
		this.minPrice = newMinPrice;
		this.upcQueryType = (byte) upcQryType;
		this.nameQueryType = (byte) nameQryType;
		this.typeQueryType = (byte) typeQryType;
		this.priceQueryType = (byte) priceQryType;
		this.dc = DatabaseConnectivity.getInstance();
		this.products = new ArrayList<Product>();
	}
	
	public long[] getSKUs() {
		return SKUs;
	}
	public void setSKUs(long[] sKUs) {
		SKUs = sKUs;
	}
	public String getWarranty() {
		return Warranty;
	}
	public void setWarranty(String warranty) {
		Warranty = warranty;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public long getSKU() {
		return SKU;
	}
	public void setSKU(long sKU) {
		SKU = sKU;
	}
	public int getLID() {
		return LID;
	}
	public void setLID(int lID) {
		LID = lID;
	}
	public List<StoreCounts> getStoreCounts() {
		return storeCounts;
	}
	public void setStoreCounts(List<StoreCounts> storeCounts) {
		this.storeCounts = storeCounts;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String[] getItemTables() {
		return itemTables;
	}
	public void setItemTables(String[] itemTables) {
		this.itemTables = itemTables;
	}
	public long getItemUpc() {
		return itemUpc;
	}
	public void setItemUpc(long itemUpc) {
		this.itemUpc = itemUpc;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getTables() {
		return tables;
	}
	public void setTables(String[] tables) {
		this.tables = tables;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public byte getUpcQueryType() {
		return upcQueryType;
	}
	public void setUpcQueryType(byte upcQueryType) {
		this.upcQueryType = upcQueryType;
	}
	public byte getNameQueryType() {
		return nameQueryType;
	}
	public void setNameQueryType(byte nameQueryType) {
		this.nameQueryType = nameQueryType;
	}
	public byte getTypeQueryType() {
		return typeQueryType;
	}
	public void setTypeQueryType(byte typeQueryType) {
		this.typeQueryType = typeQueryType;
	}
	public byte getPriceQueryType() {
		return priceQueryType;
	}
	public void setPriceQueryType(byte priceQueryType) {
		this.priceQueryType = priceQueryType;
	}
	public String constructQuery() {
		String query = "SELECT Product.*\nFROM Product";
		for(String table : tables) {
			if(table != null) {
			query += ", " + table; 
			}
		}
		query += "\nWHERE";
		int index = 0;
		for(String table : tables) {
			if(table != null) {
				query += " Product.UPC = " + table + ".UPC\nAND";
			}
			if(index == tables.length - 1)
			{
				query = query.substring(0, query.length() - 3);
			}
			index += 1;
		}
		
		query += getUPCQuery();
		query += getNameQuery();
		query += getTypeQuery();
		query += getPriceQuery();
		int correction = query.indexOf("WHEREAND");
		if(correction != -1)
		{
			query = query.substring(0, correction + 5) + query.substring(correction + 8);
		}
		correction = query.indexOf("WHERE");
		if(correction == query.length() - 5)
		{
			query = query.substring(0, correction);
		}
		return query;
	}
	private String getUPCQuery() {
		String query = "";
		if(upcQueryType != 0)
		{
			switch(upcQueryType) {
			case 1:
				query = "AND Product.UPC = " + upc + "\n";
				break;
			case 2:
				query = "AND Product.UPC LIKE " + "\"%" + upc + "%\"\n";
				break;
			case 3:
				query = "AND Product.UPC > " + upc + "\n";
				break;
			case 4:
				query = "AND Product.UPC < " + upc + "\n";
				break;
			}
		}
		return query;
	}
	private String getNameQuery() {
		String query = "";
		if(name != "none" && nameQueryType != 0)
		{
			switch(nameQueryType) {
			case 1:
				query = "AND Product.ProductName = '" + name + "'\n";
				break;
			case 2:
				query = "AND Product.ProductName LIKE " + "\"%" + name + "%\"\n";
				break;
			}
		}
		return query;
	}
	private String getTypeQuery() {
		String query = "";
		if(type != "none" && typeQueryType != 0)
		{
			switch(typeQueryType) {
			case 1:
				query = "AND Product.ProductType = '" + type + "'\n";
				break;
			case 2:
				query = "AND Product.ProductType LIKE " + "\"%" + type + "%\"\n";
				break;
			}
		}
		return query;
	}
	private String getPriceQuery() {
		String query = "";
		if(price != 0 && priceQueryType != 0)
		{
			switch(priceQueryType) {
			case 1:
				query = "AND Product.Price = " + price + "\n";
				break;
			case 2:
				query = "AND Product.Price LIKE " + "\"%" + price + "%\"\n";
				break;
			case 3:
				query = "AND Product.Price > " + minPrice + "\n";
				break;
			case 4:
				query = "AND Product.Price < " + price + "\n";
				break;
			case 5:
				query = "AND Product.Price < " + price + "\n" + "AND Product.Price > " + minPrice + "\n";
				break;
			}
		}
		return query;
	}
	public String executeProductQuery() throws SQLException {
		String resultPage = "";
		ResultSet rs;
		rs = dc.executeQuery(this.constructQuery());
		long upc = 0;
		String name = "";
		String description = "";
		String type = "";
		double price = 0.0;
		while(rs.next()) {
			upc = rs.getLong("UPC");
			name = rs.getString("ProductName");
			description = rs.getString("ProductDescription");
			type = rs.getString("ProductType");
			price = rs.getDouble("Price");
			products.add(new Product(upc, name, description, type, price));
		}
		if(this.username.equals(""))
		{
			resultPage = "ProductSearchResults";
		}
		else {
			if(this.table.equals("Person"))
			{
				resultPage = "LoginSearchProductResults";
			}
			else {
				resultPage = "VendorSearchProductResults";
			}
		}
		return resultPage;
	}
	public String logout() {
		this.tables = new String[6];
		this.upc = 0;
		this.name = "none";
		this.type = "none";
		this.price = 0.00;
		this.minPrice = 0.00;
		this.upcQueryType = 0;
		this.nameQueryType = 0;
		this.typeQueryType = 0;
		this.priceQueryType = 0;
		this.Logins = null;
		this.table = "Person";
		this.username = "";
		this.password = "";
		this.itemTables = new String[6];
		this.itemUpc = 0;
		this.itemName = "";
		this.itemType = "";
		this.itemPrice = "";
		this.itemType = "";
		this.SerialNumber = 0;
		this.SKU = 0;
		this.SKUs = new long[10];
		this.LID = 0;
		this.Warranty = "";
		this.productDetails = "";
		this.products = new ArrayList<Product>();
		this.storeCounts = new ArrayList<StoreCounts>();
		return "Login";
	}
	public String searchProductsReturn() {
		this.tables = new String[6];
		this.upc = 0;
		this.name = "none";
		this.type = "none";
		this.price = 0.00;
		this.minPrice = 0.00;
		this.upcQueryType = 0;
		this.nameQueryType = 0;
		this.typeQueryType = 0;
		this.priceQueryType = 0;
		this.Logins = null;
		this.table = "Person";
		this.itemTables = new String[6];
		this.itemUpc = 0;
		this.itemName = "";
		this.itemType = "";
		this.itemPrice = "";
		this.itemType = "";
		this.SerialNumber = 0;
		this.SKU = 0;
		this.SKUs = new long[10];
		this.LID = 0;
		this.Warranty = "";
		this.productDetails = "";
		this.products = new ArrayList<Product>();
		this.storeCounts = new ArrayList<StoreCounts>();
		String resultPage = "";
		if(this.username.equals(""))
		{
			resultPage = "SearchProducts";
		}
		else {
			resultPage = "LoginSearchProducts";
		}
		return resultPage;
	}
	public String countItemsByStore() throws SQLException, NamingException, InterruptedException {
		ResultSet rs;
		//this.setUPCTables(); Uncomment for Item Details Page Full display. 
		dc = DatabaseConnectivity.getInstance();
		this.selectProductDetails();
		String query = this.countItemsByStoreSQL(); 
		rs = dc.executeQuery(query);
		int count = 0;
		int store = 1;
		String address = "Here";
		long phone = 0;
		while(rs.next()) {
			count = rs.getInt("count");
			store = rs.getInt("Store.LID");
			address = rs.getString("Store.address");
			phone = rs.getLong("Store.phone");
			storeCounts.add(new StoreCounts(count, store, address, phone));
		}
		return "ItemDetails";
	}
	public String executeLoginQuery() throws SQLException {
		String resultPage = "";
		Logins = dc.getLogins(table);
		if(Logins.containsKey(username) && Logins.get(username).equals(password))
		{
			resultPage = "LoginSearchProducts";
		}
		else
		{
			resultPage = "LoginPageError";
		}
		return resultPage;
	}
	public String countInInstrument() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Instrument\nWHERE Instrument.UPC = " + itemUpc;
	}
	public String countInStrings() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Strings\nWHERE Strings.UPC = " + itemUpc;
	}
	public String countInKeyboards() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Keyboards\nWHERE Keyboards.UPC = " + itemUpc;
	}
	public String countInPercussion() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Percussion\nWHERE Percussion.UPC = " + itemUpc;
	}
	public String countInElectric() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Electric\nWHERE Electric.UPC = " + itemUpc;
	}
	public String countInWind() {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Wind\nWHERE Wind.UPC = " + itemUpc;
	}
	public String countItemsByStoreSQL() {
		return "SELECT count(" + itemUpc + ") AS count, Store.LID, Store.address, Store.phone\nFROM Item, Store\nWHERE Item.UPC = " + itemUpc + " AND Item.LID = Store.LID\nGROUP BY Store.LID";
	}
	public String countInInstrument(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Instrument\nWHERE Instrument.UPC = " + itemUpc;
	}
	public String countInStrings(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Strings\nWHERE Strings.UPC = " + itemUpc;
	}
	public String countInKeyboards(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Keyboards\nWHERE Keyboards.UPC = " + itemUpc;
	}
	public String countInPercussion(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Percussion\nWHERE Percussion.UPC = " + itemUpc;
	}
	public String countInElectric(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Electric\nWHERE Electric.UPC = " + itemUpc;
	}
	public String countInWind(long itemUpc) {
		 return "SELECT count(" + itemUpc + ") AS count\nFROM Wind\nWHERE Wind.UPC = " + itemUpc;
	}
	public String countItemsByStore(long itemUpc) {
		return "SELECT count(" + itemUpc + ") AS count, Store.LID, Store.address, Store.phone\nFROM Item, Store\nWHERE Item.UPC = " + itemUpc + " AND Item.LID = Store.LID\nGROUP BY Store.LID";
	}
	public String selectProductDetailsSQL() {
		String query = "SELECT Product.*";
		for(String itemTable : itemTables) {
			if(itemTable != null) {
				query += ", " + itemTable + ".*"; 
			}
		}
		query += "\nFROM Product";
		for(String itemTable : itemTables) {
			if(itemTable != null) {
				query += ", " + itemTable; 
			}
		}
		query += "\nWHERE Product.UPC = " + itemUpc + "\nAND ";
		for(String itemTable : itemTables) {
			if(itemTable != null) {
				query += itemTable + ".UPC = " + itemUpc + "\nAND ";
			}
		}
		query = query.substring(0, query.length() - 4);
		return query;
	}
	public String getProductDetails(ResultSet rs) throws SQLException {
		String result = "";
		this.itemName = rs.getString("ProductName");
		this.itemDescription = rs.getString("ProductDescription");
		this.itemType = rs.getString("ProductType");
		this.itemPrice = "$" + rs.getDouble("Price");
		if(contains("Instrument")){
			result += "Weight: " + rs.getDouble("Weight") + "\n";
		}
		if(contains("Strings")) {
			result += "Number of Strings: " + rs.getInt("NumberOfStrings") + "\n";
			result += "Scale: " + rs.getDouble("Scale") + "\n";
			result += "Body: " + rs.getString("Body") + "\n";
			result += "Neck: " + rs.getString("Neck") + "\n";
			result += "Frets: " + rs.getInt("Frets") + "\n";
		}
		if(contains("Percussion")) {
			result += "Diameter: " + rs.getDouble("Diameter") + "\n";
			result += "Depth: " + rs.getDouble("Depth") + "\n";
			result += "Construction: " + rs.getString("Construction") + "\n";
		}
		if(contains("Keyboards")) {
			result += "Number Of Keys: " + rs.getInt("NumberOfKeys") + "\n";
			result += "Key Type: " + rs.getString("KeyType") + "\n";
		}
		if(contains("Wind")) {
			result += "Tuning: " + rs.getString("Tuning") + "\n";
		}
		if(contains("Electric")) {
			result += "Polyphony: " + rs.getString("Polyphony") + "\n";
		}
		return result;
	}
	private boolean contains(String findString) {
		for(String itemTable : itemTables) {
			if(itemTable != null && itemTable.equals(findString)) {
				return true;
			}
		}
		return false;
	}
	public String selectItemsByStoreSQL() {
		return "SELECT Item.SKU\nFROM Item\nWHERE Item.UPC = " + itemUpc + " AND Item.LID = " + LID;
	}
	public String buyItem(){
		return "DELETE FROM Item\nWHERE SKU = " + SKU;
	}
	public String getItemSerial() {
		return "SELECT SerialNumber\nFROM Item\nWHERE Item.SKU = " + SKU;
	}
	public String createWarranty(long serialNumber, String pid, String coverage) {
		return "INSERT INTO Warranty (UPC, SerialNumber, PID, Coverage)\nVALUES\n(" + itemUpc + ", " + serialNumber + ", \"" + pid + "\", \"" + coverage + "\")";
	}
	public void setUPCTables() throws SQLException {
		int i = 0;
		i = this.setInstrumentTable(i);
		i = this.setStringsTable(i);
		i = this.setKeyboardsTable(i);
		if(i < 3) {	i = this.setElectricTable(i);}
		if(i < 3) {i = this.setPercussionTable(i);}
		if(i < 3) {i = this.setWindTable(i);}
	}
	private int setKeyboardsTable(int i) throws SQLException {
		String query = this.countInKeyboards();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Keyboards";
			i++;
		}
		return i;
	}
	private int setPercussionTable(int i) throws SQLException {
		String query = this.countInPercussion();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Percussion";
			i++;
		}
		return i;
	}
	private int setWindTable(int i) throws SQLException {
		String query = this.countInWind();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Wind";
			i++;
		}
		return i;
	}
	private int setElectricTable(int i) throws SQLException {
		String query = this.countInElectric();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Electric";
			i++;
		}
		return i;
	}
	private int setInstrumentTable(int i) throws SQLException {
		String query = this.countInInstrument();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Instrument";
			i++;
		}
		return i;
	}
	private int setStringsTable(int i) throws SQLException {
		String query = this.countInStrings();
		ResultSet rs = dc.executeQuery(query);
		if(rs.next() && rs.getInt("count") == 1) {
			itemTables[i] = "Strings";
			i++;
		}
		return i;
	}
	
	public void selectProductDetails() throws SQLException{
		ResultSet rs;
		String query = this.selectProductDetailsSQL();
		rs = dc.executeQuery(query);
		while(rs.next()) {
			productDetails = this.getProductDetails(rs);
		}
	}
	public String selectItemsByStore() throws SQLException{
		ResultSet rs;
		String query = this.selectItemsByStoreSQL();
		rs = dc.executeQuery(query);
        this.SKUs = new long[10];
		int i = 0;
		while(rs.next()) {
			this.SKUs[i] = rs.getLong("SKU");
			i++;
		}
		return "StoreItems";
	}
	public void selectItemToBuy() throws SQLException {
		ResultSet rs;
		String query = this.getItemSerial();
		rs = dc.executeQuery(query);
		while(rs.next()){
			SerialNumber = rs.getLong("SerialNumber");
		}
	}
	public String buyAndWarranty() throws SQLException {
		ResultSet rs;
		String PID = "";
		String query = getPidFromUsernameAndPassword(username, password);
		rs = dc.executeQuery(query);
		if(rs.next())
		{
			PID = rs.getString("PID");
		}
		query = this.buyItem();
		dc.executeUpdate(query);
		if(PID != "")
		{
			query = this.createWarranty(SerialNumber, PID, Warranty);	
		}
		dc.executeUpdate(query);
		return "ConfirmationPage";
	}
    public String getPidFromUsernameAndPassword(String username, String password) {
        return "SELECT PID\n"
        		+ "FROM Person\n"
        		+ "WHERE CAST(AES_DECRYPT(Person.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + username + "'"
                + " AND CAST(AES_DECRYPT(Person.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + password + "'";
    }
}
