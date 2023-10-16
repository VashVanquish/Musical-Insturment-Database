package ManagedBeans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.NamingException;

@ManagedBean
@RequestScoped
public class RegisterQueryConstructor {
	private String table, name, address, phone, email, username, password;
	private DatabaseConnectivity dc;
	
	public RegisterQueryConstructor() throws NamingException {
		table = "Customer";
		name = "";
		address = "";
		phone = "";
		email = "";
		username = "";
		password = "";
		dc = DatabaseConnectivity.getInstance();
	}

	 public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * This query is used for obtaining the last VID in use, so that the next
     * VID can be the last VID except incremented by 1.
     * 
     * @return Query to obtain the last vid in use.
     */
    public String getLastVID() {
        return "SELECT MAX(vid) AS ID\nFROM Vendor";
    }
    public String getVidFromUsernameAndPassword(String username, String password) {
        return "SELECT VID\n"
        		+ "FROM Vendor\n"
        		+ "WHERE CAST(AES_DECRYPT(Vendor.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + username + "'"
                + " AND CAST(AES_DECRYPT(Vendor.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + password + "'";
    }
    public String addVendorEmailAddress(String vid, String email) {
        return "INSERT INTO Vendor_Email (VID, Email) VALUES ('" + vid + "', '" + email + "')";
    }
    public String getVendorEmailAddresses(String vid) {
        return "SELECT email\nFROM Vendor_Email\nWHERE vid = " + vid;
    }
    public String addVendorPhoneNumber(String vid, String phone) {
        return "INSERT INTO Vendor_Phone (VID, Phone)  VALUES ('" + vid + "', '" + phone + "')";
    }
    public String getVendorPhoneNumbers(String vid) {
        return "SELECT Phone\nFROM Vendor_Phone\nWHERE vid = " + vid;
    }
    public String insertVendor(String vid, String name, String address, String password, String username) {
        return "INSERT INTO Vendor (VID, Name, Address, Username, Password) VALUES\n"
        		+ "('" + vid + "', '" + name + "', '"
                + address + "', \"" + username + "\", \"" + password + "\")";
    }
    public String getVendor(String vid) {
        return "SELECT *\nFROM Vendor\nWHERE vid = " + vid;
    }
    /**
     * This query is used for obtaining the last PID in use, so that the
     * next PID can be the last PID except incremented by 1.
     * 
     * @return Query to obtain the last PID in use.
     */
    public String getLastPID() {
        return "SELECT MAX(pid) AS ID\nFROM Person";
    }

    public String getPidFromUsernameAndPassword(String username, String password) {
        return "SELECT PID\n"
        		+ "FROM Person\n"
        		+ "WHERE CAST(AES_DECRYPT(Person.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + username + "'"
                + " AND CAST(AES_DECRYPT(Person.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8)  = '" + password + "'";
    }
    public String addPersonEmailAddress(String pid, String email) {

        return "INSERT INTO Person_Email (PID, Email) VALUES ('" + pid + "', \"" + email + "\")";
    }
    public String getPersonEmailAddresses(String pid) {
        return "SELECT email\nFROM Person_Email\nWHERE pid = " + pid;
    }
    public String addPersonPhoneNumber(String pid, String phone) {

        return "INSERT INTO Person_Phone (PID, Phone) VALUES ('" + pid + "', \"" + phone + "\")";

    }
    public String getPersonPhoneNumbers(String pid) {
        return "SELECT phone\nFROM Person_Phone\nWHERE pid = " + pid;
    }
    public String insertPerson(String pid, String name, String address, String username, String password) {
        return "INSERT INTO Person (PID, Name, Address, Username, Password) VALUES\n"
        		+ "('" + pid + "', '" + name + "', '"
                + address + "', '" + username + "', '" + password + "')";
    }
    public String getPerson(String pid) {
        return "SELECT *\nFROM Person\nWHERE pid = " + pid;
    }
    public String insertCustomer(String pid, double credit) {
        return "INSERT INTO Customer VALUES ('" + pid + "', " +  credit + ")";
    }
    public String getCustomer(String pid) {
        return "SELECT *\nFROM Customer\nWHERE pid = " + pid;
    }
    public String insertEmployee(String pid, String position, double salary, int lid) {
        return "INSERT INTO Employee VALUES (" + pid + ", '" + position + "', "
                + salary + ", " + lid + ")";
    }
    public String getEmployee(String pid) {
        return "SELECT *\nFROM Employee\nWHERE pid = " + pid;
    }
    public String executeQuery() throws SQLException{
    	String update = "";
    	String id = "";
		int num = Integer.parseInt(phone.substring(phone.length() - 4));
		num += 10000;
		id = name.substring(0,3) + num;
    	if(this.table.equals("Vendor")) {
    		update = this.insertVendor(id, name, address, username, password);
    		dc.executeUpdate(update);
    		update = this.addVendorPhoneNumber(id, this.phone);
    		dc.executeUpdate(update);
    		update = this.addVendorEmailAddress(id, this.email);
    		dc.executeUpdate(update);
    	}
    	else if(this.table.equals("Customer")) {
    		update = this.insertPerson(id, name, address, username, password);
    		dc.executeUpdate(update);
    		update = this.addPersonPhoneNumber(id, this.phone);
    		dc.executeUpdate(update);
    		update = this.addPersonEmailAddress(id, this.email);
    		dc.executeUpdate(update);
    		update = this.insertCustomer(id,0.0);
    		dc.executeUpdate(update);
    	}
    	return "RegisterConfirmation";
    }
}
