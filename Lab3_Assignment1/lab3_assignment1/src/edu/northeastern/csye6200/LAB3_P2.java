package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P2 {
	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			try {
				System.out.print("Enter the number of values: ");
				int val = sc.nextInt();
				if(val < 4) {
					System.out.println("Cannot check consecutive fours with "+val+" numbers");
					break;	
				}
				int[] values = new int[val];
		     
		        System.out.print("Enter the values: ");
		        for (int i = 0; i < values.length; i++)
		            values[i] = sc.nextInt();
		        
		        if(isConsecutiveFour(values)){
		            System.out.println("The list has consecutive fours");
		            break;
		        }
		        else{
		            System.out.println("The list has no consecutive fours");
		            break;
		        }
			}catch (Exception e) {
				System.out.println("Invalid Input! Kindly enter only numbers! \n");
				sc.next();
			}
		}
		System.exit(1);
	}

	public static boolean isConsecutiveFour(int[] values) {
		int count = 1;
		for(int i=1; i<values.length;i++) {
			if(values[i-1] == values[i])
				count++;
			else
				count = 1;
			
			if(count >=4) 
				return true;
		}
		return false;
	}

}

