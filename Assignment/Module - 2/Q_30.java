package assignment_1;

abstract class Marks {
	abstract void getPercentage();
}

class ClassA extends Marks {
	float sub1;
	float sub2;
	float sub3;

	ClassA(float sub1, float sub2, float sub3) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	
	void getPercentage() {
		float per =(sub1 + sub2 + sub3) / 300 * 100;
		System.out.println("Here the result of three subjcets :" +per);
	}

}

class ClassB extends Marks {
	float sub1;
	float sub2;
	float sub3;
	float sub4;

	ClassB(float sub1, float sub2, float sub3,float sub4) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
	}
	
	void getPercentage() {
		float per =((sub1 + sub2 + sub3 + sub4)/ 400 * 100);
		System.out.println("Here the result of foursubjcets :" +per);
	}

}

public class Q_30 {
	public static void main(String[] args) {
		/*
		 * We have to calculate the percentage of marks obtained in three subjects (each
		 * out of 100) by student A and in four subjects (each out of 100) by student B.
		 * Create an abstract class 'Marks' with an abstract method 'getPercentage'. It
		 * is inherited by two other classes 'A' and 'B' each having a method with the
		 * same name which returns the percentage of the students. The constructor of
		 * student A takes the marks in three subjects as its parameters and the marks
		 * in four subjects as its parameters for student B. Create an object for each
		 * of the two classes and print the percentage of marks for both the students.
		 */
		
		ClassA ca = new ClassA(45,45,45);
		ClassB ba = new ClassB(45,45,45,45);
		
		ca.getPercentage();
		ba.getPercentage();
	}
}
