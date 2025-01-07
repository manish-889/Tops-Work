package assignment_1;

import java.util.Scanner;

public class Q_19 {
	public static void main(String args[]) {
		/*
		 * W.A.J.P to find the second most frequent character in a given string. The
		 * given string is: successes The second most frequent char in the string is: c
		 */
		
		 Scanner cs=new Scanner(System.in) ;
	       String arr=cs.next();
	        char[] ch = arr.toCharArray();
	       char count;
	        for (int i =0; i <arr.length() ; i++) {
	            for (int j = i+1; j <arr.length() ; j++) {
	             if(ch[i]==ch[j]){
	                 System.out.print(ch[j] + " ");
	                 break;
	             }
	            }
	        }
	}
}
