package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			try {
				System.out.print("Enter a credit card number as a long integer: ");
		        long number = sc.nextLong();
		        
		        if(isValid(number)) {
		        	System.out.println(number + " is valid");
		        	break;
		        }
		        else {
		        	System.out.println(number + " is invalid");
		        	break;
		        }
			}catch (Exception e) {
				System.out.println("Incorrect Input! Input has to be a Long Integer \n ");
				sc.next();
			}
		}
		System.exit(1);
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean isValid = false;
		isValid = (getSize(number)>=13 && getSize(number)<=16) &&
				(prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) &&
				( (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) %10 == 0);
		return isValid;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String num = String.valueOf(number);
		for (int i = getSize(number) -2;i>=0;i-=2) {
			sum += getDigit(Integer.parseInt(num.charAt(i)+"") *2);
		}
		return sum;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		if(number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String num = String.valueOf(number);
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number,getSize(d)) ==d;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		int count = 0;
		while(d>0) {
			d = d/10;
			count++;
		}
		return count;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		if(getSize(number) > k) {
			String num = String.valueOf(number);
			return Long.parseLong(num.substring(0,k));
		}
		return number;
	}
}
