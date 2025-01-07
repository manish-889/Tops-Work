package model;

public class Employee {

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String mob;
	private String address;
	private String gender;
	private String password;
	private String cpassword;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee( String fname, String lname, String email, String mob, String address, String gender,
			String password, String cpassword) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mob = mob;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.cpassword = cpassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", email=" + email + ", mob=" + mob + ", address="
				+ address + ", gender=" + gender + ", password=" + password + ", cpassword=" + cpassword + "]";
	}
	
	
	
}
