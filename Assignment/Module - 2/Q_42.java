package assignment_1;

class AgeNotWithRangeException extends Exception{
    String message;


    public AgeNotWithRangeException(String message) {
        super(message);
        this.message = message;
    }
}
class NameNotValidException extends Exception{
    String message;

    public NameNotValidException(String message) {
        super(message);
        this.message = message;
    }
}

class Student7 {
    int rollNo;
    String name;
    int age;
    String course;

    public Student7(int rollNo, String name, int age, String course)throws AgeNotWithRangeException,NameNotValidException{

        if(age < 15 || age > 21){
           try {
        	   throw new AgeNotWithRangeException("Your age not between 15 to 21...");
           }catch(Exception e) {
        	   e.printStackTrace();
           }
           
        }

        if (!name.matches("[a-zA-Z\\s]+")){
            
            try {
            	throw new NameNotValidException("Your name contains special character...");
            }catch(Exception e) {
         	   e.printStackTrace();
            }
        }
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
public class Q_42 {
	public static void main(String[] args) throws AgeNotWithRangeException, NameNotValidException {
		/*
		 * • W.A.J.P to create a class Student with attributes roll no, name, age and
		 * course. Initialize values through parameterized constructor. If age of
		 * student is not in between 15 and 21 then generate user defined exception
		 * "AgeNotWithinRangeException". If name contains numbers or special symbols
		 * raise exception "NameNotValidException". Define the two exception classes.
		 */
		
		Student7 st = new Student7(1, "Manish", 1, "Java");
	}
}
