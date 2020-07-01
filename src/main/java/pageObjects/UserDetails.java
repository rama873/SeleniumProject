package pageObjects;

public class UserDetails {
	
	
	public static final UserDetails jsmith = new UserDetails("Jane", "Z", "Smith", "jsmith", "p", "1/11/114/1141 W Sales", "John Q Jones", "Senior Sales Consultant", "025", "SF", "United States", "415-596-2670", "No", "jsmith@demo.extensity.com", "US Dollar");
	public static final UserDetails jjones = new UserDetails("John", "Q", "Jones", "jjones", "p", "1/11/114/1141 W Sales", "Rick R Young", "Sales manager", "26", "SF", "United States", "415-596-2670", "No", "jjones@demo.extensity.com", "US Dollar");
	public static final UserDetails ryoung = new UserDetails("Rick", "R", "Young", "ryoung", "p", "1/11/111/Default Cost Center", "Betty Franklin", "Accounting", "1", "Emeryville", "United States", "510-596-2674", "No", "ryoung@demo.extensity.com", "US Dollar");
	public static final UserDetails admin = new UserDetails("Admin", null, "User", "admin", "p", "1/11/111/Default Cost Center", "Default Approver User", "Administrator", null, null, null, null, "No", null, null);
	

	
	public final String First_name;
	public final String Middle_Initial;
	public final String Last_name;
	public final String login;
	public final String password;
	public final String cost_center;
	public final String manager;
	public final String title;
	public final String emp_id;
	public final String location;
	public final String COUNTRY;
	public final String PHONE;
	public final String OUT_OF_OFFICE;
	public final String EMAIL;
	public final String CURRENCY;


private UserDetails(String First_name, String Middle_Initial, String Last_name, String login, String password, String cost_center,
		String manager, String title, String emp_id, String location, String COUNTRY, String PHONE, String OUT_OF_OFFICE, String EMAIL, String CURRENCY) {
	this.First_name = First_name;
	this.Middle_Initial = Middle_Initial;
	this.Last_name = Last_name;
	this.login = login;
	this.password = password;
	this.cost_center = cost_center;
	this.manager = manager;
	this.title = title;
	this.emp_id = emp_id;
	this.location = location;
	this.COUNTRY = COUNTRY;
	this.PHONE = PHONE;
	this.OUT_OF_OFFICE = OUT_OF_OFFICE;
	this.EMAIL = EMAIL;
	this.CURRENCY = CURRENCY;
}
}
