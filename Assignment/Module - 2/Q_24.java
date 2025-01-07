package assignment_1;
class Member{
    public String name;
    public int age;
    public String address;
    public double salary;

    public Member(String name , int age ,String address, double salary){
        this.name=name;
        this.age=age;
        this.address=address;
        this.salary=salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String phoneNumber;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printSalary(double salary){
        System.out.println("Here us your salary :"+salary);
    }

}
public class Q_24 {
	public static void main(String[] args) {
		/*
		 * Create a class named 'Member' having the following members: 1. Data members
		 * 2. Name 3. Age 4. Phone number 5. Address 6. Salary
		 */
		Member m = new Member("Manish",21,"Kim",10909);
   }
}
