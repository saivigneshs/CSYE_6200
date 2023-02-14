package edu.northeastern.csye6200;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class LAB4P1 {
	public static void main(String[] args) throws FileNotFoundException{
		// TODO: write your code here
	
		DecimalFormat df = new DecimalFormat("0.00");
		File f = new File("csye6200.txt");
		ArrayList<Double> numList = new ArrayList<>();
		Scanner sc = new Scanner(f);
		int i = 0;
		while(i<15) {
			if(sc.hasNext()) {
			numList.add(Double.parseDouble(sc.nextLine()));
			i++;
			}else {
				break;
			}
		}
		System.out.println(numList);
		double sum = 0;
		for(double num : numList) {
			sum +=num;
		}
		String avg = df.format(sum/numList.size());
		System.out.printf("\nGrade differences from the average %s :",avg);
	
		for(i=0;i<numList.size();i++) {
			System.out.printf("\nGrade %d: %.2f",i+1,numList.get(i)-Double.parseDouble(avg));
		}
	}
}
